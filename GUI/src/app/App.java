package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class App extends JFrame {
    private static final long serialVersionUID = -8412987007488059947L;
    JTextField entrada;
    JToggleButton leguas, milhas, milhasMaritimas, KM, metro, jardas, pes, polegadas, milimetros;
    JLabel saida, textoEntrada;
    JPanel painel, painelEntrada, painelSaida, painelDados;
    ButtonGroup grupo;

    public App() {

        grupo = new ButtonGroup();

        painelEntrada = new JPanel();
        painelSaida = new JPanel();
        painel = new JPanel(new GridLayout(3, 1));

        painelDados = new JPanel(new GridLayout(3, 3));

        //textoEntrada
        textoEntrada = new JLabel();
        textoEntrada.setText("Valor: ");
        textoEntrada.setFont(new Font("Verdana", 1, 50));
        painelEntrada.add(textoEntrada, BorderLayout.EAST);

        // Entrada
        entrada = new JTextField();
        entrada.setPreferredSize(new Dimension(600, 100));
        entrada.setFont(new Font("Arial", Font.BOLD, 50));
        painelEntrada.add(entrada);

        // Leguas Button
        leguas = new JToggleButton("Leguas");
        leguas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String resultado = String.valueOf(Float.parseFloat(entrada.getText()) / 6600);
                saida.setText(resultado);

            }
        });
        painelDados.add(leguas);
        grupo.add(leguas);

        // Milhas Button
        milhas = new JToggleButton("Milhas");
        milhas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String resultado = String.valueOf(Float.parseFloat(entrada.getText()) / 1609.3);
                saida.setText(resultado);

            }
        });
        painelDados.add(milhas);
        grupo.add(milhas);

        // MilhasMaritimas Button
        milhasMaritimas = new JToggleButton("Milhas Maritimas");
        milhasMaritimas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String resultado = String.valueOf(Float.parseFloat(entrada.getText()) / 1852);
                saida.setText(resultado);
            }
        });
        painelDados.add(milhasMaritimas);
        grupo.add(milhasMaritimas);

        // KM Button
        KM = new JToggleButton("KM");
        KM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String resultado = String.valueOf(Float.parseFloat(entrada.getText()) / 1000);
                saida.setText(resultado);
            }
        });
        painelDados.add(KM);
        grupo.add(KM);

        // metro Button
        metro = new JToggleButton("Metro");
        metro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String resultado = String.valueOf(Float.parseFloat(entrada.getText()));
                saida.setText(resultado);
            }
        });
        painelDados.add(metro);
        grupo.add(metro);

        // jardas Button
        jardas = new JToggleButton("Jardas");
        jardas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String resultado = String.valueOf(Float.parseFloat(entrada.getText()) / 0.914399);
                saida.setText(resultado);
            }
        });
        painelDados.add(jardas);
        grupo.add(jardas);

        // pes Button
        pes = new JToggleButton("Pes");
        pes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String resultado = String.valueOf(Float.parseFloat(entrada.getText()) / 0.304799);
                saida.setText(resultado);
            }
        });
        painelDados.add(pes);
        grupo.add(pes);

        // polegadas Button
        polegadas = new JToggleButton("Polegadas");
        polegadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String resultado = String.valueOf(Float.parseFloat(entrada.getText()) / 0.0254);
                saida.setText(resultado);
            }
        });
        painelDados.add(polegadas);
        grupo.add(polegadas);

        // milimetros Button
        milimetros = new JToggleButton("Milimetros");
        milimetros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String resultado = String.valueOf(Float.parseFloat(entrada.getText()) / 0.001);
                saida.setText(resultado);
            }
        });
        painelDados.add(milimetros);
        grupo.add(milimetros);

        // Saida
        saida = new JLabel();
        saida.setFont(new Font("Arial", 1, 50));
        saida.setAlignmentY(CENTER_ALIGNMENT);
        painelSaida.add(saida);

        painel.add(painelEntrada, "North");
        painel.add(painelDados);
        painel.add(painelSaida, "South");

        setSize(800, 600);
        setDefaultCloseOperation(3);
        setVisible(true);
        setContentPane(painel);
    }
}
