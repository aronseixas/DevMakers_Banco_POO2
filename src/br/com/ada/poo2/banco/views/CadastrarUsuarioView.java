package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.controllers.operacoes.CadastrarUsuario;
import br.com.ada.poo2.banco.controllers.operacoes.CriarConta;
import br.com.ada.poo2.banco.controllers.operacoes.DeterminarPessoaFactory;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.Scanner;

public class CadastrarUsuarioView {
    Scanner scanner = new Scanner(System.in);
    private CadastrarUsuario cadastrarUsuario;
    private CriarConta criarConta;

    public CadastrarUsuarioView(
            CadastrarUsuario cadastrarUsuario,
            CriarConta criarConta) {
        this.cadastrarUsuario = cadastrarUsuario;
        this.criarConta = criarConta;
    }
    public Pessoa iniciarCadastrarUsuarioView() {
        String nome, identificador;
        int senha;
        Pessoa usuario;

        nome = pedirNomeDoUsuario();
        senha = pedirSenhaDoUsuario();
        usuario = cadastrarUsuario.criarUsuario(nome, senha);
        exibirOpcoesIdentificadorDoUsuario(usuario);
        identificador = pedirIdentificadorDoUsuario();
        cadastrarUsuario.adicionarIdentificadorAoUsuario(identificador, usuario);
        cadastrarUsuario.adicionarUsuarioAoBanco(usuario);
        criarConta.iniciarCriarConta(usuario);
        return usuario;
    }
    public String pedirNomeDoUsuario() {
        System.out.println("Digite o nome:");
        return scanner.nextLine();
        //TODO validar quantidade mínima de caracteres
    }

    private int pedirSenhaDoUsuario() {
        System.out.println("Digite a senha (somente números):");
        return Integer.parseInt(scanner.nextLine());
        //TODO validar quantidade mínima de caracteres
    }

    public void exibirOpcoesIdentificadorDoUsuario(Pessoa usuario) {
        String tipoDeIdentificador = usuario.tipoDeIdentificador();
        System.out.println("Digite o seu " + tipoDeIdentificador + ":");
        //TODO View com acesso direto ao Model
    }

    public String pedirIdentificadorDoUsuario() {
        return scanner.nextLine();

        // TODO validar  tamanho mínimo de CPF e de CNPJ
        // TODO validar se já há contas abertas naquele CPF/CNPJ
    }

}
