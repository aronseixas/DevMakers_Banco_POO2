package br.com.ada.poo2.banco.interfaces;
import br.com.ada.poo2.banco.models.enums.EPessoa;
import br.com.ada.poo2.banco.models.enums.ETipoConta;

public interface IConta {
    public ITaxas getTaxas();

    String getNumero();

    double getSaldo();

    void setSaldo(double valor);

    IRendimento getRendimento();

    EPessoa getPessoa();

    ETipoConta getTipoConta();
}