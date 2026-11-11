public class Exercicio7 {

    static void dfs(int[][] grafo, int atual, boolean[] visitado) {
        // Marca antes de explorar os vizinhos para evitar ciclos.
        visitado[atual] = true;

        System.out.print(atual + " ");

        for (int vizinho = 0; vizinho < grafo.length; vizinho++) {
            if (grafo[atual][vizinho] == 1 && !visitado[vizinho]) {
                dfs(grafo, vizinho, visitado);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grafo = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1},
            {0, 0, 1, 1, 0}
        };

        boolean[] visitado = new boolean[grafo.length];

        System.out.println("Ordem de visita pela DFS:");

        // O primeiro percurso comeca no vertice 0.
        dfs(grafo, 0, visitado);

        // Se houver partes desconectadas, visita os vertices restantes.
        for (int i = 0; i < grafo.length; i++) {
            if (!visitado[i]) {
                System.out.println("\nNova componente:");
                dfs(grafo, i, visitado);
            }
        }

        System.out.println();
    }
}