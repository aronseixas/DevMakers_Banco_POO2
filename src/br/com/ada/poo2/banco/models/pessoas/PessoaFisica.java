package br.com.ada.poo2.banco.models.pessoas;

import br.com.ada.poo2.banco.models.enums.EPessoa;

public class PessoaFisica extends Pessoa {


    public PessoaFisica(String nome, int senha, EPessoa tipoDePessoa, String identificador) {
        super(nome, senha, tipoDePessoa, identificador);
    }

    public String toString(){
        return getNome();
    }


}