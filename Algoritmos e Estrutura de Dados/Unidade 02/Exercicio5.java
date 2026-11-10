import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

public class Exercicio5 {

    public static ArrayList<String> inverterComPilha(
            ArrayList<String> produtos) {

        Deque<String> pilha = new ArrayDeque<>();
        ArrayList<String> invertida = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            pilha.push(produtos.get(i));
        }

        while (!pilha.isEmpty()) {
            invertida.add(pilha.pop());
        }

        return invertida;
    }

    public static void main(String[] args) {
        ArrayList<String> produtos = new ArrayList<>();

        produtos.add("Teclado");
        produtos.add("Mouse");
        produtos.add("Monitor");

        ArrayList<String> invertida = inverterComPilha(produtos);

        System.out.println("Lista original: " + produtos);
        System.out.println("Lista invertida: " + invertida);
    }
}