package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.controllers.menu.MenuInicialController;

import java.util.Scanner;

public class MenuInicialView {
    static Scanner scan = new Scanner(System.in);


    private MenuInicialController menuInicialController;

    public MenuInicialView(MenuInicialController menuInicialController) {
        this.menuInicialController = menuInicialController;
    }

    public void iniciarMenuInicial() {
        String opcaoMenu;
        exibirOpcoes();
        opcaoMenu = receberOpcaoDoUsuario();
        direcionarOperacao(opcaoMenu);
    }

    public void exibirOpcoes() {
        System.out.print("##----------------Bem-vindo ao BANCO-----------------##\n\n");
        System.out.print("|----------------------------------------------------|\n");
        System.out.print("| Opção 1 - Abrir uma nova conta                     |\n");
        System.out.print("| Opção 2 - Acessar sua conta                        |\n");
        System.out.print("| Opção 3 - Fechar                                   |\n");
        System.out.print("|----------------------------------------------------|\n");
        System.out.print("Digite uma opção: ");
    }

    public String receberOpcaoDoUsuario() {
        String opcaoMenu = scan.nextLine();
        return opcaoMenu;
    }

    public void direcionarOperacao(String opcaoMenu) {
        switch (opcaoMenu) {
            case "1":
                menuInicialController.abrirConta();
                break;
            case "2":
                menuInicialController.acessarConta();
                break;
            case "3":
                menuInicialController.fechar();
                break;
            default:
                System.out.println("Opção inválida");
                iniciarMenuInicial();
        }
    }
}
