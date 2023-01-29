package br.com.ada.poo2.banco.exceptions;

public class InvalidInputException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Opção Inválida";
    }
}
