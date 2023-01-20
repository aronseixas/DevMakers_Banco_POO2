package br.com.ada.poo2.banco.models.pessoa;

import br.com.ada.poo2.banco.interfaces.IRendimento;
import br.com.ada.poo2.banco.interfaces.ITaxa;

import java.util.List;

public class PessoaJuridica extends Pessoa implements IRendimento, ITaxa {

    private String CNPJ;

    protected PessoaJuridica(String nome, List contas) {
        super(nome, contas);
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    @Override
    public void render() {

    }

    @Override
    public void taxar() {

    }
}
