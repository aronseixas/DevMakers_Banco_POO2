package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.List;
import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class EscolherConta {

    public void executar() {

        int inputTipoDeConta;
        List<Conta> listaDeContasDoUsuario;
        Conta contaEscolhidaPeloUsuario;

        listaDeContasDoUsuario = pegarListaDeContasDoUsuario();
        mostrarContasDoUsuario(listaDeContasDoUsuario);
        inputTipoDeConta = pegarInputDaConta();
        contaEscolhidaPeloUsuario = determinarContaEscolhida(listaDeContasDoUsuario, inputTipoDeConta);
        logarContaEscolhida(contaEscolhidaPeloUsuario);
        mensagemMostrandoContaLogada(contaEscolhidaPeloUsuario);
    }

    public List<Conta> pegarListaDeContasDoUsuario() {
        Pessoa usuarioLogado = banco.getUsuarioLogado();
        return usuarioLogado.getContas();
    }
    public void mostrarContasDoUsuario(List <Conta> listaDeContasDoUsuario) {
        int i = 1;
        for (Conta conta: listaDeContasDoUsuario) {
              System.out.println("Opção " + i++ +" - Tipo: " + conta.getTipoConta() + " - Número: " + conta.getNumero());
         }
     }

    public int pegarInputDaConta() {
        System.out.println("Escolha a conta desejada:");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        int inputTipoDeConta = scan.nextInt();
        //TODO fazer try catch
        return inputTipoDeConta;
    }

    public Conta determinarContaEscolhida(List<Conta> listaDeContasDoUsuario,  int inputTipoDeConta) {
        return listaDeContasDoUsuario.get(inputTipoDeConta - 1);
    }

    public void logarContaEscolhida(Conta contaEscolhidaPeloUsuario) {
        banco.setContaLogada(contaEscolhidaPeloUsuario);
    }

    public void mensagemMostrandoContaLogada(Conta contaLogada) {
        System.out.println("Conta " + contaLogada.getTipoConta() +" escolhida com sucesso." );
    }
}
