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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getNumeroMusicas() {
        return numeroMusicas;
    }

    public void setNumeroMusicas(int numeroMusicas) {
        this.numeroMusicas = numeroMusicas;
    }

    public int getAnoGravacao() {
        return anoGravacao;
    }

    public void setAnoGravacao(int anoGravacao) {
        this.anoGravacao = anoGravacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public boolean isEstaEmprestado() {
        return estaEmprestado;
    }

    public void setEstaEmprestado(boolean estaEmprestado) {
        this.estaEmprestado = estaEmprestado;
    }

}