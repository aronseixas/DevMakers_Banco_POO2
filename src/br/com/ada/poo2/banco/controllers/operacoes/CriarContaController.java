package br.com.ada.poo2.banco.controllers.operacoes;
import br.com.ada.poo2.banco.interfaces.IPessoaFactory;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;
import java.util.List;
import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class CriarContaController {
    Pessoa usuario;
    public void iniciarCriarConta() {
        List<Conta> listaDeContasDoUsuario;
        this.usuario = banco.getUsuarioCadastrado();
        listaDeContasDoUsuario = criarConta();
        adicionarContaAoUsuario(listaDeContasDoUsuario);
        associarNumeroDaContaAoUsuarioNoBanco(listaDeContasDoUsuario);
    }

    private List<Conta> criarConta() {
        String identificadorDoUsuario = usuario.getIdentificador();
        IPessoaFactory pessoaFactory = banco.getPessoaFactory();
        return pessoaFactory.criarContasDoUsuario(identificadorDoUsuario);
    }

    private void adicionarContaAoUsuario(List<Conta> listaDeContasDoUsuario) {
        usuario.setContas(listaDeContasDoUsuario);
    }

    private void associarNumeroDaContaAoUsuarioNoBanco(List<Conta> listaDeContasDoUsuario) {
        for (Conta conta: listaDeContasDoUsuario) {
            banco.getMapaDeContas().put(conta.getNumero(), usuario);
        }
    }
}
