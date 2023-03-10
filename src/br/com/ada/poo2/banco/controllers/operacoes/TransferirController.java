package br.com.ada.poo2.banco.controllers.operacoes;
import br.com.ada.poo2.banco.exceptions.InsufficientFundsException;
import br.com.ada.poo2.banco.exceptions.NoFundsException;
import br.com.ada.poo2.banco.exceptions.UserDoesNotExistException;
import br.com.ada.poo2.banco.models.contas.Conta;
import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class TransferirController {
    Conta contaDestino;

    public void transferirValor(double valor, String numeroContaDestino) {
        double taxa, saldoAtualDaConta, valorDescontadoDoSaldoAtualDaConta;
        contaDestino = banco.getMapaDeNumeroContaEConta().get(numeroContaDestino);
        validarValorTransferencia(valor);
        validarContaDestino();
        taxa = banco.getContaLogada().getTaxas().taxa("TRANSFERENCIA");
        saldoAtualDaConta = banco.getContaLogada().getSaldo();
        valorDescontadoDoSaldoAtualDaConta = valor * (1 + taxa);
        banco.getContaLogada().setSaldo(saldoAtualDaConta - valorDescontadoDoSaldoAtualDaConta);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
    }

    public void validarSaldoPositivoConta() throws NoFundsException {
        if(banco.getContaLogada().getSaldo() <= 0){
            throw new NoFundsException();
        }
    }
    public void validarValorTransferencia(double valor) throws InsufficientFundsException{
        if (banco.getContaLogada().getSaldo() < valor){
            throw new InsufficientFundsException();
        }
    }

    public void validarContaDestino() throws UserDoesNotExistException{
        if (contaDestino == null) {
            throw new UserDoesNotExistException();
        }
    }
}
