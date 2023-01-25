package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.models.contas.Conta;

import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class Transferir {
    public void executar() {

        Conta contaLogada = banco.getContaLogada();
        Conta contaDestino;

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o número da conta para transferência: ");



    }
    //Deve retornar MenuOperacoes ao final
}
