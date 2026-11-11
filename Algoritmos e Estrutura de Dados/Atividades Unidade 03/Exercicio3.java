public class Exercicio3 {

    public static int buscaLinear(int[] numeros, int procurado) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == procurado) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] numeros = {45, 12, 78, 23, 90};

        int procurado = 23;
        int posicao = buscaLinear(numeros, procurado);

        if (posicao == -1) {
            System.out.println("Numero nao encontrado.");
        } else {
            System.out.println("Numero encontrado no indice: " + posicao);
        }
    }
}