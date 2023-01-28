package br.com.ada.poo2.banco.applicacao;

import br.com.ada.poo2.banco.controllers.menu.MenuInicialController;
import br.com.ada.poo2.banco.controllers.menu.MenuOperacoesController;
import br.com.ada.poo2.banco.views.MenuOperacoesView;
import br.com.ada.poo2.banco.controllers.operacoes.*;
import br.com.ada.poo2.banco.views.*;
import br.com.ada.poo2.banco.models.banco.Banco;

public class Aplicacao {
    public static Banco banco = new Banco();

    private MenuInicialView menuInicialView;
    private MenuOperacoesView menuOperacoesView;
    private MenuInicialController menuInicialController;
    
    private CadastrarUsuarioView cadastrarUsuarioView;
    
    private   DeterminarPessoaFactoryView determinarPessoaFactoryView;

    private MenuOperacoesController menuOperacoesController;

    public static void main(String[] args) {
        Aplicacao aplicacao = new Aplicacao();
        aplicacao.setUpMenuOperacoesController();
        aplicacao.setUpDeterminarFactoryView();
        aplicacao.setUpCadastrarUsuarioVIew();
        aplicacao.setUpMenuOperacoesView();
        aplicacao.setUpMenuInicialController();
        aplicacao.setUpMenuInicialView();
        aplicacao.iniciarMenuInicial();
    }


    public void setUpMenuOperacoesController() {
        ConsultarSaldoView consultarSaldoView = new ConsultarSaldoView();

        menuOperacoesController = new MenuOperacoesController(
                consultarSaldoView
        );
    }
    public void setUpDeterminarFactoryView() {
        determinarPessoaFactoryView = new DeterminarPessoaFactoryView(
                new DeterminarPessoaFactory()
        );
    }
    
    public void setUpCadastrarUsuarioVIew() {
        cadastrarUsuarioView = new CadastrarUsuarioView(
                new CadastrarUsuario(),
                new CriarConta()
        );
    }
    public void setUpMenuOperacoesView() {
        menuOperacoesView = new MenuOperacoesView(
                menuOperacoesController);
    }
    public void setUpMenuInicialController() {
        LogarUsuario logarUsuario = new LogarUsuario();
        LogarUsuarioView logarUsuarioView = new LogarUsuarioView();
        EscolherContaView escolherContaView = new EscolherContaView();

        menuInicialController = new MenuInicialController(
                escolherContaView,
                logarUsuario,
                logarUsuarioView,
                menuOperacoesView,
                cadastrarUsuarioView,
                determinarPessoaFactoryView);
    }
    public void setUpMenuInicialView() {

        menuInicialView = new MenuInicialView(
                menuInicialController);
    }

    public void iniciarMenuInicial() {
        menuInicialView.iniciarMenuInicial();
    }
}