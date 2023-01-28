package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.models.contas.Conta;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class ConsultarSaldo {

    public double pegarSaldoDaConta() {
        Conta contaLogada = banco.getContaLogada();
        return contaLogada.getSaldo();
    }
}