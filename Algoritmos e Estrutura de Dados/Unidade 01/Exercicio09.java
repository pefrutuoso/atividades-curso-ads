import java.util.Scanner;
// Exercício 9: Gerenciando um Cadastro de Clientes
class Pessoa {
    private String nome;
    private int idade;
    private String endereco;

    public Pessoa(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Idade: " + idade + " | Endereço: " + endereco;
    }
}

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pessoa[] clientes = new Pessoa[100];
        int total = 0;

        int opcao;
        do {
            System.out.println("\n=== Cadastro de Clientes ===");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    if (total >= clientes.length) {
                        System.out.println("Cadastro cheio!");
                        break;
                    }
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();

                    clientes[total] = new Pessoa(nome, idade, endereco);
                    total++;
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    if (total == 0) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        for (int i = 0; i < total; i++) {
                            System.out.println((i + 1) + " - " + clientes[i]);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
