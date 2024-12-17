import socket
import threading

name = input("Digite seu nome: ")

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(('127.0.0.1', 55555))

def receive_messages():
    while True:
        try:
            message = client.recv(1024).decode('ascii')
            if message != 'NOME':
                print(message)
        except:
            print("Ocorreu um erro ao receber a mensagem. Conexão encerrada.")
            client.close()
            break

def send_messages():
    while True:
        try:
            message = f'{name}: {input("")}'
            client.send(message.encode('ascii'))
        except:
            print("Ocorreu um erro ao enviar a mensagem.")
            client.close()
            break

receive_thread = threading.Thread(target=receive_messages)
receive_thread.start()

write_thread = threading.Thread(target=send_messages)
write_thread.start()
