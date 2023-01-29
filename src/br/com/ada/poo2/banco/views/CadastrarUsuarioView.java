package br.com.ada.poo2.banco.views;
import br.com.ada.poo2.banco.controllers.operacoes.CadastrarUsuarioController;
import br.com.ada.poo2.banco.controllers.operacoes.CriarContaController;
import br.com.ada.poo2.banco.exceptions.UserAlreadyExistsException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastrarUsuarioView {
    Scanner scanner = new Scanner(System.in);
    private CadastrarUsuarioController cadastrarUsuarioController;
    private CriarContaController criarContaController;

    public CadastrarUsuarioView(
            CadastrarUsuarioController cadastrarUsuarioController,
            CriarContaController criarContaController) {
        this.cadastrarUsuarioController = cadastrarUsuarioController;
        this.criarContaController = criarContaController;
    }

    public void iniciarCadastrarUsuarioView() {
        String nome, identificador;
        int senha;

        try {
            nome = pedirNomeDoUsuario();
            senha = pedirSenhaDoUsuario();
            cadastrarUsuarioController.criarUsuario(nome, senha);
            exibirOpcoesIdentificadorDoUsuario();
            scanner.nextLine();
            identificador = pedirIdentificadorDoUsuario();
            cadastrarUsuarioController.adicionarIdentificadorAoUsuario(identificador);
            cadastrarUsuarioController.adicionarUsuarioAoBanco();
            criarContaController.iniciarCriarConta();
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida");
            scanner.nextLine();
            iniciarCadastrarUsuarioView();
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
            scanner.nextLine();
            iniciarCadastrarUsuarioView();
        }
    }

    public String pedirNomeDoUsuario() {
        System.out.println("Digite o nome:");
        return scanner.nextLine();
    }

    private int pedirSenhaDoUsuario() {
        System.out.println("Digite a senha (somente números):");
        return scanner.nextInt();
    }

    public void exibirOpcoesIdentificadorDoUsuario() {
        String tipoDeIdentificador = cadastrarUsuarioController.pegarTipoIdentificadorUsuario();
        System.out.println("Digite o seu " + tipoDeIdentificador + ":");
    }

    public String pedirIdentificadorDoUsuario() {
        return scanner.nextLine();
    }
}