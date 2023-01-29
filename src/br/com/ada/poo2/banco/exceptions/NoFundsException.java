package br.com.ada.poo2.banco.exceptions;

public class NoFundsException extends RuntimeException{

    public String getMessage(){
        return "Conta não possui saldo para investir.";
    }

}
