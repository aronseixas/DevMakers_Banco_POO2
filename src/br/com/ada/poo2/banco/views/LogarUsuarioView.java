package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.controllers.operacoes.LogarUsuarioController;

import java.util.Scanner;

public class LogarUsuarioView {

    Scanner scanner = new Scanner(System.in);
    LogarUsuarioController logarUsuarioController = new LogarUsuarioController();

    public void iniciarLogarUsuarioView() {
        String identificadorDigitado = pedirIdentificador();
        int senhaDigitada = pedirSenha();
        logarUsuarioController.iniciarLogarUsuario(identificadorDigitado, senhaDigitada);
    }

    public String pedirIdentificador() {
        System.out.println("Digite o CPF ou CNPJ:");
        String identificadorDigitado = scanner.nextLine();
        return identificadorDigitado;
    }

    public int pedirSenha() {
        System.out.println("Digite sua senha: ");
        int senhaDigitada = scanner.nextInt();
        return senhaDigitada;
    }
}
