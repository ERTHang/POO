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
        boolean sair = false;
        int opt;
        while (!sair) {
            System.out.println(
                    "\n\nOpcoes:\n0. sair\n1. Cadastrar pessoa fisica\n2. Cadastrar pessoa juridica\n3. Imprimir id\n4. Excluir pessoa");
            opt = in.nextInt();
            in.nextLine();
            switch (opt) {
            case 1:
                System.out.println("posição especifica?");
                if (in.nextLine().equals("sim")) {
                    cadastrarPFnaPosicao();
                } else {
                    cadastrarPF();
                }
                break;
            case 2:
                System.out.println("Posição específica?");
                if (in.nextLine().equals("sim")) {
                    cadastrarPJnaPosicao();
                } else {
                    cadastrarPJ();
                }
                break;
            case 3:
                System.out.println("pela posição ou nome?");
                String opts = in.nextLine();
                if (opts.equals("posicao")) {
                    imprimirIdPessoanaPosicao();
                } else if (opts.equals("nome")) {
                    imprimirIdPessoaPorNome();
                }
                break;
            case 4:
                System.out.println("pela posição ou nome?");
                String opts2 = in.nextLine();
                if (opts2.equals("posicao")) {
                    excluirPessoaNaPosicao();
                } else if (opts2.equals("nome")) {
                    excluirPessoaPorNome();
                }
                break;
            case 0:
                sair = true;
                break;
            default:
                break;
            }

        }
    }

    public static void cadastrarPF() {
        PF pessoa = new PF();
        String nome;

        System.out.println("CPF:");
        pessoa.setCpf(in.nextLine());
        System.out.println("Nome:");
        nome = in.nextLine();
        pessoa.setNome(nome);

        gerencia.inserirFinalLista(pessoa);
    }

    public static void cadastrarPJ() {
        PJ pessoa = new PJ();
        String nome;

        System.out.println("CNPJ:");
        pessoa.setCnpj(in.nextLine());
        System.out.println("Nome:");
        nome = in.nextLine();
        pessoa.setNome(nome);

        gerencia.inserirFinalLista(pessoa);
    }

    public static void cadastrarPFnaPosicao() {
        PF pessoa = new PF();
        String nome;
        int pos;

        System.out.println("CPF:");
        pessoa.setCpf(in.nextLine());
        System.out.println("Nome:");
        nome = in.nextLine();
        pessoa.setNome(nome);
        System.out.println("Posição:");
        pos = in.nextInt();
        in.nextLine();

        try {
            gerencia.inserirNaPosicao(pessoa, pos);
        } catch (PosicaoInvalidaException e) {
            System.out.println("posição invalida");
        }
    }

    public static void cadastrarPJnaPosicao() {
        PJ pessoa = new PJ();
        String nome;
        int pos;

        System.out.println("CNPJ:");
        pessoa.setCnpj(in.nextLine());
        System.out.println("Nome:");
        nome = in.nextLine();
        pessoa.setNome(nome);

        System.out.println("Posição:");
        pos = in.nextInt();
        in.nextLine();

        try {
            gerencia.inserirNaPosicao(pessoa, pos);
        } catch (PosicaoInvalidaException e) {
            System.out.println("posição invalida");
        }
    }

    public static void imprimirIdPessoaPorNome() {
        String nome;

        System.out.println("Nome:");
        nome = in.nextLine();

        try {
            System.out.println("ID = " + gerencia.pegarPorNome(nome).getId());
        } catch (InformacaoNaoEncontradaException e) {
            System.out.println("nome não encontrado");

        } catch (ListaVaziaException e) {
            System.out.println("cadastre uma pessoa antes");
        }
    }

    public static void imprimirIdPessoanaPosicao() {
        int pos;

        System.out.println("Posição:");
        pos = in.nextInt();
        in.nextLine();

        try {
            System.out.println("ID = " + gerencia.pegarNaPosicao(pos).getId());
        } catch (ListaVaziaException e) {
            System.out.println("cadastre uma pessoa antes");
        } catch (PosicaoInvalidaException e) {
            System.out.println("posição nao encontrada");
        }
    }

    public static void excluirPessoaNaPosicao() {
        int pos;

        System.out.println("Posição:");
        pos = in.nextInt();
        in.nextLine();

        try {
            gerencia.excluirNaPosicao(pos);
            System.out.println("Sucesso");
        } catch (PosicaoInvalidaException e) {
            System.out.println("posição nao encontrada");

        } catch (ListaVaziaException e) {
            System.out.println("cadastre uma pessoa antes");

        }
    }

    public static void excluirPessoaPorNome() {
        String nome;

        System.out.println("Nome:");
        nome = in.nextLine();

        try {
            gerencia.excluirPorNome(nome);
            System.out.println("Sucesso");

        } catch (InformacaoNaoEncontradaException e) {
            System.out.println("nome nao encontrado");

        } catch (ListaVaziaException e) {
            System.out.println("cadastre uma pessoa antes");

        }
    }

}