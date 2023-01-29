package br.com.ada.poo2.banco.controllers.menu;

import br.com.ada.poo2.banco.controllers.operacoes.LogarUsuarioController;
import br.com.ada.poo2.banco.exceptions.InvalidPasswordException;
import br.com.ada.poo2.banco.exceptions.UserDoesNotExistException;
import br.com.ada.poo2.banco.views.*;

import java.util.InputMismatchException;

public class MenuInicialController {

    private EscolherContaView escolherContaView;

    private LogarUsuarioController logarUsuarioController;

    private LogarUsuarioView logarUsuarioView;

    private MenuOperacoesView menuOperacoesView;

    private CadastrarUsuarioView cadastrarUsuarioView;

    private DeterminarPessoaFactoryView determinarPessoaFactoryView;

    public MenuInicialController(
            EscolherContaView escolherContaView,
            LogarUsuarioController logarUsuarioController,
            LogarUsuarioView logarUsuarioView,
            MenuOperacoesView menuOperacoesView,
            CadastrarUsuarioView cadastrarUsuarioView,
            DeterminarPessoaFactoryView determinarPessoaFactoryView) {
        this.escolherContaView = escolherContaView;
        this.logarUsuarioController = logarUsuarioController;
        this.logarUsuarioView = logarUsuarioView;
        this.menuOperacoesView = menuOperacoesView;
        this.cadastrarUsuarioView = cadastrarUsuarioView;
        this.determinarPessoaFactoryView = determinarPessoaFactoryView;
    }

    public void abrirConta() {
        determinarPessoaFactoryView.iniciarDeterminarPessoaFactoryView();
        cadastrarUsuarioView.iniciarCadastrarUsuarioView();
        logarUsuarioController.logarUsarioNovo();
        escolherContaView.iniciarEscolherContaView();
        menuOperacoesView.iniciarMenuOperacoesView();
    }

    public void acessarConta() {
        try {
            logarUsuarioView.iniciarLogarUsuarioView();
            escolherContaView.iniciarEscolherContaView();
            menuOperacoesView.iniciarMenuOperacoesView();
        } catch (InputMismatchException e) {
            System.out.println("Usuário ou senha inválidos!");
        } catch (UserDoesNotExistException | InvalidPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public void fechar() {
        System.exit(0);
    }
}
