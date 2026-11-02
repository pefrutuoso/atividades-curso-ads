import java.util.ArrayList;
import java.util.Scanner;
// Exercício 10: Desafio Final - Sistema de Gerenciamento de Estoque para uma Loja
class Produto {
    int codigo;
    String nome;
    int quantidade;
    double preco;

    Produto(int codigo, String nome, int quantidade, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
}

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Produto> estoque = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n=== Gerenciamento de estoque ===");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Atualizar produto");
            System.out.println("4 - Remover produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 1) {
                System.out.print("Codigo: ");
                int codigo = entrada.nextInt();
                entrada.nextLine();

                boolean codigoExiste = false;

                for (int i = 0; i < estoque.size(); i++) {
                    if (estoque.get(i).codigo == codigo) {
                        codigoExiste = true;
                        break;
                    }
                }

                if (codigoExiste) {
                    System.out.println("Ja existe um produto com esse codigo.");
                } else {
                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidade = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Preco (use ponto, exemplo 15.90): ");
                    double preco = Double.parseDouble(entrada.nextLine());

                    if (quantidade < 0 || preco < 0) {
                        System.out.println(
                            "Quantidade e preco nao podem ser negativos."
                        );
                    } else {
                        Produto produto = new Produto(
                            codigo, nome, quantidade, preco
                        );

                        estoque.add(produto);
                        System.out.println("Produto cadastrado.");
                    }
                }

            } else if (opcao == 2) {
                if (estoque.isEmpty()) {
                    System.out.println("O estoque esta vazio.");
                } else {
                    for (int i = 0; i < estoque.size(); i++) {
                        Produto produto = estoque.get(i);

                        System.out.println("\nCodigo: " + produto.codigo);
                        System.out.println("Nome: " + produto.nome);
                        System.out.println("Quantidade: " + produto.quantidade);
                        System.out.println("Preco: R$ " + produto.preco);
                    }
                }

            } else if (opcao == 3) {
                System.out.print("Codigo do produto para atualizar: ");
                int codigo = entrada.nextInt();
                entrada.nextLine();

                int posicao = -1;

                for (int i = 0; i < estoque.size(); i++) {
                    if (estoque.get(i).codigo == codigo) {
                        posicao = i;
                        break;
                    }
                }

                if (posicao == -1) {
                    System.out.println("Produto nao encontrado.");
                } else {
                    System.out.print("Novo nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Nova quantidade: ");
                    int quantidade = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Novo preco (use ponto): ");
                    double preco = Double.parseDouble(entrada.nextLine());

                    if (quantidade < 0 || preco < 0) {
                        System.out.println(
                            "Quantidade e preco nao podem ser negativos."
                        );
                    } else {
                        Produto produto = estoque.get(posicao);

                        produto.nome = nome;
                        produto.quantidade = quantidade;
                        produto.preco = preco;

                        System.out.println("Produto atualizado.");
                    }
                }

            } else if (opcao == 4) {
                System.out.print("Codigo do produto para remover: ");
                int codigo = entrada.nextInt();
                entrada.nextLine();

                int posicao = -1;

                for (int i = 0; i < estoque.size(); i++) {
                    if (estoque.get(i).codigo == codigo) {
                        posicao = i;
                        break;
                    }
                }

                if (posicao == -1) {
                    System.out.println("Produto nao encontrado.");
                } else {
                    estoque.remove(posicao);
                    System.out.println("Produto removido.");
                }

            } else if (opcao != 0) {
                System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
        entrada.close();
    }
}