package br.com.ada.poo2.banco.controllers.menu;

import br.com.ada.poo2.banco.controllers.operacoes.*;
import br.com.ada.poo2.banco.models.enums.ETipoConta;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.Scanner;

public class MenuOperacoes {
//TODO apresentar nome de usuário e qual a conta logada;
//TODO limitas as operações ao tipo de conta;
    static Scanner menu = new Scanner(System.in);
    public static void iniciarMenuOperacoes() {

        while (true) {

            System.out.print("##---------------Bem-vindo à sua conta---------------##\n\n");
            System.out.print("|-----------------------------------------------------|\n");
            System.out.print("| Opção 1 - Consultar saldo                           |\n");
            System.out.print("| Opção 2 - Sacar                                     |\n");
            System.out.print("| Opção 3 - Depositar                                 |\n");
            System.out.print("| Opção 4 - Investir                                  |\n");
            System.out.print("| Opção 5 - Transferir                                |\n");
            System.out.print("| Opção 6 - Escolher conta                            |\n");
            System.out.print("| Opção 7 - Sair                                      |\n");
            System.out.print("|-----------------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            String opcao = menu.next();

            if (opcao.equals("7")) {
                System.out.print("\nAté logo!");
                menu.close();
                break;
            }

            switch (opcao) {
                case "1" :
                    System.out.println("\nOpção Consultar saldo \n");
                    ConsultarSaldo.mostrarSaldoDaConta();
                    break;
                case "2" :
                    System.out.println("\nOpção Sacar \n");
                    Sacar.executarSaque();
                    break;
                case "3" :
                    System.out.println("\nOpção Depositar\n");
                    Depositar.executarDeposito();
                    break;
                case "4" :
                    System.out.println("\nOpção Investir\n");
                    Investir.executarInvestimento();
                    break;
                case "5" :
                    System.out.println("\nOpção Transferir\n");
                    Transferir.executarTransferencia();
                    break;
                case "6" :
                    System.out.println("\nOpção Escolher conta\n");
                    EscolherConta.escolherConta();
                    break;
                default :
                    System.out.println("\nOpção Inválida!");
            }
        }
    }
}