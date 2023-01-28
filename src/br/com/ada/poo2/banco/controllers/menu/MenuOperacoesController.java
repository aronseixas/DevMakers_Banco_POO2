package br.com.ada.poo2.banco.controllers.menu;

import br.com.ada.poo2.banco.views.ConsultarSaldoView;
import br.com.ada.poo2.banco.views.SacarView;

public class MenuOperacoesController {
    private ConsultarSaldoView consultarSaldoView;

    public MenuOperacoesController(ConsultarSaldoView consultarSaldoView) {
        this.consultarSaldoView = consultarSaldoView;
    }

    public void consultarSaldo() {
        consultarSaldoView.iniciarConsultarSaldoView();
    }

    public void sacar() {
        SacarView sacarView = new SacarView();
        sacarView.iniciarSacar();
    }

}
