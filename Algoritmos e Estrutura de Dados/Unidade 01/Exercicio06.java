// Exercício 6: Seleção de Números Primos para Criptografia
public class Exercicio06 {
    public static void main(String[] args) {
        System.out.println("Numeros primos entre 1 e 100:");

        for (int numero = 2; numero <= 100; numero++) {
            boolean primo = true;

            for (int divisor = 2; divisor < numero; divisor++) {
                if (numero % divisor == 0) {
                    primo = false;
                    break;
                }
            }

            if (primo) {
                System.out.print(numero + " ");
            }
        }

        System.out.println();
    }
}