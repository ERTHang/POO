package principal;

import java.util.ArrayList;
import java.util.Scanner;

import dados.CD;
import dados.Livro;
import negocio.ItemDeBiblioteca;

public class Biblioteca {
    private static String nome;
    private static int quantItens;
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<ItemDeBiblioteca> itens = new ArrayList<ItemDeBiblioteca>();

    public static void catalogarLivro() {
        System.out.println("Titulo:");
        String titulo = in.nextLine();
        System.out.println("Localizacao:");
        String localizacao = (in.nextLine());
        Livro aux = new Livro(titulo, localizacao);
        System.out.println("Autor:");
        aux.setAutor(in.nextLine());
        System.out.println("Numero de paginas:");
        aux.setNumeroPaginas(in.nextInt());
        in.nextLine();
        System.out.println("Ano de edicao:");
        aux.setAnoEdicao(in.nextInt());
        in.nextLine();
        itens.add(aux);
    }

    public static void catalogarCD() {
        System.out.println("Titulo:");
        String titulo = in.nextLine();
        System.out.println("Localizacao:");
        String localizacao = (in.nextLine());
        CD aux = new CD(titulo, localizacao);
        System.out.println("Nome do artista::");
        aux.setNomeArtista(in.nextLine());
        System.out.println("duracao:");
        aux.setDuracao(in.nextInt());
        in.nextLine();
        System.out.println("Numero de musicas:");
        aux.setNumeroMusicas(in.nextInt());
        in.nextLine();
        System.out.println("Ano de gravacao:");
        aux.setAnoGravacao(in.nextInt());
        in.nextLine();
        itens.add(aux);
    }

    public static void emprestarItem(String titulo) {
        for (ItemDeBiblioteca item : itens) {
            if (item.titulo().equals(titulo)) {
                item.empresta();
                break;
            }
        }
    }

    public static void devolverItem(String titulo) {
        for (ItemDeBiblioteca item : itens) {
            if (item.titulo().equals(titulo)) {
                item.devolve();
                break;
            }
        }
    }

    public static void mostrarLocalizacao(String titulo) {
        for (ItemDeBiblioteca item : itens) {
            if (item.titulo().equals(titulo)) {
                System.out.println(item.localizacao());
                break;
            }
        }
    }

    public static void mostrarDetalhesItem(String titulo) {
        for (ItemDeBiblioteca item : itens) {
            if (item.titulo().equals(titulo)) {
                if (item instanceof Livro) {
                    System.out.println(((Livro) item).toString());
                }
                if (item instanceof CD) {
                    System.out.println(((CD) item).toString());
                }
            }
        }
    }

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            System.out.println(
                    "\n\n1. cadastrar CD\n2. cadastrar Livro\n3. emprestar Item\n4. devolver Item\n5. mostrar Localizacao\n6. mostrar Detalhes\n0. Sair");
            int opt = in.nextInt();
            in.nextLine();
            switch (opt) {
            case 1:
                catalogarCD();
                break;
            case 2:
                catalogarLivro();
                break;
            case 3:
                System.out.println("Titulo:");
                emprestarItem(in.nextLine());
                break;
            case 4:
                System.out.println("Titulo:");
                devolverItem(in.nextLine());
                break;
            case 5:
                System.out.println("Titulo:");
                mostrarLocalizacao(in.nextLine());
                break;
            case 6:
                System.out.println("Titulo:");
                mostrarDetalhesItem(in.nextLine());
                break;

                default:
                    sair = true;
                    break;
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantItens() {
        return quantItens;
    }

    public void setQuantItens(int quantItens) {
        this.quantItens = quantItens;
    }

    public ArrayList<ItemDeBiblioteca> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemDeBiblioteca> itens) {
        this.itens = itens;
    }

}