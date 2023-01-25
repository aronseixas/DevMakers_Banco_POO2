package br.com.ada.poo2.banco.models.contas;

import br.com.ada.poo2.banco.interfaces.IConta;
import br.com.ada.poo2.banco.interfaces.IRendimento;
import br.com.ada.poo2.banco.interfaces.ITaxas;
import br.com.ada.poo2.banco.models.enums.EPessoa;
import br.com.ada.poo2.banco.models.enums.ETipoConta;

public  class Conta implements IConta {
    private ETipoConta tipoConta;
    private int numero;
    protected double saldo;
    private IRendimento rendimento;



    private ITaxas taxas;
    private EPessoa pessoa;

    public Conta(int numero, double saldo, IRendimento rendimento, ITaxas taxas, EPessoa pessoa, ETipoConta tipoConta) {
        this.numero = numero;
        //Número vai ser com base no identificador da Pessoa
            //PessoaFIsica - CPF e PessoaJuridica - CNPJ
        this.saldo = saldo;
        this.rendimento = rendimento;
        this.taxas = taxas;
        this.pessoa = pessoa;
        this.tipoConta = tipoConta;
    }

    @Override
    public ITaxas getTaxas() {
        return this.taxas;
    }

    @Override
    public int getNumero() {
        return this.numero;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public void setSaldo(double valor) {
        this.saldo = valor;
    }

    @Override
    public IRendimento getRendimento() {
        return this.rendimento;
    }

    @Override
    public EPessoa getPessoa() {
        return this.pessoa;
    }
    @Override
    public ETipoConta getTipoConta() {
        return tipoConta;
    }
}
