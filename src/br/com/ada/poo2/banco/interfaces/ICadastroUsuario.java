package br.com.ada.poo2.banco.interfaces;

import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.List;

public interface ICadastroUsuario {
    Pessoa criarUsuario(String nome,
                        List<Conta> listaDeContasDoUsuario,
                        int senha,
                        String identificador);

    List<Conta> criarContasDoUsuario();
    void adicionarContasAoBanco(Pessoa usuario);

    void adicionarUsuarioAoBanco(Pessoa usuario, String identificador);

}
