package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.controllers.operacoes.EscolherConta;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EscolherContaView {

    Scanner scanner = new Scanner(System.in);
    EscolherConta escolherConta = new EscolherConta();

    public void iniciarEscolherContaView() {
        int tipoDeConta;

        mostrarContasDoUsuario();
        tipoDeConta = pedirTipoDeConta();
        logarContaEscolhida(tipoDeConta);
        mensagemMostrandoContaLogada(tipoDeConta);
    }

    public void mostrarContasDoUsuario() {
        int qtdeContasDoUsuario = escolherConta.pegarQtddDeContasDoUsuario();

        for (int i = 1; i <= qtdeContasDoUsuario; i++) {
            System.out.println("Opção " + i
                    + " - Tipo: " + escolherConta.pegarTipoDaConta(i)
                    + " - Número: " + escolherConta.pegarNumeroDaConta(i));
        }
    }

    public int pedirTipoDeConta() {
        System.out.println("Escolha a conta desejada:");
        return scanner.nextInt();

        //TODO fazer try catch
    }

    public void logarContaEscolhida(int tipoDeConta) {
        try {
            escolherConta.logarConta(tipoDeConta);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Opção inválida");
            iniciarEscolherContaView();
        }
    }

    public void mensagemMostrandoContaLogada(int tipoDeConta) {
        System.out.println("Conta "
                + escolherConta.pegarTipoDaConta(tipoDeConta)
                +" escolhida com sucesso." );
    }
}
