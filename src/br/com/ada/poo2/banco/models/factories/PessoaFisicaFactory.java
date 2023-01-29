package br.com.ada.poo2.banco.models.factories;
import br.com.ada.poo2.banco.interfaces.ICriarConta;
import br.com.ada.poo2.banco.interfaces.ICriarUsuario;
import br.com.ada.poo2.banco.interfaces.IPessoaFactory;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.criarconta.CriarContaPessoaFisica;
import br.com.ada.poo2.banco.models.criarusuario.CriarUsuarioPessoaFisica;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;
import java.util.List;

public class PessoaFisicaFactory implements IPessoaFactory {

    @Override
    public Pessoa criarUsuario(String nome, int senha) {
       ICriarUsuario criarUsuarioPessoaFisica = new CriarUsuarioPessoaFisica();
       return criarUsuarioPessoaFisica.criarUsuario(nome, senha);
    }

    @Override
    public List<Conta> criarContasDoUsuario(String identificadorDoUsuario) {
        ICriarConta criarContaPessoaFisica = new CriarContaPessoaFisica();
        return criarContaPessoaFisica.criarContas(identificadorDoUsuario);
    }
}