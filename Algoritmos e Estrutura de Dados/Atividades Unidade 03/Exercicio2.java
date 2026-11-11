public class Exercicio2 {

    static class No {
        int codigo;
        No esquerdo;
        No direito;

        No(int codigo) {
            this.codigo = codigo;
        }
    }

    static boolean ehBST(No raiz) {
        // long permite usar limites fora da faixa de int.
        return validar(raiz, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean validar(No no, long minimo, long maximo) {
        // Uma arvore vazia nao viola a regra da BST.
        if (no == null) {
            return true;
        }

        // O valor precisa estar estritamente dentro dos limites.
        if (no.codigo <= minimo || no.codigo >= maximo) {
            return false;
        }

        // A esquerda recebe um limite superior.
        boolean esquerdaValida = validar(
            no.esquerdo, minimo, no.codigo
        );

        // A direita recebe um limite inferior.
        boolean direitaValida = validar(
            no.direito, no.codigo, maximo
        );

        return esquerdaValida && direitaValida;
    }

    public static void main(String[] args) {
        No raiz = new No(20);
        raiz.esquerdo = new No(10);
        raiz.direito = new No(30);
        raiz.esquerdo.direito = new No(15);

        System.out.println("Arvore valida: " + ehBST(raiz));

        // 25 e maior que 10, mas nao pode estar a esquerda de 20.
        raiz.esquerdo.direito.codigo = 25;

        System.out.println("Depois da alteracao: " + ehBST(raiz));
    }
}