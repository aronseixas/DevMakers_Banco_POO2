package br.com.ada.poo2.banco.views;
import br.com.ada.poo2.banco.exceptions.InvalidInputException;
import br.com.ada.poo2.banco.exceptions.InvalidValueException;
import br.com.ada.poo2.banco.controllers.operacoes.DepositarController;
import br.com.ada.poo2.banco.exceptions.UserDoesNotExistException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DepositarView {
    Scanner scanner = new Scanner(System.in);
    boolean usuarioDepositouNaPropriaConta;
    DepositarController depositarController = new DepositarController();

    public void iniciarDepositar(){

        try {
            int opcaoDeposito;
            double valor;
            exibirOpcoesDeDeposito();
            opcaoDeposito = pedirOpcaoDeDeposito();
            scanner.nextLine();
            setUsuarioDepositouNaPropriaConta(opcaoDeposito);
            String numeroContaDestino = determinarNumeroContaDestino(opcaoDeposito);
            depositarController.determinarContaDestino(opcaoDeposito, numeroContaDestino);
            valor = pedirValorDoDeposito();
            depositarController.depositarContaUsuario(valor);
            System.out.println("Depósito efetuado com sucesso!");
        } catch (UserDoesNotExistException | InvalidValueException | InvalidInputException e)  {
            System.out.println(e.getMessage());
            scanner.nextLine();
            iniciarDepositar();
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida");
            scanner.nextLine();
            iniciarDepositar();
        }
    }

    public void exibirOpcoesDeDeposito() {
        System.out.println("Opção 1 - Depositar nesta conta");
        System.out.println("Opção 2 - Depositar para outro cliente");
    }

    public int pedirOpcaoDeDeposito() {
        System.out.println("Digite a opção:");
        return scanner.nextInt();
    }

    public String determinarNumeroContaDestino(int opcaoDeposito) {
        String numeroContaDestino = null;
        if (opcaoDeposito == 2) {
            numeroContaDestino = pedirContaParaDeposito();
        }
        return numeroContaDestino;
    }

    public String pedirContaParaDeposito(){
        System.out.println("Informe a conta para depósito: ");
        return scanner.nextLine();
    }

    public double pedirValorDoDeposito(){
        System.out.println("Informe o valor para depósito: ");
        return scanner.nextDouble();
    }

    public void setUsuarioDepositouNaPropriaConta(int opcaoDeposito) {
        if (opcaoDeposito == 1) {
            usuarioDepositouNaPropriaConta = true;
        } else {
            usuarioDepositouNaPropriaConta = false;
        }
    }

    public boolean getUsuarioDepositouNaPropriaConta() {
        return this.usuarioDepositouNaPropriaConta;
    }
}