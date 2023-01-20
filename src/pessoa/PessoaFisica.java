package pessoa;

import java.util.List;

public class PessoaFisica extends Pessoa {

    private String CPF;

    protected PessoaFisica(String nome, List contas) {
        super(nome, contas);
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
