package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.exceptions.UserDoesNotExistException;
import br.com.ada.poo2.banco.controllers.operacoes.LogarUsuario;

import java.util.Scanner;

public class LogarUsuarioView {

    Scanner scanner = new Scanner(System.in);
    LogarUsuario logarUsuario = new LogarUsuario();

    public void iniciarLogarUsuarioView() {
        String identificadorDigitado = pedirIdentificador();
        int senhaDigitada = pedirSenha();
        identificarUsuario(identificadorDigitado, senhaDigitada);
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
        // TODO implementar o try catch para validar se a senha tem os digitos necessários
    }

    public void identificarUsuario(String identificadorDigitado, int senhaDigitada) {
        try {
            logarUsuario.iniciarLogarUsuario(identificadorDigitado, senhaDigitada);
        } catch (UserDoesNotExistException e) {
            System.out.println("Senha e/ou usuário inválido. Tente novamente.");
            scanner.nextLine();
            iniciarLogarUsuarioView();
        }
    }
}
