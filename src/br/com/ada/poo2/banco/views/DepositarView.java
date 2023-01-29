package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.exceptions.InvalidValueException;
import br.com.ada.poo2.banco.controllers.operacoes.Depositar;
import br.com.ada.poo2.banco.exceptions.UserDoesNotExistException;
import br.com.ada.poo2.banco.models.contas.Conta;

import java.util.Scanner;

public class DepositarView {

    Scanner scanner = new Scanner(System.in);

    Depositar depositar = new Depositar();

    public void iniciarDepositar(){
        int opcaoDeposito;
        double valor;
        Conta contaDestino;

        exibirOpcoesDeDeposito();
        opcaoDeposito = pedirOpcaoDeDeposito();

        try {
            contaDestino = determinarContaDestino(opcaoDeposito);
            valor = pedirValorDoDeposito();
            depositarValor(valor, contaDestino);
        } catch (UserDoesNotExistException e)  {
            System.out.println(e.getMessage());
            iniciarDepositar();
        }
    }

    public void exibirOpcoesDeDeposito() {
        System.out.println("Opção 1 - Depositar nesta conta");
        System.out.println("Opção 2 - Depositar para outro cliente");
    }

    public int pedirOpcaoDeDeposito() {
        System.out.println("Digite a opção:");
        int opcao = scanner.nextInt();
        return opcao;
    }

    public Conta determinarContaDestino(int opcaoDeposito) {
       Conta contaDestino = null;
        switch (opcaoDeposito) {
            case 1 :
                contaDestino = depositar.pegarContaDoProprioCLiente();
                break;
            case 2 :
                String numeroContaDestino = pedirContaParaDeposito();
                contaDestino = depositar.pegarContaDeOutroCliente(numeroContaDestino);
                break;
            default:
                System.out.println("opção inválida");
                iniciarDepositar();
        }
        return contaDestino;
    }


    public String pedirContaParaDeposito(){
        System.out.println("Informe a conta para depósito: ");
        String numeroConta = scanner.nextLine();
        return numeroConta;
        //TODO try-catch
    }

    public double pedirValorDoDeposito(){
        System.out.println("Informe o valor para depósito: ");
        double valor = scanner.nextDouble();
        return valor;
        //TODO try-catch
    }

    public void depositarValor(double valor, Conta contaDestino){
        try{
            depositar.depositarContaUsuario(valor, contaDestino);
            System.out.println("Depósito efetuado com sucesso!");

        } catch (InvalidValueException e){
            System.out.println("O valor para esta operação deve ser maior que 0(zero)!");
            iniciarDepositar();
        }
    }
}
