import socket
import threading

def handle_client(client_socket, client_address):
    while True:
        data = client_socket.recv(1024)
        if not data:
            break
        message = data.decode('utf-8')
        print(f"{client_address}: {message}")
        response = "Servidor recebeu sua mensagem: " + message
        client_socket.sendall(response.encode('utf-8'))
    client_socket.close

def main():
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    host = '127.0.0.1'
    port = 12345
    server_socket.bind((host, port))
    server_socket.listen(5)
    print(f"Servidor conectado em: {host}, {port}")

    while True:
        client_socket, client_address = server_socket.accept()
        print(f"Conexão aceita de {client_address}")
        client_handler = threading.Thread(target=handle_client, args=(client_socket, client_address))
        client_handler.start()

if __name__ == "__main__":
    main()