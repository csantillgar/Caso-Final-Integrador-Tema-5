package genomic_analysis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class GeneticCombinationsPanel extends JPanel {
    private JButton calculateButton;
    private JLabel resultLabel;
    private JTextField dnaSequenceField; // Campo de texto para la secuencia de ADN

    public GeneticCombinationsPanel() {
        // Configuración del layout
        setLayout(new BorderLayout());

        // Crear y configurar los componentes
        JLabel titleLabel = new JLabel("Cálculo de Combinaciones Genéticas");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Campo de texto para la secuencia de ADN
        dnaSequenceField = new JTextField(20);


        calculateButton = new JButton("Calcular Combinaciones Genéticas");

        resultLabel = new JLabel();

        // Agregar componentes al panel
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Secuencia de ADN: "));
        inputPanel.add(dnaSequenceField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);

        add(titleLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.SOUTH);



        // Agregar listener al botón
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGeneticCombinations();
            }
        });
        // Agregar KeyListener al campo de texto para detectar la pulsación de Enter
        dnaSequenceField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calculateGeneticCombinations();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    private void calculateGeneticCombinations() {
        // Implementaremos la lógica para calcular las combinaciones genéticas aqui
        // Aquí recuperaremos la secuencia de ADN ingresada por el usuario
        String dnaSequence = dnaSequenceField.getText();

        // Llamamos al método de la clase GeneticCombinations para calcular las combinaciones
        List<String> combinations = GeneticCombinations.calculateCombinations(dnaSequence);

        // Mostramos las combinaciones en el JLabel resultLabel
        StringBuilder resultText = new StringBuilder("<html>Combinaciones genéticas:<br>");
        for (String combination : combinations) {
            resultText.append(combination).append("<br>");
        }
        resultText.append("</html>");
        resultLabel.setText(resultText.toString());
    }
}