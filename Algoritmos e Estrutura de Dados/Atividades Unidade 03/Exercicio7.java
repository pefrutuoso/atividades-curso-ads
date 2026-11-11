public class Exercicio7 {

    public static void dfs(
            int[][] grafo,
            int atual,
            boolean[] visitado) {

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

        System.out.print("Ordem da DFS: ");
        dfs(grafo, 0, visitado);

        System.out.println();
    }
}