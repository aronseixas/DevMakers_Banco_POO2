package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class Logar {

    private Pessoa usuarioRealizandoLogin;
    private int senhaDigitada;

    public void executar(){
        pedirIdentificadorCliente();
        pedirSenha();
        verificarSenha();
        logarUsarioCadastrado();
    }
    public void pedirIdentificadorCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual seu CPF ou CNPJ?");
        String identificadorDigitado = sc.next();
        // TODO implementar o try catch para validar o usuario
        usuarioRealizandoLogin = banco.getMapaDeClientes().get(identificadorDigitado);

    }


    public void pedirSenha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite sua senha: ");
        senhaDigitada = sc.nextInt();
        // TODO implementar o try catch para validar a senha
    }

    public void verificarSenha() {
        if (senhaDigitada == usuarioRealizandoLogin.getSenha()){
            logarUsarioCadastrado();
        }
        else {
            System.out.println("Senha e/ou usuário inválido. Tente logar novamente.");
            executar();
        }
    }

    public void logarUsarioCadastrado() {
        banco.setUsuarioLogado(usuarioRealizandoLogin);

    }

    public void logarUsarioNovo(Pessoa pessoa) {
        usuarioRealizandoLogin = pessoa;
        logarUsarioCadastrado();
    }
}
