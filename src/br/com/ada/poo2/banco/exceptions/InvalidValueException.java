package br.com.ada.poo2.banco.exceptions;

public class InvalidValueException extends RuntimeException{

    @Override
    public String getMessage(){

       return "Valor inválido!";
    }

    public String getMessageTransferir(){
        return "Valor inválido!";
    }



}
