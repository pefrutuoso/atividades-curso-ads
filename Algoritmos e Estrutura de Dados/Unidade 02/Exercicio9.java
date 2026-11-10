import java.util.HashMap;

public class Exercicio9 {

    public static HashMap<String, Integer> mesclarMapas(
            HashMap<String, Integer> estoque1,
            HashMap<String, Integer> estoque2) {

        HashMap<String, Integer> resultado = new HashMap<>();

        for (String produto : estoque1.keySet()) {
            resultado.put(produto, estoque1.get(produto));
        }

        for (String produto : estoque2.keySet()) {
            int quantidade = estoque2.get(produto);

            if (resultado.containsKey(produto)) {
                int quantidadeAtual = resultado.get(produto);

                resultado.put(
                    produto,
                    quantidadeAtual + quantidade
                );
            } else {
                resultado.put(produto, quantidade);
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> estoque1 = new HashMap<>();
        HashMap<String, Integer> estoque2 = new HashMap<>();

        estoque1.put("Teclado", 10);
        estoque1.put("Mouse", 20);

        estoque2.put("Mouse", 5);
        estoque2.put("Monitor", 8);

        HashMap<String, Integer> estoqueFinal =
                mesclarMapas(estoque1, estoque2);

        System.out.println("Estoque mesclado:");

        for (String produto : estoqueFinal.keySet()) {
            System.out.println(
                produto + ": " + estoqueFinal.get(produto)
            );
        }
    }
}