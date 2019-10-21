package app;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App extends JFrame {
    JTextField entrada;
    JButton leguas, milhas;
    JLabel saida;
    JPanel painel;

    public App(){
        Container c = getContentPane();
        entrada = new JTextField("Valor em metros");
        entrada.setFont(new Font("Arial", Font.BOLD, 72));
        leguas = new JButton("Leguas");
        milhas = new JButton("Milhas");
        saida = new JLabel();
        painel = new JPanel(new GridLayout(0, 1));
        leguas.addActionListener(new ActionListener(){
            String resultado = String.valueOf(Float.parseFloat(entrada.getText()) )
            saida.
        });
        painel.add(entrada);
        painel.add(leguas);
        painel.add(milhas);
        painel.add(saida);
        setSize(800, 600);
        setDefaultCloseOperation(3);
        setVisible(true);
        setContentPane(painel);
    }
}
