package br.com.ada.poo2.banco.models.criarconta;

import br.com.ada.poo2.banco.interfaces.ICriarConta;
import br.com.ada.poo2.banco.interfaces.IRendimento;
import br.com.ada.poo2.banco.interfaces.ITaxas;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.contas.ContaCorrente;
import br.com.ada.poo2.banco.models.contas.ContaInvestimento;
import br.com.ada.poo2.banco.models.enums.EPessoa;
import br.com.ada.poo2.banco.models.rendimento.RendimentoPJ;
import br.com.ada.poo2.banco.models.taxas.TaxasPJ;

import java.util.ArrayList;
import java.util.List;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class CriarContaPessoaJuridica implements ICriarConta {
    List<Conta> listaDeContas = new ArrayList<>();
    Conta contaCorrente, contaInvestimento;
    private final EPessoa TIPO_DE_PESSOA = EPessoa.JURIDICA;
    private final IRendimento TAXA_DE_RENDIMENTO = new RendimentoPJ();
    private final ITaxas TAXA_DE_OPERACAO = new TaxasPJ();

    @Override
    public List<Conta> criarContas(String identificadorDoUsuario) {
        String CNPJ = identificadorDoUsuario;
        criarContaCorrente(CNPJ);
        criarContaInvestimento(CNPJ);
        return listaDeContas;
    }

    private void criarContaCorrente(String CNPJ) {
        String numeroContaCorrente = CNPJ + ".1";
        contaCorrente = new ContaCorrente(
                numeroContaCorrente,
                0,
                TAXA_DE_RENDIMENTO,
                TAXA_DE_OPERACAO,
                TIPO_DE_PESSOA);
        listaDeContas.add(contaCorrente);
        banco.getMapaDeNumeroContaEConta().put(numeroContaCorrente, contaCorrente);
    }

    public void criarContaInvestimento(String CNPJ) {
        String numeroContaInvestimento = CNPJ + ".3";
        contaInvestimento = new ContaInvestimento(
                numeroContaInvestimento,
                0,
                TAXA_DE_RENDIMENTO,
                TAXA_DE_OPERACAO,
                TIPO_DE_PESSOA);
        listaDeContas.add(contaInvestimento);
        banco.getMapaDeNumeroContaEConta().put(numeroContaInvestimento, contaInvestimento);
    }
}
