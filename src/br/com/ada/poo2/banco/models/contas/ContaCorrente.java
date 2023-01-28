package br.com.ada.poo2.banco.models.contas;

import br.com.ada.poo2.banco.interfaces.IRendimento;
import br.com.ada.poo2.banco.interfaces.ITaxas;
import br.com.ada.poo2.banco.models.enums.EPessoa;
import br.com.ada.poo2.banco.models.enums.ETipoConta;

public class ContaCorrente extends Conta {
    public ContaCorrente(String numero, double saldo, IRendimento rendimento, ITaxas taxas, EPessoa pessoa) {
        super(numero, saldo, rendimento, taxas, pessoa, ETipoConta.CORRENTE);
    }
}
