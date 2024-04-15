package genomic_analysis;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }

    private void countGenes() {
        // Aquí implementaremos la lógica para contar genes
        String dnaSequence = dnaTextField.getText();
        // Lógica para contar genes en la cadena de ADN
        // Por ahora, solo mostraremos un mensaje
        resultLabel.setText("Número de genes encontrados: XX"); // XX representa el número de genes encontrado
    }
}
