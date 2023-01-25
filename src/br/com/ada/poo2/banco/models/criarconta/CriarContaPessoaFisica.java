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
    private String identificadorCPF;
    @Override
    public List<Conta> criarContas(String identificadorDoUsuario) {
        this.identificadorCPF = identificadorDoUsuario;
        criarContaCorrente();
        criarContaInvestimento();
        criarContaPoupanca();
        return listaDeContas;
    }

    private void criarContaCorrente() {
        String identificadorDoUsuarioContaCorrente = identificadorCPF + ".1";
        contaCorrente = new ContaCorrente(identificadorDoUsuarioContaCorrente,
                0,
                new RendimentoPF(),
                new TaxasPF(),
                EPessoa.FISICA,
                ETipoConta.CORRENTE);
        listaDeContas.add(contaCorrente);
    }

    private void criarContaPoupanca() {
        String identificadorDoUsuarioContaPoupanca = identificadorCPF + ".2";
        contaPoupanca = new ContaPoupanca(identificadorDoUsuarioContaPoupanca,
                0,
                new RendimentoPF(),
                new TaxasPF(),
                EPessoa.FISICA,
                ETipoConta.POUPANCA);
        listaDeContas.add(contaPoupanca);
    }

    private void criarContaInvestimento() {
        String identificadorDoUsuarioContaInvestimento = identificadorCPF + ".3";
        contaInvestimento = new ContaInvestimento(identificadorDoUsuarioContaInvestimento,
                0,
                new RendimentoPF(),
                new TaxasPF(),
                EPessoa.FISICA,
                ETipoConta.INVESTIMENTO);
        listaDeContas.add(contaInvestimento);
    }

}
