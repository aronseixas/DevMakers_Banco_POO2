package br.com.ada.poo2.banco.exceptions;

public class InvalidInputException extends RuntimeException{

    public String getMessage(){
        return "Opção inválida!";
    }

}
