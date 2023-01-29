package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.exceptions.InsufficientFundsException;
import br.com.ada.poo2.banco.controllers.operacoes.Sacar;

import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;


public class SacarView {

    Scanner scanner = new Scanner(System.in);
    Sacar sacar = new Sacar();

    public void iniciarSacar() {
        double valor;

        valor = pedirValorDoSaque();
        sacarValor(valor);
    }

    public double pedirValorDoSaque() {
        System.out.println("Informe o valor para saque: ");
        double valor = scanner.nextDouble();
        if (banco.getContaLogada().getSaldo() < valor) {
            System.out.println("Saldo em conta insuficiente.");
            return pedirValorDoSaque();
        } else {
            return valor;
        }
        //TODO TRY-CATCH de imput
    }

    public void sacarValor(double valor) {
        try {
            sacar.sacarDaContaDoUsuario(valor);
            System.out.println("Saque efetuado com sucesso!");
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessageSaque());
            iniciarSacar();
        }
    }
}
