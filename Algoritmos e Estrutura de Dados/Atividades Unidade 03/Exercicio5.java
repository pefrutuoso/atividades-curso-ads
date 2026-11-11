public class Exercicio5 {

    static class Grafo {
        int[][] matriz;

        Grafo(int quantidade) {
            matriz = new int[quantidade][quantidade];
        }

        void adicionarAresta(int origem, int destino) {
            // Conexao de ida.
            matriz[origem][destino] = 1;

            // Conexao de volta: grafo nao direcionado.
            matriz[destino][origem] = 1;
        }

        void exibirConexoes() {
            for (int i = 0; i < matriz.length; i++) {
                System.out.print("Local " + i + " conectado a: ");

                for (int j = 0; j < matriz.length; j++) {
                    if (matriz[i][j] == 1) {
                        System.out.print(j + " ");
                    }
                }

                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(4);

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 3);

        grafo.exibirConexoes();
    }
}