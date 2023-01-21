package br.com.ada.poo2.banco.models.pessoas;

import br.com.ada.poo2.banco.models.contas.Conta;

import java.util.List;

public class PessoaFisica extends Pessoa {

    private String CPF;


    public PessoaFisica(String nome, List<Conta> contas, String CPF) {
        super(nome, contas);
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