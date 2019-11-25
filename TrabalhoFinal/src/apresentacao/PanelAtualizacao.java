package apresentacao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import dados.Contribuinte;
import dados.Dependente;
import dados.PessoaJuridica;
import negocio.DeclaracaoRenda;

public class PanelAtualizacao extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 8026665514164642294L;

    DeclaracaoRenda declaracaoRenda = new DeclaracaoRenda();

    public PanelAtualizacao() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.TOP);

        tabbedPane.addTab("Contribuinte", null, panelContribuinte(), "Atualizar contribuinte");

        tabbedPane.addTab("Dependente", null, panelDependente(), "Atualizar dependente");

        tabbedPane.addTab("Pessoa Jurídica", null, panelPessoaJuridica(), "Consultar pessoa jurídica");

        add(tabbedPane);
    }

    public JComponent panelContribuinte() {
        JPanel panel = new JPanel(new GridLayout(6, 1));

        // nome
        JPanel nomePanel = new JPanel(new FlowLayout());
        JTextField nome = new JTextField();
        nome.setPreferredSize(new Dimension(400, 20));
        JLabel nomeLabel = new JLabel();
        nomeLabel.setText("Nome: ");
        nomeLabel.setLabelFor(nome);
        nomePanel.add(nomeLabel);
        nomePanel.add(nome);

        // idade
        JPanel idadePanel = new JPanel(new FlowLayout());
        JTextField idade = new JTextField();
        idade.setPreferredSize(new Dimension(400, 20));
        JLabel idadeLabel = new JLabel();
        idadeLabel.setText("Idade: ");
        idadeLabel.setLabelFor(idade);
        idadePanel.add(idadeLabel);
        idadePanel.add(idade);

        // endereco
        JPanel enderecoPanel = new JPanel(new FlowLayout());
        JTextField endereco = new JTextField();
        endereco.setPreferredSize(new Dimension(400, 20));
        JLabel enderecoLabel = new JLabel();
        enderecoLabel.setText("Endereco: ");
        enderecoLabel.setLabelFor(endereco);
        enderecoPanel.add(enderecoLabel);
        enderecoPanel.add(endereco);

        // conta
        JPanel contaPanel = new JPanel(new FlowLayout());
        JTextField conta = new JTextField();
        conta.setPreferredSize(new Dimension(400, 20));
        JLabel contaLabel = new JLabel();
        contaLabel.setText("Conta Bancaria: ");
        contaLabel.setLabelFor(conta);
        contaPanel.add(contaLabel);
        contaPanel.add(conta);

        // cpf
        JPanel cpfPanel = new JPanel(new FlowLayout());
        JTextField cpf = new JTextField();
        cpf.setPreferredSize(new Dimension(400, 20));
        JLabel cpfLabel = new JLabel();
        cpfLabel.setText("CPF: ");
        cpfLabel.setLabelFor(cpf);
        JButton consulta = new JButton("Verificar");
        consulta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Contribuinte contribuinte;
                try {
                    contribuinte = declaracaoRenda.getContribuinteCpf(cpf.getText());
                    nome.setText(contribuinte.getNome());
                    idade.setText(Integer.toString(contribuinte.getIdade()));
                    endereco.setText(contribuinte.getEndereco());
                    conta.setText(Integer.toString(contribuinte.getContaBancaria()));
                }catch (NumberFormatException e3){
                    JOptionPane.showMessageDialog(panel, "Valor invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }  
                catch (Exception e2) {
                    JOptionPane.showMessageDialog(panel, "Cpf invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
        });
        cpfPanel.add(cpfLabel);
        cpfPanel.add(cpf);
        cpfPanel.add(consulta);

        JButton update = new JButton("Atualizar");
        update.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    declaracaoRenda.updateContribuinte(
                        declaracaoRenda.getContribuinteCpf(cpf.getText()).getId(),
                        nome.getText(),
                        Integer.parseInt(idade.getText()),
                        endereco.getText(),
                        Integer.parseInt(conta.getText()));
                    PanelListagem.refreshContribuintes();
                }catch (NumberFormatException e3){
                    JOptionPane.showMessageDialog(panel, "Valor invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }  
                catch (Exception e2) {
                    JOptionPane.showMessageDialog(panel, "Cpf invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
        });

        panel.add(cpfPanel);
        panel.add(nomePanel);
        panel.add(idadePanel);
        panel.add(enderecoPanel);
        panel.add(contaPanel);
        panel.add(update);
        return panel;
    }

    private JComponent panelDependente() {
        JPanel panel = new JPanel(new GridLayout(5, 1));

        // nome
        JPanel nomePanel = new JPanel(new FlowLayout());
        JTextField nome = new JTextField();
        nome.setPreferredSize(new Dimension(400, 20));
        JLabel nomeLabel = new JLabel();
        nomeLabel.setText("Nome: ");
        nomeLabel.setLabelFor(nome);
        nomePanel.add(nomeLabel);
        nomePanel.add(nome);

        // idade
        JPanel idadePanel = new JPanel(new FlowLayout());
        JTextField idade = new JTextField();
        idade.setPreferredSize(new Dimension(400, 20));
        JLabel idadeLabel = new JLabel();
        idadeLabel.setText("Idade: ");
        idadeLabel.setLabelFor(idade);
        idadePanel.add(idadeLabel);
        idadePanel.add(idade);

        // endereco
        JPanel enderecoPanel = new JPanel(new FlowLayout());
        JTextField endereco = new JTextField();
        endereco.setPreferredSize(new Dimension(400, 20));
        JLabel enderecoLabel = new JLabel();
        enderecoLabel.setText("Endereco: ");
        enderecoLabel.setLabelFor(endereco);
        enderecoPanel.add(enderecoLabel);
        enderecoPanel.add(endereco);

        // cpf
        JPanel cpfPanel = new JPanel(new FlowLayout());
        JTextField cpf = new JTextField();
        cpf.setPreferredSize(new Dimension(400, 20));
        JLabel cpfLabel = new JLabel();
        cpfLabel.setText("CPF: ");
        cpfLabel.setLabelFor(cpf);
        JButton consulta = new JButton("Verificar");
        consulta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Dependente dependente;
                try {
                    dependente = declaracaoRenda.getDependenteCpf(cpf.getText());
                    nome.setText(dependente.getNome());
                    idade.setText(Integer.toString(dependente.getIdade()));
                    endereco.setText(dependente.getEndereco());

                }catch (NumberFormatException e3){
                    JOptionPane.showMessageDialog(panel, "Valor invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }  
                catch (Exception e2) {
                    JOptionPane.showMessageDialog(panel, "Cpf invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
        });
        cpfPanel.add(cpfLabel);
        cpfPanel.add(cpf);
        cpfPanel.add(consulta);

        JButton update = new JButton("Atualizar");
        update.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    declaracaoRenda.updateDependente(
                        declaracaoRenda.getDependenteCpf(cpf.getText()).getId(),
                        nome.getText(),
                        Integer.parseInt(idade.getText()),
                        endereco.getText());
                }catch (NumberFormatException e3){
                    JOptionPane.showMessageDialog(panel, "Valor invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }  
                catch (Exception e2) {
                    JOptionPane.showMessageDialog(panel, "Cpf invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
        });

        panel.add(cpfPanel);
        panel.add(nomePanel);
        panel.add(idadePanel);
        panel.add(enderecoPanel);
        panel.add(update);
        return panel;
    }

    private JComponent panelPessoaJuridica() {
        JPanel panel = new JPanel(new GridLayout(5, 1));

        // nome
        JPanel nomePanel = new JPanel(new FlowLayout());
        JTextField nome = new JTextField();
        nome.setPreferredSize(new Dimension(400, 20));
        JLabel nomeLabel = new JLabel();
        nomeLabel.setText("Nome: ");
        nomeLabel.setLabelFor(nome);
        nomePanel.add(nomeLabel);
        nomePanel.add(nome);

        // endereco
        JPanel enderecoPanel = new JPanel(new FlowLayout());
        JTextField endereco = new JTextField();
        endereco.setPreferredSize(new Dimension(400, 20));
        JLabel enderecoLabel = new JLabel();
        enderecoLabel.setText("Endereco: ");
        enderecoLabel.setLabelFor(endereco);
        enderecoPanel.add(enderecoLabel);
        enderecoPanel.add(endereco);

        // numFuncionarios
        JPanel numFuncionariosPanel = new JPanel(new FlowLayout());
        JTextField numFuncionarios = new JTextField();
        numFuncionarios.setPreferredSize(new Dimension(400, 20));
        JLabel numFuncionariosLabel = new JLabel();
        numFuncionariosLabel.setText("Numero de funcionarios: ");
        numFuncionariosLabel.setLabelFor(numFuncionarios);
        numFuncionariosPanel.add(numFuncionariosLabel);
        numFuncionariosPanel.add(numFuncionarios);

        // cnpj
        JPanel cnpjPanel = new JPanel(new FlowLayout());
        JTextField cnpj = new JTextField();
        cnpj.setPreferredSize(new Dimension(400, 20));
        JLabel cnpjLabel = new JLabel();
        cnpjLabel.setText("CNPJ: ");
        cnpjLabel.setLabelFor(cnpj);
        JButton consulta = new JButton("Verificar");
        consulta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PessoaJuridica pessoa;
                try {
                    pessoa = declaracaoRenda.getPessoaCnpj(cnpj.getText());
                    nome.setText(pessoa.getNomePJ());
                    endereco.setText(pessoa.getEndereco());
                    numFuncionarios.setText(Integer.toString(pessoa.getNumFuncionarios()));
                    PanelListagem.refreshPessoas();
                }catch (NumberFormatException e3){
                    JOptionPane.showMessageDialog(panel, "Valor invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }  
                catch (Exception e2) {
                    JOptionPane.showMessageDialog(panel, "Cnpj invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
        });
        cnpjPanel.add(cnpjLabel);
        cnpjPanel.add(cnpj);
        cnpjPanel.add(consulta);

        JButton update = new JButton("Atualizar");
        update.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    declaracaoRenda.updatePessoaJuridica(
                        declaracaoRenda.getPessoaCnpj(cnpj.getText()).getId(),
                        nome.getText(),
                        endereco.getText(),
                        Integer.parseInt(numFuncionarios.getText()));
                }catch (NumberFormatException e3){
                    JOptionPane.showMessageDialog(panel, "Valor invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }  
                catch (Exception e2) {
                    JOptionPane.showMessageDialog(panel, "Cnpj invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
        });

        panel.add(cnpjPanel);
        panel.add(nomePanel);
        panel.add(enderecoPanel);
        panel.add(numFuncionariosPanel);
        panel.add(update);
        return panel;
    }

    
}