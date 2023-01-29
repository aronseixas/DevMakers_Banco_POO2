package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.controllers.operacoes.EscolherContaController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EscolherContaView {

    Scanner scanner = new Scanner(System.in);
    EscolherContaController escolherContaController = new EscolherContaController();

    public void iniciarEscolherContaView() {
        int tipoDeConta;
        try {
            mostrarContasDoUsuario();
            tipoDeConta = pedirTipoDeConta();
            escolherContaController.logarConta(tipoDeConta);
            mensagemMostrandoContaLogada(tipoDeConta);
        } catch (IndexOutOfBoundsException | InputMismatchException e) {
            System.out.println("Opção inválida");
            scanner.nextLine();
            iniciarEscolherContaView();
        }
    }

    public void mostrarContasDoUsuario() {
        int qtdeContasDoUsuario = escolherContaController.pegarQtddDeContasDoUsuario();

        for (int i = 1; i <= qtdeContasDoUsuario; i++) {
            System.out.println("Opção " + i
                    + " - Tipo: " + escolherContaController.pegarTipoDaConta(i)
                    + " - Número: " + escolherContaController.pegarNumeroDaConta(i));
        }
    }

    public int pedirTipoDeConta() {
        System.out.println("Escolha a conta desejada:");
        return scanner.nextInt();
    }

    public void mensagemMostrandoContaLogada(int tipoDeConta) {
        System.out.println("Conta "
                + escolherContaController.pegarTipoDaConta(tipoDeConta)
                + " escolhida com sucesso.");
    }
}
