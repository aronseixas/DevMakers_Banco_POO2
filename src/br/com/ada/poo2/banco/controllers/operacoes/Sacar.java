package br.com.ada.poo2.banco.controllers.operacoes;


import br.com.ada.poo2.banco.applicacao.InsufficientFundsException;


import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class Sacar {

    public void sacarDaContaDoUsuario(double valorSacado) {
        validarValorDoSaque(valorSacado);
        double valorASerDescontadoDaConta = aplicarTaxaSobreSaque(valorSacado);
        double saldoAtualDaConta = banco.getContaLogada().getSaldo();

        banco.getContaLogada().setSaldo(saldoAtualDaConta - valorASerDescontadoDaConta);
    }

    private double aplicarTaxaSobreSaque(double valorSacado) {
        double taxa;
        taxa = banco.getContaLogada().getTaxas().taxa("SAQUE");
        return valorSacado * (1 + taxa);
    }


    public void validarValorDoSaque(double saque) throws InsufficientFundsException {
        if (saque <= 0) {
            throw new InsufficientFundsException();
        }
    }
}