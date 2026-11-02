import java.util.ArrayList;
import java.util.Scanner;
// Exercício 4: Organizando uma Lista de Espera Dinâmica
public class Exercicio04 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> clientes = new ArrayList<>();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n1 - Adicionar cliente");
            System.out.println("2 - Remover cliente");
            System.out.println("3 - Mostrar lista");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 1) {
                System.out.print("Nome do cliente: ");
                String nome = entrada.nextLine();

                clientes.add(nome);
                System.out.println("Cliente adicionado.");

            } else if (opcao == 2) {
                System.out.print("Nome do cliente para remover: ");
                String nome = entrada.nextLine();

                boolean removido = clientes.remove(nome);

                if (removido) {
                    System.out.println("Cliente removido.");
                } else {
                    System.out.println("Cliente nao encontrado.");
                }

            } else if (opcao != 3 && opcao != 0) {
                System.out.println("Opcao invalida.");
            }

            if (opcao != 0) {
                System.out.println("Lista atual: " + clientes);
                System.out.println("Clientes aguardando: " + clientes.size());
            }
        }

        entrada.close();
    }
}