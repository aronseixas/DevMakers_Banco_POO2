package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.applicacao.InsufficientFundsException;
import br.com.ada.poo2.banco.applicacao.InvalidValueException;
import br.com.ada.poo2.banco.controllers.operacoes.Investir;

import java.util.Scanner;

public class InvestirView {

    Scanner scanner = new Scanner(System.in);

    Investir investir = new Investir();

    public void iniciarInvestir(){
        double valor;

        valor = pedirValorInvestir();
        investirValor(valor);
    }

    public double pedirValorInvestir(){
        System.out.println("Informe o valor a ser investido: ");
        double valorASerInvestido = scanner.nextDouble();
        return valorASerInvestido;
        //TODO try-catch
    }

    public void investirValor(double valor){
        try{
            investir.executar(valor);
            System.out.println("Investimento realizado com sucesso!");
        } catch(InsufficientFundsException e){
            System.out.println("Valor inválido! Saldo insuficiente.");
            iniciarInvestir();
        } catch (InvalidValueException e){
            System.out.println("Valor inválido!");
            iniciarInvestir();
        }
    }
}
