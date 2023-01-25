package br.com.ada.poo2.banco.controllers.operacoes;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class ConsultarSaldo {

    public void executar() {
        System.out.println("~~~~~~~~~~~~~~~~~~ ");
        System.out.println("Consulta de saldo ");
        System.out.println("~~~~~~~~~~~~~~~~~~ \n");

        System.out.printf("Saldo atual: R$ %.2f%n ", banco.getContaLogada().getSaldo());
    }
}
