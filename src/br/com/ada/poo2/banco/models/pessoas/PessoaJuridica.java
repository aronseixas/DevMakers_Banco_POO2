package br.com.ada.poo2.banco.models.pessoas;
import br.com.ada.poo2.banco.models.enums.EPessoa;

public class PessoaJuridica extends Pessoa {
    private String CNPJ;
    public PessoaJuridica(String nome, int senha, EPessoa tipoDePessoa) {
        super(nome, senha, tipoDePessoa);
    }

    @Override
    public String getIdentificador() {
        return this.CNPJ;
    }

    @Override
    public void setIdentificador(String identificador) {
        this.CNPJ = identificador;
    }

    @Override
    public String tipoDeIdentificador() {
        return "CNPJ";
    }
}