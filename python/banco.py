from teste import cria_conta
conta=cria_conta(123, "Nico", 55.0, 1000.0)
conta["numero"]
123

numero=123
titular="Nico"
saldo=55.0
limite=1000.0
conta={"numero":123, "titular": "Nico", "saldo":55.0, "limite":1000.0}
conta['numero']
123
conta["saldo"]
55
def cria_conta(numero, titular, saldo, limite):
    conta2={"numero": numero,"titular": titular, "saldo": saldo, "limite": limite}
    return conta