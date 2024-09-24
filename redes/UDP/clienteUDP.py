import socket

#criando socket UDP
socketUDP = socket.socket(family=socket.AF_INET, type=socket.SOCK_DGRAM)

#enviando requisições para o servidor
socketUDP.sendto(str.encode("Minha mensagem"),("127.0.0.1",2023))

#lendo respostas do servidor
resposta = socketUDP.recvfrom(1024)

while True:
    print("pinto")
    pinto=input()
    socketUDP.sendto(str.encode(pinto),"127.0.0.1",2023)
    if not (pinto != "00"):
        break
    
#imprimindo mensagem do servidor na tela
# printado = ""
# i = 0
# while (printado != "00"):
#     resposta = socketUDP.recvfrom(1024)
#     msg = "mensagem do servidor {}".format(resposta[0])
#     if (printado != msg):
#         print(msg)
#         printado = msg
