package br.com.ada.poo2.banco.models.pessoas;

import br.com.ada.poo2.banco.models.contas.Conta;

import java.util.List;

public class PessoaJuridica extends Pessoa {

    private String CNPJ;

    public PessoaJuridica(String nome, List<Conta> contas, String CNPJ) {
        super(nome, contas);
        this.CNPJ = CNPJ;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}
