package br.com.ada.poo2.banco.models.criarconta;

import br.com.ada.poo2.banco.interfaces.ICriarConta;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.contas.ContaCorrente;
import br.com.ada.poo2.banco.models.contas.ContaInvestimento;
import br.com.ada.poo2.banco.models.contas.ContaPoupanca;
import br.com.ada.poo2.banco.models.enums.EPessoa;

import br.com.ada.poo2.banco.models.enums.ETipoConta;
import br.com.ada.poo2.banco.models.rendimento.RendimentoPF;
import br.com.ada.poo2.banco.models.taxas.TaxasPF;

import java.util.ArrayList;
import java.util.List;


public class CriarContaPessoaFisica implements ICriarConta {
    Conta contaCorrente, contaPoupanca, contaInvestimento;
    List<Conta> listaDeContas = new ArrayList<>();
    @Override
    public List<Conta> criarContas() {
        criarContaCorrente();
        criarContaInvestimento();
        criarContaPoupanca();
        return listaDeContas;
    }

    private void criarContaCorrente() {
        contaCorrente = new ContaCorrente(0000,
                0,
                new RendimentoPF(),
                new TaxasPF(),
                EPessoa.FISICA,
                ETipoConta.CORRENTE);
        listaDeContas.add(contaCorrente);
    }

    private void criarContaPoupanca() {
        contaPoupanca = new ContaPoupanca(0000,
                0,
                new RendimentoPF(),
                new TaxasPF(),
                EPessoa.FISICA,
                ETipoConta.POUPANCA);
        listaDeContas.add(contaPoupanca);
    }

    private void criarContaInvestimento() {
        contaInvestimento = new ContaInvestimento(0000,
                0,
                new RendimentoPF(),
                new TaxasPF(),
                EPessoa.FISICA,
                ETipoConta.INVESTIMENTO);
        listaDeContas.add(contaInvestimento);
    }

}
