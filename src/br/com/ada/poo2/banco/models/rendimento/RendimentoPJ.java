package br.com.ada.poo2.banco.models.rendimento;

import br.com.ada.poo2.banco.interfaces.IRendimento;

public class RendimentoPJ implements IRendimento {
    @Override
    public double taxaRendimento(String tipoConta) {

        if (tipoConta.equals("INVESTIMENTO")) {
            return 0.035;
        } else {
            return 0;
        }
    }
}
