import socket
import threading

host = '127.0.0.1' # localhost
port = 55555

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((host, port))
server.listen()

clients = []
names = []

def broadcast(message):
    for client in clients:
        client.send(message)

def handle(client):
    while True:
        try:
            message = client.recv(1024)
            broadcast(message)
        except:
            index = clients.index(client)
            clients.remove(client)
            client.close()
            name = names[index]
            broadcast(f'{name} foi desconectado!'.encode('ascii'))
            names.remove(name)
            break

def recieve():
    while True:
        client, address = server.accept()
        print(f"Conectado em {str(address)}")

        client.send('NOME'.encode('ascii'))
        name = client.recv(1024).decode('ascii')
        names.append(name)
        clients.append(client)

        print(f'nome do cliente é {name}!')
        broadcast(f'{name} entrou no chat!'.encode('ascii'))
        client.send('Conectado ao servidor!'.encode('ascii'))

        thread = threading.Thread(target=handle, args=(client,))
        thread.start()

recieve()