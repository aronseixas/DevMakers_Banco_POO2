package br.com.ada.poo2.banco.models.rendimento;

import br.com.ada.poo2.banco.interfaces.IRendimento;
import br.com.ada.poo2.banco.models.enums.ETipoConta;

public class RendimentoPF implements IRendimento {

    @Override
    public double taxaRendimentoDeposito(ETipoConta tipoConta) {

        switch (tipoConta) {

            case POUPANCA:
                return 0.01;

            default:
                return 0;
        }
    }

    public double taxaRendimentoInvestimento(ETipoConta tipoConta) {

        switch (tipoConta) {

            case INVESTIMENTO:
                return 0.015;

            default:
                return 0;
        }
    }
}
