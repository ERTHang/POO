package dados;
import negocio.*;

public class Livro implements ItemDeBiblioteca{
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private int anoEdicao;
    private String localizacao;
    private boolean estaEmprestado;

    public Livro(String titulo, String localizacao){
        this.titulo = titulo;
        this.localizacao = localizacao;
        this.estaEmprestado = false;
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
            System.out.println("O livro nao esta emprestado");
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public int getAnoEdicao() {
        return anoEdicao;
    }

    public void setAnoEdicao(int anoEdicao) {
        this.anoEdicao = anoEdicao;
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

    @Override
    public String toString() {
        return "Livro [anoEdicao=" + anoEdicao + ", autor=" + autor + ", estaEmprestado=" + estaEmprestado
                + ", localizacao=" + localizacao + ", numeroPaginas=" + numeroPaginas + ", titulo=" + titulo + "]";
    }
}