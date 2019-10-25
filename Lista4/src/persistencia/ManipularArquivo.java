package persistencia;

import java.util.ArrayList;

/**
 * manipularArquivo
 */
public interface ManipularArquivo {
    public void abreArquivo();

    public void fechaArquivo();
    
    public <T> ArrayList<T> carregaDadosArquivoTexto();

    public <T> ArrayList<T> carregaDadosArquivoBinario();

    public <T> void gravaDadosArquivoTexto(ArrayList<T> dados);

    public <T> void gravaDadosArquivoBinario(ArrayList<T> dados);

    public <T> String toLinhaArquivo(T objeto);

    public <T> T toObjeto(String linhaArquivo);

}