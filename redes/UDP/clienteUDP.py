import socket

#criando socket UDP
socketUDP = socket.socket(family=socket.AF_INET, type=socket.SOCK_DGRAM)

#enviando requisições para o servidor
socketUDP.sendto(str.encode("Minha mensagem"),("127.0.0.1",2023))

#lendo respostas do servidor
resposta = socketUDP.recvfrom(1024)

#imprimindo mensagem do servidor na tela
while True:
    msg = "mensagem do servidor {}".format(resposta[0])
    print(msg)
    if not (msg != "00"):
        break