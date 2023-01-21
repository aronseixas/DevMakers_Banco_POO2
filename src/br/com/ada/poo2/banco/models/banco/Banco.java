package br.com.ada.poo2.banco.models.banco;

import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.List;
import java.util.Map;

public class Banco {
    Map<Conta, Pessoa> listaDeContas;
    //Pode ser talvez um map<Número de Conta, Pessoa>
    List<Pessoa> listaDeClientes;
    Pessoa usuarioLogado;

    //Deixar pré-carregado uma Pessoa Física e uma Pessoa Jurídica com cada tipo de conta para testes


    public void getListaDeContas() {

    }

    public void setUsuarioLogado(Pessoa usuarioLogado) {

    }

    public void getUsuarioLogado () {

    }
}
