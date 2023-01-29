package br.com.ada.poo2.banco.exceptions;

public class InvalidPasswordException extends RuntimeException{
    public String getMessage() {
        return "Usuário ou senha inválida";
    }
}
