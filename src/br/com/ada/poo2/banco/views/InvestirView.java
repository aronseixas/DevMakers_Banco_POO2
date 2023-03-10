package br.com.ada.poo2.banco.views;
import br.com.ada.poo2.banco.exceptions.InsufficientFundsException;
import br.com.ada.poo2.banco.exceptions.InvalidAccountException;
import br.com.ada.poo2.banco.exceptions.InvalidValueException;
import br.com.ada.poo2.banco.controllers.operacoes.InvestirController;
import br.com.ada.poo2.banco.exceptions.NoFundsException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class InvestirView {
    Scanner scanner = new Scanner(System.in);
    InvestirController investirController = new InvestirController();

    public void iniciarInvestir(){

        try {
            investirController.validarTipoConta();
            investirController.validarSaldoPositivoConta();
            double valor;
            valor = pedirValorInvestir();
            investirValor(valor);
        } catch (InvalidAccountException e){
            System.out.println(e.getMessage());
        } catch(InsufficientFundsException e){
            System.out.println(e.getMessage());
            iniciarInvestir();
        } catch (InvalidValueException e) {
            System.out.println(e.getMessage());
            iniciarInvestir();
        } catch (InputMismatchException e){
            System.out.println("Valor inválido");
            scanner.nextLine();
            iniciarInvestir();
        } catch (NoFundsException e){
            System.out.println(e.getMessage());
        }
    }

    public double pedirValorInvestir(){
        System.out.println("Informe o valor a ser investido: ");
        double valorASerInvestido = scanner.nextDouble();
        return valorASerInvestido;
    }

    public void investirValor(double valor){
            investirController.executar(valor);
            System.out.println("Investimento realizado com sucesso!");
            System.out.printf("Saldo atualizado: R$%.2f%n", banco.getContaLogada().getSaldo());
    }
}