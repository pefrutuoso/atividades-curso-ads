import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Exercicio4 {

    public static boolean verificarParenteses(String expressao) {
        Deque<Character> pilha = new ArrayDeque<>();

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            if (caractere == '(') {
                pilha.push(caractere);

            } else if (caractere == ')') {
                if (pilha.isEmpty()) {
                    return false;
                }

                pilha.pop();
            }
        }

        return pilha.isEmpty();
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite uma expressao: ");
        String expressao = entrada.nextLine();

        if (verificarParenteses(expressao)) {
            System.out.println("Parenteses balanceados.");
        } else {
            System.out.println("Parenteses desbalanceados.");
        }

        entrada.close();
    }
}