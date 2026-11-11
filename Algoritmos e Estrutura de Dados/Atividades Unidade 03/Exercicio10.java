import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Exercicio10 {

    public static void ordenarTopologicamente(
            int[][] grafo,
            String[] tarefas) {

        int quantidade = grafo.length;
        int[] grauEntrada = new int[quantidade];

        for (int origem = 0; origem < quantidade; origem++) {
            for (int destino = 0; destino < quantidade; destino++) {
                if (grafo[origem][destino] == 1) {
                    grauEntrada[destino]++;
                }
            }
        }

        Queue<Integer> fila = new ArrayDeque<>();

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
                    grauEntrada[vizinho]--;

                    if (grauEntrada[vizinho] == 0) {
                        fila.offer(vizinho);
                    }
                }
            }
        }

        if (ordem.size() != quantidade) {
            System.out.println(
                "O grafo possui ciclo. Nao existe ordenacao topologica."
            );
            return;
        }

        System.out.println("Ordem das tarefas:");

        for (int i = 0; i < ordem.size(); i++) {
            int tarefa = ordem.get(i);

            System.out.println((i + 1) + " - " + tarefas[tarefa]);
        }
    }

    public static void main(String[] args) {
        String[] tarefas = {
            "Planejar",
            "Comprar materiais",
            "Preparar ambiente",
            "Executar projeto",
            "Entregar projeto"
        };

        int[][] grafo = new int[5][5];

        grafo[0][1] = 1;
        grafo[0][2] = 1;
        grafo[1][3] = 1;
        grafo[2][3] = 1;
        grafo[3][4] = 1;

        ordenarTopologicamente(grafo, tarefas);
    }
}