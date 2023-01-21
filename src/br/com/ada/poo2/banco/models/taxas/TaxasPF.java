package br.com.ada.poo2.banco.models.taxas;

import br.com.ada.poo2.banco.interfaces.ITaxas;

public class TaxasPF implements ITaxas {

    @Override
    public double taxa(String tipoOperacao) {
        return 0;
    }
}