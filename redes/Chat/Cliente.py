import socket
import threading

def main():
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    host = '127.0.0.1'
    port = 12345
    client_socket.connect((host, port))

    while True:
        message = input ("Digite sua mensagem: ")
        client_socket.sendall(message.encode('utf-8'))
        data = client_socket.recv(1024)
        response = data.decode('utf-8')
        print(f"Mensagem do servidor: {response}")
        
if __name__ == "__main__":
    main()