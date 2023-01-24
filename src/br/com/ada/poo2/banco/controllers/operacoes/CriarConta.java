package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.interfaces.ICriarConta;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.criarconta.CriarContaPessoaFisica;
import br.com.ada.poo2.banco.models.criarconta.CriarContaPessoaJuridica;
import br.com.ada.poo2.banco.models.enums.EPessoa;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.ArrayList;
import java.util.List;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class CriarConta {
    EPessoa tipoDePessoa;
    ICriarConta criadorDeConta;
    Pessoa usuarioCadastrado;
    List<Conta> listaDeContasDoUsuario = new ArrayList<>();

    public void executar(Pessoa usuarioCadastrado) {
        System.out.println("----Passei por CriarConta ---");
        this.usuarioCadastrado = usuarioCadastrado;
        tipoDePessoa = usuarioCadastrado.getTipoDePessoa();
        determinarClasseDeCriacaoDaConta();
        criarConta();
        adicionarContaAoUsuario();
        associarNumeroDaContaAoUsuarioNoBanco();
        System.out.println("---Terminei de passar por CriarConta ----");
    }


    private void determinarClasseDeCriacaoDaConta() {
        switch (tipoDePessoa) {
            case FISICA:
                criadorDeConta = new CriarContaPessoaFisica();
                break;
            case JURIDICA:
                criadorDeConta = new CriarContaPessoaJuridica();
                break;
            default:
                System.out.println("Erro na hora de criar a conta");
        }
    }

    private void criarConta() {
        listaDeContasDoUsuario = criadorDeConta.criarContas();
    }

    private void adicionarContaAoUsuario() {
        usuarioCadastrado.setContas(listaDeContasDoUsuario);
    }

    private void associarNumeroDaContaAoUsuarioNoBanco() {
        for (Conta conta: listaDeContasDoUsuario) {
            banco.getMapaDeContas().put(conta.getNumero(), usuarioCadastrado);
        }
    }
}
