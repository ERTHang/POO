package dados;

import negocio.ItemDeBiblioteca;

public class CD implements ItemDeBiblioteca{
    private String titulo;
    private String nomeArtista;
    private int duracao;
    private int numeroMusicas;
    private int anoGravacao;
    private String localizacao;
    private boolean estaEmprestado;

    public CD(String titulo, String localizacao){
        this.titulo = titulo;
        this.localizacao = localizacao;
    }

    public boolean estaEmprestado(){
        return this.estaEmprestado;
    }

    public boolean empresta(){
        if(this.estaEmprestado){
            return false;
        }
        this.estaEmprestado = true;
        return true;
    }

    public void devolve(){
        if(this.estaEmprestado){
            this.estaEmprestado = false;
        }else{
            System.out.println("O CD nao esta emprestado");
        }
    }

    public String localizacao(){
        return this.localizacao;
    }

    public String titulo(){
        return this.titulo;
    }

}