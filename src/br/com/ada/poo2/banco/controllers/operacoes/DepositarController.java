package br.com.ada.poo2.banco.controllers.operacoes;
import br.com.ada.poo2.banco.exceptions.InvalidInputException;
import br.com.ada.poo2.banco.exceptions.InvalidValueException;
import br.com.ada.poo2.banco.exceptions.UserDoesNotExistException;
import br.com.ada.poo2.banco.models.contas.Conta;
import br.com.ada.poo2.banco.models.enums.ETipoConta;
import static br.com.ada.poo2.banco.applicacao.Aplicacao.banco;

public class DepositarController {
    Conta contaDestino;

    public void determinarContaDestino(int opcaoDeposito, String numeroContaDestino) throws InvalidInputException {
        switch (opcaoDeposito) {
            case 1 :
                contaDestino = banco.getContaLogada();
                break;
            case 2 :
                contaDestino = banco.getMapaDeNumeroContaEConta().get(numeroContaDestino);
                validarContaDestino(contaDestino);
                break;
            default:
                throw new InvalidInputException();
        }
    }

    public void depositarContaUsuario(double valor) {
        double rendimento, saldoAtualDaConta;
        validarValorDeposito(valor);
        ETipoConta tipoContaLogada = contaDestino.getTipoConta();
        rendimento = contaDestino.getRendimento().taxaRendimentoDeposito(tipoContaLogada);
        saldoAtualDaConta = contaDestino.getSaldo();
        contaDestino.setSaldo((saldoAtualDaConta + valor) * (1 + rendimento));
    }

    public void validarValorDeposito(double valor) throws InvalidValueException{
        if (valor <= 0){
            throw new InvalidValueException();
        }
    }

    public void validarContaDestino(Conta contaDestino) throws UserDoesNotExistException {
        if (contaDestino == null){
            throw new UserDoesNotExistException();
        }
    }
}
