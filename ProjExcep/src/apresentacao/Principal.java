package apresentacao;

import java.util.Scanner;
import dados.*;
import exceptions.InformacaoNaoEncontradaException;
import exceptions.ListaVaziaException;
import exceptions.PosicaoInvalidaException;
import negocio.*;

public class Principal {

    private static Scanner in = new Scanner(System.in);
    private static GerenciaPessoas gerencia = new GerenciaPessoas();

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public static void cadastrarPF() throws Exception {
        PF pessoa = new PF();
        String nome;

        System.out.println("CPF:");
        pessoa.setCpf(in.nextLine());
        System.out.println("Nome:");
        nome = in.nextLine();
        pessoa.setNome(nome);

        if (gerencia.pegarPorNome(nome) != null)
            throw new Exception();

        gerencia.inserirFinalLista(pessoa);
    }

    public static void cadastrarPJ() throws Exception {
        PJ pessoa = new PJ();
        String nome;

        System.out.println("CNPJ:");
        pessoa.setCnpj(in.nextLine());
        System.out.println("Nome:");
        nome = in.nextLine();
        pessoa.setNome(nome);

        if (gerencia.pegarPorNome(nome) != null)
            throw new Exception();

        gerencia.inserirFinalLista(pessoa);
    }

    public static void cadastrarPFnaPosicao() throws Exception {
        PF pessoa = new PF();
        String nome;
        int pos;

        System.out.println("CPF:");
        pessoa.setCpf(in.nextLine());
        System.out.println("Nome:");
        nome = in.nextLine();
        pessoa.setNome(nome);

        if (gerencia.pegarPorNome(nome) != null)
            throw new Exception();

        System.out.println("Posição:");
        pos = in.nextInt();
        in.nextLine();

        gerencia.inserirNaPosicao(pessoa, pos);
    }

    public static void cadastrarPJnaPosicao() throws Exception {
        PJ pessoa = new PJ();
        String nome;
        int pos;

        System.out.println("CNPJ:");
        pessoa.setCnpj(in.nextLine());
        System.out.println("Nome:");
        nome = in.nextLine();
        pessoa.setNome(nome);

        if (gerencia.pegarPorNome(nome) != null)
            throw new Exception();

        System.out.println("Posição:");
        pos = in.nextInt();
        in.nextLine();

        gerencia.inserirNaPosicao(pessoa, pos);
    }

    public static void imprimirIdPessoaPorNome() {
        String nome;

        System.out.println("Nome:");
        nome = in.nextLine();

        try {
            System.out.println(gerencia.pegarPorNome(nome).getId());
        } catch (InformacaoNaoEncontradaException e) {

        } catch (ListaVaziaException e) {

        }
    }

    public static void imprimirIdPessoanaPosicao() {
        int pos;

        System.out.println("Posição:");
        pos = in.nextInt();
        in.nextLine();

        try {
            System.out.println(gerencia.pegarNaPosicao(pos).getId());
        } catch (ListaVaziaException e) {

        } catch (PosicaoInvalidaException e) {

        }
    }

    public static void excluirPessoaNaPosicao(){
        int pos;

        System.out.println("Posição:");
        pos = in.nextInt();
        in.nextLine();

        try {
            gerencia.excluirNaPosicao(pos);
        } catch (PosicaoInvalidaException e) {
        } catch (ListaVaziaException e) {
        }
    }

    public static void excluirPessoaPorNome(){
        String nome;

        System.out.println("Nome:");
        nome = in.nextLine();

        try {
            gerencia.excluirPorNome(nome);
        } catch (InformacaoNaoEncontradaException e) {
        } catch (ListaVaziaException e) {
        }
    }

}