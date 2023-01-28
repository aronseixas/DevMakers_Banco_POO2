package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.exceptions.InsufficientFundsException;
import br.com.ada.poo2.banco.exceptions.InvalidValueException;
import br.com.ada.poo2.banco.exceptions.UserDoesNotExistException;
import br.com.ada.poo2.banco.controllers.operacoes.Transferir;
import br.com.ada.poo2.banco.models.contas.Conta;

import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class TransferirView {

    Scanner scanner =  new Scanner(System.in);

    Transferir transferir = new Transferir();

    public void iniciarTransferir(){
        double valor;
        Conta contaDestino;

        valor = pedirValorTransferencia();
        contaDestino = pedirContaDestino();

        transferirValor(valor, contaDestino);
    }

    private Conta pedirContaDestino(){
        System.out.println("Informe o número da conta para transferência: ");
        String numeroContaDestino = scanner.nextLine();
        return banco.getMapaDeNumeroContaEConta().get(numeroContaDestino);
    }

    private double pedirValorTransferencia() {
        System.out.println("Informe o valor a ser transferido: ");
        double valor = scanner.nextDouble();
        return valor;
        //TODO try-catch
    }

    public void transferirValor(double valor, Conta contaDestino){
        try{
            transferir.transferirValor(valor, contaDestino);
        } catch(InsufficientFundsException e){
            System.out.println("Saldo insuficiente. Operação cancelada.");
            iniciarTransferir();
        } catch(InvalidValueException e){
            System.out.println("Valor inválido!");
            iniciarTransferir();
        } catch(UserDoesNotExistException e){
            System.out.println("Conta destino não encontrada. Operação cancelada.");
        }
    }
}
