package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.applicacao.InvalidPasswordException;
import br.com.ada.poo2.banco.applicacao.InvalidValueException;
import br.com.ada.poo2.banco.models.enums.ETipoConta;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class Depositar {
    public void depositarContaUsuario(double valor) {
        validarValorDeposito(valor);
        ETipoConta tipoContaLogada = banco.getContaLogada().getTipoConta();
        double rendimento = banco.getContaLogada().getRendimento().taxaRendimentoDeposito(tipoContaLogada);
        double saldoAtualDaConta = banco.getContaLogada().getSaldo();
        banco.getContaLogada().setSaldo(saldoAtualDaConta + valor * (1 + rendimento));
    }

    public void validarValorDeposito(double valor) throws InvalidValueException{
        if (valor <= 0){
            throw new InvalidValueException();
        }
    }
}

    //Deve retornar MenuOperacoes ao final
    //TODO testar colocar tudo no try catch.
