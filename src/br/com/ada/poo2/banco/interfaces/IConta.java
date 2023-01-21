package br.com.ada.poo2.banco.interfaces;

import br.com.ada.poo2.banco.models.contas.Conta;

public interface IConta {

    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, Conta contaDestino);
    void checarSaldo();


}

