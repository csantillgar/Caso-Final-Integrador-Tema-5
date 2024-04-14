package genomic_analysis;

public class GeneCounter {

    // Método para contar genes en una cadena de ADN
    public static int countGenes(String dna) {
        // Contador de genes
        int geneCount = 0;

        // Buscar el inicio de un gen (ATG) en la cadena de ADN
        int startIndex = dna.indexOf("ATG");
        while (startIndex != -1) {
            // Encontrar la próxima ocurrencia de ATG después del inicio del gen actual
            int endIndex = dna.indexOf("ATG", startIndex + 3);

            // Si no se encuentra otra ocurrencia de ATG, terminar la búsqueda
            if (endIndex == -1) {
                break;
            }

            // Verificar si hay un múltiplo de 3 caracteres entre ATG y el siguiente STOP codon
            int stopIndex = findStopCodon(dna, startIndex + 3);
            if (stopIndex != -1) {
                // Se ha encontrado un gen válido, aumentar el contador de genes
                geneCount++;

                // Continuar la búsqueda desde la posición después del STOP codon
                startIndex = dna.indexOf("ATG", stopIndex + 3);
            } else {
                // No se encontró un STOP codon después de ATG, continuar la búsqueda desde la próxima posición
                startIndex = dna.indexOf("ATG", startIndex + 1);
            }
        }

        return geneCount;
    }

    // Método para encontrar el STOP codon después de un gen
    private static int findStopCodon(String dna, int startIndex) {
        // Arrays de los posibles STOP codons
        String[] stopCodons = {"TAA", "TAG", "TGA"};

        // Buscar la primera ocurrencia de un STOP codon después del startIndex
        int minIndex = dna.length();
        for (String stopCodon : stopCodons) {
            int stopIndex = dna.indexOf(stopCodon, startIndex);
            if (stopIndex != -1 && (stopIndex - startIndex) % 3 == 0) {
                // Se encontró un STOP codon que está en la posición correcta (múltiplo de 3)
                minIndex = Math.min(minIndex, stopIndex);
            }
        }

        // Si se encontró algún STOP codon válido, devolver su índice mínimo
        if (minIndex != dna.length()) {
            return minIndex;
        } else {
            return -1;
        }
    }
}

