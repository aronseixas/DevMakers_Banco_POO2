package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.applicacao.InsufficientFundsException;

import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class Investir {
    double saldoAtualDaConta = banco.getContaLogada().getSaldo();
    public void executar(double valorASerInvestido) {
        validarValorInvestir(valorASerInvestido);
        double rendimentoDoInvestimento = aplicarRendimento(valorASerInvestido);

        banco.getContaLogada().setSaldo(saldoAtualDaConta + (valorASerInvestido + rendimentoDoInvestimento));

        //conta investimento possui um ou dois saldos?
        //getSaldo está mostrando o saldo da conta corrente e não da conta investimento.
        //Possivelmente o método esteja funcionando, mas não consegui checar o saldo especificamente da contaInvestimento.
        //Talvez valha checar isso para a poupança.
    }
    //Deve retornar MenuOperacoes ao final

    public void validarValorInvestir(double valorASerInvestido) throws InsufficientFundsException{
        if (saldoAtualDaConta < valorASerInvestido) {
            throw new IllegalArgumentException("Saldo insuficiente. Operação cancelada.");
        }
    }

    private double aplicarRendimento(double valorASerInvestido){
        double taxa = banco.getContaLogada().getTaxas().taxa("INVESTIMENTO");
         return valorASerInvestido * (1 + taxa);
    }
}
