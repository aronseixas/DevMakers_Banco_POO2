package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.exceptions.InsufficientFundsException;
import br.com.ada.poo2.banco.exceptions.UserDoesNotExistException;
import br.com.ada.poo2.banco.models.contas.Conta;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class Transferir {

    public Conta pegarContaDestino(String numeroDaConta) {
        Conta contaDestino = banco.getMapaDeNumeroContaEConta().get(numeroDaConta);

        return contaDestino;
    }
    public void transferirValor(double valor, String numeroContaDestino) {
        Conta contaDestino;
        double taxa, saldoAtualDaConta, valorDescontadoDoSaldoAtualDaConta;

        contaDestino = pegarContaDestino(numeroContaDestino);
        validarValorTransferencia(valor);
        validarContaDestino(contaDestino);


        //sacar
        taxa = banco.getContaLogada().getTaxas().taxa("TRANSFERENCIA");
        saldoAtualDaConta = banco.getContaLogada().getSaldo();
        valorDescontadoDoSaldoAtualDaConta = valor * (1 + taxa);
        banco.getContaLogada().setSaldo(saldoAtualDaConta - valorDescontadoDoSaldoAtualDaConta);

        //depositar
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
        //banco.getMapaDeNumeroContaEConta().put(numeroContaDestino,contaDestino);
        //Ver como funciona o MAP e se a operação de fato modifica 1MAP ou todos e tb se ele só mexeu na conta da linha 18 desta classe
    }

    public void validarValorTransferencia(double valor) throws InsufficientFundsException{
        if (banco.getContaLogada().getSaldo() < valor){
            throw new InsufficientFundsException();
        }
    }

    public void validarContaDestino(Conta contaDestino) throws UserDoesNotExistException{
        if (contaDestino == null) {
            throw new UserDoesNotExistException();
        }
    }
}
