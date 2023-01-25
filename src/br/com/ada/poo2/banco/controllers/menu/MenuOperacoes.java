package br.com.ada.poo2.banco.controllers.menu;
import br.com.ada.poo2.banco.controllers.operacoes.*;

import java.awt.*;
import java.util.Scanner;

public class MenuOperacoes {

//TODO apresentar nome de usuário e qual a conta logada;
//TODO limitas as operações ao tipo de conta;
    static Scanner scan = new Scanner(System.in);
    public void iniciarMenuOperacoes() {


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

            String opcao = scan.next();
            ConsultarSaldo consultarSaldo = new ConsultarSaldo();
            Sacar sacar = new Sacar();
            Depositar depositar = new Depositar();
            Investir investir = new Investir();
            Transferir transferir = new Transferir();
            EscolherConta escolherConta = new EscolherConta();
            Sair sair = new Sair();


            switch (opcao) {
                case "1" :

                    consultarSaldo.executar();
                    break;
                case "2" :
                    System.out.println("\nOpção Sacar \n");
                    sacar.executar();
                    consultarSaldo.executar();
                    break;
                case "3" :
                    System.out.println("\nOpção Depositar\n");
                    depositar.executar();
                    consultarSaldo.executar();
                    break;
                case "4" :
                    System.out.println("\nOpção Investir\n");
                    investir.executar();
                    break;
                case "5" :
                    System.out.println("\nOpção Transferir\n");
                    transferir.executar();
                    break;
                case "6" :
                    System.out.println("\nOpção Escolher conta\n");
                    escolherConta.executar();
                    break;
                case "7" :
                    MenuInicial.iniciarPrimeiroMenu();
                    scan.close();
                    //TODO iniciarPrimeiroMenu();
                    break;
                default :
                    System.out.println("\nOpção Inválida!");
                    //TODO REFATORAR DIVIDINDO EM MAIS MÉTODOS
            }
        }
    }
}