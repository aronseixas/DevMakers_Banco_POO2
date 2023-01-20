package br.com.ada.poo2.banco.models.pessoa;

import br.com.ada.poo2.banco.interfaces.IRendimento;

import java.util.List;

public class PessoaFisica extends Pessoa implements IRendimento {

    private String CPF;

    protected PessoaFisica(String nome, List contas) {
        super(nome, contas);
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public void render() {

    }
}
