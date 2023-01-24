package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.interfaces.ICadastroUsuario;
import br.com.ada.poo2.banco.models.cadastroUsuario.CadastroPessoaFisica;
import br.com.ada.poo2.banco.models.cadastroUsuario.CadastroPessoaJuridica;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.enums.EPessoa;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.List;
import java.util.Scanner;

public class AbrirConta {
    EPessoa tipoDePessoa;
    ICadastroUsuario cadastradorDeUsuario;
    List<Conta> listaDeContasDoUsuario;
    Pessoa usuario;
    int senha;
    String nome, identificador, opcaoDePessoa;

    static Scanner scanner = new Scanner(System.in);
    public void executar() {
        exibirOpcoesDePessoa();
        criarCadastroDeCliente();
        receberDadosCadastrais();
        criarContasDoUsuario();
        criarUsuario();
        adicionarUsuarioAoBanco();
        adicionarContasAoBanco();
        logarUsario();
    }
    private void exibirOpcoesDePessoa() {
        System.out.println("Qual tipo de conta você deseja abrir:");
        System.out.println("Opção 1 - Pessoa Física");
        System.out.println("Opção 2 - Pessoa Jurídica");
        opcaoDePessoa = scanner.nextLine();

    }

    private void criarCadastroDeCliente() {
            switch (opcaoDePessoa) {
                case "1" :
                    tipoDePessoa = EPessoa.FISICA;
                    cadastradorDeUsuario = new CadastroPessoaFisica();
                    break;
                case "2" :
                    tipoDePessoa = EPessoa.JURIDICA;
                    cadastradorDeUsuario = new CadastroPessoaJuridica();
                    break;
                default:
                    System.out.println("Erro na hora de gerar os cadastradores de usuário");
            }
    }

    private void receberDadosCadastrais() {
        receberIdentificadorDoUsuario();
        receberNomeDoUsuario();
        receberSenhaDoUsuario();
    }

    private void receberIdentificadorDoUsuario() {
        switch (tipoDePessoa) {
            case FISICA:
                System.out.println("Digite seu CPF: ");
                break;
            case JURIDICA:
                System.out.println("Digite seu CNPJ: ");
                break;
            default:
                System.out.println("Erro na hora de pedir o CPF/CNPJ");
                receberDadosCadastrais();
        }
        identificador = scanner.nextLine();
    }

    private void receberNomeDoUsuario(){
        System.out.println("Digite o nome:");
        nome = scanner.nextLine();
    }

    private void receberSenhaDoUsuario() {
        System.out.println("Digite a senha (somente números):");
        senha = Integer.parseInt(scanner.nextLine());
        //TODO fazer um try catch para o tipo de entrada.
    }


    private void criarContasDoUsuario() {
        listaDeContasDoUsuario = cadastradorDeUsuario.criarContasDoUsuario();
    }

    private void criarUsuario() {
        usuario = cadastradorDeUsuario.criarUsuario(nome,
                listaDeContasDoUsuario,
                senha,
                identificador);
    }

    private void adicionarUsuarioAoBanco() {

        cadastradorDeUsuario.adicionarUsuarioAoBanco(usuario, identificador);
    }
    private void adicionarContasAoBanco() {

        cadastradorDeUsuario.adicionarContasAoBanco(usuario);
    }

    public void logarUsario() {
        Logar logar = new Logar();
        logar.logarUsarioNovo(usuario);
    }
}
