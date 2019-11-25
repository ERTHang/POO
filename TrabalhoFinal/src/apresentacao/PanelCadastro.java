package apresentacao;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import negocio.DeclaracaoRenda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCadastro extends JPanel {
        private DeclaracaoRenda declaracaoRenda = new DeclaracaoRenda();

        /**
        *
        */
        private static final long serialVersionUID = 7059975753563017243L;

        public PanelCadastro() {
                super(new GridLayout(1, 1));
                JTabbedPane tabbedPane = new JTabbedPane();
                tabbedPane.setTabPlacement(JTabbedPane.TOP);

                tabbedPane.addTab("Contribuinte", null, panelContribuinte(), "Cadastro de contribuintes");

                tabbedPane.addTab("Dependente", null, panelDependente(), "Cadastro de dependentes");

                tabbedPane.addTab("Bens", null, panelBem(), "Validar bens");

                tabbedPane.addTab("Nota Fiscal", null, panelNotaFiscal(), "Validar notas fiscais");

                tabbedPane.addTab("Contracheque", null, panelContracheque(), "Validar contracheque");

                tabbedPane.addTab("Pessoa Juridica", null, panelPessoaJuridica(), "Cadastro de pessoas juridicas");

                add(tabbedPane);
        }

        public JComponent panelContribuinte() {
                JPanel panel = new JPanel(new GridLayout(6, 1));

                // cpf
                JPanel cpfPanel = new JPanel(new FlowLayout());
                JTextField cpf = new JTextField();
                cpf.setPreferredSize(new Dimension(400, 20));
                JLabel cpfLabel = new JLabel();
                cpfLabel.setText("CPF: ");
                cpfLabel.setLabelFor(cpf);
                cpfPanel.add(cpfLabel);
                cpfPanel.add(cpf);

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

                // cadastro
                JButton cadastro = new JButton("Cadastro");
                cadastro.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                try {
                                        if (declaracaoRenda.getContribuinteCpf(cpf.getText()) != null) {
                                                JOptionPane.showMessageDialog(panel, "Cpf já registrado", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }
                                        declaracaoRenda.cadastrarContribuinte(cpf.getText(), nome.getText(),
                                                        Integer.parseInt(idade.getText()), endereco.getText(),
                                                        Integer.parseInt(conta.getText()));
                                        cpf.setText("");
                                        nome.setText("");
                                        idade.setText("");
                                        endereco.setText("");
                                        conta.setText("");
                                        PanelListagem.refreshContribuintes();
                                        

                                } catch (NumberFormatException e3) {
                                        JOptionPane.showMessageDialog(panel, "Valor invalido", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                        }
                });

                panel.add(cpfPanel);
                panel.add(nomePanel);
                panel.add(idadePanel);
                panel.add(enderecoPanel);
                panel.add(contaPanel);
                panel.add(cadastro);
                return panel;

        }

        public JComponent panelDependente() {
                JPanel panel = new JPanel(new GridLayout(6, 1));

                // cpf
                JPanel cpfPanel = new JPanel(new FlowLayout());
                JTextField cpf = new JTextField();
                cpf.setPreferredSize(new Dimension(400, 20));
                JLabel cpfLabel = new JLabel();
                cpfLabel.setText("CPF: ");
                cpfLabel.setLabelFor(cpf);
                cpfPanel.add(cpfLabel);
                cpfPanel.add(cpf);

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

                // Contribuinte
                JPanel contribuintesPanel = new JPanel(new FlowLayout());
                JTextField contribuintes1 = new JTextField();
                contribuintes1.setPreferredSize(new Dimension(400, 20));
                JLabel contribuintesLabel = new JLabel();
                contribuintesLabel.setText("Cpf do contribuinte: ");
                contribuintesLabel.setLabelFor(contribuintes1);
                contribuintesPanel.add(contribuintesLabel);
                contribuintesPanel.add(contribuintes1);

                // cadastro
                JButton cadastro = new JButton("Cadastro");
                cadastro.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                try {
                                        if (declaracaoRenda.getDependenteCpf(cpf.getText()) != null) {
                                                JOptionPane.showMessageDialog(panel, "Cpf já registrado", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }
                                        declaracaoRenda.cadastrarDependente(cpf.getText(), nome.getText(),
                                                        Integer.parseInt(idade.getText()), endereco.getText(),
                                                        declaracaoRenda.getContribuinteCpf(contribuintes1.getText())
                                                                        .getId());
                                        cpf.setText("");
                                        nome.setText("");
                                        idade.setText("");
                                        endereco.setText("");

                                } catch (NumberFormatException e3) {
                                        JOptionPane.showMessageDialog(panel, "Valor invalido", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                } catch (Exception e2) {
                                        JOptionPane.showMessageDialog(panel, "Cpf invalido", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                }
                        }
                });

                panel.add(cpfPanel);
                panel.add(nomePanel);
                panel.add(idadePanel);
                panel.add(enderecoPanel);
                panel.add(contribuintesPanel);
                panel.add(cadastro);
                return panel;

        }

        public JComponent panelBem() {
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

                // tipo
                JPanel tipoPanel = new JPanel(new FlowLayout());
                JTextField tipo = new JTextField();
                tipo.setPreferredSize(new Dimension(400, 20));
                JLabel tipoLabel = new JLabel();
                tipoLabel.setText("Tipo: ");
                tipoLabel.setLabelFor(tipo);
                tipoPanel.add(tipoLabel);
                tipoPanel.add(tipo);

                // valor
                JPanel valorPanel = new JPanel(new FlowLayout());
                JTextField valor = new JTextField();
                valor.setPreferredSize(new Dimension(400, 20));
                JLabel valorLabel = new JLabel();
                valorLabel.setText("Valor: ");
                valorLabel.setLabelFor(valor);
                valorPanel.add(valorLabel);
                valorPanel.add(valor);

                // Contribuinte
                JPanel contribuintesPanel = new JPanel(new FlowLayout());
                JTextField contribuintes2 = new JTextField();
                contribuintes2.setPreferredSize(new Dimension(400, 20));
                JLabel contribuintesLabel = new JLabel();
                contribuintesLabel.setText("Cpf do contribuinte: ");
                contribuintesLabel.setLabelFor(contribuintes2);
                contribuintesPanel.add(contribuintesLabel);
                contribuintesPanel.add(contribuintes2);

                // cadastro
                JButton cadastro = new JButton("Cadastro");
                cadastro.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                try {
                                        declaracaoRenda.cadastrarBem(nome.getText(), tipo.getText(),
                                                        Double.parseDouble(valor.getText()),
                                                        declaracaoRenda.getContribuinteCpf(contribuintes2.getText())
                                                                        .getId());
                                        nome.setText("");
                                        tipo.setText("");
                                        valor.setText("");

                                } catch (NumberFormatException e3) {
                                        JOptionPane.showMessageDialog(panel, "Valor invalido", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                } catch (Exception e2) {
                                        JOptionPane.showMessageDialog(panel, "Cpf invalido", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                }
                        }
                });

                panel.add(nomePanel);
                panel.add(tipoPanel);
                panel.add(valorPanel);
                panel.add(contribuintesPanel);
                panel.add(cadastro);
                return panel;

        }

        public JComponent panelNotaFiscal() {
                JPanel panel = new JPanel(new GridLayout(5, 1));

                // protocolo
                JPanel protocoloPanel = new JPanel(new FlowLayout());
                JTextField protocolo = new JTextField();
                protocolo.setPreferredSize(new Dimension(400, 20));
                JLabel protocoloLabel = new JLabel();
                protocoloLabel.setText("Numero de protocolo: ");
                protocoloLabel.setLabelFor(protocolo);
                protocoloPanel.add(protocoloLabel);
                protocoloPanel.add(protocolo);

                // valor
                JPanel valorPanel = new JPanel(new FlowLayout());
                JTextField valor = new JTextField();
                valor.setPreferredSize(new Dimension(400, 20));
                JLabel valorLabel = new JLabel();
                valorLabel.setText("Valor: ");
                valorLabel.setLabelFor(valor);
                valorPanel.add(valorLabel);
                valorPanel.add(valor);

                // Contribuinte
                JPanel contribuintesPanel = new JPanel(new FlowLayout());
                JTextField contribuintes3 = new JTextField();
                contribuintes3.setPreferredSize(new Dimension(400, 20));
                JLabel contribuintesLabel = new JLabel();
                contribuintesLabel.setText("Cpf do contribuinte: ");
                contribuintesLabel.setLabelFor(contribuintes3);
                contribuintesPanel.add(contribuintesLabel);
                contribuintesPanel.add(contribuintes3);

                // pessoaJuridica
                JPanel pessoaJuridicaPanel = new JPanel(new FlowLayout());
                JTextField pessoaJuridica1 = new JTextField();
                pessoaJuridica1.setPreferredSize(new Dimension(400, 20));
                JLabel pessoaJuridicaLabel = new JLabel();
                pessoaJuridicaLabel.setText("Cnpj da Pessoa Juridica: ");
                pessoaJuridicaLabel.setLabelFor(pessoaJuridica1);
                pessoaJuridicaPanel.add(pessoaJuridicaLabel);
                pessoaJuridicaPanel.add(pessoaJuridica1);

                // cadastro
                JButton cadastro = new JButton("Cadastro");
                cadastro.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                try {
                                        if (declaracaoRenda.getNotaProtocolo(Integer.parseInt(protocolo.getText())) != null) {
                                                JOptionPane.showMessageDialog(panel, "Protocolo ja registrado", "Error", JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }
                                        declaracaoRenda.cadastrarNotaFiscal(Integer.parseInt(protocolo.getText()),
                                                        declaracaoRenda.getPessoaCnpj(pessoaJuridica1.getText())
                                                                        .getCnpj(),
                                                        Double.parseDouble(valor.getText()),
                                                        declaracaoRenda.getPessoaCnpj(pessoaJuridica1.getText())
                                                                        .getId(),
                                                        declaracaoRenda.getContribuinteCpf(contribuintes3.getText())
                                                                        .getId());
                                        protocolo.setText("");
                                        valor.setText("");

                                } catch (NumberFormatException e3) {
                                        JOptionPane.showMessageDialog(panel, "Valor invalido", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                } catch (Exception e2) {
                                        JOptionPane.showMessageDialog(panel, "Cpf ou Cnpj invalido", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                }
                        }
                });
                panel.add(protocoloPanel);
                panel.add(valorPanel);
                panel.add(pessoaJuridicaPanel);
                panel.add(contribuintesPanel);
                panel.add(cadastro);
                return panel;

        }

        public JComponent panelContracheque() {
                JPanel panel = new JPanel(new GridLayout(5, 1));

                // protocolo
                JPanel protocoloPanel = new JPanel(new FlowLayout());
                JTextField protocolo = new JTextField();
                protocolo.setPreferredSize(new Dimension(400, 20));
                JLabel protocoloLabel = new JLabel();
                protocoloLabel.setText("Numero de protocolo: ");
                protocoloLabel.setLabelFor(protocolo);
                protocoloPanel.add(protocoloLabel);
                protocoloPanel.add(protocolo);

                // valor
                JPanel valorPanel = new JPanel(new FlowLayout());
                JTextField valor = new JTextField();
                valor.setPreferredSize(new Dimension(400, 20));
                JLabel valorLabel = new JLabel();
                valorLabel.setText("Valor: ");
                valorLabel.setLabelFor(valor);
                valorPanel.add(valorLabel);
                valorPanel.add(valor);

                // Contribuinte
                JPanel contribuintesPanel = new JPanel(new FlowLayout());
                JTextField contribuintes4 = new JTextField();
                contribuintes4.setPreferredSize(new Dimension(400, 20));
                JLabel contribuintesLabel = new JLabel();
                contribuintesLabel.setText("Contribuinte: ");
                contribuintesLabel.setLabelFor(contribuintes4);
                contribuintesPanel.add(contribuintesLabel);
                contribuintesPanel.add(contribuintes4);

                // pessoaJuridica
                JPanel pessoaJuridicaPanel = new JPanel(new FlowLayout());
                JTextField pessoaJuridica2 = new JTextField();
                pessoaJuridica2.setPreferredSize(new Dimension(400, 20));
                JLabel pessoaJuridicaLabel = new JLabel();
                pessoaJuridicaLabel.setText("Pessoa Juridica: ");
                pessoaJuridicaLabel.setLabelFor(pessoaJuridica2);
                pessoaJuridicaPanel.add(pessoaJuridicaLabel);
                pessoaJuridicaPanel.add(pessoaJuridica2);

                // cadastro
                JButton cadastro = new JButton("Cadastro");
                cadastro.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                try {
                                        if (declaracaoRenda.getChequeProtocolo(Integer.parseInt(protocolo.getText())) != null) {
                                                JOptionPane.showMessageDialog(panel, "Protocolo ja registrado", "Error", JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }
                                        declaracaoRenda.cadastrarContracheque(Integer.parseInt(protocolo.getText()),
                                                        declaracaoRenda.getPessoaCnpj(pessoaJuridica2.getText())
                                                                        .getCnpj(),
                                                        Double.parseDouble(valor.getText()),
                                                        declaracaoRenda.getPessoaCnpj(pessoaJuridica2.getText())
                                                                        .getId(),
                                                        declaracaoRenda.getContribuinteCpf(contribuintes4.getText())
                                                                        .getId());
                                        protocolo.setText("");
                                        valor.setText("");

                                } catch (NumberFormatException e3) {
                                        JOptionPane.showMessageDialog(panel, "Valor invalido", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                } catch (Exception e2) {
                                        JOptionPane.showMessageDialog(panel, "Cpf ou Cnpj invalido", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                }
                        }
                });

                panel.add(protocoloPanel);
                panel.add(valorPanel);
                panel.add(pessoaJuridicaPanel);
                panel.add(contribuintesPanel);
                panel.add(cadastro);
                return panel;

        }

        public JComponent panelPessoaJuridica() {
                JPanel panel = new JPanel(new GridLayout(5, 1));

                // cnpj
                JPanel cnpjPanel = new JPanel(new FlowLayout());
                JTextField cnpj = new JTextField();
                cnpj.setPreferredSize(new Dimension(400, 20));
                JLabel cnpjLabel = new JLabel();
                cnpjLabel.setText("CNPJ: ");
                cnpjLabel.setLabelFor(cnpj);
                cnpjPanel.add(cnpjLabel);
                cnpjPanel.add(cnpj);

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

                // cadastro
                JButton cadastro = new JButton("Cadastro");
                cadastro.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                try {
                                        if (declaracaoRenda.getPessoaCnpj(cnpj.getText()) != null) {
                                                JOptionPane.showMessageDialog(panel, "Cnpj ja registrado", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }
                                        declaracaoRenda.cadastrarPessoaJuridica(cnpj.getText(), nome.getText(),
                                                        endereco.getText(),
                                                        Integer.parseInt(numFuncionarios.getText()));
                                        nome.setText("");
                                        cnpj.setText("");
                                        endereco.setText("");
                                        numFuncionarios.setText("");
                                        PanelListagem.refreshPessoas();

                                } catch (NumberFormatException e3) {
                                        JOptionPane.showMessageDialog(panel, "Valor invalido", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                        }
                });

                panel.add(cnpjPanel);
                panel.add(nomePanel);
                panel.add(enderecoPanel);
                panel.add(numFuncionariosPanel);
                panel.add(cadastro);
                return panel;

        }

}
