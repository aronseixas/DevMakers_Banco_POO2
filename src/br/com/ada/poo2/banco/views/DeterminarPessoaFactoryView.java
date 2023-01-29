package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.exceptions.InvalidInputException;
import br.com.ada.poo2.banco.controllers.operacoes.DeterminarPessoaFactoryController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DeterminarPessoaFactoryView {
    Scanner scanner = new Scanner(System.in);
    private DeterminarPessoaFactoryController determinarPessoaFactoryController;

    public DeterminarPessoaFactoryView(DeterminarPessoaFactoryController determinarPessoaFactoryController) {
        this.determinarPessoaFactoryController = determinarPessoaFactoryController;
    }

    public void iniciarDeterminarPessoaFactoryView() {
        try {
            exibirOpcoesTipoDePessoa();
            int tipoDePessoa = receberTipoDePessoa();
            determinarPessoaFactory(tipoDePessoa);
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida");
            scanner.nextLine();
            iniciarDeterminarPessoaFactoryView();
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            scanner.nextLine();
            iniciarDeterminarPessoaFactoryView();
        }
    }

    public void exibirOpcoesTipoDePessoa() {
        System.out.println("Para efetuar o cadastro, por favor, preencha as seguintes informações requisitadas:");
        System.out.println("Escolha o tipo de conta que deseja abrir:");
        System.out.println("Opção 1 - Pessoa Física");
        System.out.println("Opção 2 - Pessoa Jurídica");
    }

    public int receberTipoDePessoa() {
        System.out.println("Digite uma opção: ");
        return scanner.nextInt();
    }

    public void determinarPessoaFactory(int tipoDePessoa) {
        determinarPessoaFactoryController.determinarTipoDePessoa(tipoDePessoa);
    }
}


