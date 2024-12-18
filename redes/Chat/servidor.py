import socket
import threading

host = "localhost"  # Corrigido de "locahost"
port = 55555

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((host, port))
server.listen()

clients = []
names = []

def broadcast(message):
    """Envia a mensagem para todos os clientes conectados"""
    for client in clients:
        client.send(message)

def handle(client):
    """Lida com as mensagens recebidas de um cliente"""
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
           
