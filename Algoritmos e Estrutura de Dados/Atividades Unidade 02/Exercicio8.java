import java.util.HashMap;
import java.util.Scanner;

public class Exercicio8 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        HashMap<String, Integer> frequencias = new HashMap<>();

        System.out.print("Digite uma frase: ");
        String frase = entrada.nextLine();

        frase = frase.toLowerCase(java.util.Locale.ROOT);

        String[] palavras = frase.split("[^\\p{L}\\p{N}]+");

        for (int i = 0; i < palavras.length; i++) {
            String palavra = palavras[i];

            if (!palavra.isEmpty()) {
                if (frequencias.containsKey(palavra)) {
                    int quantidade = frequencias.get(palavra);
                    frequencias.put(palavra, quantidade + 1);
                } else {
                    frequencias.put(palavra, 1);
                }
            }
        }

        if (frequencias.isEmpty()) {
            System.out.println("Nenhuma palavra encontrada.");
        } else {
            System.out.println("\nFrequencia das palavras:");

            for (String palavra : frequencias.keySet()) {
                System.out.println(
                    palavra + ": " + frequencias.get(palavra)
                );
            }
        }

        entrada.close();
    }
}