package persistencia;

import java.util.ArrayList;

public class ManipuladorArquivoAgenda implements ManipularArquivo {

    @Override
    public void abreArquivo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void fechaArquivo() {
        // TODO Auto-generated method stub

    }

    @Override
    public <T> ArrayList<T> carregaDadosArquivoTexto() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> ArrayList<T> carregaDadosArquivoBinario() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> void gravaDadosArquivoTexto(ArrayList<T> dados) {
        // TODO Auto-generated method stub

    }

    @Override
    public <T> void gravaDadosArquivoBinario(ArrayList<T> dados) {
        // TODO Auto-generated method stub

    }

    @Override
    public <T> String toLinhaArquivo(T objeto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T toObjeto(String linhaArquivo) {
        // TODO Auto-generated method stub
        return null;
    }

}