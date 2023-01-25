package br.com.ada.poo2.banco.models.banco;

import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
    Map<String, Pessoa> mapaDeContas = new HashMap<String, Pessoa>();
    //Associa o <Número de Conta, Pessoa>
    Map<String, Pessoa> mapaDeClientes = new HashMap<>();
    Pessoa usuarioLogado;
    Conta contaLogada;


//TODO Deixar pré-carregado uma Pessoa Física e uma Pessoa Jurídica com cada tipo de conta para testes


    public void getListaDeContas() {

    }

    public void setUsuarioLogado(Pessoa usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }

    public Map<String, Pessoa> getMapaDeContas() {
        return mapaDeContas;
    }

    public Map<String, Pessoa> getMapaDeClientes() {
        return mapaDeClientes;
    }

    public Conta getContaLogada() {
        return contaLogada;
    }

    public void setContaLogada(Conta contaLogada) {
        this.contaLogada = contaLogada;
    }
}
