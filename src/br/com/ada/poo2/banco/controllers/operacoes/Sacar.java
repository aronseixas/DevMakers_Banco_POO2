package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.models.taxas.TaxasPJ;

import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class Sacar {
    public void executar() {

        double taxa = banco.getContaLogada().getTaxas().taxa("SAQUE");
        double saque = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o valor para saque: ");
            saque = sc.nextDouble();
            if (saque <= 0) {
                System.out.println("Valor inadequado.");
            } else {
                double saldoAtualDaConta = banco.getContaLogada().getSaldo();
                double valorDescontadoDoSaldoAtualDaConta = saque * (1 + taxa);
                banco.getContaLogada().setSaldo(saldoAtualDaConta - valorDescontadoDoSaldoAtualDaConta);
            }
        } while (saque <= 0);
    }
}
    //Deve retornar MenuOperacoes ao final
    //TODO testar colocar tudo no try catch.

