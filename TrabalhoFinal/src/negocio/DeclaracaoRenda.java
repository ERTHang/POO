package negocio;

import java.util.ArrayList;

import dados.*;
import persistencia.*;

public class DeclaracaoRenda {
    BemDAO bemDAO = BemDAO.getInstance();
    ContrachequeDAO contrachequeDAO = ContrachequeDAO.getInstance();
    ContribuinteDAO contribuinteDAO = ContribuinteDAO.getInstance();
    DependenteDAO dependenteDAO = DependenteDAO.getInstance();
    NotaFiscalDAO notaFiscalDAO = NotaFiscalDAO.getInstance();
    PessoaJuridicaDAO pessoaJuridicaDAO = PessoaJuridicaDAO.getInstance();

    public void cadastrarContribuinte(String cpf, String nome, int idade, String endereco, int contaBancaria) {
        int id = contribuinteDAO.maiorID() + 1;
        contribuinteDAO.insert(id, cpf, nome, idade, endereco, contaBancaria);
    }

    public void cadastrarBem(String nome, String tipo, double valor, int idContribuinte) {
        int id = bemDAO.maiorID() + 1;
        bemDAO.insert(id, nome, tipo, valor, idContribuinte);
    }

    public void cadastrarContracheque(int numProtocolo, String cnpj, double valor, int idContribuinte, int idpj) {
        int id = contrachequeDAO.maiorID() + 1;
        contrachequeDAO.insert(id, numProtocolo, cnpj, valor, idContribuinte, idpj);
    }

    public void cadastrarDependente(String cpf, String nome, int idade, String endereco, int idContribuinte) {
        int id = dependenteDAO.maiorID() + 1;
        dependenteDAO.insert(id, cpf, nome, idade, endereco, idContribuinte);
    }

    public void cadastrarNotaFiscal(int numProtocolo, String cnpj, double valor, int idpj, int idContribuinte) {
        int id = notaFiscalDAO.maiorID() + 1;
        notaFiscalDAO.insert(id, numProtocolo, cnpj, valor, idpj, idContribuinte);
    }

    public void cadastrarPessoaJuridica(String cnpj, String nomePJ, String endereco, int numFuncionarios) {
        int id = pessoaJuridicaDAO.maiorID() + 1;
        pessoaJuridicaDAO.insert(id, cnpj, nomePJ, endereco, numFuncionarios);
    }

    public ArrayList<Contribuinte> getContribuintes() {
        return contribuinteDAO.getContribuintes();
    }

    public ArrayList<PessoaJuridica> getPessoas() {
        return pessoaJuridicaDAO.getPessoas();
    }

    public ArrayList<Dependente> getDependentes() {
        return dependenteDAO.getDependentes();
    }

    public ArrayList<Bem> getBens() {
        return bemDAO.getBens();
    }

    public ArrayList<NotaFiscal> getNotas() {
        return notaFiscalDAO.getNotas();
    }

    public ArrayList<Contracheque> getContracheques() {
        return contrachequeDAO.getContracheques();
    }

    public PessoaJuridica getPessoa(int code){
        return pessoaJuridicaDAO.select(code);
    }

    public Contribuinte getContribuinteCpf(String cpf) {
        for (Contribuinte contribuinte : getContribuintes()) {
            if (contribuinte.getCpf().equals(cpf)) {
                return contribuinte;
            }
        }
        return null;
    }

    public Dependente getDependenteCpf(String cpf) {
        for (Dependente dependente : getDependentes()) {
            if (dependente.getCpf().equals(cpf)) {
                return dependente;
            }
        }
        return null;
    }

    public PessoaJuridica getPessoaCnpj(String cnpj) {
        for (PessoaJuridica pessoa : getPessoas()) {
            if (pessoa.getCnpj().equals(cnpj)) {
                return pessoa;
            }
        }
        return null;
    }

    public int removeDependente(String cpf) {
        for (Dependente dependente : getDependentes()) {
            if (dependente.getCpf().equals(cpf)) {
                dependenteDAO.delete(dependente.getId());
                return 1;
            }
        }
        return 0;
    }

    public int removeBem(int idContribuinte, String nome) {
        for (Bem bem : getBens()) {
            if (bem.getIdContribuinte() == idContribuinte) {
                if (bem.getNome().equals(nome)) {
                    bemDAO.delete(bem.getId());
                    return 1;
                }
            }
        }
        return 0;
    }

    public int removeNotaFiscal(int numProtocolo) {
        for (NotaFiscal nota : getNotas()) {
            if (nota.getNumProtocolo() == numProtocolo) {
                notaFiscalDAO.delete(nota.getId());
                return 1;
            }
        }
        return 0;
    }

    public void removeNotaFiscalPorPessoa(int idPessoa) {
        for (NotaFiscal nota : getNotas()) {
            if (nota.getIdPJ() == idPessoa) {
                notaFiscalDAO.delete(nota.getId());
            }
        }
    }

    public int removeContracheque(int numProtocolo) {
        for (Contracheque contracheque : getContracheques()) {
            if (contracheque.getNumProtocolo() == numProtocolo) {
                contrachequeDAO.delete(contracheque.getId());
                return 1;
            }
        }
        return 0;
    }

    public void removeContrachequePorPessoa(int idPessoa) {
        for (Contracheque contracheque : getContracheques()) {
            if (contracheque.getIdPJ() == idPessoa) {
                contrachequeDAO.delete(contracheque.getId());
            }
        }
    }

    public int removePessoaJuridica(String cnpj) {
        for (PessoaJuridica pessoa : getPessoas()) {
            if (pessoa.getCnpj().equals(cnpj)) {
                removeContrachequePorPessoa(pessoa.getId());
                removeNotaFiscalPorPessoa(pessoa.getId());
                pessoaJuridicaDAO.delete(pessoa.getId());
                return 1;
            }
        }
        return 0;
    }

    public void updateContribuinte(int id, String nome, int idade, String endereco, int contaBancaria) {
        contribuinteDAO.update(id, nome, idade, endereco, contaBancaria);
    }

    public void updateDependente(int id, String nome, int idade, String endereco) {
        dependenteDAO.update(id, nome, idade, endereco);
    }

    public void updatePessoaJuridica(int id, String nome, String endereco, int numFuncionarios) {
        pessoaJuridicaDAO.update(id, nome, endereco, numFuncionarios);
    }

    public NotaFiscal getNotaProtocolo(int protocolo) {
        for (NotaFiscal nota : getNotas()) {
            if (nota.getNumProtocolo() == protocolo) {
                return nota;
            }
        }
        return null;
    }

    public Contracheque getChequeProtocolo(int protocolo) {
        for (Contracheque contracheque : getContracheques()) {
            if (contracheque.getNumProtocolo() == protocolo) {
                return contracheque;
            }
        }
        return null;
    }

    
}