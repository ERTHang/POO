package apresentacao;

import java.awt.*;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import dados.Contribuinte;
import dados.PessoaJuridica;
import negocio.DeclaracaoRenda;

public class PanelListagem extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 6474275644506896318L;
    static DefaultListModel<String> listModel = new DefaultListModel<String>();
    static DefaultListModel<String> listModelPessoas = new DefaultListModel<String>();
    static DeclaracaoRenda declaracaoRenda = new DeclaracaoRenda();

    public PanelListagem() {
        super(new GridLayout(1, 1));
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.TOP);
        
        tabbedPane.addTab("Contribuintes", PanelContribuintes());
        
        tabbedPane.addTab("Pessoas Jurídicas", PanelPessoas());
        
        add(tabbedPane);
    }

    public JComponent PanelContribuintes() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        refreshContribuintes();
        JList<String> lista = new JList<String>(listModel);
        lista.setPreferredSize(new Dimension(400, 400));

        c.gridx = 1;
        c.gridy = 1;
        c.ipadx = 400;
        c.ipady = 400;
        c.fill = 2;
        panel.add(lista);
        return panel;
    }

    public static void refreshContribuintes() {
        listModel.clear();
        for (Contribuinte contribuinte : declaracaoRenda.getContribuintes()) {
            listModel.addElement(contribuinte.getNome() + ",     CPF = " + contribuinte.getCpf());
        }
    }

    public JComponent PanelPessoas() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        refreshPessoas();
        JList<String> lista = new JList<String>(listModelPessoas);
        lista.setPreferredSize(new Dimension(400, 400));

        c.gridx = 1;
        c.gridy = 1;
        c.fill = 2;
        panel.add(lista);
        return panel;
    }

    public static void refreshPessoas() {
        listModelPessoas.clear();
        for (PessoaJuridica pessoa : declaracaoRenda.getPessoas()) {
            listModelPessoas.addElement(pessoa.getNomePJ() + ",     CNPJ = " + pessoa.getCnpj());
        }
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }

    public DefaultListModel<String> getListModelPessoas() {
        return listModelPessoas;
    }
}