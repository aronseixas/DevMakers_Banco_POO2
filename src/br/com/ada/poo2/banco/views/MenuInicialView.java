package br.com.ada.poo2.banco.views;
import br.com.ada.poo2.banco.controllers.menu.MenuInicialController;
import java.util.Scanner;

public class MenuInicialView {
    Scanner scanner = new Scanner(System.in);
    private MenuInicialController menuInicialController;

    public MenuInicialView(MenuInicialController menuInicialController) {
        this.menuInicialController = menuInicialController;
    }

    public void iniciarMenuInicial() {

        try {
            exibirOpcoes();
            int opcaoMenu = receberOpcaoDoUsuario();
            scanner.nextLine();
            direcionarOperacao(opcaoMenu);
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Opção inválida");
            iniciarMenuInicial();
        }
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

    public int receberOpcaoDoUsuario() {
        int opcao = scanner.nextInt();
        return opcao;
    }

    public void direcionarOperacao(int opcaoMenu) {
        switch (opcaoMenu) {
            case 1:
                System.out.println("\nOpção Abrir Conta\n");
                menuInicialController.abrirConta();
                iniciarMenuInicial();
                break;
            case 2:
                System.out.println("\nOpção Acessar Conta\n");
                menuInicialController.acessarConta();
                iniciarMenuInicial();
                break;
            case 3:
                menuInicialController.fechar();
                break;
            default:
                System.out.println("Opção inválida");
                iniciarMenuInicial();
        }
    }
}