package genomic_analysis;
public class CountGenes {
    public static int countGenes(String dnaSequence) {
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

        return geneCount;
    }

    private static int findEndCodon(String dnaSequence, int startIndex) {
        int endCodonIndex1 = dnaSequence.indexOf("TAG", startIndex + 3);
        int endCodonIndex2 = dnaSequence.indexOf("TAA", startIndex + 3);
        int endCodonIndex3 = dnaSequence.indexOf("TGA", startIndex + 3);

        int minIndex = Math.min(endCodonIndex1, Math.min(endCodonIndex2, endCodonIndex3));
        return minIndex != -1 ? minIndex : dnaSequence.length();
    }
}


