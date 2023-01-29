package br.com.ada.poo2.banco.controllers.operacoes;
import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class DeslogarController {
    public void executar() {
        banco.setContaLogada(null);
    }
}
