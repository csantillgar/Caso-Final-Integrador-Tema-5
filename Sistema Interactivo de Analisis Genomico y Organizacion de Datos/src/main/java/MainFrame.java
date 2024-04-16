import javax.swing.*;
import genomic_analysis.GeneCounterPanel;
import genomic_analysis.GeneticCombinationsPanel;
import scientific_management.DocumentOrganizationPanel;

import numerical_analysis.NumericalTools;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Sistema Interactivo de Análisis Genómico");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear botones
        JButton geneCounterButton = new JButton("Contador de Genes");
        JButton geneticCombinationsButton = new JButton("Combinaciones Genéticas");
        JButton numericalToolsButton = new JButton("Herramientas de Análisis Numérico");
        JButton documentOrganizationButton = new JButton("Organización de Documentos");

        // Agregar botones al panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1)); // Cambio aquí a 4 filas
        panel.add(geneCounterButton);
        panel.add(geneticCombinationsButton);
        panel.add(numericalToolsButton);
        panel.add(documentOrganizationButton); // Agrego el botón aquí
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

        // Listener para el botón de Herramientas de Análisis Numérico
        numericalToolsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNumericalToolsPanel();
            }
        });

        // Listener para el botón de Organización de Documentos
        documentOrganizationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDocumentOrganizationPanel();
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

    private void openNumericalToolsPanel() {
        // Crear y mostrar la ventana de Herramientas de Análisis Numérico
        JFrame numericalToolsFrame = new JFrame("Herramientas de Análisis Numérico");
        numericalToolsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        numericalToolsFrame.setSize(400, 200);
        numericalToolsFrame.setLocationRelativeTo(this); // Centrar respecto a la ventana principal

        // Crear botones para las herramientas numéricas
        JButton sumAndListButton = new JButton("Sumatoria y Listado de Números");
        JButton powersAndMaxButton = new JButton("Cálculo de Potencias y Máximos");

        // Crear panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.add(sumAndListButton);
        buttonPanel.add(powersAndMaxButton);

        // Agregar panel de botones a la ventana
        numericalToolsFrame.add(buttonPanel);

        // Listener para el botón de Sumatoria y Listado de Números
        sumAndListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes llamar a la función que implementa la funcionalidad de Sumatoria y Listado de Números
                // Por ejemplo:
                NumericalTools.calculateSumAndList();
            }
        });

        // Listener para el botón de Cálculo de Potencias y Máximos
        powersAndMaxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes llamar a la función que implementa la funcionalidad de Cálculo de Potencias y Máximos
                // Por ejemplo:
                NumericalTools.calculatePowersAndMax();
            }
        });

        // Mostrar la ventana de Herramientas de Análisis Numérico
        numericalToolsFrame.setVisible(true);
    }

    private void openDocumentOrganizationPanel() {
        // Crear y mostrar la ventana de Organización de Documentos
        JFrame documentOrganizationFrame = new JFrame("Organización de Documentos");
        documentOrganizationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        documentOrganizationFrame.setSize(400, 200);
        documentOrganizationFrame.setLocationRelativeTo(this); // Centrar respecto a la ventana principal

        // Aquí puedes agregar el código para la funcionalidad de Organización de Documentos
        DocumentOrganizationPanel documentOrganizationPanel = new DocumentOrganizationPanel();
        // Agregar el panel al JFrame
        documentOrganizationFrame.add(documentOrganizationPanel);
        // Mostrar la ventana de Organización de Documentos
        documentOrganizationFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}

