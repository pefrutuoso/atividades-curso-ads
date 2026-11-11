public class Exercicio4 {

    public static int buscaBinaria(int[] numeros, int procurado) {
        int inicio = 0;
        int fim = numeros.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (numeros[meio] == procurado) {
                return meio;

            } else if (procurado > numeros[meio]) {
                inicio = meio + 1;

            } else {
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