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
    int senha, escolhaOpcaoMenu;
    String nome, identificador;

    static Scanner scanner = new Scanner(System.in);
    public void abrirConta() {
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
        System.out.println("Qual tipo de conta você deseja abrir");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        try {
            escolhaOpcaoMenu = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, escolha um número válido");
        }
    }

    private void criarCadastroDeCliente() {
            switch (escolhaOpcaoMenu) {
                case 1:
                    tipoDePessoa = EPessoa.FISICA;
                    cadastradorDeUsuario = new CadastroPessoaFisica();
                    break;
                case 2:
                    tipoDePessoa = EPessoa.JURIDICA;
                    cadastradorDeUsuario = new CadastroPessoaJuridica();
                    break;
                default:
                    System.out.println("Por favor, escolha um número válido");
            }
    }


    private void receberDadosCadastrais() {
        receberIdentificadorDaPessoa();
        System.out.println("Qual o nome?");
        nome = scanner.nextLine();
        System.out.println("Qual a senha?");
        senha = Integer.parseInt(scanner.nextLine());
        //TODO fazer um try catch para o tipo de entrada.
    }

    private void receberIdentificadorDaPessoa() {
        switch (tipoDePessoa) {
            case FISICA:
                System.out.println("Digite o seu CPF");
                break;
            case JURIDICA:
                System.out.println("Digite o seu CNPJ");
                break;
            default:
                System.out.println("Erro na hora de pedir o CPF/CNPJ");
                receberDadosCadastrais();
        }
        identificador = scanner.nextLine();
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
        logar.logarUsario(usuario);
    }
}
