package genomic_analysis;

import java.util.ArrayList;
import java.util.List;

public class GeneticCombinations {
    public static List<String> calculateCombinations(String dnaSequence) {
        List<String> combinations = new ArrayList<>();
        generateCombinations(dnaSequence, "", combinations);
        return combinations;
    }

    private static void generateCombinations(String remainingSequence, String currentCombination, List<String> combinations) {
        // Si no hay más secuencia de ADN restante, añadimos la combinación actual a la lista de combinaciones
        if (remainingSequence.isEmpty()) {
            combinations.add(currentCombination);
            return;
        }

        // Tomamos el primer carácter de la secuencia de ADN restante
        char currentGene = remainingSequence.charAt(0);

        // Generamos combinaciones incluyendo el gen actual
        generateCombinations(remainingSequence.substring(1), currentCombination + currentGene, combinations);

        // Generamos combinaciones sin incluir el gen actual
        generateCombinations(remainingSequence.substring(1), currentCombination, combinations);
    }
}
