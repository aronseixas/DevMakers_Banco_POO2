package br.com.ada.poo2.banco.models.contas;

import br.com.ada.poo2.banco.interfaces.IRendimento;
import br.com.ada.poo2.banco.interfaces.ITaxas;

public class ContaInvestimento extends Conta {


    public ContaInvestimento(int numero, int senha, double saldo, IRendimento rendimento, ITaxas taxas) {
        super(numero, senha, saldo, rendimento, taxas);
    }

    @Override
    public void sacar(double valor) {

        // saldo = saldo - (valor + (valor * getTaxas().taxa("SAQUE")));

        System.out.printf("SALDO SAQUE: %f\n", getSaldo());
        System.out.printf("FOI FEITO UM SAQUE DE: %f\n",  valor);
        System.out.printf("VALOR DA TAXA: %f", this.getTaxas().taxa("SAQUE"));
        saldo = saldo - valor - (valor * getTaxas().taxa("SAQUE"));
        System.out.printf("\n SALDO APOS SAQUE: %f", getSaldo());


    }


    // FEITO
    @Override
    public void depositar(double valor) {

        saldo = saldo + valor + (valor * getRendimento().taxaRendimento("INVESTIMENTO"));
/*
        System.out.printf("SALDO: %f\n", getSaldo());
        System.out.printf("FOI FEITO UM DEPOSITO DE: %f\n",  valor);
        System.out.print("VALOR TAXA INVESTIMENTO: " + this.getRendimento().taxaRendimento("INVESTIMENTO"));
        saldo = saldo + valor + (valor * getRendimento().taxaRendimento("INVESTIMENTO"));
        System.out.printf("SALDO FINAL: %f", saldo);
*/

    }

    @Override
    public void transferir(double valor, Conta contaDestino) {

    }

    //FEITO
    @Override
    public void checarSaldo() {
        System.out.printf("SALDO EM CONTA: %f", saldo);

    }
}