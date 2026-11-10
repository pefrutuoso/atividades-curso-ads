// Exercício 5: Avaliação de Notas dos Alunos
public class Exercicio05 {
    public static void main(String[] args) {
        float[] notas = {7.5f, 8.0f, 6.5f, 9.5f, 8.7f};

        float maiorNota = notas[0];

        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > maiorNota) {
                maiorNota = notas[i];
            }
        }

        System.out.println("Maior nota da turma é: " + maiorNota);
    }
}