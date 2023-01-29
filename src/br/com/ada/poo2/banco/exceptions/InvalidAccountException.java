package br.com.ada.poo2.banco.exceptions;

public class InvalidAccountException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Tipo de conta não permite investimento.";
    }
}