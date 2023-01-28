package br.com.ada.poo2.banco.controllers.operacoes;

import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class Investir {
    public void executar() {


        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o valor a ser investido: ");
        double valorASerInvestido = sc.nextDouble();

        double taxa = banco.getContaLogada().getTaxas().taxa("INVESTIMENTO");
        double rendimentoDoInvestimento = valorASerInvestido * (1 + taxa);
        double saldoAtualDaConta = banco.getContaLogada().getSaldo();

        if (saldoAtualDaConta < valorASerInvestido) {
            throw new IllegalArgumentException("Saldo insuficiente. Operação cancelada.");
        }
        banco.getContaLogada().setSaldo(saldoAtualDaConta - valorASerInvestido + rendimentoDoInvestimento);
        banco.getContaLogada().getSaldo();

        //getSaldo está mostrando o saldo da conta corrente e não da conta investimento.
        //Possivelmente o método esteja funcionando, mas não consegui checar o saldo especificamente da contaInvestimento.
        //Talvez valha checar isso para a poupança.
    }
    //Deve retornar MenuOperacoes ao final
}
