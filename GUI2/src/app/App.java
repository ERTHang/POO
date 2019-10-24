package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class App extends JFrame {
    private static final long serialVersionUID = 5430513214412853815L;
    JPanel painel, painelBotoes, painelSaida, painelUm, painelDois;
    JTextField valorUm, valorDois;
    JToggleButton botaoSoma, botaoMenos, botaoDiv, botaoMul;
    JButton botaoIgual;
    JLabel textUm, textDois, saida, textSaida;
    ButtonGroup grupo;

    public App() {
        painel = new JPanel(new GridLayout(5, 1));
        painelDois = new JPanel();
        painelUm = new JPanel();
        painelBotoes = new JPanel(new GridLayout(2, 2));
        painelSaida = new JPanel(new GridLayout(2, 1));
        saida = new JLabel();
        grupo = new ButtonGroup();

        // texto valor um
        textUm = new JLabel();
        textUm.setText("Valor: ");
        textUm.setFont(new Font("Arial", 1, 50));
        painelUm.add(textUm, "North");

        valorUm = new JTextField();
        valorUm.setPreferredSize(new Dimension(600, 80));
        valorUm.setFont(new Font("Arial", 1, 50));
        painelUm.add(valorUm);

        // texto valor dois
        textDois = new JLabel();
        textDois.setText("Valor: ");
        textDois.setFont(new Font("Arial", 1, 50));
        painelDois.add(textDois);

        valorDois = new JTextField();
        valorDois.setPreferredSize(new Dimension(600, 80));
        valorDois.setFont(new Font("Arial", 1, 50));
        painelDois.add(valorDois);

        // botoes
        // +
        botaoSoma = new JToggleButton("+");
        botaoSoma.setPreferredSize(new Dimension(200, 100));
        botaoSoma.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        painelBotoes.add(botaoSoma);
        grupo.add(botaoSoma);

        // -
        botaoMenos = new JToggleButton("-");
        botaoMenos.setPreferredSize(new Dimension(200, 100));
        botaoMenos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        grupo.add(botaoMenos);
        painelBotoes.add(botaoMenos);

        // /
        botaoDiv = new JToggleButton("/");
        botaoDiv.setPreferredSize(new Dimension(200, 100));
        botaoDiv.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        grupo.add(botaoDiv);
        painelBotoes.add(botaoDiv);

        // x
        botaoMul = new JToggleButton("x");
        botaoMul.setPreferredSize(new Dimension(200, 100));
        botaoMul.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        grupo.add(botaoMul);
        painelBotoes.add(botaoMul);

        // = 
        botaoIgual = new JButton("=");
        botaoIgual.setPreferredSize(new Dimension(200, 100));
        botaoIgual.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(botaoSoma.isSelected())
                        try{
                            float v1 = Float.parseFloat(valorUm.getText()); 
                            float v2 = Float.parseFloat(valorDois.getText());
                            String res = Float.toString(v1 + v2);
                            saida.setText(res);
                        }catch(Exception e2){
                            JOptionPane.showMessageDialog(null, "Entrada Inválida", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                else if(botaoMenos.isSelected())
                        try{
                            float v1 = Float.parseFloat(valorUm.getText()); 
                            float v2 = Float.parseFloat(valorDois.getText());
                            String res = Float.toString(v1 - v2);
                            saida.setText(res);
                        }catch(Exception e2){
                            JOptionPane.showMessageDialog(null, "Entrada Inválida", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                else if(botaoDiv.isSelected())
                        try{
                            float v1 = Float.parseFloat(valorUm.getText()); 
                            float v2 = Float.parseFloat(valorDois.getText());
                            if(v2 == 0){
                                JOptionPane.showMessageDialog(null, "Entrada Inválida", "ERRO", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            String res = Float.toString(v1 / v2);
                            saida.setText(res);
                        }catch(Exception e2){
                            JOptionPane.showMessageDialog(null, "Entrada Inválida", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                else if(botaoMul.isSelected())
                        try{
                            float v1 = Float.parseFloat(valorUm.getText()); 
                            float v2 = Float.parseFloat(valorDois.getText());
                            String res = Float.toString(v1 * v2);
                            saida.setText(res);
                        }catch(Exception e2){
                            JOptionPane.showMessageDialog(null, "Entrada Inválida", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
            }

        });
        
        
        //resultado
        textSaida = new JLabel();
        textSaida.setText("Resultado: ");
        textSaida.setFont(new Font("Arial", 1, 50));
        painelSaida.add(textSaida);
        
        saida.setFont(new Font("Arial", 1, 50));
        saida.setPreferredSize(new Dimension(600, 80));
        painelSaida.add(saida);
        
        
        painel.add(painelUm);
        painel.add(painelDois);
        painel.add(painelBotoes);
        painel.add(botaoIgual);
        painel.add(painelSaida);

        setSize(800, 600);
        setDefaultCloseOperation(3);
        setVisible(true);
        setContentPane(painel);
    }
}