import java.util.ArrayList;

public class Exercicio2 {

    public static void removerDuplicados(ArrayList<String> contatos) {
        for (int i = 0; i < contatos.size(); i++) {
            int j = i + 1;

            while (j < contatos.size()) {
                if (contatos.get(i).equals(contatos.get(j))) {
                    contatos.remove(j);
                } else {
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> contatos = new ArrayList<>();

        contatos.add("Ana");
        contatos.add("Pedro");
        contatos.add("Ana");
        contatos.add("Carlos");
        contatos.add("Pedro");

        System.out.println("Antes: " + contatos);

        removerDuplicados(contatos);

        System.out.println("Depois: " + contatos);
    }
}