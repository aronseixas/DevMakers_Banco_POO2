package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.applicacao.InvalidPasswordException;
import br.com.ada.poo2.banco.applicacao.UserDoesNotExistException;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class LogarUsuario {

    public void iniciarLogarUsuario(String identificadorDigitado, int senhaDigitada){
        Pessoa usuario;

        usuario = identificarUsuario(identificadorDigitado);
        verificarSenha(usuario, senhaDigitada);
    }


    public Pessoa identificarUsuario(String identificadorDigitado) throws UserDoesNotExistException {
        Pessoa usuario = banco.getMapaIdentificadorEUsuario().get(identificadorDigitado);
        if (usuario == null) {
            throw new UserDoesNotExistException();
        } else {
            return usuario;
        }
    }


    public void verificarSenha(Pessoa usuario, int senhaDigitada) throws InvalidPasswordException {
        if (senhaDigitada == usuario.getSenha()){
            logarUsarioCadastrado(usuario);
            //TODO retirar daqui. Talvez colocar um boolean loginPOdeProceder
        }
        else {
            throw new InvalidPasswordException();
        }
    }

    private void logarUsarioCadastrado(Pessoa usuario) {
        banco.setUsuarioLogado(usuario);
    }

    public void logarUsarioNovo(Pessoa novoUsuario) {
        Pessoa usuario = novoUsuario;
        logarUsarioCadastrado(usuario);
    }
}
