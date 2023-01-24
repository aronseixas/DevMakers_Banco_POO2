package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.models.enums.EPessoa;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;
import br.com.ada.poo2.banco.models.pessoas.PessoaFisica;
import br.com.ada.poo2.banco.models.pessoas.PessoaJuridica;

import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class CadastrarUsuario {

    Scanner scanner = new Scanner(System.in);
    String inputTipoDePessoa, identificadorDoUsuario, nomeDoUsuario;
    int senhaDoUsuario;
    EPessoa tipoDePessoa;
    Pessoa usuarioCadastrado;

    public void executar() {
        System.out.println("----Entrei em CadastrarUsuario----");
        exibirOpcoesDoTipoDePessoa();
        determinarTipoDePessoa();
        pedirIdentificadorDoUsuario();
        pedirNomeDoUsuario();
        pedirSenhaDoUsuario();
        criarUsuario();
        adicionarUsuarioAoBanco();
        System.out.println("----Terminei de passar em CadastrarUsuário----");
    }

    private void exibirOpcoesDoTipoDePessoa() {
        System.out.println("Qual tipo de conta você deseja abrir:");
        System.out.println("Opção 1 - Pessoa Física");
        System.out.println("Opção 2 - Pessoa Jurídica");
        inputTipoDePessoa = scanner.nextLine();
    }

    private void determinarTipoDePessoa() {
        switch (inputTipoDePessoa) {
            case "1" :
                tipoDePessoa = EPessoa.FISICA;
                break;
            case "2" :
                tipoDePessoa = EPessoa.JURIDICA;
                break;
            default:
                System.out.println("Erro na hora de determinar o tipo de pessoa de usuário");
        }
    }

    private void pedirIdentificadorDoUsuario() {
        switch (tipoDePessoa) {
            case FISICA:
                System.out.println("Digite seu CPF: ");
                break;
            case JURIDICA:
                System.out.println("Digite seu CNPJ: ");
                break;
            default:
                System.out.println("Erro na hora de pedir o CPF/CNPJ");
                executar();
        }
        identificadorDoUsuario = scanner.nextLine();
    }

    private void pedirNomeDoUsuario(){
        System.out.println("Digite o nome:");
        nomeDoUsuario = scanner.nextLine();
    }

    private void pedirSenhaDoUsuario() {
        System.out.println("Digite a senha (somente números):");
        senhaDoUsuario = Integer.parseInt(scanner.nextLine());
        //TODO fazer um try catch para o tipo de entrada.
    }

    private void criarUsuario() {
        switch(tipoDePessoa) {
            case FISICA:
                usuarioCadastrado = new PessoaFisica(
                        nomeDoUsuario,
                        senhaDoUsuario,
                        tipoDePessoa,
                        identificadorDoUsuario);
                break;
            case JURIDICA:
                usuarioCadastrado = new PessoaJuridica(
                        nomeDoUsuario,
                        senhaDoUsuario,
                        tipoDePessoa,
                        identificadorDoUsuario);
                break;
            default:
                System.out.println("Erro na hora de criar o usuário");
                //TODO é possível fazer uma interface para criação de usuário
        }
    }

    private void adicionarUsuarioAoBanco() {
        banco.getMapaDeClientes().put(identificadorDoUsuario, usuarioCadastrado);
    }

    public Pessoa getUsuarioCadastrado() {
        return this.usuarioCadastrado;
    }
}
