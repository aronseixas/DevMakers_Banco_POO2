package br.com.ada.poo2.banco.controllers.menu;

import br.com.ada.poo2.banco.controllers.operacoes.*;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.Scanner;

public class MenuInicial {

    static Scanner scan = new Scanner(System.in);
    public static void iniciarPrimeiroMenu(){

        while (true) {

            System.out.print("##----------------Bem-vindo ao BANCO-----------------##\n\n");
            System.out.print("|----------------------------------------------------|\n");
            System.out.print("| Opção 1 - Abrir uma nova conta                     |\n");
            System.out.print("| Opção 2 - Acessar sua conta                        |\n");
            System.out.print("| Opção 3 - Fechar                                   |\n");
            System.out.print("|----------------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            String opcao = scan.next();
            LogarUsuario logar = new LogarUsuario();
            EscolherConta escolherConta = new EscolherConta();
            MenuOperacoes menuOperacoes = new MenuOperacoes();

            switch (opcao) {

                case "1" :
                    System.out.println("\nOpção abrir uma conta \n");
                    DeterminarFactory determinarFactory = new DeterminarFactory();
                    determinarFactory.executar();
                    CadastrarUsuario cadastrarUsuario = new CadastrarUsuario();
                    cadastrarUsuario.executar();
                    Pessoa usuarioCadastrado = cadastrarUsuario.getUsuarioCadastrado();
                    CriarConta criarConta = new CriarConta();
                    criarConta.executar(usuarioCadastrado);
                    logar.logarUsarioNovo(usuarioCadastrado);
                    escolherConta.executar();
                    menuOperacoes.iniciarMenuOperacoes();

                    //TODO SUGESTÃO - colocar funções dentro dos switches e nelas fazer o fluxo.
                    break;
                case "2" :
                    System.out.println("\nOpção acessar sua conta\n");
                    logar.executar();
                    escolherConta.executar();
                    menuOperacoes.iniciarMenuOperacoes();
                    break;
                case "3" :
                        System.out.print("\nAté logo!");
                        scan.close();
                        System.exit(0);
                        break;
                default:
                    System.out.println("\nOpção Inválida!");

                    //TODO se tirar o while - fazer default voltar ao menu enicial.
            }
        }
    }
}
