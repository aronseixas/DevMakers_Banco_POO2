package br.com.ada.poo2.banco.exceptions;

public class UserDoesNotExistException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Usuário ou senha inválida";
    }
}