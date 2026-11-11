import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Exercicio6 {

    static void buscarCaminho(int[][] grafo, int origem, int destino) {
        boolean[] visitado = new boolean[grafo.length];
        int[] anterior = new int[grafo.length];

        // -1 indica que ainda nao existe antecessor registrado.
        for (int i = 0; i < anterior.length; i++) {
            anterior[i] = -1;
        }

        Queue<Integer> fila = new ArrayDeque<>();

        fila.offer(origem);
        visitado[origem] = true;

        while (!fila.isEmpty()) {
            int atual = fila.poll();

            if (atual == destino) {
                break;
            }

            // Examina todos os possiveis vizinhos.
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

        // Volta do destino ate a origem pelos antecessores.
        int atual = destino;

        while (atual != -1) {
            caminho.add(0, atual);
            atual = anterior[atual];
        }

        System.out.println("Caminho mais curto: " + caminho);
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

        buscarCaminho(grafo, 0, 4);
    }
}