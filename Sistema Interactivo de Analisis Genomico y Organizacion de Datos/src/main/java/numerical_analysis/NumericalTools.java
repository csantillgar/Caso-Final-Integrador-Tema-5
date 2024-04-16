package numerical_analysis;

import java.util.ArrayList;
import java.util.List;

public class NumericalTools {
    public static void calculateSumAndList() {
        // Calcular la suma de números naturales y listar números en un rango dado
        int sum = calculateSum(1, 10);
        System.out.println("Suma de números del 1 al 10: " + sum);

        List<Integer> numbersInRange = listNumbersInRange(1, 10);
        System.out.println("Números en el rango del 1 al 10: " + numbersInRange);
    }

    public static int calculateSum(int start, int end) {
        // Calcular la suma de números naturales en un rango dado
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public static List<Integer> listNumbersInRange(int start, int end) {
        // Listar números en un rango dado
        List<Integer> numbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public static void calculatePowersAndMax() {
        // Implementar funciones para calcular potencias mediante multiplicaciones sucesivas
        // y encontrar el valor máximo en un conjunto de datos numéricos
        // (Esto debería ir en una clase específica para el cálculo de potencias y máximos)
    }
    // Método para calcular una potencia mediante multiplicaciones sucesivas
    public static int calculatePower(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            int result = 1;
            for (int i = 1; i <= exponent; i++) {
                result *= base;
            }
            return result;
        }
    }

    // Método para encontrar el valor máximo en un conjunto de datos numéricos
    public static int findMaxValue(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("La lista de números está vacía.");
        }

        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        return max;
    }
}

