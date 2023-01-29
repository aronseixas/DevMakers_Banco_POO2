package br.com.ada.poo2.banco.exceptions;

public class InsufficientFundsException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Valor inválido! Saldo insuficiente.";
    }

    public String getMessageSaque(){
        return "Opção inválida!";
    }

    public String getMessageSaqueTransferir(){
        return "Saldo insuficiente. Operação cancelada.";
    }



}
