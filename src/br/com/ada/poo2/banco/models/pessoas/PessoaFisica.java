package br.com.ada.poo2.banco.models.pessoas;

import br.com.ada.poo2.banco.models.enums.EPessoa;

public class PessoaFisica extends Pessoa {

    private String CPF;

    public PessoaFisica(String nome, int senha, EPessoa tipoDePessoa, String CPF) {
        super(nome, senha, tipoDePessoa);
        this.CPF = CPF;
    }


    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String toString(){
        return getNome();
    }


}