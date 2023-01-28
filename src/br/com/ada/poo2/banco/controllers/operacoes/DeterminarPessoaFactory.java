package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.exceptions.InvalidInputException;
import br.com.ada.poo2.banco.interfaces.IPessoaFactory;
import br.com.ada.poo2.banco.models.factories.PessoaFisicaFactory;
import br.com.ada.poo2.banco.models.factories.PessoaJuridicaFactory;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class DeterminarPessoaFactory {
    private IPessoaFactory pessoaFactory;
    public void determinarTipoDePessoa(String inputTipoDePessoa) throws InvalidInputException {
        switch (inputTipoDePessoa) {
            case "1" :
                pessoaFactory = new PessoaFisicaFactory();
                break;
            case "2" :
                pessoaFactory = new PessoaJuridicaFactory();
                break;
            default:
                throw new InvalidInputException();
        }
        banco.setPessoaFactory(pessoaFactory);
    }
}
