public class Exercicio1 {

    // Cada objeto No representa um livro na arvore.
    static class No {
        int codigo;
        String titulo;
        String autor;

        No esquerdo;
        No direito;

        No(int codigo, String titulo, String autor) {
            this.codigo = codigo;
            this.titulo = titulo;
            this.autor = autor;
        }
    }

    static class ArvoreLivros {
        No raiz;

        // Insere um livro e atualiza a raiz, se necessario.
        void inserir(int codigo, String titulo, String autor) {
            raiz = inserirNo(raiz, codigo, titulo, autor);
        }

        No inserirNo(
                No atual, int codigo, String titulo, String autor) {

            // Uma posicao vazia pode receber o novo livro.
            if (atual == null) {
                return new No(codigo, titulo, autor);
            }

            if (codigo < atual.codigo) {
                atual.esquerdo = inserirNo(
                    atual.esquerdo, codigo, titulo, autor
                );
            } else if (codigo > atual.codigo) {
                atual.direito = inserirNo(
                    atual.direito, codigo, titulo, autor
                );
            } else {
                // Esta versao nao permite codigos repetidos.
                System.out.println("Codigo ja cadastrado: " + codigo);
            }

            return atual;
        }

        void exibirLivro(No no) {
            System.out.println(
                no.codigo + " - " + no.titulo + " - " + no.autor
            );
        }

        // Pre-ordem: raiz, esquerda, direita.
        void preOrdem(No no) {
            if (no != null) {
                exibirLivro(no);
                preOrdem(no.esquerdo);
                preOrdem(no.direito);
            }
        }

        // Em ordem: esquerda, raiz, direita.
        void emOrdem(No no) {
            if (no != null) {
                emOrdem(no.esquerdo);
                exibirLivro(no);
                emOrdem(no.direito);
            }
        }

        // Pos-ordem: esquerda, direita, raiz.
        void posOrdem(No no) {
            if (no != null) {
                posOrdem(no.esquerdo);
                posOrdem(no.direito);
                exibirLivro(no);
            }
        }
    }

    public static void main(String[] args) {
        ArvoreLivros arvore = new ArvoreLivros();

        arvore.inserir(20, "Java Basico", "Ana");
        arvore.inserir(10, "Logica de Programacao", "Carlos");
        arvore.inserir(30, "Estrutura de Dados", "Mariana");

        System.out.println("=== Pre-ordem ===");
        arvore.preOrdem(arvore.raiz);

        System.out.println("\n=== Em ordem ===");
        arvore.emOrdem(arvore.raiz);

        System.out.println("\n=== Pos-ordem ===");
        arvore.posOrdem(arvore.raiz);
    }
}