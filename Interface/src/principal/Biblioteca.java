package principal;

import java.util.ArrayList;

import negocio.ItemDeBiblioteca;

public class Biblioteca{
    private String nome;
    private int quantItens;
    private ArrayList<ItemDeBiblioteca>itens = new ArrayList<ItemDeBiblioteca>();

    public void catalogarLivro(){

    }

    public void catalogarCD(){

    }

    public void emprestarItem(String titulo){

    }

    public void devolverItem(String titulo){

    }

    public void mostrarLocalizacao(String titulo){

    }

    public void mostrarDetalhesItem(String titulo){

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