<?php
function exibeMensagem($mensagem)
{
    $mensagem = mb_strtoupper($mensagem);
    echo $mensagem . PHP_EOL;
}

function depositar($conta, $deposito)
{
    if ($deposito > 0) {
        $conta['saldo'] += $deposito;
    } else
        exibeMensagem(mensagem: "Deposito invalido");

    return $conta;
}

function sacar($conta, $saque)
{
    if ($conta['saldo'] > $saque) {
        $conta['saldo'] -= $saque;
    }
    return $conta;
}

function exibeConta(array $conta)
{
    ['titular' => $titular, 'saldo' => $saldo] = $conta;
    $html = "<li>Titular: $titular. Saldo: $saldo</li>";
}

