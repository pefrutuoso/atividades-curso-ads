public class Exercicio4 {

    static int buscaBinaria(int[] numeros, int procurado) {
        int inicio = 0;
        int fim = numeros.length - 1;

        while (inicio <= fim) {
            // Calcula o indice central sem somar inicio com fim.
            int meio = inicio + (fim - inicio) / 2;

            if (numeros[meio] == procurado) {
                return meio;

            } else if (procurado > numeros[meio]) {
                // Descarta o meio e a parte esquerda.
                inicio = meio + 1;

            } else {
                // Descarta o meio e a parte direita.
                fim = meio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50, 60, 70};
        int procurado = 60;

        int posicao = buscaBinaria(numeros, procurado);

        if (posicao == -1) {
            System.out.println("Numero nao encontrado.");
        } else {
            System.out.println("Numero encontrado no indice: " + posicao);
        }
    }
}