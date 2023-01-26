package br.com.ada.poo2.banco.models.pessoas;

import br.com.ada.poo2.banco.models.enums.EPessoa;

public class PessoaJuridica extends Pessoa {


    public PessoaJuridica(String nome, int senha, EPessoa tipoDePessoa, String identificador) {
        super(nome, senha, tipoDePessoa, identificador);
    }
}
