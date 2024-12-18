import socket
import threading

name = input("Digite seu nome: ")

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(('127.0.0.1', 55555))

def recieve():
    while True:
        try:
            message = client.recv(1024).decode('ascii')
            if message == 'NOME':
                pass
            else:
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

recieve_thread = threading.Thread(target=recieve)
recieve_thread.start()

write_thread = threading.Thread(target=write)
write_thread.start()
