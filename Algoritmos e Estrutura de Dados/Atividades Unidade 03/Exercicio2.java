public class Exercicio2 {

    static class No {
        int valor;
        No esquerdo;
        No direito;

        No(int valor) {
            this.valor = valor;
        }
    }

    public static boolean ehBST(No raiz) {
        return validar(raiz, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validar(No no, long minimo, long maximo) {
        if (no == null) {
            return true;
        }

        if (no.valor <= minimo || no.valor >= maximo) {
            return false;
        }

        return validar(no.esquerdo, minimo, no.valor)
                && validar(no.direito, no.valor, maximo);
    }

    public static void main(String[] args) {
        No raiz = new No(20);

        raiz.esquerdo = new No(10);
        raiz.direito = new No(30);

        raiz.esquerdo.esquerdo = new No(5);
        raiz.esquerdo.direito = new No(15);

        System.out.println("A arvore e BST? " + ehBST(raiz));

        raiz.esquerdo.direito.valor = 25;

        System.out.println("Depois da alteracao, e BST? " + ehBST(raiz));
    }
}