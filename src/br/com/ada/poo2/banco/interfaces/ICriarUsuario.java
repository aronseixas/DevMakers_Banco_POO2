package br.com.ada.poo2.banco.interfaces;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;

public interface ICriarUsuario {
    Pessoa criarUsuario(String nome, int senha);
}