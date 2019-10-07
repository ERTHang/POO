package dados;

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
    }

    public boolean estaEmprestado(){
        return this.estaEmprestado;
    }

    public boolean empresta(){
        this.estaEmprestado = true;
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
}