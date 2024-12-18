import socket
import threading

name = input("Digite seu nome: ")

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(('127.0.0.1', 55555))

def receive():
    while True:
        try:
            message = client.recv(1024).decode('ascii')
            if message == 'NOME':
                client.send(name.encode('ascii'))  # Envia o nome quando solicitado
            else:
                print(message)
        except:
            print("Ocorreu um erro!")
            client.close()
            break

def write():
    while True:
        message = f'{name}: {input("")}'
        client.send(message.encode('ascii'))

# Thread para receber mensagens
receive_thread = threading.Thread(target=receive)
receive_thread.start()

# Thread para enviar mensagens
write_thread = threading.Thread(target=write)
write_thread.start()
