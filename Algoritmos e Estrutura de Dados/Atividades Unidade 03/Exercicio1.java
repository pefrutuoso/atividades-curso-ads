public class Exercicio1 {

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

    static class Arvore {
        No raiz;

        void inserir(int codigo, String titulo, String autor) {
            raiz = inserirNo(raiz, codigo, titulo, autor);
        }

        No inserirNo(No atual, int codigo, String titulo, String autor) {
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
                System.out.println("Codigo ja cadastrado: " + codigo);
            }

            return atual;
        }

        void exibirLivro(No no) {
            System.out.println(
                no.codigo + " - " + no.titulo + " - " + no.autor
            );
        }

        void preOrdem(No no) {
            if (no != null) {
                exibirLivro(no);
                preOrdem(no.esquerdo);
                preOrdem(no.direito);
            }
        }

        void emOrdem(No no) {
            if (no != null) {
                emOrdem(no.esquerdo);
                exibirLivro(no);
                emOrdem(no.direito);
            }
        }

        void posOrdem(No no) {
            if (no != null) {
                posOrdem(no.esquerdo);
                posOrdem(no.direito);
                exibirLivro(no);
            }
        }
    }

    public static void main(String[] args) {
        Arvore biblioteca = new Arvore();

        biblioteca.inserir(20, "Dom Casmurro", "Machado de Assis");
        biblioteca.inserir(10, "O Cortico", "Aluisio Azevedo");
        biblioteca.inserir(30, "Iracema", "Jose de Alencar");

        System.out.println("=== Pre-ordem ===");
        biblioteca.preOrdem(biblioteca.raiz);

        System.out.println("\n=== Em ordem ===");
        biblioteca.emOrdem(biblioteca.raiz);

        System.out.println("\n=== Pos-ordem ===");
        biblioteca.posOrdem(biblioteca.raiz);
    }
}