package genomic_analysis;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneCounterPanel extends JPanel {
    private JTextField dnaTextField;
    private JLabel resultLabel;
    private JButton switchButton; // Botón para cambiar entre los módulos

    public GeneCounterPanel() {
        // Configuración del layout
        setLayout(new BorderLayout());

        // Crear y configurar los componentes
        JLabel titleLabel = new JLabel("Contador de Genes");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel dnaLabel = new JLabel("Cadena de ADN:");
        dnaTextField = new JTextField(20);

        JButton countButton = new JButton("Contar Genes");
        switchButton = new JButton("Cambiar a Combinaciones Genéticas"); // Botón de alternancia

        resultLabel = new JLabel();

        // Agregar componentes al panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1));
        inputPanel.add(dnaLabel);
        inputPanel.add(dnaTextField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(countButton);
        buttonPanel.add(switchButton); // Agregar el botón de alternancia

        add(titleLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.SOUTH);

        // Agregar listener al botón de contar genes
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countGenes();
            }
        });

        // Agregar listener al botón de alternancia
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToGeneticCombinations(); // Cambiar a Combinaciones Genéticas
            }
        });
    }

    private void countGenes() {
        // Implementación del contador de genes
        // ...
        resultLabel.setText("Número de genes encontrados: X"); // X representa el número de genes encontrados
    }

    private void switchToGeneticCombinations() {
        // Implementación para cambiar a la vista de Combinaciones Genéticas
        // ...
        // Por ejemplo, podrías abrir una nueva ventana con la vista de Combinaciones Genéticas
        JFrame frame = new JFrame("Combinaciones Genéticas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
