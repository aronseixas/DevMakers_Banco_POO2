package br.com.ada.poo2.banco.models.factories;
import br.com.ada.poo2.banco.interfaces.ICriarConta;
import br.com.ada.poo2.banco.interfaces.ICriarUsuario;
import br.com.ada.poo2.banco.interfaces.IPessoaFactory;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.criarconta.CriarContaPessoaJuridica;
import br.com.ada.poo2.banco.models.criarusuario.CriarUsuarioPessoaJuridica;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;
import java.util.List;

public class PessoaJuridicaFactory implements IPessoaFactory {
    @Override
    public Pessoa criarUsuario(String nome, int senha) {
        ICriarUsuario criarUsuarioPessoaJuridica = new CriarUsuarioPessoaJuridica();
        return criarUsuarioPessoaJuridica.criarUsuario(nome, senha);
    }

    @Override
    public List<Conta> criarContasDoUsuario(String identificadorDoUsuario) {
        ICriarConta criarContaPessoaJuridica = new CriarContaPessoaJuridica();
        return criarContaPessoaJuridica.criarContas(identificadorDoUsuario);
    }
}