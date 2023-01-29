package br.com.ada.poo2.banco.exceptions;

public class InsufficientFundsException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Saldo insuficiente.";
    }
}
