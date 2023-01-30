package br.com.ada.poo2.banco.views;
import br.com.ada.poo2.banco.exceptions.InsufficientFundsException;
import br.com.ada.poo2.banco.exceptions.UserDoesNotExistException;
import br.com.ada.poo2.banco.controllers.operacoes.TransferirController;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TransferirView {
    Scanner scanner =  new Scanner(System.in);
    TransferirController transferirController = new TransferirController();

    public void iniciarTransferir(){

        try {
            double valor;
            String numeroContaDestino;

            transferirController.validarSaldoPositivoConta();
            numeroContaDestino = pedirContaDestino();
            valor = pedirValorTransferencia();
            transferirController.transferirValor(valor, numeroContaDestino);
            System.out.println("Transferência realizada com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Opção Inválida");
            scanner.nextLine();
            iniciarTransferir();
        } catch (InsufficientFundsException | UserDoesNotExistException e) {
            System.out.println(e.getMessage());
            scanner.nextLine();
            iniciarTransferir();
        }
    }

    private String pedirContaDestino(){
        System.out.println("Informe o número da conta para transferência: ");
        return scanner.nextLine();
    }

    private double pedirValorTransferencia() {
        System.out.println("Informe o valor a ser transferido: ");
        return scanner.nextDouble();
    }
}