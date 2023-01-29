package br.com.ada.poo2.banco.views;

import br.com.ada.poo2.banco.exceptions.InsufficientFundsException;
import br.com.ada.poo2.banco.exceptions.InvalidAccountException;
import br.com.ada.poo2.banco.exceptions.InvalidValueException;
import br.com.ada.poo2.banco.controllers.operacoes.Investir;
import br.com.ada.poo2.banco.exceptions.NoFundsException;

import java.util.InputMismatchException;
import java.util.Scanner;

import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class InvestirView {

    Scanner scanner = new Scanner(System.in);

    Investir investir = new Investir();

    public void iniciarInvestir(){
        try {
            investir.validarTipoConta();
            investir.validarSaldoPositivoConta();
            double valor;
            valor = pedirValorInvestir();
            investirValor(valor);
        } catch (InvalidAccountException e){
            System.out.println(e.getMessage());
        } catch(InsufficientFundsException e){
            System.out.println("Valor inválido! Saldo insuficiente.");
            iniciarInvestir();
        } catch (InvalidValueException e) {
            System.out.println("Valor inválido!");
            iniciarInvestir();
        } catch (InputMismatchException e){
            System.out.println("Valor inválido");
            scanner.nextLine();
            iniciarInvestir();
        } catch (NoFundsException e){
            System.out.println("Conta não possui saldo para investir.");
        }
    }

    public double pedirValorInvestir(){
        System.out.println("Informe o valor a ser investido: ");
        double valorASerInvestido = scanner.nextDouble();
        return valorASerInvestido;
        //TODO try-catch
    }

    public void investirValor(double valor){
            investir.executar(valor);
            System.out.println("Investimento realizado com sucesso!");
            System.out.printf("Saldo atualizado: R$%.2f%n", banco.getContaLogada().getSaldo());
    }
}
