package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.exceptions.InvalidInputException;
import br.com.ada.poo2.banco.controllers.operacoes.DeterminarPessoaFactory;

import java.util.Scanner;

public class DeterminarPessoaFactoryView {
    Scanner scanner = new Scanner(System.in);
    private DeterminarPessoaFactory determinarPessoaFactory;

    public DeterminarPessoaFactoryView(DeterminarPessoaFactory determinarPessoaFactory) {
        this.determinarPessoaFactory = determinarPessoaFactory;
    }

    public void iniciarDeterminarPessoaFactoryView() {
        exibirOpcoesTipoDePessoa();
        String tipoDePessoa = receberTipoDePessoa();
        determinarPessoaFactory(tipoDePessoa);
    }

    public void exibirOpcoesTipoDePessoa() {
        System.out.println("Bem-vindo ao Banco. Para efetuar o cadastro, por favor, preencha as seguintes informações requisitadas");
        System.out.println("Qual tipo de conta você deseja abrir:");
        System.out.println("Opção 1 - Pessoa Física");
        System.out.println("Opção 2 - Pessoa Jurídica");
    }

    public String receberTipoDePessoa() {
        System.out.println("Digite uma opção: ");
        return scanner.nextLine();
    }

    public void determinarPessoaFactory(String tipoDePessoa) {
        try {
            determinarPessoaFactory.determinarTipoDePessoa(tipoDePessoa);
        } catch (InvalidInputException e) {
            System.out.println("Opção inválida!");
            iniciarDeterminarPessoaFactoryView();
        }
    }
}


