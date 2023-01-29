package br.com.ada.poo2.banco.controllers.menu;

import br.com.ada.poo2.banco.views.*;

public class MenuOperacoesController {
    private ConsultarSaldoView consultarSaldoView;
    private SacarView sacarView;
    private DepositarView depositarView;
    private TransferirView transferirView;
    private InvestirView investirView;
    private EscolherContaView escolherContaView;
    public MenuOperacoesController(ConsultarSaldoView consultarSaldoView,
                                   SacarView sacarView,
                                   DepositarView depositarView,
                                   TransferirView transferirView,
                                   InvestirView investirView,
                                   EscolherContaView escolherContaView)
    {
        this.consultarSaldoView = consultarSaldoView;
        this.sacarView = sacarView;
        this.depositarView = depositarView;
        this.transferirView = transferirView;
        this.investirView = investirView;
        this.escolherContaView = escolherContaView;
    }

    public void consultarSaldo() {
        consultarSaldoView.iniciarConsultarSaldoView();
    }

    public void sacar() {
        sacarView.iniciarSacar();
        consultarSaldoView.iniciarConsultarSaldoView();
    }

    public void depositar(){
        depositarView.iniciarDepositar();
        consultarSaldoView.iniciarConsultarSaldoView();
    }

    public void transferir(){
        transferirView.iniciarTransferir();
    }

    public void investir(){
        investirView.iniciarInvestir();
    }

    public void escolherConta() {escolherContaView.iniciarEscolherContaView();}

}
