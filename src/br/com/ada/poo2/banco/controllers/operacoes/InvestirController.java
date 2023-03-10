package br.com.ada.poo2.banco.controllers.operacoes;
import br.com.ada.poo2.banco.exceptions.InsufficientFundsException;
import br.com.ada.poo2.banco.exceptions.InvalidAccountException;
import br.com.ada.poo2.banco.exceptions.NoFundsException;
import br.com.ada.poo2.banco.models.enums.ETipoConta;
import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class InvestirController {

    public void executar(double valorASerInvestido) {
        validarValorInvestir(valorASerInvestido);
        double saldoAtualDaConta = banco.getContaLogada().getSaldo();
        double rendimentoDoInvestimento = aplicarRendimento(valorASerInvestido);
        banco.getContaLogada().setSaldo(saldoAtualDaConta - valorASerInvestido + rendimentoDoInvestimento);
    }

    public void validarValorInvestir(double valorASerInvestido) throws InsufficientFundsException {
        if (banco.getContaLogada().getSaldo() < valorASerInvestido) {
            throw new InsufficientFundsException();
        }
    }

    private double aplicarRendimento(double valorASerInvestido){
        double rendimento = banco.getContaLogada().getRendimento().taxaRendimentoInvestimento(ETipoConta.INVESTIMENTO);
         return valorASerInvestido * (1 + rendimento);
    }

    public void validarTipoConta() throws InvalidAccountException {
        if(banco.getContaLogada().getTipoConta() != ETipoConta.INVESTIMENTO){
            throw new InvalidAccountException();
        }
    }

    public void validarSaldoPositivoConta() throws NoFundsException {
        if(banco.getContaLogada().getSaldo() <= 0){
            throw new NoFundsException();
        }
    }
}
