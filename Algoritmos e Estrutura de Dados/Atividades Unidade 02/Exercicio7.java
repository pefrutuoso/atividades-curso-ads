import java.util.ArrayDeque;
import java.util.Queue;

public class Exercicio7 {

    public static void main(String[] args) {
        Queue<String> clientes = new ArrayDeque<>();

        clientes.offer("Ana");
        clientes.offer("Pedro");
        clientes.offer("Carlos");

        System.out.println("Ordem de chegada: " + clientes);

        System.out.println("\nOrdem de saida:");

        int ordem = 1;

        while (!clientes.isEmpty()) {
            String cliente = clientes.poll();

            System.out.println(ordem + " - " + cliente);
            ordem++;
        }

        System.out.println("\nTodos os clientes foram atendidos.");
    }
}