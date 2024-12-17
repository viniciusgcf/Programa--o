import socket
import threading

# Configurações do servidor
HOST = '127.0.0.1'
PORT = 55555

# Inicialização do servidor
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((HOST, PORT))
server.listen()

clients = []
names = []

def broadcast(message, exclude=None):
    """Envia uma mensagem para todos os clientes conectados, exceto o especificado em exclude."""
    for client in clients:
        if client != exclude:
            try:
                client.send(message)
            except:
                continue

def handle_client(client):
    """Gerencia mensagens enviadas por um cliente específico."""
    while True:
        try:
            message = client.recv(1024)
            broadcast(message, exclude=client)
        except:
            disconnect_client(client)
            break

def disconnect_client(client):
    """Remove o cliente da lista e notifica os outros usuários."""
    if client in clients:
        index = clients.index(client)
        name = names[index]
        clients.remove(client)
        names.remove(name)
        broadcast(f'{name} foi desconectado!'.encode('ascii'))
        client.close()

def receive_connections():
    """Aceita novas conexões e inicializa threads para gerenciar clientes."""
    while True:
        client, address = server.accept()
        print(f"Conexão estabelecida com {address}")

        client.send('NOME'.encode('ascii'))
        name = client.recv(1024).decode('ascii')
        names.append(name)
        clients.append(client)

        print(f"O cliente {name} conectou!")
        broadcast(f'{name} entrou no chat!'.encode('ascii'))
        client.send('Bem-vindo ao servidor de chat!'.encode('ascii'))

        thread = threading.Thread(target=handle_client, args=(client,))
        thread.start()

print("Servidor está rodando...")
receive_connections()
