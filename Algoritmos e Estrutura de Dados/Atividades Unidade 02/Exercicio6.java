import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Exercicio6 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Queue<String> pacientes = new ArrayDeque<>();

        int opcao;

        do {
            System.out.println("\n=== Fila de pacientes ===");
            System.out.println("1 - Adicionar paciente");
            System.out.println("2 - Atender primeiro paciente");
            System.out.println("3 - Exibir fila");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 1) {
                System.out.print("Nome do paciente: ");
                String nome = entrada.nextLine();

                pacientes.offer(nome);

                System.out.println("Paciente adicionado.");

            } else if (opcao == 2) {
                if (pacientes.isEmpty()) {
                    System.out.println("Nao ha pacientes aguardando.");
                } else {
                    String atendido = pacientes.poll();

                    System.out.println("Paciente chamado: " + atendido);
                }

            } else if (opcao == 3) {
                if (pacientes.isEmpty()) {
                    System.out.println("A fila esta vazia.");
                } else {
                    int posicao = 1;

                    for (String paciente : pacientes) {
                        System.out.println(posicao + " - " + paciente);
                        posicao++;
                    }
                }

            } else if (opcao != 0) {
                System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        entrada.close();
    }
}