package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.models.contas.Conta;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class ConsultarSaldo {

    public void executar() {
        double saldo;
        saldo = pegarSaldoDaConta();
        exibirSaldoDaConta(saldo);
    }

    public double pegarSaldoDaConta() {
        Conta contaLogada = banco.getContaLogada();
        return contaLogada.getSaldo();
    }

    public void exibirSaldoDaConta(double saldo) {
        System.out.printf("Saldo atual: R$ %.2f%n ", saldo);
    }
}
