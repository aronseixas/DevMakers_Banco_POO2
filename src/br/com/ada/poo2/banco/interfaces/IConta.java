package br.com.ada.poo2.banco.interfaces;

import br.com.ada.poo2.banco.models.enums.EPessoa;

public interface IConta {
    public ITaxas getTaxas();

    int getNumero();

    double getSaldo();

    void setSaldo(double valor);

    IRendimento getRendimento();

    EPessoa getPessoa();
}

