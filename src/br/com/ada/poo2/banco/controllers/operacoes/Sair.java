package br.com.ada.poo2.banco.controllers.operacoes;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class Sair {



    public void executar() {
        System.out.print("\nAté logo!");
        banco.setContaLogada(null);

    }
}
