package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.enums.ETipoConta;

import java.util.List;


import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class EscolherConta {


    public int pegarQtddDeContasDoUsuario() {
        return banco.getUsuarioLogado().getContas().size();
    }

    public Conta pegarConta(int index) {
        List<Conta> listaDeContasDoUsuario = banco.getUsuarioLogado().getContas();
        return listaDeContasDoUsuario.get(index - 1);
    }

    public ETipoConta pegarTipoDaConta(int index) {
        return pegarConta(index).getTipoConta();
    }

    public String pegarNumeroDaConta(int index) {
        return pegarConta(index).getNumero();
    }

    public void logarConta(int index) {
        Conta contaEscolhida = pegarConta(index);
        banco.setContaLogada(contaEscolhida);
    }

}
