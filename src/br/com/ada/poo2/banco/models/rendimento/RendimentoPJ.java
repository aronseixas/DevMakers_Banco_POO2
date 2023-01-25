package br.com.ada.poo2.banco.models.rendimento;

import br.com.ada.poo2.banco.interfaces.IRendimento;
import br.com.ada.poo2.banco.models.enums.ETipoConta;

public class RendimentoPJ implements IRendimento {

    @Override
    public double taxaRendimentoDeposito(ETipoConta tipoConta) {
       return 0;
    }

    @Override
    public double taxaRendimentoInvestimento(ETipoConta tipoConta) {
        switch (tipoConta) {

            case INVESTIMENTO:
                return 0.035;

            default:
                return 0;
        }
    }
}
