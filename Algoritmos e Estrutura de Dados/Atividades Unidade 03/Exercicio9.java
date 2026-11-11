import java.util.ArrayList;

public class Exercicio9 {

    static void dijkstra(int[][] grafo, int origem, int destino) {
        int quantidade = grafo.length;

        long[] distancia = new long[quantidade];
        boolean[] finalizado = new boolean[quantidade];
        int[] anterior = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            distancia[i] = Long.MAX_VALUE;
            anterior[i] = -1;
        }

        // A distancia da origem para ela mesma e zero.
        distancia[origem] = 0;

        for (int passo = 0; passo < quantidade; passo++) {
            int atual = -1;

            // Escolhe o vertice pendente com menor distancia.
            for (int i = 0; i < quantidade; i++) {
                if (!finalizado[i]) {
                    if (atual == -1 || distancia[i] < distancia[atual]) {
                        atual = i;
                    }
                }
            }

            // Nao existem mais vertices alcancaveis para explorar.
            if (atual == -1 || distancia[atual] == Long.MAX_VALUE) {
                break;
            }

            finalizado[atual] = true;

            if (atual == destino) {
                break;
            }

            for (int vizinho = 0; vizinho < quantidade; vizinho++) {
                int peso = grafo[atual][vizinho];

                // Peso -1 significa que a conexao nao existe.
                if (peso >= 0 && !finalizado[vizinho]) {
                    long novaDistancia = distancia[atual] + peso;

                    // Atualiza quando encontra uma rota menor.
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

        // Reconstrucao do destino ate a origem.
        int atual = destino;

        while (atual != -1) {
            caminho.add(0, atual);
            atual = anterior[atual];
        }

        System.out.println("Menor caminho: " + caminho);
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