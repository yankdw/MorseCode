import java.util.Scanner;

/**
 * Classe principal para demonstrar a implementação da Árvore Binária com Código Morse
 */
public class MorseCodeMain {

    public static void main(String[] args) {
        // Inicializa a árvore Morse
        MorseCodeTree arvore = new MorseCodeTree();

        // Exibe a árvore
        arvore.exibirArvore();

        // Testes básicos
        System.out.println("\nTestes básicos:");
        System.out.println("Código Morse para 'S': " + arvore.buscarCodigoMorse('S'));
        System.out.println("Código Morse para 'O': " + arvore.buscarCodigoMorse('O'));
        System.out.println("Caractere para '...': " + arvore.buscar("..."));
        System.out.println("Caractere para '---': " + arvore.buscar("---"));

        // Tradução de mensagens
        System.out.println("\nTradução de 'SOS' para Morse: " + arvore.traduzirParaMorse("SOS"));
        System.out.println("Tradução de '... --- ...' para texto: " + arvore.traduzirParaTexto("... --- ..."));

        // Interface de usuário
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Traduzir texto para código Morse");
            System.out.println("2. Traduzir código Morse para texto");
            System.out.println("3. Buscar código Morse de um caractere");
            System.out.println("4. Buscar caractere de um código Morse");
            System.out.println("5. Exibir árvore");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o texto a ser traduzido: ");
                        String texto = scanner.nextLine();
                        System.out.println("Código Morse: " + arvore.traduzirParaMorse(texto));
                        break;
                    case 2:
                        System.out.print("Digite o código Morse (use espaço entre letras e / entre palavras): ");
                        String morse = scanner.nextLine();
                        System.out.println("Texto: " + arvore.traduzirParaTexto(morse));
                        break;
                    case 3:
                        System.out.print("Digite um caractere: ");
                        char c = scanner.nextLine().charAt(0);
                        System.out.println("Código Morse: " + arvore.buscarCodigoMorse(c));
                        break;
                    case 4:
                        System.out.print("Digite um código Morse: ");
                        String codigo = scanner.nextLine();
                        System.out.println("Caractere: " + arvore.buscar(codigo));
                        break;
                    case 5:
                        arvore.exibirArvore();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: entrada inválida!");
                scanner.nextLine(); // Limpa o buffer
                opcao = -1;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
