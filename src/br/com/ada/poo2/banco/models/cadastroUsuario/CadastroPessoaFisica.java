package br.com.ada.poo2.banco.models.cadastroUsuario;

import br.com.ada.poo2.banco.interfaces.ICadastroUsuario;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.contas.ContaCorrente;
import br.com.ada.poo2.banco.models.contas.ContaInvestimento;
import br.com.ada.poo2.banco.models.contas.ContaPoupanca;
import br.com.ada.poo2.banco.models.enums.EPessoa;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;
import br.com.ada.poo2.banco.models.pessoas.PessoaFisica;
import br.com.ada.poo2.banco.models.rendimento.RendimentoPF;
import br.com.ada.poo2.banco.models.taxas.TaxasPF;

import java.util.ArrayList;
import java.util.List;


public class CadastroPessoaFisica implements ICadastroUsuario {

    Conta contaCorrente, contaPoupanca, contaInvestimento;
    @Override
    public Pessoa criarUsuario(String nome, List<Conta> listaDeContasDoUsuario, int senha, String identificador) {
        return new PessoaFisica(nome, listaDeContasDoUsuario, senha, identificador);
    }

    @Override
    public List<Conta> criarContasDoUsuario() {
        List<Conta> listaDeContasDoUsuario = new ArrayList<>();
        contaCorrente = new ContaCorrente(0000,
                0,
                new RendimentoPF(),
                new TaxasPF(),
                EPessoa.FISICA);
        contaPoupanca = new ContaPoupanca(0000,
                0,
                new RendimentoPF(),
                new TaxasPF(),
                EPessoa.FISICA);
        contaInvestimento = new ContaInvestimento(0000,
                0,
                new RendimentoPF(),
                new TaxasPF(),
                EPessoa.FISICA);
        listaDeContasDoUsuario.add(contaCorrente);
        listaDeContasDoUsuario.add(contaPoupanca);
        listaDeContasDoUsuario.add(contaInvestimento);
        return listaDeContasDoUsuario;
    }

    @Override
    public void adicionarContasAoBanco(Pessoa usuario) {
        banco.getMapaDeContas().put(contaCorrente, usuario);
        banco.getMapaDeContas().put(contaInvestimento, usuario);
        banco.getMapaDeContas().put(contaPoupanca, usuario);
    }

    @Override
    public void adicionarUsuarioAoBanco(Pessoa usuario, String identificador) {
        banco.getMapaDeClientes().put(identificador, usuario);
    }
}
