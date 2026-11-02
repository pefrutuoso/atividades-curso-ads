import java.util.Scanner;
public class Exercicio02 {
    //Exercício 2: Verificador de Características de Um Produto
    public static void main(String[] args) {       
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o código do produto: ");
        int codidoProduto = entrada.nextInt();

        if(codidoProduto % 2 == 0){
            System.out.println("O código do produto é par.");
        } else {
            System.out.println("O código do produto é ímpar.");
        }
        entrada.close();
    }
}
