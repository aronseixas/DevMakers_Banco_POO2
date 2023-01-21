package br.com.ada.poo2.banco.applicacao;

import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.contas.ContaCorrente;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;
import br.com.ada.poo2.banco.models.pessoas.PessoaFisica;
import br.com.ada.poo2.banco.models.pessoas.PessoaJuridica;
import br.com.ada.poo2.banco.models.rendimento.RendimentoPF;
import br.com.ada.poo2.banco.models.taxas.TaxasPF;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        List<Conta> contas = new ArrayList<>();

        System.out.print("NOME: ");
        String nome = scan.nextLine();
        ContaCorrente contaCorrente = new ContaCorrente(1, 11, 1000, new RendimentoPF(), new TaxasPF());
        contas.add(contaCorrente);

        PessoaFisica fulano = new PessoaFisica(nome, contas, "1234");

        fulano.getContas().get(0).sacar(100);
        System.out.println(fulano.getContas().get(0).getSaldo());

/*
        ContaCorrente contaCorrente = new ContaCorrente(1, 11, 1000, new RendimentoPF(), new TaxasPF());
        //contaCorrente.depositar(100);
        System.out.println("\n\n\n ");
        contaCorrente.depositar(50);
        System.out.println("\n\n\n");
        //contaCorrente.checarSaldo();

/*
        //System.out.println(" \n\n ");


        ContaCorrente contaCorrentePJ = new ContaCorrente(1, 11, 1000, new RendimentoPJ(), new TaxasPJ());
        contaCorrentePJ.sacar(100);

        System.out.println(" \n\n ");

        ContaPoupanca contaPoupancaPF = new ContaPoupanca(1, 11, 0, new RendimentoPF());
        contaPoupancaPF.depositar(100);

        System.out.println(" \n\n ");

        ContaInvestimento contaInvestimento = new ContaInvestimento(123, 234, 1000, new RendimentoPF(), new TaxasPJ());
        contaInvestimento.sacar(100);

        System.out.println(" \n\n ");
/*
        ContaInvestimento contaInvestimentoPJ = new ContaInvestimento(123, 234, 100, new RendimentoPJ());
        contaInvestimentoPJ.depositar(200);
*/
    }
}