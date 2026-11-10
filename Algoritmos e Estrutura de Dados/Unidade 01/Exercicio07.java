import java.util.Scanner;
// Exercício 7: Jogo da Velha Interativo
public class Exercicio07 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        char[][] tabuleiro = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
        };

        char jogador = 'X';
        int jogadas = 0;
        boolean venceu = false;

        while (jogadas < 9 && !venceu) {
            System.out.println("\n=== Tabuleiro ===");

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(tabuleiro[i][j] + " ");
                }

                System.out.println();
            }

            System.out.println("Vez do jogador " + jogador);

            System.out.print("Escolha a linha (1 a 3): ");
            int linha = entrada.nextInt() - 1;

            System.out.print("Escolha a coluna (1 a 3): ");
            int coluna = entrada.nextInt() - 1;

            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
                System.out.println("Posicao fora do tabuleiro.");
                continue;
            }

            if (tabuleiro[linha][coluna] != '-') {
                System.out.println("Posicao ocupada.");
                continue;
            }

            tabuleiro[linha][coluna] = jogador;
            jogadas++;

            for (int i = 0; i < 3; i++) {
                if (tabuleiro[i][0] == jogador
                        && tabuleiro[i][1] == jogador
                        && tabuleiro[i][2] == jogador) {
                    venceu = true;
                }

                if (tabuleiro[0][i] == jogador
                        && tabuleiro[1][i] == jogador
                        && tabuleiro[2][i] == jogador) {
                    venceu = true;
                }
            }

            if (tabuleiro[0][0] == jogador
                    && tabuleiro[1][1] == jogador
                    && tabuleiro[2][2] == jogador) {
                venceu = true;
            }

            if (tabuleiro[0][2] == jogador
                    && tabuleiro[1][1] == jogador
                    && tabuleiro[2][0] == jogador) {
                venceu = true;
            }

            if (!venceu) {
                if (jogador == 'X') {
                    jogador = 'O';
                } else {
                    jogador = 'X';
                }
            }
        }

        System.out.println("\n=== Tabuleiro final ===");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }

            System.out.println();
        }

        if (venceu) {
            System.out.println("Jogador " + jogador + " venceu!");
        } else {
            System.out.println("Empate!");
        }

        entrada.close();
    }
}