package scientific_management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocumentOrganization extends JFrame {
    private JTextArea originalTextArea;
    private JTextArea sortedTextArea;

    public DocumentOrganization() {
        setTitle("Organización de Documentos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        originalTextArea = new JTextArea();
        sortedTextArea = new JTextArea();
        sortedTextArea.setEditable(false);

        JButton organizeButton = new JButton("Organizar");

        organizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                organizeLines();
            }
        });

        panel.add(originalTextArea);
        panel.add(sortedTextArea);
        add(panel, BorderLayout.CENTER);
        add(organizeButton, BorderLayout.SOUTH);
    }

    private void organizeLines() {
        String originalText = originalTextArea.getText();
        String[] lines = originalText.split("\n");

        List<String> lineList = new ArrayList<>();
        for (String line : lines) {
            lineList.add(line);
        }

        Collections.sort(lineList);

        StringBuilder sortedText = new StringBuilder();
        for (String line : lineList) {
            sortedText.append(line).append("\n");
        }

        sortedTextArea.setText(sortedText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DocumentOrganization frame = new DocumentOrganization();
            frame.setVisible(true);
        });
    }
}
