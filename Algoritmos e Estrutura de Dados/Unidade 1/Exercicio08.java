import java.util.ArrayList;
import java.util.Scanner;
// Exercício 8: Análise de Frequência de Pedidos no Delivery
public class Exercicio08 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Integer> pedidos = new ArrayList<>();

        System.out.print("Quantos pedidos deseja informar? ");
        int quantidade = entrada.nextInt();

        if (quantidade <= 0) {
            System.out.println("Informe pelo menos um pedido.");
        } else {
            for (int i = 0; i < quantidade; i++) {
                System.out.print("Codigo do pedido " + (i + 1) + ": ");
                pedidos.add(entrada.nextInt());
            }

            int maisPedido = pedidos.get(0);
            int maiorFrequencia = 0;

            for (int i = 0; i < pedidos.size(); i++) {
                int codigoAtual = pedidos.get(i);
                int frequencia = 0;

                for (int j = 0; j < pedidos.size(); j++) {
                    if (pedidos.get(j) == codigoAtual) {
                        frequencia++;
                    }
                }

                if (frequencia > maiorFrequencia) {
                    maiorFrequencia = frequencia;
                    maisPedido = codigoAtual;
                }
            }

            System.out.println("Item mais pedido: " + maisPedido);
            System.out.println("Quantidade de vezes: " + maiorFrequencia);
        }

        entrada.close();
    }
}