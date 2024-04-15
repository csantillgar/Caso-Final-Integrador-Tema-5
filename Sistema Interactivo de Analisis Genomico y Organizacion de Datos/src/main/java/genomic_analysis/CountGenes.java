package genomic_analysis;
public class CountGenes {
    public static int countGenes(String dnaSequence) {
        CountGenes counter = new CountGenes(); // Crear una instancia de CountGenes
        int geneCount = 0;

        int startIndex = 0;
        while (startIndex != -1 && startIndex < dnaSequence.length()) {
            int startCodonIndex = dnaSequence.indexOf("ATG", startIndex);
            if (startCodonIndex == -1) {
                break; // No se encontró ningún codón de inicio
            }

            int endCodonIndex = counter.findEndCodon(dnaSequence, startCodonIndex);// Llamar al método en la instancia
            if (endCodonIndex == -1) {
                break; // No se encontró ningún codón de finalización
            }

            geneCount++;
            startIndex = endCodonIndex + 3; // Avanzar la búsqueda más allá del codón de finalización
        }

        return geneCount;
    }

    private int findEndCodon(String dnaSequence, int startIndex) {
        int endCodonIndex1 = dnaSequence.indexOf("TAG", startIndex + 3);
        int endCodonIndex2 = dnaSequence.indexOf("TAA", startIndex + 3);
        int endCodonIndex3 = dnaSequence.indexOf("TGA", startIndex + 3);

        int minIndex = Math.min(endCodonIndex1, Math.min(endCodonIndex2, endCodonIndex3));

        if (minIndex != -1 && (minIndex - startIndex) % 3 == 0) {
            return minIndex; // Devolver el índice del codón de parada si está en la posición correcta
        } else {
            return -1; // Devolver -1 si no se encontró ningún codón de parada válido
        }
    }

}

