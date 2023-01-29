package br.com.ada.poo2.banco.exceptions;

public class NoFundsException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Realize um depósito antes de tentar esta operação";
    }
}