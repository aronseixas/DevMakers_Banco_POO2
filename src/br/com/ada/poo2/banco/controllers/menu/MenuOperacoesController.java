package br.com.ada.poo2.banco.controllers.menu;

import br.com.ada.poo2.banco.controllers.operacoes.DeslogarController;
import br.com.ada.poo2.banco.exceptions.NoFundsException;
import br.com.ada.poo2.banco.views.*;

public class MenuOperacoesController {
    private ConsultarSaldoView consultarSaldoView;
    private SacarView sacarView;
    private DepositarView depositarView;
    private TransferirView transferirView;
    private InvestirView investirView;
    private EscolherContaView escolherContaView;

    private DeslogarController deslogarController;
    public MenuOperacoesController(ConsultarSaldoView consultarSaldoView,
                                   SacarView sacarView,
                                   DepositarView depositarView,
                                   TransferirView transferirView,
                                   InvestirView investirView,
                                   EscolherContaView escolherContaView,
                                   DeslogarController deslogarController)
    {
        this.consultarSaldoView = consultarSaldoView;
        this.sacarView = sacarView;
        this.depositarView = depositarView;
        this.transferirView = transferirView;
        this.investirView = investirView;
        this.escolherContaView = escolherContaView;
        this.deslogarController = deslogarController;
    }

    public void consultarSaldo() {
        consultarSaldoView.iniciarConsultarSaldoView();
    }

    public void sacar() {
        try {
            sacarView.iniciarSacar();
            consultarSaldoView.iniciarConsultarSaldoView();
        } catch (NoFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void depositar() {
        depositarView.iniciarDepositar();
        if (depositarView.getUsuarioDepositouNaPropriaConta()) {
            consultarSaldoView.iniciarConsultarSaldoView();
        }
    }

    public void transferir(){
        try {
            transferirView.iniciarTransferir();
            consultarSaldoView.iniciarConsultarSaldoView();
        } catch (NoFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void investir(){
        investirView.iniciarInvestir();
    }

    public void escolherConta() {escolherContaView.iniciarEscolherContaView();}

    public void deslogar() {
        deslogarController.executar();
    }

}
