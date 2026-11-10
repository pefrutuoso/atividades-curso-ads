import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio1 {

    public static void inverterLista(ArrayList<String> tarefas) {
        int inicio = 0;
        int fim = tarefas.size() - 1;

        while (inicio < fim) {
            String auxiliar = tarefas.get(inicio);

            tarefas.set(inicio, tarefas.get(fim));
            tarefas.set(fim, auxiliar);

            inicio++;
            fim--;
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ArrayList<String> tarefas = new ArrayList<>();

        tarefas.add("Estudar Java");
        tarefas.add("Fazer exercicios");
        tarefas.add("Revisar o conteudo");

        System.out.println("Lista original: " + tarefas);

        System.out.println("1 - Ver a lista invertida");
        System.out.println("2 - Manter a lista original");
        System.out.print("Escolha: ");

        int opcao = entrada.nextInt();

        if (opcao == 1) {
            inverterLista(tarefas);
            System.out.println("Lista invertida: " + tarefas);
        } else if (opcao == 2) {
            System.out.println("Lista original: " + tarefas);
        } else {
            System.out.println("Opcao invalida.");
        }

        entrada.close();
    }
}