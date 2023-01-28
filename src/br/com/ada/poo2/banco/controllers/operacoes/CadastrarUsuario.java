package br.com.ada.poo2.banco.controllers.operacoes;
import br.com.ada.poo2.banco.interfaces.IPessoaFactory;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.Map;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class CadastrarUsuario {
    Pessoa usuarioCadastrado;

    public Pessoa criarUsuario(String nome, int senha) {
        IPessoaFactory pessoaFactory = banco.getPessoaFactory();
        return pessoaFactory.criarUsuario(nome, senha);

    }

    public void adicionarIdentificadorAoUsuario(String identificador, Pessoa usuario) {
        usuario.setIdentificador(identificador);
    }

    public void adicionarUsuarioAoBanco(Pessoa usuario) {
        Map<String, Pessoa> mapaIdentificadorUsuario;
        mapaIdentificadorUsuario = banco.getMapaIdentificadorEUsuario();
        mapaIdentificadorUsuario.put(usuario.getIdentificador(), usuario);
    }

    public Pessoa getUsuarioCadastrado() {
        return this.usuarioCadastrado;
    }
    // TODO talvez colocar em sua própria classe
}
