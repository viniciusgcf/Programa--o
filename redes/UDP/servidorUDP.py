import socket

#criando o socket
socketUDP = socket.socket(family=socket.AF_INET, type=socket.SOCK_DGRAM) 
socketUDP.bind(("127.0.0.1",2023))

print("Servidor UDP está esperando mensagens!")

printado = ""
while (printado != "00"):
    #esperando mensagem da rede - thread principal bloqueada
    parMsgEndereco = socketUDP.recvfrom(1024)

    #se mensagem chegou fazer o tratamento
    msg = parMsgEndereco[0]
    endereco = parMsgEndereco[1]
    msgCliente = "Mensagem do cliente:{}".format(msg)
    ipCliente = "Endereço de IP do cliente:{}".format(endereco)

    if (printado != msgCliente):
        print(msgCliente)
        print(ipCliente)
        printado = msgCliente

#Enviando mensagem de resposta ao cliente   
#socketUDP.sendto(str.encode("Mensagem recebida"),endereco)

