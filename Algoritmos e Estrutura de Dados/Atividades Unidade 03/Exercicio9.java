import java.util.ArrayList;

public class Exercicio9 {

    public static void dijkstra(
            int[][] grafo,
            int origem,
            int destino) {

        int quantidade = grafo.length;

        long[] distancia = new long[quantidade];
        boolean[] visitado = new boolean[quantidade];
        int[] anterior = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            distancia[i] = Long.MAX_VALUE;
            anterior[i] = -1;
        }

        distancia[origem] = 0;

        for (int passo = 0; passo < quantidade; passo++) {
            int atual = -1;

            for (int i = 0; i < quantidade; i++) {
                if (!visitado[i]) {
                    if (atual == -1 || distancia[i] < distancia[atual]) {
                        atual = i;
                    }
                }
            }

            if (atual == -1 || distancia[atual] == Long.MAX_VALUE) {
                break;
            }

            visitado[atual] = true;

            if (atual == destino) {
                break;
            }

            for (int vizinho = 0; vizinho < quantidade; vizinho++) {
                int peso = grafo[atual][vizinho];

                if (peso >= 0 && !visitado[vizinho]) {
                    long novaDistancia = distancia[atual] + peso;

                    if (novaDistancia < distancia[vizinho]) {
                        distancia[vizinho] = novaDistancia;
                        anterior[vizinho] = atual;
                    }
                }
            }
        }

        if (distancia[destino] == Long.MAX_VALUE) {
            System.out.println("Nao existe caminho.");
            return;
        }

        ArrayList<Integer> caminho = new ArrayList<>();
        int atual = destino;

        while (atual != -1) {
            caminho.add(atual);
            atual = anterior[atual];
        }

        System.out.print("Menor caminho: ");

        for (int i = caminho.size() - 1; i >= 0; i--) {
            System.out.print(caminho.get(i));

            if (i > 0) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
        System.out.println("Distancia total: " + distancia[destino]);
    }

    public static void main(String[] args) {
        int[][] grafo = {
            {-1, 4, 1, -1},
            {4, -1, 2, 1},
            {1, 2, -1, 5},
            {-1, 1, 5, -1}
        };

        dijkstra(grafo, 0, 3);
    }
}