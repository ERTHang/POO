package apresentacao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import dados.Contracheque;
import dados.Contribuinte;
import dados.NotaFiscal;
import dados.PessoaJuridica;
import negocio.DeclaracaoRenda;

public class PanelConsulta extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = -6312128787590845983L;

    DeclaracaoRenda declaracaoRenda = new DeclaracaoRenda();

    public PanelConsulta() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.TOP);

        tabbedPane.addTab("Contribuinte", panelContribuinte());

        tabbedPane.addTab("Receitas", panelReceitas());

        tabbedPane.addTab("Despesas", panelDespesas());

        tabbedPane.addTab("Pessoa Jurídica", panelPessoaJuridica());

        add(tabbedPane);
    }

    public JComponent panelContribuinte() {
        JPanel panel = new JPanel(new GridLayout(5, 1));

        // nome
        JPanel nomePanel = new JPanel(new FlowLayout());
        JLabel nome = new JLabel();
        nome.setPreferredSize(new Dimension(400, 20));
        JLabel nomeLabel = new JLabel();
        nomeLabel.setText("Nome: ");
        nomeLabel.setLabelFor(nome);
        nomePanel.add(nomeLabel);
        nomePanel.add(nome);

        // idade
        JPanel idadePanel = new JPanel(new FlowLayout());
        JLabel idade = new JLabel();
        idade.setPreferredSize(new Dimension(400, 20));
        JLabel idadeLabel = new JLabel();
        idadeLabel.setText("Idade: ");
        idadeLabel.setLabelFor(idade);
        idadePanel.add(idadeLabel);
        idadePanel.add(idade);

        // endereco
        JPanel enderecoPanel = new JPanel(new FlowLayout());
        JLabel endereco = new JLabel();
        endereco.setPreferredSize(new Dimension(400, 20));
        JLabel enderecoLabel = new JLabel();
        enderecoLabel.setText("Endereco: ");
        enderecoLabel.setLabelFor(endereco);
        enderecoPanel.add(enderecoLabel);
        enderecoPanel.add(endereco);

        // conta
        JPanel contaPanel = new JPanel(new FlowLayout());
        JLabel conta = new JLabel();
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

        JButton consulta = new JButton("consultar");
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
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(panel, "Cpf não encontrado", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

        });
        cpfPanel.add(cpfLabel);
        cpfPanel.add(cpf);
        cpfPanel.add(consulta);

        panel.add(cpfPanel);
        panel.add(nomePanel);
        panel.add(idadePanel);
        panel.add(enderecoPanel);
        panel.add(contaPanel);
        return panel;
    }

    private JComponent panelReceitas() {
        JPanel panel = new JPanel(new GridBagLayout());
        JLabel valor = new JLabel();
        GridBagConstraints c = new GridBagConstraints();

        //list
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        JList<String> lista = new JList<String>(listModel);


        // cpf
        JPanel cpfPanel = new JPanel(new FlowLayout());
        cpfPanel.setPreferredSize(new Dimension(500, 40));
        JTextField cpf = new JTextField();
        cpf.setPreferredSize(new Dimension(400, 20));
        JLabel cpfLabel = new JLabel();
        cpfLabel.setText("CPF: ");
        cpfLabel.setLabelFor(cpf);
        cpfPanel.add(cpfLabel);
        cpfPanel.add(cpf);

        JButton consulta = new JButton("Verificar");
        consulta.setPreferredSize(new Dimension(100, 30));
        consulta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (declaracaoRenda.getContracheques().size() == 0) {
                        JOptionPane.showMessageDialog(panel, "Nenhuma receita registrada", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    listModel.clear();
                    double sum = 0;
                    for (Contracheque cheque : declaracaoRenda.getContracheques()) {
                        if (cheque.getIdContribuinte() == declaracaoRenda.getContribuinteCpf(cpf.getText()).getId()) {
                            listModel.addElement(cheque.getNumProtocolo() + ": R$" + cheque.getValor());
                            sum += cheque.getValor();
                        }
                        valor.setText("R$" + sum);
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(panel, "Cpf não encontrado", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

        });

        JPanel valorPanel = new JPanel(new FlowLayout());
        valor.setPreferredSize(new Dimension(150, 20));
        JLabel valorText = new JLabel();
        valorText.setText("Valor Final: ");
        valorPanel.add(valorText);
        valorPanel.add(valor);



        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        panel.add(cpfPanel, c);
        c.gridx = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        panel.add(consulta, c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(valorPanel, c);
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 1;
        c.ipady = 300;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        panel.add(lista, c);
        return panel;
    }

    private JComponent panelDespesas() {
        JPanel panel = new JPanel(new GridBagLayout());
        JLabel valor = new JLabel();
        GridBagConstraints c = new GridBagConstraints();

        //list
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        JList<String> lista = new JList<String>(listModel);


        // cpf
        JPanel cpfPanel = new JPanel(new FlowLayout());
        cpfPanel.setPreferredSize(new Dimension(500, 40));
        JTextField cpf = new JTextField();
        cpf.setPreferredSize(new Dimension(400, 20));
        JLabel cpfLabel = new JLabel();
        cpfLabel.setText("CPF: ");
        cpfLabel.setLabelFor(cpf);
        cpfPanel.add(cpfLabel);
        cpfPanel.add(cpf);

        JButton consulta = new JButton("Verificar");
        consulta.setPreferredSize(new Dimension(100, 30));
        consulta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (declaracaoRenda.getNotas().size() == 0) {
                        JOptionPane.showMessageDialog(panel, "Nenhuma despesa registrada", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    listModel.clear();
                    double sum = 0;
                    for (NotaFiscal nota : declaracaoRenda.getNotas()) {
                        if (nota.getIdContribuinte() == declaracaoRenda.getContribuinteCpf(cpf.getText()).getId()) {
                            listModel.addElement(nota.getNumProtocolo() + ": R$" + nota.getValor());
                            sum += nota.getValor();
                        }
                        valor.setText("R$" + sum);
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(panel, "Cpf não encontrado", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

        });

        JPanel valorPanel = new JPanel(new FlowLayout());
        valor.setPreferredSize(new Dimension(150, 20));
        JLabel valorText = new JLabel();
        valorText.setText("Valor Final: ");
        valorPanel.add(valorText);
        valorPanel.add(valor);



        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        panel.add(cpfPanel, c);
        c.gridx = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        panel.add(consulta, c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(valorPanel, c);
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 1;
        c.ipady = 300;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        panel.add(lista, c);
        return panel;
    }

    private JComponent panelPessoaJuridica() {
        JPanel panel = new JPanel(new GridLayout(4, 1));

        // nome
        JPanel nomePanel = new JPanel(new FlowLayout());
        JLabel nome = new JLabel();
        nome.setPreferredSize(new Dimension(400, 20));
        JLabel nomeLabel = new JLabel();
        nomeLabel.setText("Nome: ");
        nomeLabel.setLabelFor(nome);
        nomePanel.add(nomeLabel);
        nomePanel.add(nome);

        // endereco
        JPanel enderecoPanel = new JPanel(new FlowLayout());
        JLabel endereco = new JLabel();
        endereco.setPreferredSize(new Dimension(400, 20));
        JLabel enderecoLabel = new JLabel();
        enderecoLabel.setText("Endereco: ");
        enderecoLabel.setLabelFor(endereco);
        enderecoPanel.add(enderecoLabel);
        enderecoPanel.add(endereco);

        // numFuncionarios
        JPanel numFuncionariosPanel = new JPanel(new FlowLayout());
        JLabel numFuncionarios = new JLabel();
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
        JButton consulta = new JButton("consultar");
        consulta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PessoaJuridica pessoa;
                try {
                    pessoa = declaracaoRenda.getPessoaCnpj(cnpj.getText());
                    nome.setText(pessoa.getNomePJ());
                    endereco.setText(pessoa.getEndereco());
                    numFuncionarios.setText(Integer.toString(pessoa.getNumFuncionarios()));
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

        panel.add(cnpjPanel);
        panel.add(nomePanel);
        panel.add(enderecoPanel);
        panel.add(numFuncionariosPanel);
        return panel;
    }

}