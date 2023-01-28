package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.enums.ETipoConta;

import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class Transferir {
    public void executar() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o número da conta para transferência: ");

        String numeroContaDestino = sc.nextLine();

        Conta contaDestino = banco.getMapaDeNumeroContaEConta().get(numeroContaDestino);

        if (contaDestino == null) {
            System.out.println("Conta destino não encontrada. Operação cancelada.");
            return;
        }

        System.out.println("Informe o valor a ser transferido: ");
        double valorASerTransferido = sc.nextDouble();

        if (banco.getContaLogada().getSaldo() < valorASerTransferido) {
            System.out.println("Saldo insuficiente. Operação cancelada.");
            return;
        }

        //sacar
        double taxa = banco.getContaLogada().getTaxas().taxa("TRANSFERENCIA");
        double saldoAtualDaConta = banco.getContaLogada().getSaldo();
        double valorDescontadoDoSaldoAtualDaConta = valorASerTransferido * (1 + taxa);
        banco.getContaLogada().setSaldo(saldoAtualDaConta - valorDescontadoDoSaldoAtualDaConta);

        //depositar
        contaDestino.setSaldo(contaDestino.getSaldo() + valorASerTransferido);
        //banco.getMapaDeNumeroContaEConta().put(numeroContaDestino,contaDestino);
        //Ver como funciona o MAP e se a operação de fato modifica 1MAP ou todos e tb se ele só mexeu na conta da linha 18 desta classe
    }
    //Deve retornar MenuOperacoes ao final
}
