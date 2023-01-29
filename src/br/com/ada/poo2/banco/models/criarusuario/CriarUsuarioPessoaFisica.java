package br.com.ada.poo2.banco.models.criarusuario;
import br.com.ada.poo2.banco.interfaces.ICriarUsuario;
import br.com.ada.poo2.banco.models.enums.EPessoa;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;
import br.com.ada.poo2.banco.models.pessoas.PessoaFisica;

public class CriarUsuarioPessoaFisica implements ICriarUsuario {
    @Override
    public Pessoa criarUsuario(String nome, int senha) {
        return new PessoaFisica(
                nome,
                senha,
                EPessoa.FISICA);
    }
}