package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.models.enums.ETipoConta;

import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class Depositar {
    public void executar() {

        ETipoConta tipoContaLogada = banco.getContaLogada().getTipoConta();
        double rendimento = banco.getContaLogada().getRendimento().taxaRendimentoDeposito(tipoContaLogada);
        double deposito = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o valor para depósito: ");
            deposito = sc.nextDouble();
            if (deposito <= 0) {
                System.out.println("Valor inadequado.");
            } else {
                double saldoAtualDaConta = banco.getContaLogada().getSaldo();
                banco.getContaLogada().setSaldo(saldoAtualDaConta + deposito * (1 + rendimento));
                System.out.println("Deposito concluído com sucesso!");
            }
        } while (deposito <= 0);
        }
    }
    //Deve retornar MenuOperacoes ao final
    //TODO testar colocar tudo no try catch.
