package br.com.ada.poo2.banco.exceptions;

public class UserDoesNotExistException extends RuntimeException{

    public String getMessage(){
        return "Essa conta não existe.";
    }

    public String getMessageTransferir(){
        return "Conta destino não encontrada. Operação cancelada.";
    }



}
