package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.exceptions.InvalidValueException;
import br.com.ada.poo2.banco.exceptions.UserDoesNotExistException;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.enums.ETipoConta;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class Depositar {
    Conta contaDestino;
    public Conta pegarContaDeOutroCliente(String numeroConta) {
        contaDestino = banco.getMapaDeNumeroContaEConta().get(numeroConta);
        validarContaDestino(contaDestino);
        return contaDestino;
    }

    public Conta pegarContaDoProprioCLiente() {
        contaDestino = banco.getContaLogada();
        return contaDestino;
    }

    public void depositarContaUsuario(double valor, Conta contaDestino) {
        double rendimento, saldoAtualDaConta;

        validarValorDeposito(valor);
        ETipoConta tipoContaLogada = contaDestino.getTipoConta();
        rendimento = contaDestino.getRendimento().taxaRendimentoDeposito(tipoContaLogada);
        saldoAtualDaConta = contaDestino.getSaldo();
        contaDestino.setSaldo(saldoAtualDaConta + valor * (1 + rendimento));
    }

    public void validarValorDeposito(double valor) throws InvalidValueException{
        if (valor <= 0){
            throw new InvalidValueException();
        }
    }

    public void validarContaDestino(Conta contaDestino) throws UserDoesNotExistException {
        if (contaDestino == null){
            throw new UserDoesNotExistException();
        }
    }
}
    //TODO testar colocar tudo no try catch.
