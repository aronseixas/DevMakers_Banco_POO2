package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.controllers.operacoes.ConsultarSaldo;

public class ConsultarSaldoView {

    ConsultarSaldo consultarSaldo;

    public void iniciarConsultarSaldoView() {
        consultarSaldo = new ConsultarSaldo();
        double saldo = consultarSaldo.pegarSaldoDaConta();
        exibirSaldoDaConta(saldo);
    }

    public void exibirSaldoDaConta(double saldo) {
        System.out.printf("Saldo atual: R$ %.2f%n ", saldo);
    }
}

