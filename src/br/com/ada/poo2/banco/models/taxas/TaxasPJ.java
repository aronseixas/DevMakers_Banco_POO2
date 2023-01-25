package br.com.ada.poo2.banco.models.taxas;

import br.com.ada.poo2.banco.interfaces.ITaxas;

public class TaxasPJ implements ITaxas {

    @Override
    public double taxa(String tipoOperacao) {

        if(tipoOperacao.equals("SAQUE")) {
            return 0.005;
        } else if (tipoOperacao.equals("TRANSFERENCIA")) {
            return 0.005;
        } else {
            return 0;
        }
    }
}
