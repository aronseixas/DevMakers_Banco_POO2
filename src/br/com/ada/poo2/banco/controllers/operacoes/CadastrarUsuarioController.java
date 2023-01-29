package br.com.ada.poo2.banco.controllers.operacoes;
import br.com.ada.poo2.banco.exceptions.UserAlreadyExistsException;
import br.com.ada.poo2.banco.interfaces.IPessoaFactory;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;
import java.util.Map;
import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class CadastrarUsuarioController {
    Pessoa usuario;
    String identificador;

    public void criarUsuario(String nome, int senha) {
        IPessoaFactory pessoaFactory = banco.getPessoaFactory();
        usuario = pessoaFactory.criarUsuario(nome, senha);
        setUsuarioCadastrado();
    }

    private void setUsuarioCadastrado() {
        banco.setUsuarioCadastrado(usuario);
    }

    public void adicionarIdentificadorAoUsuario(String identificador) {
        this.identificador = identificador;
        validarIdentificadorJaUtilizado();
        usuario.setIdentificador(identificador);
    }

    public String pegarTipoIdentificadorUsuario() {
        return usuario.tipoDeIdentificador();
    }

    public void adicionarUsuarioAoBanco() {
        Map<String, Pessoa> mapaIdentificadorUsuario;
        mapaIdentificadorUsuario = banco.getMapaIdentificadorEUsuario();
        mapaIdentificadorUsuario.put(identificador, usuario);
    }

    public void validarIdentificadorJaUtilizado() throws UserAlreadyExistsException{
        Pessoa usuarioAEncontrar = banco.getMapaIdentificadorEUsuario().get(identificador);
        if (usuarioAEncontrar != null) {
            throw new UserAlreadyExistsException();
        }
    }
}
