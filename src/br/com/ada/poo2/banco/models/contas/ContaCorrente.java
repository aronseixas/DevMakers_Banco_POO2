package br.com.ada.poo2.banco.models.contas;

import br.com.ada.poo2.banco.interfaces.IRendimento;
import br.com.ada.poo2.banco.interfaces.ITaxas;
import br.com.ada.poo2.banco.models.enums.EPessoa;

public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, double saldo, IRendimento rendimento, ITaxas taxas, EPessoa pessoa) {
        super(numero, saldo, rendimento, taxas, pessoa);
    }


}
