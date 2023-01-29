package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.exceptions.InsufficientFundsException;
import br.com.ada.poo2.banco.controllers.operacoes.SacarController;
import br.com.ada.poo2.banco.exceptions.InvalidValueException;

import java.util.InputMismatchException;
import java.util.Scanner;


public class SacarView {

    Scanner scanner = new Scanner(System.in);
    SacarController sacarController = new SacarController();

    public void iniciarSacar() {
        try {
            double valor;

            sacarController.validarSaldoPositivoConta();
            valor = pedirValorDoSaque();
            sacarController.sacarDaContaDoUsuario(valor);
            System.out.println("Saque efetuado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida");
            scanner.nextLine();
            iniciarSacar();
        } catch (InvalidValueException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
            scanner.nextLine();
            iniciarSacar();
        }
    }

    public double pedirValorDoSaque() {
        System.out.println("Informe o valor para saque: ");
        return scanner.nextDouble();
    }

}
