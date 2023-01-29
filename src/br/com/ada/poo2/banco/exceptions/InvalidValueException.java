package br.com.ada.poo2.banco.exceptions;

public class InvalidValueException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Valor não pode ser menor ou igual a zero!";
    }
}