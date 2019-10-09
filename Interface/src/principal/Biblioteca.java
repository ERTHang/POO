package principal;

import java.util.ArrayList;
import java.util.Scanner;

import dados.CD;
import dados.Livro;
import negocio.ItemDeBiblioteca;

public class Biblioteca {
    private String nome;
    private int quantItens;
    private Scanner in = new Scanner(System.in);
    private ArrayList<ItemDeBiblioteca> itens = new ArrayList<ItemDeBiblioteca>();

    public void catalogarLivro() {
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

    public void catalogarCD() {
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

    public void emprestarItem(String titulo) {
        for(ItemDeBiblioteca item:itens){
            if(item.titulo().equals(titulo)){
                item.empresta();
                break;
            }
        }
    }

    public void devolverItem(String titulo) {
        for(ItemDeBiblioteca item:itens){
            if(item.titulo().equals(titulo)){
                item.devolve();
                break;
            }
        }
    }

    public void mostrarLocalizacao(String titulo) {
        for(ItemDeBiblioteca item:itens){
            if(item.titulo().equals(titulo)){
                item.devolve();
                break;
            }
        }
    }

    public void mostrarDetalhesItem(String titulo) {
        for(ItemDeBiblioteca item:itens){
            if(item.titulo().equals(titulo)){
                if(item instanceof Livro){
                    System.out.println(((Livro)item).toString());
                }
                if(item instanceof CD){
                    System.out.println(((CD)item).toString());
                }
            }
        }
    }

    public static void main(String[] args) {

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