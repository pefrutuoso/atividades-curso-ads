import java.util.Scanner;
// Exercício 10: Desafio Final - Sistema de Gerenciamento de Estoque para uma Loja
class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(int codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    @Override
    public String toString() {
        return String.format("Cód: %d | Nome: %s | Preço: R$ %.2f | Qtd: %d",
                codigo, nome, preco, quantidade);
    }
}

public class Exercicio10 {
    private static Produto[] estoque = new Produto[100];
    private static int total = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Gerenciamento de Estoque ===");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Atualizar produto");
            System.out.println("4 - Listar produtos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: adicionar(sc); break;
                case 2: remover(sc); break;
                case 3: atualizar(sc); break;
                case 4: listar(); break;
                case 0: System.out.println("Encerrando sistema..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void adicionar(Scanner sc) {
        if (total >= estoque.length) {
            System.out.println("Estoque cheio!");
            return;
        }
        System.out.print("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        if (buscarIndice(codigo) != -1) {
            System.out.println("Já existe um produto com esse código!");
            return;
        }

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        System.out.print("Quantidade: ");
        int qtd = sc.nextInt();

        estoque[total] = new Produto(codigo, nome, preco, qtd);
        total++;
        System.out.println("Produto adicionado!");
    }

    private static void remover(Scanner sc) {
        System.out.print("Código do produto a remover: ");
        int codigo = sc.nextInt();
        int indice = buscarIndice(codigo);

        if (indice == -1) {
            System.out.println("Produto não encontrado.");
            return;
        }

        for (int i = indice; i < total - 1; i++) {
            estoque[i] = estoque[i + 1];
        }
        estoque[total - 1] = null;
        total--;
        System.out.println("Produto removido!");
    }

    private static void atualizar(Scanner sc) {
        System.out.print("Código do produto a atualizar: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        int indice = buscarIndice(codigo);

        if (indice == -1) {
            System.out.println("Produto não encontrado.");
            return;
        }

        Produto p = estoque[indice];

        System.out.print("Novo nome (" + p.getNome() + "): ");
        String nome = sc.nextLine();
        if (!nome.isEmpty()) p.setNome(nome);

        System.out.print("Novo preço (" + p.getPreco() + "): ");
        String precoStr = sc.nextLine();
        if (!precoStr.isEmpty()) p.setPreco(Double.parseDouble(precoStr));

        System.out.print("Nova quantidade (" + p.getQuantidade() + "): ");
        String qtdStr = sc.nextLine();
        if (!qtdStr.isEmpty()) p.setQuantidade(Integer.parseInt(qtdStr));

        System.out.println("Produto atualizado!");
    }

    private static void listar() {
        if (total == 0) {
            System.out.println("Estoque vazio.");
            return;
        }
        for (int i = 0; i < total; i++) {
            System.out.println(estoque[i]);
        }
    }

    private static int buscarIndice(int codigo) {
        for (int i = 0; i < total; i++) {
            if (estoque[i].getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }
}
