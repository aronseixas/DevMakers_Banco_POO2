package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.applicacao.InsufficientFundsException;
import br.com.ada.poo2.banco.controllers.operacoes.Sacar;

import java.util.Scanner;


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
        return valor;
        //TODO try-catch
    }

    public void sacarValor(double valor) {
        try {
            sacar.sacarDaContaDoUsuario(valor);
        } catch (InsufficientFundsException e) {
            System.out.println("Valor inválido!");
            iniciarSacar();
        }
    }
}
