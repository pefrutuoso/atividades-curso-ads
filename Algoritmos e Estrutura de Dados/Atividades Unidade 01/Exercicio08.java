import java.util.Scanner;
// Exercício 8: Análise de Frequência de Pedidos no Delivery
public class Exercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos pedidos serão informados? ");
        int n = sc.nextInt();

        int[] pedidos = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o código do pedido " + (i + 1) + ": ");
            pedidos[i] = sc.nextInt();
        }

        int maisFrequente = pedidos[0];
        int maiorContagem = 0;

        for (int i = 0; i < n; i++) {
            int contagem = 0;
            for (int j = 0; j < n; j++) {
                if (pedidos[i] == pedidos[j]) {
                    contagem++;
                }
            }
            if (contagem > maiorContagem) {
                maiorContagem = contagem;
                maisFrequente = pedidos[i];
            }
        }

        System.out.println("\nItem mais pedido: " + maisFrequente);
        System.out.println("Quantidade de vezes: " + maiorContagem);

        sc.close();
    }
}
