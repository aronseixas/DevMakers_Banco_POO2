package br.com.ada.poo2.banco.models.pessoas;

import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.enums.EPessoa;

import java.util.List;

public abstract class Pessoa {
    private String nome;
    private List<Conta> contas;
    private int senha;
    private EPessoa tipoDePessoa;

    public Pessoa(String nome, int senha, EPessoa tipoDePessoa) {
        this.nome = nome;
        this.senha = senha;
        this.tipoDePessoa = tipoDePessoa;
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

    public EPessoa getTipoDePessoa() {
        return tipoDePessoa;
    }

    abstract public String getIdentificador();

    abstract public void setIdentificador(String identificador);

    abstract public String tipoDeIdentificador();

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}

