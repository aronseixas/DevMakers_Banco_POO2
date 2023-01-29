package br.com.ada.poo2.banco.views;
import br.com.ada.poo2.banco.controllers.menu.MenuOperacoesController;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuOperacoesView {
    Scanner scanner = new Scanner(System.in);
    private MenuOperacoesController menuOperacoesController;

    public MenuOperacoesView(MenuOperacoesController menuOperacoesController) {
        this.menuOperacoesController = menuOperacoesController;
    }

    public void iniciarMenuOperacoesView() {

        try {
            exibirOpcoes();
            int opcaoMenu = receberOpcaoDoUsuario();
            scanner.nextLine();
            direcionarOperacao(opcaoMenu);
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida");
            scanner.nextLine();
        }
    }

    public void exibirOpcoes() {
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
    }

    public int receberOpcaoDoUsuario() {
        System.out.print("Digite uma opção: ");
        int opcao = scanner.nextInt();
        return opcao;
    }

    public void direcionarOperacao(int opcaoMenu) {
        switch (opcaoMenu) {
            case 1:
                System.out.println("\nOpção Consultar Saldo \n");
                menuOperacoesController.consultarSaldo();
                iniciarMenuOperacoesView();
                break;
            case 2:
                System.out.println("\nOpção Sacar \n");
                menuOperacoesController.sacar();
                iniciarMenuOperacoesView();
                break;
            case 3:
                System.out.println("\nOpção Depositar\n");
                menuOperacoesController.depositar();
                iniciarMenuOperacoesView();
                break;
            case 4:
                System.out.println("\nOpção Investir\n");
                menuOperacoesController.investir();
                iniciarMenuOperacoesView();
                break;
            case 5:
                System.out.println("\nOpção Transferir\n");
                menuOperacoesController.transferir();
                iniciarMenuOperacoesView();
                break;
            case 6:
                System.out.println("\nOpção Escolher Conta\n");
                menuOperacoesController.escolherConta();
                iniciarMenuOperacoesView();
                break;
            case 7 :
                menuOperacoesController.deslogar();
                break;
            default:
                System.out.println("\nOpção Inválida!");
                iniciarMenuOperacoesView();
        }
    }
}