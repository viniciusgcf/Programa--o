import subprocess #usado quando é necessario usar o output de um processo no resto do código
import socket #faz a comunicação necessaria para dar o ping
import time #usado para saber quando tempo se passou, funciona com o sleep no final
#faz import dos processos necessarios para rodar o codigo

file = "IPs" #conecta um termo ao outro
COUNT = 1 #vê se o termo aparece no codigo

def check_ip(ip):
    try:
        socket.inet_aton(ip) #resume o output 
        response = subprocess.call(["ping", "-c", str(COUNT), ip], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        #executa o ping
        return "ok" if response == 0 else "not_ok"
    except socket.error:
        return "invalid_ip"
        #mostra se o IP tá funcionando ou não

while True:
    with open(file, 'r') as f: #atribui o processo de abrir o arquivo com os IPs a variavel f
        for line in f: #todos os processos abaixo se repetirão para cada linha
            ip = line.strip() #tira espaços desnecessarios do IP
            result = check_ip(ip)
            saida = f"IP: {ip} {result}"
            print(saida)
            time.sleep(2) #declara o tempo de intervalo entre os pings
            