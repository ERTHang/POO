package apresentacao;


import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class App extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public App() {
        super(new GridLayout(1, 1));
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
        
        tabbedPane.addTab("Cadastrar", new PanelCadastro());
        
        tabbedPane.addTab("Consultar", new PanelConsulta());
        
        tabbedPane.addTab("Alterar", new PanelAtualizacao());
        
        tabbedPane.addTab("Remover", new PanelRemocao());

        tabbedPane.addTab("Listagens", new PanelListagem());
        
        add(tabbedPane);
    }
    
    private static void start() {
        JFrame frame = new JFrame("Declaração Imposto de Renda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(new App(), BorderLayout.CENTER);

        frame.setSize(800, 600);

        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        start();
    }
    
}