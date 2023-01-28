package br.com.ada.poo2.banco.controllers.menu;

import br.com.ada.poo2.banco.controllers.operacoes.LogarUsuario;
import br.com.ada.poo2.banco.models.pessoas.Pessoa;
import br.com.ada.poo2.banco.views.*;

public class MenuInicialController {

    private EscolherContaView escolherContaView;

    private LogarUsuario logarUsuario;

    private LogarUsuarioView logarUsuarioView;

    private MenuOperacoesView menuOperacoesView;

    private CadastrarUsuarioView cadastrarUsuarioView;

    private DeterminarPessoaFactoryView determinarPessoaFactoryView;

    public MenuInicialController(
            EscolherContaView escolherContaView,
            LogarUsuario logarUsuario,
            LogarUsuarioView logarUsuarioView,
            MenuOperacoesView menuOperacoesView,
            CadastrarUsuarioView cadastrarUsuarioView,
            DeterminarPessoaFactoryView determinarPessoaFactoryView) {
        this.escolherContaView = escolherContaView;
        this.logarUsuario = logarUsuario;
        this.logarUsuarioView = logarUsuarioView;
        this.menuOperacoesView = menuOperacoesView;
        this.cadastrarUsuarioView = cadastrarUsuarioView;
        this.determinarPessoaFactoryView = determinarPessoaFactoryView;
    }

    public void abrirConta() {
        determinarPessoaFactoryView.iniciarDeterminarPessoaFactoryView();
        Pessoa novoUsuario = cadastrarUsuarioView.iniciarCadastrarUsuarioView();
        logarUsuario.logarUsarioNovo(novoUsuario);
        //TODO Views não podem reotrnar nada.
        escolherContaView.iniciarEscolherContaView();
        menuOperacoesView.iniciarMenuOperacoesView();
    }

    public void acessarConta() {
        logarUsuarioView.iniciarLogarUsuarioView();
        escolherContaView.iniciarEscolherContaView();
        menuOperacoesView.iniciarMenuOperacoesView();
    }

    public void fechar() {
        System.exit(0);
    }
}
