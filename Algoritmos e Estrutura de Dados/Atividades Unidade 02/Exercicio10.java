import java.util.ArrayList;

public class Exercicio10 {

    static class Produto {
        String nome;
        int vendas;

        Produto(String nome, int vendas) {
            this.nome = nome;
            this.vendas = vendas;
        }
    }

    public static void ordenarPorVendas(ArrayList<Produto> produtos) {
        for (int i = 0; i < produtos.size() - 1; i++) {
            boolean houveTroca = false;

            for (int j = 0; j < produtos.size() - 1 - i; j++) {
                Produto atual = produtos.get(j);
                Produto proximo = produtos.get(j + 1);

                if (atual.vendas < proximo.vendas) {
                    produtos.set(j, proximo);
                    produtos.set(j + 1, atual);

                    houveTroca = true;
                }
            }

            if (!houveTroca) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Teclado", 80));
        produtos.add(new Produto("Mouse", 150));
        produtos.add(new Produto("Monitor", 45));
        produtos.add(new Produto("Headset", 100));

        ordenarPorVendas(produtos);

        System.out.println("=== Produtos mais vendidos ===");

        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);

            System.out.println(
                (i + 1) + " - " + produto.nome
                + ": " + produto.vendas + " vendas"
            );
        }
    }
}