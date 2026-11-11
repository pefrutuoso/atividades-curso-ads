public class Exercicio8 {

    static class No {
        int valor;
        No esquerdo;
        No direito;

        No(int valor) {
            this.valor = valor;
        }
    }

    public static Integer encontrarMenor(No raiz) {
        if (raiz == null) {
            return null;
        }

        No atual = raiz;

        while (atual.esquerdo != null) {
            atual = atual.esquerdo;
        }

        return atual.valor;
    }

    public static void main(String[] args) {
        No raiz = new No(100);

        raiz.esquerdo = new No(70);
        raiz.direito = new No(150);

        raiz.esquerdo.esquerdo = new No(40);
        raiz.esquerdo.direito = new No(90);

        Integer menor = encontrarMenor(raiz);

        if (menor == null) {
            System.out.println("A arvore esta vazia.");
        } else {
            System.out.println("Menor valor: " + menor);
        }
    }
}