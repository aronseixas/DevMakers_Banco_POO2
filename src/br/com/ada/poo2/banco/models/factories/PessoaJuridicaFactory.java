package br.com.ada.poo2.banco.models.factories;

import br.com.ada.poo2.banco.interfaces.ICriarConta;
import br.com.ada.poo2.banco.interfaces.ICriarUsuario;
import br.com.ada.poo2.banco.interfaces.IPessoaFactory;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.criarconta.CriarContaPessoaFisica;
import br.com.ada.poo2.banco.models.criarconta.CriarContaPessoaJuridica;
import br.com.ada.poo2.banco.models.criarusuario.CriarUsuarioPessoaFisica;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;
import br.com.ada.poo2.banco.models.rendimento.RendimentoPJ;
import br.com.ada.poo2.banco.models.taxas.TaxasPJ;

import java.util.List;

public class PessoaJuridicaFactory implements IPessoaFactory {

    @Override
    public Pessoa criarUsuario(String nome, int senha) {
        ICriarUsuario criarUsuarioPessoaJuridica = new CriarUsuarioPessoaFisica();
        Pessoa usuario = criarUsuarioPessoaJuridica.criarUsuario(nome, senha);
        return usuario;
    }

    @Override
    public List<Conta> criarContasDoUsuario(String identificadorDoUsuario) {
        ICriarConta criarContaPessoaJuridica = new CriarContaPessoaFisica();
        List<Conta> contas = criarContaPessoaJuridica.criarContas(identificadorDoUsuario);
        return contas;
    }

}
