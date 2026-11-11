public class Exercicio8 {

    static class No {
        String produto;
        int precoCentavos;

        No esquerdo;
        No direito;

        No(String produto, int precoCentavos) {
            this.produto = produto;
            this.precoCentavos = precoCentavos;
        }
    }

    static No encontrarMenor(No raiz) {
        if (raiz == null) {
            return null;
        }

        No atual = raiz;

        // Em uma BST, os menores valores ficam a esquerda.
        while (atual.esquerdo != null) {
            atual = atual.esquerdo;
        }

        return atual;
    }

    public static void main(String[] args) {
        // Os precos devem respeitar a organizacao da BST.
        No raiz = new No("Teclado", 15000);
        raiz.esquerdo = new No("Mouse", 8000);
        raiz.direito = new No("Monitor", 90000);
        raiz.esquerdo.esquerdo = new No("Mousepad", 2500);

        No menor = encontrarMenor(raiz);

        if (menor == null) {
            System.out.println("A arvore esta vazia.");
        } else {
            System.out.println("Produto mais barato: " + menor.produto);

            // Separa reais e centavos apenas para exibir.
            System.out.printf(
                "Preco: R$ %d,%02d%n",
                menor.precoCentavos / 100,
                menor.precoCentavos % 100
            );
        }
    }
}