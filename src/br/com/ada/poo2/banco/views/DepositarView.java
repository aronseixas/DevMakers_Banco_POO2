package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.exceptions.InvalidValueException;
import br.com.ada.poo2.banco.controllers.operacoes.Depositar;

import java.util.Scanner;

public class DepositarView {

    Scanner scanner = new Scanner(System.in);

    Depositar depositar = new Depositar();

    public void iniciarDepositar(){

        double valor;

        valor = pedirValorDoDeposito();
        depositarValor(valor);
    }

    public double pedirValorDoDeposito(){
        System.out.println("Informe o valor para depósito: ");
        double valor = scanner.nextDouble();
        return valor;
        //TODO try-catch
    }

    public void depositarValor(double valor){
        try{
            depositar.depositarContaUsuario(valor);
            System.out.println("Depósito efetuado com sucesso!");
        } catch (InvalidValueException e){
            System.out.println("O valor para esta operação deve ser maior que 0(zero)!");
            iniciarDepositar();
        }
    }
}
