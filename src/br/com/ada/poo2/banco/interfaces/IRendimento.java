package br.com.ada.poo2.banco.interfaces;
import br.com.ada.poo2.banco.models.enums.ETipoConta;

public interface IRendimento {
    double taxaRendimentoDeposito(ETipoConta tipoConta);
    double taxaRendimentoInvestimento(ETipoConta tipoConta);
}