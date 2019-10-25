package dados;

/**
 * Contato
 */
public class Contato {

    private String nome;
    private int telefone;
    

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return int return the telefone
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contato [nome=" + nome + ", telefone=" + telefone + "]";
    }

}