import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Exercicio10 {

    static void ordenarTopologicamente(
            int[][] grafo, String[] tarefas) {

        int quantidade = grafo.length;
        int[] grauEntrada = new int[quantidade];

        // Conta quantas arestas chegam a cada vertice.
        for (int origem = 0; origem < quantidade; origem++) {
            for (int destino = 0; destino < quantidade; destino++) {
                if (grafo[origem][destino] == 1) {
                    grauEntrada[destino]++;
                }
            }
        }

        Queue<Integer> fila = new ArrayDeque<>();

        // Vertices sem dependencias podem ser processados primeiro.
        for (int i = 0; i < quantidade; i++) {
            if (grauEntrada[i] == 0) {
                fila.offer(i);
            }
        }

        ArrayList<Integer> ordem = new ArrayList<>();

        while (!fila.isEmpty()) {
            int atual = fila.poll();
            ordem.add(atual);

            for (int vizinho = 0; vizinho < quantidade; vizinho++) {
                if (grafo[atual][vizinho] == 1) {
                    // A tarefa atual deixou de ser uma pendencia.
                    grauEntrada[vizinho]--;

                    if (grauEntrada[vizinho] == 0) {
                        fila.offer(vizinho);
                    }
                }
            }
        }

        // Um ciclo impede que todos os vertices sejam liberados.
        if (ordem.size() != quantidade) {
            System.out.println(
                "Nao e possivel ordenar: o grafo possui ciclo."
            );
            return;
        }

        System.out.println("Ordem das tarefas:");

        for (int i = 0; i < ordem.size(); i++) {
            int vertice = ordem.get(i);

            System.out.println((i + 1) + " - " + tarefas[vertice]);
        }
    }

    public static void main(String[] args) {
        String[] tarefas = {
            "Planejar",
            "Programar",
            "Testar",
            "Documentar",
            "Publicar"
        };

        // Matriz direcionada: nao adicionamos automaticamente a volta.
        int[][] grafo = {
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };

        ordenarTopologicamente(grafo, tarefas);
    }
}