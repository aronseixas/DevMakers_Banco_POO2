package br.com.ada.poo2.banco.exceptions;

public class UserAlreadyExistsException extends RuntimeException{

    @Override
    public String getMessage() {
        return "CPF ou CNPJ já utilizado";
    }
}
