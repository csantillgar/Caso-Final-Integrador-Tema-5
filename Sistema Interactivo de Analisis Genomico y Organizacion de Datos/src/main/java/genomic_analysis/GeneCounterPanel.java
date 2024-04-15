package genomic_analysis;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GeneCounterPanel extends JPanel {
    private JTextField dnaTextField;
    private JLabel resultLabel;

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

        resultLabel = new JLabel();

        // Agregar componentes al panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1));
        inputPanel.add(dnaLabel);
        inputPanel.add(dnaTextField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(countButton);

        add(titleLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.SOUTH);

        // Agregar listener al botón
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countGenes();
            }
        });

        // Agregar listener de teclado al campo de texto
        dnaTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // No se necesita implementar en este caso
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Verificar si se presionó "Enter"
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    countGenes();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No se necesita implementar en este caso
            }
        });
    }

    private void countGenes() {
        String dnaSequence = dnaTextField.getText();
        int geneCount = 0;

        int startIndex = 0;
        while (startIndex != -1 && startIndex < dnaSequence.length()) {
            int startCodonIndex = dnaSequence.indexOf("ATG", startIndex);
            if (startCodonIndex == -1) {
                break; // No se encontró ningún codón de inicio
            }

            int endCodonIndex = findEndCodon(dnaSequence, startCodonIndex);
            if (endCodonIndex == -1) {
                break; // No se encontró ningún codón de finalización
            }

            geneCount++;
            startIndex = endCodonIndex + 3; // Avanzar la búsqueda más allá del codón de finalización
        }

        resultLabel.setText("Número de genes encontrados: " + geneCount);
    }

    private int findEndCodon(String dnaSequence, int startIndex) {
        int endCodonIndex1 = dnaSequence.indexOf("TAG", startIndex + 3);
        int endCodonIndex2 = dnaSequence.indexOf("TAA", startIndex + 3);
        int endCodonIndex3 = dnaSequence.indexOf("TGA", startIndex + 3);

        int minIndex = Math.min(endCodonIndex1, Math.min(endCodonIndex2, endCodonIndex3));
        return minIndex != -1 ? minIndex : dnaSequence.length();
    }
}
