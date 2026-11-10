import java.util.ArrayList;

public class Exercicio3 {

    public static ArrayList<String> intercalarListas(
            ArrayList<String> lista1,
            ArrayList<String> lista2) {

        ArrayList<String> resultado = new ArrayList<>();

        int i = 0;

        while (i < lista1.size() || i < lista2.size()) {
            if (i < lista1.size()) {
                resultado.add(lista1.get(i));
            }

            if (i < lista2.size()) {
                resultado.add(lista2.get(i));
            }

            i++;
        }

        return resultado;
    }

    public static void main(String[] args) {
        ArrayList<String> lista1 = new ArrayList<>();
        ArrayList<String> lista2 = new ArrayList<>();

        lista1.add("Ana");
        lista1.add("Carlos");
        lista1.add("Mariana");

        lista2.add("Pedro");
        lista2.add("Julia");

        ArrayList<String> convidados =
                intercalarListas(lista1, lista2);

        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);
        System.out.println("Lista intercalada: " + convidados);
    }
}