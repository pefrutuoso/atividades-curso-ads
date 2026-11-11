public class Exercicio3 {

    static int buscaLinear(int[] numeros, int procurado) {
        // Examina cada posicao do array.
        for (int i = 0; i < numeros.length; i++) {

            if (numeros[i] == procurado) {
                return i;
            }
        }

        // Nenhuma posicao apresentou o valor procurado.
        return -1;
    }

    public static void main(String[] args) {
        int[] numeros = {42, 17, 85, 23, 60};
        int procurado = 23;

        int posicao = buscaLinear(numeros, procurado);

        if (posicao == -1) {
            System.out.println("Numero nao encontrado.");
        } else {
            System.out.println("Numero encontrado no indice: " + posicao);
        }
    }
}