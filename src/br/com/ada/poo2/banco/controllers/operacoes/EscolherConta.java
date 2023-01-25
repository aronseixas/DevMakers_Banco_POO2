package br.com.ada.poo2.banco.controllers.operacoes;

import br.com.ada.poo2.banco.models.contas.Conta;

import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;


public class EscolherConta {
    int inputTipoDeConta;

    public void executar() {
        mostrarContasDoUsuario();
        pegarInputDaConta();
        determinarContaLogada();
        System.out.println("Conta escolhida com sucesso - " + banco.getContaLogada().getTipoConta());

    }
    public void mostrarContasDoUsuario() {
        System.out.println("Escolha a conta desejada:");
        System.out.println();
        int i = 1;
        for (Conta conta:banco.getUsuarioLogado().getContas()) {
              System.out.println("Opção " +i++ +" - Tipo: " + conta.getTipoConta() + " - Número: " + conta.getNumero());
         }
     }

    public void pegarInputDaConta() {
        Scanner scan = new Scanner(System.in);
        inputTipoDeConta = scan.nextInt();
        //TODO fazer try catch
    }
    public void determinarContaLogada() {
        switch(inputTipoDeConta) {
            case 1:
                banco.setContaLogada(banco.getUsuarioLogado().getContas().get(0));
                break;
            case 2:
                banco.setContaLogada(banco.getUsuarioLogado().getContas().get(1));
                break;
            case 3:
                banco.setContaLogada(banco.getUsuarioLogado().getContas().get(2));
                break;
            default :
                System.out.println("Opção não encontrada");
                executar();
//TODO TRY CATCH - NUM INTEIROS e outofbounds exeption(pessoa juridica digita 3)
//TODO MELHORAR O SWITCH SE POSSIVEL, PARA FICAR MAIS CLARO
        }
    }
}
