package br.com.ada.poo2.banco.models.pessoas;

import java.util.List;

public class PessoaJuridica extends Pessoa {

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
}
