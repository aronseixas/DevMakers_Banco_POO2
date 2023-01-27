package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.interfaces.IPessoaFactory;
import br.com.ada.poo2.banco.models.factories.PessoaFisicaFactory;
import br.com.ada.poo2.banco.models.factories.PessoaJuridicaFactory;

import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class DeterminarFactory {
    Scanner scanner = new Scanner(System.in);


    public void executar() {
        String inputTipoPessoa;
        exibirOpcoesDoTipoDePessoa();
        inputTipoPessoa = pedirTipoDePessoa();
        determinarTipoDePessoa(inputTipoPessoa);

    }

    private void exibirOpcoesDoTipoDePessoa() {
        System.out.println("Qual tipo de conta você deseja abrir:");
        System.out.println("Opção 1 - Pessoa Física");
        System.out.println("Opção 2 - Pessoa Jurídica");
    }

    private String pedirTipoDePessoa() {
        System.out.println("Digite uma opção: ");
        String inputTipoDePessoa = scanner.nextLine();
        //TODO validar e try-catch
        return inputTipoDePessoa;
    }

    public void determinarTipoDePessoa(String inputTipoDePessoa) {
        IPessoaFactory pessoaFactory = null;
        switch (inputTipoDePessoa) {
            case "1" :
                pessoaFactory =  new PessoaFisicaFactory();
                break;
            case "2" :
                pessoaFactory = new PessoaJuridicaFactory();
                break;
            default:
                System.out.println("Erro na hora de determinar o tipo de pessoa de usuário");
        }
        banco.setPessoaFactory(pessoaFactory);
    }
}
