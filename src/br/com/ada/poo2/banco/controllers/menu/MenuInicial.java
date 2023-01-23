package br.com.ada.poo2.banco.controllers.menu;

import br.com.ada.poo2.banco.applicacao.Aplicacao;
import br.com.ada.poo2.banco.controllers.operacoes.AbrirConta;
import br.com.ada.poo2.banco.controllers.operacoes.Logar;

import java.util.Scanner;

public class MenuInicial {

    static Scanner menu = new Scanner(System.in);
    public static void iniciarPrimeiroMenu(){

        while (true) {

            System.out.print("##------------Bem-vindo ao BANCO-------------##\n\n");
            System.out.print("|----------------------------------------------------|\n");
            System.out.print("| Opção 1 - Abrir uma nova conta                     |\n");
            System.out.print("| Opção 2 - Acessar sua conta                        |\n");
            System.out.print("| Opção 3 - Fechar                                   |\n");
            System.out.print("|----------------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            String opcao = menu.next();

            if (opcao.equals("3")) {
                System.out.print("\nAté logo!");
                menu.close();
                break;
            }

            switch (opcao) {
                case "1" :
                    System.out.println("\nOpção abrir uma conta \n");
                    AbrirConta abrirConta = new AbrirConta();
                    abrirConta.abrirConta();
                    break;
                    case "2" :
                    System.out.println("\nOpção acessar sua conta\n");
                    Logar.pedirIdentificadorCliente();
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
            }
        }
    }
}
