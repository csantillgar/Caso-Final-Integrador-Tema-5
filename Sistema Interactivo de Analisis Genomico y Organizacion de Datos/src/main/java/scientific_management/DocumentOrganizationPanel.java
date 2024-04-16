package scientific_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class DocumentOrganizationPanel extends JPanel {
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;

    public DocumentOrganizationPanel() {
        setLayout(new BorderLayout());

        // Crear el área de texto para la entrada
        inputTextArea = new JTextArea(10, 20);
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);

        // Crear el área de texto para la salida
        outputTextArea = new JTextArea(10, 20);
        outputTextArea.setEditable(false); // Hacer el área de texto de salida no editable
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);

        // Crear el botón de ordenar
        JButton sortButton = new JButton("Ordenar");

        // Agregar componentes al panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(sortButton);

        add(inputScrollPane, BorderLayout.WEST);
        add(outputScrollPane, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        // Agregar listener al botón de ordenar
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortLines();
            }
        });
    }

    private void sortLines() {
        // Obtener el texto del área de entrada
        String inputText = inputTextArea.getText();

        // Dividir el texto en líneas
        String[] lines = inputText.split("\n");

        // Ordenar las líneas alfabéticamente
        Arrays.sort(lines);

        // Construir el texto ordenado
        StringBuilder sortedText = new StringBuilder();
        for (String line : lines) {
            sortedText.append(line).append("\n");
        }

        // Mostrar el texto ordenado en el área de salida
        outputTextArea.setText(sortedText.toString());
    }
}

