package br.com.ada.poo2.banco.models.criarconta;

import br.com.ada.poo2.banco.interfaces.ICriarConta;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.contas.ContaCorrente;
import br.com.ada.poo2.banco.models.contas.ContaInvestimento;
import br.com.ada.poo2.banco.models.enums.EPessoa;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;
import br.com.ada.poo2.banco.models.rendimento.RendimentoPJ;
import br.com.ada.poo2.banco.models.taxas.TaxasPJ;

import java.util.ArrayList;
import java.util.List;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class CriarContaPessoaJuridica implements ICriarConta {
    Conta contaCorrente, contaInvestimento;

    List<Conta> listaDeContas = new ArrayList<>();


    @Override
    public List<Conta> criarContas() {
        criarContaCorrente();
        criarContaInvestimento();
        return listaDeContas;
    }

    private void criarContaCorrente() {
        contaCorrente = new ContaCorrente(0000,
                0,
                new RendimentoPJ(),
                new TaxasPJ(),
                EPessoa.JURIDICA);
        listaDeContas.add(contaCorrente);
    }

    public void criarContaInvestimento() {
        contaInvestimento = new ContaInvestimento(0000,
                0,
                new RendimentoPJ(),
                new TaxasPJ(),
                EPessoa.JURIDICA);
        listaDeContas.add(contaInvestimento);
    }
}
