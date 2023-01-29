package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.controllers.operacoes.ConsultarSaldoController;

public class ConsultarSaldoView {
    ConsultarSaldoController consultarSaldoController;
    public void iniciarConsultarSaldoView() {
        consultarSaldoController = new ConsultarSaldoController();
        double saldo = consultarSaldoController.pegarSaldoDaConta();
        exibirSaldoDaConta(saldo);
    }

    public void exibirSaldoDaConta(double saldo) {
        System.out.printf("Saldo atual: R$ %.2f%n ", saldo);
    }
}

