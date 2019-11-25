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

import negocio.DeclaracaoRenda;

public class PanelRemocao extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = -864309141947150531L;
    DeclaracaoRenda declaracaoRenda = new DeclaracaoRenda();
    GridBagConstraints c = new GridBagConstraints();


    public PanelRemocao() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.TOP);

        tabbedPane.addTab("Dependente", null, panelDependente(), "Remover dependente");

        tabbedPane.addTab("Bem", null, panelBem(), "Remover bem");

        tabbedPane.addTab("Nota Fiscal", null, panelNotaFiscal(), "Remover nota fiscal");

        tabbedPane.addTab("Contracheque", null, panelContracheque(), "Remover contracheque");

        tabbedPane.addTab("Pessoa Juridica", null, panelPessoaJuridica(), "Remover pessoa jurídica");

        add(tabbedPane);
    }

    public JComponent panelDependente() {
        JPanel panel = new JPanel(new GridBagLayout());

        JPanel cpfPanel = new JPanel(new FlowLayout());
        JTextField cpf = new JTextField();
        cpf.setPreferredSize(new Dimension(400, 20));
        JLabel cpfLabel = new JLabel();
        cpfLabel.setText("CPF: ");
        cpfLabel.setLabelFor(cpf);
        JButton remove = new JButton("remover");
        remove.setPreferredSize(new Dimension(100,50));
        remove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int res = declaracaoRenda.removeDependente(cpf.getText());
                if (res == 1) {
                    JOptionPane.showMessageDialog(panel, "Removido com sucesso", "Sucesso", JOptionPane.DEFAULT_OPTION);
                }
                if (res == 0) {
                    JOptionPane.showMessageDialog(panel, "Cpf não encontrado", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });
        cpfPanel.add(cpfLabel);
        cpfPanel.add(cpf);
        
        c.gridx = 0;
        c.gridy = 0;
        panel.add(cpfPanel, c);
        c.gridy = 1;
        panel.add(remove, c);
        return panel;
    }

    private JComponent panelBem() {
        JPanel panel = new JPanel(new GridBagLayout());

        // Contribuinte
        JPanel contribuintesPanel = new JPanel(new FlowLayout());
        JTextField contribuintes = new JTextField();
        contribuintes.setPreferredSize(new Dimension(400, 20));
        JLabel contribuintesLabel = new JLabel();
        contribuintesLabel.setText("CPF do contribuinte: ");
        contribuintesLabel.setLabelFor(contribuintes);
        contribuintesPanel.add(contribuintesLabel);
        contribuintesPanel.add(contribuintes);

        // nome
        JPanel nomePanel = new JPanel(new FlowLayout());
        JTextField nome = new JTextField();
        nome.setPreferredSize(new Dimension(400, 20));
        JLabel nomeLabel = new JLabel();
        nomeLabel.setText("Nome: ");
        nomeLabel.setLabelFor(nome);
        nomePanel.add(nomeLabel);
        nomePanel.add(nome);

        JButton remove = new JButton("remover");
        remove.setPreferredSize(new Dimension(100,50));
        remove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int res = declaracaoRenda.removeBem(declaracaoRenda.getContribuinteCpf(contribuintes.getText()).getId(), nome.getText());
                    if (res == 1) {
                        JOptionPane.showMessageDialog(panel, "Removido com sucesso", "Sucesso", JOptionPane.DEFAULT_OPTION);
                    }
                    if (res == 0) {
                        JOptionPane.showMessageDialog(panel, "Bem não encontrado", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Contribuinte não encontrado", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        panel.add(contribuintesPanel, c);
        c.gridy = 1;
        c.weightx = 0.5;
        panel.add(nomePanel, c);
        c.gridy = 2;
        c.weightx = 0.5;
        panel.add(remove, c);

        return panel;
    }

    private JComponent panelNotaFiscal() {
        JPanel panel = new JPanel(new GridBagLayout());

        // protocolo
        JPanel protocoloPanel = new JPanel(new FlowLayout());
        JTextField protocolo = new JTextField();
        protocolo.setPreferredSize(new Dimension(400, 20));
        JLabel protocoloLabel = new JLabel();
        protocoloLabel.setText("Numero de protocolo: ");
        protocoloLabel.setLabelFor(protocolo);
        protocoloPanel.add(protocoloLabel);
        protocoloPanel.add(protocolo);

        JButton remove = new JButton("remover");
        remove.setPreferredSize(new Dimension(100,50));
        remove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int res = declaracaoRenda.removeNotaFiscal(Integer.parseInt(protocolo.getText()));
                if (res == 1) {
                    JOptionPane.showMessageDialog(panel, "Removido com sucesso", "Sucesso", JOptionPane.DEFAULT_OPTION);
                }
                if (res == 0) {
                    JOptionPane.showMessageDialog(panel, "Nota fiscal não encontrada", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });

        c.gridx = 0;
        c.gridy = 0;
        panel.add(protocoloPanel, c);
        c.gridy = 1;
        panel.add(remove, c);

        return panel;
    }

    private JComponent panelContracheque() {
        JPanel panel = new JPanel(new GridBagLayout());

        // protocolo
        JPanel protocoloPanel = new JPanel(new FlowLayout());
        JTextField protocolo = new JTextField();
        protocolo.setPreferredSize(new Dimension(400, 20));
        JLabel protocoloLabel = new JLabel();
        protocoloLabel.setText("Numero de protocolo: ");
        protocoloLabel.setLabelFor(protocolo);
        protocoloPanel.add(protocoloLabel);
        protocoloPanel.add(protocolo);

        JButton remove = new JButton("remover");
        remove.setPreferredSize(new Dimension(100,50));
        remove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int res = declaracaoRenda.removeContracheque(Integer.parseInt(protocolo.getText()));
                if (res == 1) {
                    JOptionPane.showMessageDialog(panel, "Removido com sucesso", "Sucesso", JOptionPane.DEFAULT_OPTION);
                }
                if (res == 0) {
                    JOptionPane.showMessageDialog(panel, "Contracheque não encontrado", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });

        c.gridx = 0;
        c.gridy = 0;
        panel.add(protocoloPanel, c);
        c.gridy = 1;
        panel.add(remove, c);

        return panel;
    }

    private JComponent panelPessoaJuridica() {
        JPanel panel = new JPanel(new GridBagLayout());

        JPanel cnpjPanel = new JPanel(new FlowLayout());
        JTextField cnpj = new JTextField();
        cnpj.setPreferredSize(new Dimension(400, 20));
        JLabel cnpjLabel = new JLabel();
        cnpjLabel.setText("CNPJ: ");
        cnpjLabel.setLabelFor(cnpj);
        cnpjPanel.add(cnpjLabel);
        cnpjPanel.add(cnpj);


        JButton remove = new JButton("remover");
        remove.setPreferredSize(new Dimension(100,50));
        remove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int res = declaracaoRenda.removePessoaJuridica(cnpj.getText());
                if (res == 1) {
                    JOptionPane.showMessageDialog(panel, "Removido com sucesso", "Sucesso", JOptionPane.DEFAULT_OPTION);
                    PanelListagem.refreshPessoas();
                }
                if (res == 0) {
                    JOptionPane.showMessageDialog(panel, "Cnpj não encontrado", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });
        
        c.gridx = 0;
        c.gridy = 0;
        panel.add(cnpjPanel, c);
        c.gridy = 1;
        panel.add(remove, c);
        return panel;
    }

    
}