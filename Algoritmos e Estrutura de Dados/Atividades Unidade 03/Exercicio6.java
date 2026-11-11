import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Exercicio6 {

    public static void bfs(int[][] grafo, int origem, int destino) {
        boolean[] visitado = new boolean[grafo.length];
        int[] anterior = new int[grafo.length];

        for (int i = 0; i < anterior.length; i++) {
            anterior[i] = -1;
        }

        Queue<Integer> fila = new ArrayDeque<>();

        visitado[origem] = true;
        fila.offer(origem);

        while (!fila.isEmpty()) {
            int atual = fila.poll();

            if (atual == destino) {
                break;
            }

            for (int vizinho = 0; vizinho < grafo.length; vizinho++) {
                if (grafo[atual][vizinho] == 1 && !visitado[vizinho]) {
                    visitado[vizinho] = true;
                    anterior[vizinho] = atual;

                    fila.offer(vizinho);
                }
            }
        }

        if (!visitado[destino]) {
            System.out.println("Nao existe caminho.");
            return;
        }

        ArrayList<Integer> caminho = new ArrayList<>();
        int atual = destino;

        while (atual != -1) {
            caminho.add(atual);
            atual = anterior[atual];
        }

        System.out.print("Caminho mais curto: ");

        for (int i = caminho.size() - 1; i >= 0; i--) {
            System.out.print(caminho.get(i));

            if (i > 0) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
        System.out.println("Quantidade de arestas: " + (caminho.size() - 1));
    }

    public static void main(String[] args) {
        int[][] grafo = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1},
            {0, 0, 1, 1, 0}
        };

        bfs(grafo, 0, 4);
    }
}