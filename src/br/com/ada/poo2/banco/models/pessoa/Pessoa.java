package br.com.ada.poo2.banco.models.pessoa;

import br.com.ada.poo2.banco.models.conta.Conta;

import java.util.List;

public abstract class Pessoa {

    private String nome;
    private List<Conta> contas;

    protected Pessoa(String nome, List<Conta> contas) {
        this.nome = nome;
        this.contas = contas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
