package br.com.ada.poo2.banco.models.banco;

import br.com.ada.poo2.banco.interfaces.IPessoaFactory;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.HashMap;
import java.util.Map;

public class Banco {
    Map<String, Pessoa> mapaDeContas = new HashMap<String, Pessoa>();
    //Associa o <Número de Conta, Pessoa>
    Map<String, Pessoa> mapaIdentificadorEUsuario = new HashMap<>();
    Map<String, Conta> mapaDeNumeroContaEConta = new HashMap<>();
    Pessoa usuarioLogado;
    Conta contaLogada;

    IPessoaFactory pessoaFactory;


//TODO Deixar pré-carregado uma Pessoa Física e uma Pessoa Jurídica com cada tipo de conta para testes


    public void setUsuarioLogado(Pessoa usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }

    public Map<String, Pessoa> getMapaDeContas() {
        return mapaDeContas;
    }

    public Map<String, Pessoa> getMapaIdentificadorEUsuario() {
        return mapaIdentificadorEUsuario;
    }

    public Conta getContaLogada() {
        return contaLogada;
    }

    public void setContaLogada(Conta contaLogada) {
        this.contaLogada = contaLogada;
    }

    public IPessoaFactory getPessoaFactory() {
        return pessoaFactory;
    }

    public void setPessoaFactory(IPessoaFactory pessoaFactory) {
        this.pessoaFactory = pessoaFactory;
    }

    public Map<String, Conta> getMapaDeNumeroContaEConta() {
        return mapaDeNumeroContaEConta;
    }

}
