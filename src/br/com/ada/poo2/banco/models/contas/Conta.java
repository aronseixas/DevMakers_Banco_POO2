package br.com.ada.poo2.banco.models.contas;

import br.com.ada.poo2.banco.interfaces.IConta;

public abstract class Conta implements IConta {

    private int numero;
    private int senha;
    private double saldo;
    private double taxaRendimento;

    public Conta(int numero, int senha, double saldo, double taxaRendimento) {
        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
        this.taxaRendimento = taxaRendimento;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
}
