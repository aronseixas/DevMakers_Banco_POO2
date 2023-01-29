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
        String numeroContaDestino;

        valor = pedirValorTransferencia();
        scanner.nextLine();
        numeroContaDestino = pedirContaDestino();

        transferirValor(valor, numeroContaDestino);
    }

    private String pedirContaDestino(){
        System.out.println("Informe o número da conta para transferência: ");
        return scanner.nextLine();
    }

    private double pedirValorTransferencia() {
        System.out.println("Informe o valor a ser transferido: ");

        double valor = scanner.nextDouble();
        return valor;
        //TODO try-catch
    }

    public void transferirValor(double valor, String numeroContaDestino){
        try{
            transferir.transferirValor(valor, numeroContaDestino);
        } catch(InsufficientFundsException e){
            System.out.println(e.getMessageSaqueTransferir());
            iniciarTransferir();
        } catch(InvalidValueException e){
            System.out.println(e.getMessageTransferir());
            iniciarTransferir();
        } catch(UserDoesNotExistException e){
            System.out.println(e.getMessageTransferir());
        }
    }
}
