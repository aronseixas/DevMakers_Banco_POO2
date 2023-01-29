package br.com.ada.poo2.banco.controllers.operacoes;


import br.com.ada.poo2.banco.exceptions.InsufficientFundsException;
import br.com.ada.poo2.banco.exceptions.InvalidValueException;
import br.com.ada.poo2.banco.exceptions.NoFundsException;


import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class SacarController {

    public void sacarDaContaDoUsuario(double valorSacado) {
        validarValorDoSaque(valorSacado);
        validarSaldoSuficiente(valorSacado);
        double valorASerDescontadoDaConta = aplicarTaxaSobreSaque(valorSacado);
        double saldoAtualDaConta = banco.getContaLogada().getSaldo();

        banco.getContaLogada().setSaldo(saldoAtualDaConta - valorASerDescontadoDaConta);
    }

    private double aplicarTaxaSobreSaque(double valorSacado) {
        double taxa;
        taxa = banco.getContaLogada().getTaxas().taxa("SAQUE");
        return valorSacado * (1 + taxa);
    }

    public void validarSaldoPositivoConta() throws NoFundsException {
        if(banco.getContaLogada().getSaldo() <= 0){
            throw new NoFundsException();
        }
    }

    private void validarValorDoSaque(double valorSacado) throws InvalidValueException {
        if (valorSacado <= 0) {
            throw new InvalidValueException();
        }
    }

    private void validarSaldoSuficiente(double valorSacado) throws InsufficientFundsException {
        if (banco.getContaLogada().getSaldo() < valorSacado) {
            throw new InsufficientFundsException();
        }
    }



}