import javax.swing.*;
import genomic_analysis.GeneCounterPanel;
import genomic_analysis.GeneticCombinationsPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Sistema Interactivo de Análisis Genómico");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear botones
        JButton geneCounterButton = new JButton("Contador de Genes");
        JButton geneticCombinationsButton = new JButton("Combinaciones Genéticas");

        // Agregar botones al panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(geneCounterButton);
        panel.add(geneticCombinationsButton);
        add(panel);

        // Listener para el botón de Contador de Genes
        geneCounterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGeneCounterPanel();
            }
        });

        // Listener para el botón de Combinaciones Genéticas
        geneticCombinationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGeneticCombinationsPanel();
            }
        });
    }

    private void openGeneCounterPanel() {
        // Crear y mostrar la ventana del Contador de Genes
        JFrame geneCounterFrame = new JFrame("Contador de Genes");
        geneCounterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        geneCounterFrame.setSize(400, 300);
        geneCounterFrame.setLocationRelativeTo(this); // Centrar respecto a la ventana principal

        GeneCounterPanel geneCounterPanel = new GeneCounterPanel();
        geneCounterFrame.add(geneCounterPanel);

        geneCounterFrame.setVisible(true);
    }

    private void openGeneticCombinationsPanel() {
        // Crear y mostrar la ventana de Combinaciones Genéticas
        JFrame geneticCombinationsFrame = new JFrame("Combinaciones Genéticas");
        geneticCombinationsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        geneticCombinationsFrame.setSize(400, 300);
        geneticCombinationsFrame.setLocationRelativeTo(this); // Centrar respecto a la ventana principal

        GeneticCombinationsPanel geneticCombinationsPanel = new GeneticCombinationsPanel();
        geneticCombinationsFrame.add(geneticCombinationsPanel);

        geneticCombinationsFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
