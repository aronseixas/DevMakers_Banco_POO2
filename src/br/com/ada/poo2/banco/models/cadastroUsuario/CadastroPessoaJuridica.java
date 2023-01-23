package br.com.ada.poo2.banco.models.cadastroUsuario;

import br.com.ada.poo2.banco.interfaces.ICadastroUsuario;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.contas.ContaCorrente;
import br.com.ada.poo2.banco.models.contas.ContaInvestimento;
import br.com.ada.poo2.banco.models.enums.EPessoa;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;
import br.com.ada.poo2.banco.models.pessoas.PessoaJuridica;
import br.com.ada.poo2.banco.models.rendimento.RendimentoPJ;
import br.com.ada.poo2.banco.models.taxas.TaxasPJ;

import java.util.ArrayList;
import java.util.List;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class CadastroPessoaJuridica implements ICadastroUsuario {
    Conta contaCorrente, contaInvestimento;
    @Override
    public Pessoa criarUsuario(String nome, List<Conta> listaDeContasDoUsuario, int senha, String identificador) {
        return new PessoaJuridica(nome,listaDeContasDoUsuario, senha, identificador);
    }

    @Override
    public List<Conta> criarContasDoUsuario() {
        List<Conta> listaDeContasDoUsuario = new ArrayList<>();
        contaCorrente = new ContaCorrente(0000,
                0,
                new RendimentoPJ(),
                new TaxasPJ(),
                EPessoa.JURIDICA);
        contaInvestimento = new ContaInvestimento(0000,
                0,
                new RendimentoPJ(),
                new TaxasPJ(),
                EPessoa.JURIDICA);
        listaDeContasDoUsuario.add(contaCorrente);
        listaDeContasDoUsuario.add(contaInvestimento);
        return listaDeContasDoUsuario;
    }

    @Override
    public void adicionarContasAoBanco(Pessoa usuario) {
        banco.getMapaDeContas().put(contaCorrente, usuario);
        banco.getMapaDeContas().put(contaInvestimento, usuario);
    }

    @Override
    public void adicionarUsuarioAoBanco(Pessoa usuario, String identificador) {
        banco.getMapaDeClientes().put(identificador, usuario);
    }
}
