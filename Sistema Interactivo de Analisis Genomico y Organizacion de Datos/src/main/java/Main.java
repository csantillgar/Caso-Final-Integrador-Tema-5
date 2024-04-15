import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Contador de Genes");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

            GeneCounterPanel panel = new GeneCounterPanel();
            frame.add(panel);

            frame.setVisible(true);
        });
    }
}
