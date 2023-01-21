package br.com.ada.poo2.banco.models.contas;

import br.com.ada.poo2.banco.interfaces.IConta;
import br.com.ada.poo2.banco.interfaces.IRendimento;
import br.com.ada.poo2.banco.interfaces.ITaxas;

public abstract class Conta implements IConta {

        private int numero;
        private int senha;
        protected double saldo;
        private IRendimento rendimento;
        private ITaxas taxas;

        public Conta(int numero, int senha, double saldo, IRendimento rendimento, ITaxas taxas) {
            this.numero = numero;
            this.senha = senha;
            this.saldo = saldo;
            this.rendimento = rendimento;
            this.taxas = taxas;
        }

        public ITaxas getTaxas() {
            return taxas;
        }

        public int getNumero() {
            return numero;
        }

        public double getSaldo() {
            return saldo;
        }

        public IRendimento getRendimento() {
            return rendimento;
        }

        public void setRendimento(IRendimento rendimento) {
            this.rendimento = rendimento;
        }

}
