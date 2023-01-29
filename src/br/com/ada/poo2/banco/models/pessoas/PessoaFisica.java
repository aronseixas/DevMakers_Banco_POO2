package br.com.ada.poo2.banco.models.pessoas;
import br.com.ada.poo2.banco.models.enums.EPessoa;

public class PessoaFisica extends Pessoa {
    private String CPF;

    public PessoaFisica(String nome, int senha, EPessoa tipoDePessoa) {
        super(nome, senha, tipoDePessoa);
    }

    @Override
    public String getIdentificador() {
        return this.CPF;
    }

    @Override
    public void setIdentificador(String identificador) {
        this.CPF = identificador;
    }

    @Override
     public String tipoDeIdentificador() {
        return "CPF";
    }
}