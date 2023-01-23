package br.com.ada.poo2.banco.models.banco;

import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
    Map<Conta, Pessoa> mapaDeContas = new HashMap<>();
    //Pode ser talvez um map<Número de Conta, Pessoa>

    Map<String, Pessoa> mapaDeClientes = new HashMap<>();
    List<Pessoa> listaDeClientes;
    Pessoa usuarioLogado;

    //Deixar pré-carregado uma Pessoa Física e uma Pessoa Jurídica com cada tipo de conta para testes


    public void getListaDeContas() {

    }

    public void setUsuarioLogado(Pessoa usuarioLogado) {

    }

    public Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }

    public Map<Conta, Pessoa> getMapaDeContas() {
        return mapaDeContas;
    }

    public List<Pessoa> getListaDeClientes() {
        return listaDeClientes;
    }

    public Map<String, Pessoa> getMapaDeClientes() {
        return mapaDeClientes;
    }
}
