package negocio;

import java.util.ArrayList;

import dados.Contato;
import excecoes.agendaVaziaException;
import excecoes.contatoJaCadastradoException;
import excecoes.contatoNaoEncontradoException;

/**
 * Agenda
 */
public class Agenda {

    private ArrayList<Contato> contatos = new ArrayList<Contato>();

    public void cadastrarContato(Contato novo) throws contatoJaCadastradoException {

    }

    public Contato buscarContato(int telefone) throws contatoNaoEncontradoException, agendaVaziaException {
        return null;
    }

    public ArrayList<Contato> buscarContatos(String nome) throws contatoNaoEncontradoException, agendaVaziaException {
        return null;
    }

    public void removerContato(Contato contato) throws contatoNaoEncontradoException, agendaVaziaException {

    }

    /**
     * @return ArrayList<Contato> return the contatos
     */
    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    /**
     * @param contatos the contatos to set
     */
    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

}