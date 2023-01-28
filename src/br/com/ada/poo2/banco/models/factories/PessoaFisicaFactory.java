package br.com.ada.poo2.banco.models.factories;


import br.com.ada.poo2.banco.interfaces.ICriarConta;
import br.com.ada.poo2.banco.interfaces.ICriarUsuario;
import br.com.ada.poo2.banco.interfaces.IPessoaFactory;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.criarconta.CriarContaPessoaFisica;
import br.com.ada.poo2.banco.models.criarusuario.CriarUsuarioPessoaFisica;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.List;

public class PessoaFisicaFactory implements IPessoaFactory {
    @Override
    public Pessoa criarUsuario(String nome, int senha) {
       ICriarUsuario criarUsuarioPessoaFisica = new CriarUsuarioPessoaFisica();
       Pessoa usuario = criarUsuarioPessoaFisica.criarUsuario(nome, senha);
       return usuario;
    }

    @Override
    public List<Conta> criarContasDoUsuario(String identificadorDoUsuario) {
        ICriarConta criarContaPessoaFisica = new CriarContaPessoaFisica();
        List<Conta> contas = criarContaPessoaFisica.criarContas(identificadorDoUsuario);
        return contas;
    }

}
