import java.util.ArrayList;
import java.util.Scanner;
// Exercício 9: Gerenciando um Cadastro de Clientes
class Pessoa {
    String nome;
    int idade;
    String endereco;

    Pessoa(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }
}

public class Exercicio09 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Pessoa> clientes = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n=== Cadastro de clientes ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Remover");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = entrada.nextLine();

                System.out.print("Idade: ");
                int idade = entrada.nextInt();
                entrada.nextLine();

                System.out.print("Endereco: ");
                String endereco = entrada.nextLine();

                if (idade < 0) {
                    System.out.println("A idade nao pode ser negativa.");
                } else {
                    Pessoa cliente = new Pessoa(nome, idade, endereco);
                    clientes.add(cliente);

                    System.out.println("Cliente cadastrado.");
                }

            } else if (opcao == 2) {
                if (clientes.isEmpty()) {
                    System.out.println("Nenhum cliente cadastrado.");
                } else {
                    for (int i = 0; i < clientes.size(); i++) {
                        Pessoa cliente = clientes.get(i);

                        System.out.println("\nCliente " + (i + 1));
                        System.out.println("Nome: " + cliente.nome);
                        System.out.println("Idade: " + cliente.idade);
                        System.out.println("Endereco: " + cliente.endereco);
                    }
                }

            } else if (opcao == 3) {
                System.out.print("Numero do cliente que deseja remover: ");
                int numero = entrada.nextInt();
                entrada.nextLine();

                if (numero >= 1 && numero <= clientes.size()) {
                    clientes.remove(numero - 1);
                    System.out.println("Cliente removido.");
                } else {
                    System.out.println("Numero invalido.");
                }

            } else if (opcao != 0) {
                System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        entrada.close();
    }
}