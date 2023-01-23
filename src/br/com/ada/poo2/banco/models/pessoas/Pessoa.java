package br.com.ada.poo2.banco.models.pessoas;

import br.com.ada.poo2.banco.models.contas.Conta;

import java.util.List;

public abstract class Pessoa {
    private String nome;
    private List<Conta> contas;
    private int senha;


    public Pessoa(String nome, List<Conta> contas, int senha) {
        this.nome = nome;
        this.contas = contas;
        this.senha = senha;
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

    public int getSenha() {
        return senha;
    }
}

