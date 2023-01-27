package br.com.ada.poo2.banco.controllers.operacoes;
import br.com.ada.poo2.banco.interfaces.IPessoaFactory;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.Map;
import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class CadastrarUsuario {

    Scanner scanner = new Scanner(System.in);
    Pessoa usuarioCadastrado;

    public void executar() {

        String identificador, nome, tipoDeIdentificador;
        int senha;

        nome = pedirNomeDoUsuario();

        senha = pedirSenhaDoUsuario();

        usuarioCadastrado = criarUsuario(nome, senha);

        tipoDeIdentificador = getTipoDeIdentificador();

        exibirOpcoesIdentificadorDoUsuario(tipoDeIdentificador);

        identificador = pedirIdentificadorDoUsuario();

        adicionarIdentificadorAoUsuario(identificador);

        adicionarUsuarioAoBanco(identificador);
    }

    private String pedirNomeDoUsuario() {
        String nome;
        System.out.println("Digite o nome:");
        nome = scanner.nextLine();
        //TODO validar e try-catch
        return nome;
    }

    private int pedirSenhaDoUsuario() {
        int senha;
        System.out.println("Digite a senha (somente números):");
        senha = Integer.parseInt(scanner.nextLine());
        //TODO fazer um try catch para o tipo de entrada.
        return senha;
    }

    public Pessoa criarUsuario(String nome, int senha) {
        IPessoaFactory pessoaFactory = banco.getPessoaFactory();
        return pessoaFactory.criarUsuario(nome, senha);
    }

    public String getTipoDeIdentificador() {
        return usuarioCadastrado.tipoDeIdentificador();
    }

    private void exibirOpcoesIdentificadorDoUsuario(String tipoDeIdentificador) {
        System.out.println("Digite o seu " + tipoDeIdentificador + ":");
    }

    public String pedirIdentificadorDoUsuario() {
        String identificador;
        identificador = scanner.nextLine();
        //TODO validar e try-catch
        return identificador;
        //TODO validar se já há contas abertars naquele CPF/CNPJ
    }


    public void adicionarIdentificadorAoUsuario(String identificador) {
        usuarioCadastrado.setIdentificador(identificador);
    }

    private void adicionarUsuarioAoBanco(String identificador) {
        Map<String, Pessoa> mapaIdentificadorUsuario;
        mapaIdentificadorUsuario = banco.getMapaDeClientes();
        mapaIdentificadorUsuario.put(identificador, usuarioCadastrado);
    }

    public Pessoa getUsuarioCadastrado() {
        return this.usuarioCadastrado;
    }
    //TODO talvez colocar em sua própria classe
}
