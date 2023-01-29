package br.com.ada.poo2.banco.interfaces;

import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.enums.EPessoa;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

import java.util.List;

public interface IPessoaFactory {
    Pessoa criarUsuario(String nome, int senha);
    List<Conta> criarContasDoUsuario(String identificadorDoUsuario);
}
