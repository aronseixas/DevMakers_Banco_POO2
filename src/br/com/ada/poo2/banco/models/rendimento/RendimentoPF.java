package br.com.ada.poo2.banco.models.rendimento;

import br.com.ada.poo2.banco.interfaces.IRendimento;

public class RendimentoPF implements IRendimento {
    @Override
    public double taxaRendimento(String tipoConta) {

        if (tipoConta.equals("POUPANCA")){
            return 0.01;
        } else if (tipoConta.equals("INVESTIMENTO")) {
            return 0.015;
        } else {
            return 0;
        }
    }

}
