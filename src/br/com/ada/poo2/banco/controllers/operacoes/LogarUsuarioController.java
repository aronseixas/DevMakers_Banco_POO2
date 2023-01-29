package br.com.ada.poo2.banco.controllers.operacoes;
import br.com.ada.poo2.banco.exceptions.InvalidPasswordException;
import br.com.ada.poo2.banco.exceptions.UserDoesNotExistException;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;
import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class LogarUsuarioController {
    Pessoa usuario;
    public void iniciarLogarUsuario(String identificadorDigitado, int senhaDigitada){
        identificarUsuario(identificadorDigitado);
        verificarSenha(senhaDigitada);
        logarUsarioJaCadastrado();
    }

    private void identificarUsuario(String identificadorDigitado) throws UserDoesNotExistException {
        usuario = banco.getMapaIdentificadorEUsuario().get(identificadorDigitado);
        if (usuario == null) {
            throw new UserDoesNotExistException();
        }
    }

    private void verificarSenha( int senhaDigitada) throws InvalidPasswordException {
        if (senhaDigitada != usuario.getSenha()) {
            throw new InvalidPasswordException();
        }
    }

    private void logarUsarioJaCadastrado() {
        banco.setUsuarioLogado(usuario);
    }

    public void logarUsarioNovo() {
        usuario = banco.getUsuarioCadastrado();
        logarUsarioJaCadastrado();
    }
}