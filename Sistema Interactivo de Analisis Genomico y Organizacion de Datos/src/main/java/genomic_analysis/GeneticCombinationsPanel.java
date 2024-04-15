package genomic_analysis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneticCombinationsPanel extends JPanel {
    private JButton calculateButton;
    private JLabel resultLabel;

    public GeneticCombinationsPanel() {
        // Configuración del layout
        setLayout(new BorderLayout());

        // Crear y configurar los componentes
        JLabel titleLabel = new JLabel("Cálculo de Combinaciones Genéticas");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        calculateButton = new JButton("Calcular Combinaciones Genéticas");

        resultLabel = new JLabel();

        // Agregar componentes al panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);

        add(titleLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        // Agregar listener al botón
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGeneticCombinations();
            }
        });
    }

    private void calculateGeneticCombinations() {
        // Lógica para calcular las combinaciones genéticas aquí
        // Por ahora, solo mostraremos un mensaje
        resultLabel.setText("Combinaciones genéticas calculadas.");
    }
}
