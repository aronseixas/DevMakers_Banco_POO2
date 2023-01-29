package br.com.ada.poo2.banco.models.criarconta;
import br.com.ada.poo2.banco.interfaces.ICriarConta;
import br.com.ada.poo2.banco.interfaces.IRendimento;
import br.com.ada.poo2.banco.interfaces.ITaxas;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.contas.ContaCorrente;
import br.com.ada.poo2.banco.models.contas.ContaInvestimento;
import br.com.ada.poo2.banco.models.contas.ContaPoupanca;
import br.com.ada.poo2.banco.models.enums.EPessoa;
import br.com.ada.poo2.banco.models.rendimento.RendimentoPF;
import br.com.ada.poo2.banco.models.taxas.TaxasPF;
import java.util.ArrayList;
import java.util.List;
import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class CriarContaPessoaFisica implements ICriarConta {
    Conta contaCorrente, contaPoupanca, contaInvestimento;
    List<Conta> listaDeContas = new ArrayList<>();
    private final EPessoa TIPO_DE_PESSOA = EPessoa.FISICA;
    private IRendimento taxaDeRendimento = new RendimentoPF();
    private ITaxas taxaDeOperacao = new TaxasPF();
    @Override
    public List<Conta> criarContas(String identificadorDoUsuario) {
        String CPF = identificadorDoUsuario;
        criarContaCorrente(CPF);
        criarContaInvestimento(CPF);
        criarContaPoupanca(CPF);
        return listaDeContas;
    }

    private void criarContaCorrente(String CPF) {
        String numeroContaCorrente = CPF + ".1";
        contaCorrente = new ContaCorrente(
                numeroContaCorrente,
                0,
                taxaDeRendimento,
                taxaDeOperacao,
                TIPO_DE_PESSOA);
        listaDeContas.add(contaCorrente);
        banco.getMapaDeNumeroContaEConta().put(numeroContaCorrente, contaCorrente);
    }

    private void criarContaPoupanca(String CPF) {
        String numeroContaPoupanca = CPF + ".2";
        contaPoupanca = new ContaPoupanca(
                numeroContaPoupanca,
                0,
                taxaDeRendimento,
                taxaDeOperacao,
                TIPO_DE_PESSOA);
        listaDeContas.add(contaPoupanca);
        banco.getMapaDeNumeroContaEConta().put(numeroContaPoupanca, contaPoupanca);
    }

    private void criarContaInvestimento(String CPF) {
        String numeroContaInvestimento = CPF + ".3";
        contaInvestimento = new ContaInvestimento(
                numeroContaInvestimento,
                0,
                taxaDeRendimento,
                taxaDeOperacao,
                TIPO_DE_PESSOA);
        listaDeContas.add(contaInvestimento);
        banco.getMapaDeNumeroContaEConta().put(numeroContaInvestimento, contaInvestimento);
    }
}