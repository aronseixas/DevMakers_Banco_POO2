package br.com.ada.poo2.banco.models.pessoas;

import br.com.ada.poo2.banco.models.enums.EPessoa;

public class PessoaJuridica extends Pessoa {

    private String CNPJ;

    public PessoaJuridica(String nome, int senha, EPessoa tipoDePessoa, String CNPJ) {
        super(nome, senha, tipoDePessoa);
        this.CNPJ = CNPJ;
    }


    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}
