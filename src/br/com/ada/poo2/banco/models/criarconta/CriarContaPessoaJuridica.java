package br.com.ada.poo2.banco.models.criarconta;

import br.com.ada.poo2.banco.interfaces.ICriarConta;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.contas.ContaCorrente;
import br.com.ada.poo2.banco.models.contas.ContaInvestimento;
import br.com.ada.poo2.banco.models.enums.EPessoa;
import br.com.ada.poo2.banco.models.enums.ETipoConta;
import br.com.ada.poo2.banco.models.rendimento.RendimentoPJ;
import br.com.ada.poo2.banco.models.taxas.TaxasPJ;

import java.util.ArrayList;
import java.util.List;

public class CriarContaPessoaJuridica implements ICriarConta {
    Conta contaCorrente, contaInvestimento;

    List<Conta> listaDeContas = new ArrayList<>();

    private String identificadorCNPJ;
    @Override
    public List<Conta> criarContas(String identificadorCNPJ) {
        this.identificadorCNPJ = identificadorCNPJ;
        criarContaCorrente();
        criarContaInvestimento();
        return listaDeContas;
    }

    private void criarContaCorrente() {
        String identificadorUsuarioContaCorrente = identificadorCNPJ + ".1";
        contaCorrente = new ContaCorrente(identificadorUsuarioContaCorrente,
                0,
                new RendimentoPJ(),
                new TaxasPJ(),
                EPessoa.JURIDICA,
                ETipoConta.CORRENTE);
        listaDeContas.add(contaCorrente);
    }

    public void criarContaInvestimento() {
        String identificadorUsuarioContaInvestimento = identificadorCNPJ + ".3";
        contaInvestimento = new ContaInvestimento(identificadorUsuarioContaInvestimento,
                0,
                new RendimentoPJ(),
                new TaxasPJ(),
                EPessoa.JURIDICA,
                ETipoConta.INVESTIMENTO);
        listaDeContas.add(contaInvestimento);
    }
}
