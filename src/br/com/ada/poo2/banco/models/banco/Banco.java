package br.com.ada.poo2.banco.models.banco;

import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
    Map<Integer, Pessoa> mapaDeContas = new HashMap<>();
    //Associa o <Número de Conta, Pessoa>
    Map<String, Pessoa> mapaDeClientes = new HashMap<>();
    Pessoa usuarioLogado;

    //TODO Deixar pré-carregado uma Pessoa Física e uma Pessoa Jurídica com cada tipo de conta para testes


    public void getListaDeContas() {

    }

    public void setUsuarioLogado(Pessoa usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }

    public Map<Integer, Pessoa> getMapaDeContas() {
        return mapaDeContas;
    }

    public Map<String, Pessoa> getMapaDeClientes() {
        return mapaDeClientes;
    }
}
