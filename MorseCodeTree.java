/**
 * Implementação de Árvore Binária com Código Morse
 * Esta classe implementa uma árvore binária para representar o código Morse,
 * onde cada caminho da raiz a um nó folha representa um caractere.
 */
public class MorseCodeTree {

    // Classe interna para representar um nó da árvore
    private class Nodo {
        char caractere; // Caractere armazenado no nó
        Nodo esquerda;  // Filho esquerdo (representa ponto '.')
        Nodo direita;   // Filho direito (representa traço '-')

        // Construtor do nó
        public Nodo(char caractere) {
            this.caractere = caractere;
            this.esquerda = null;
            this.direita = null;
        }
    }

    private Nodo raiz; // Raiz da árvore

    // Construtor da árvore
    public MorseCodeTree() {
        inicializar();
        inserirTodosCaracteres();
    }

    // Inicializa a árvore com um nó raiz vazio
    public void inicializar() {
        raiz = new Nodo('\0'); // Caractere nulo para a raiz
    }

    // Insere um caractere na árvore de acordo com seu código Morse
    public void inserir(String codigoMorse, char caractere) {
        Nodo atual = raiz;

        // Percorre o código Morse para encontrar a posição correta
        for (int i = 0; i < tamanhoString(codigoMorse); i++) {
            char simbolo = caracterNaPosicao(codigoMorse, i);

            if (simbolo == '.') {
                // Se o símbolo for um ponto, vai para a esquerda
                if (atual.esquerda == null) {
                    atual.esquerda = new Nodo('\0');
                }
                atual = atual.esquerda;
            } else if (simbolo == '-') {
                // Se o símbolo for um traço, vai para a direita
                if (atual.direita == null) {
                    atual.direita = new Nodo('\0');
                }
                atual = atual.direita;
            }
        }

        // Insere o caractere no nó encontrado
        atual.caractere = caractere;
    }

    // Busca um caractere na árvore de acordo com seu código Morse
    public char buscar(String codigoMorse) {
        Nodo atual = raiz;

        // Percorre o código Morse para encontrar o caractere
        for (int i = 0; i < tamanhoString(codigoMorse); i++) {
            char simbolo = caracterNaPosicao(codigoMorse, i);

            if (simbolo == '.') {
                // Se o símbolo for um ponto, vai para a esquerda
                if (atual.esquerda == null) {
                    return '\0'; // Caractere não encontrado
                }
                atual = atual.esquerda;
            } else if (simbolo == '-') {
                // Se o símbolo for um traço, vai para a direita
                if (atual.direita == null) {
                    return '\0'; // Caractere não encontrado
                }
                atual = atual.direita;
            } else if (simbolo == ' ') {
                // Ignora espaços
                continue;
            }
        }

        return atual.caractere;
    }

    // Busca o código Morse para um caractere
    public String buscarCodigoMorse(char caractere) {
        return buscarCodigoMorseRecursivo(raiz, caractere, "");
    }

    // Método recursivo para buscar o código Morse de um caractere
    private String buscarCodigoMorseRecursivo(Nodo nodo, char caractere, String codigoAtual) {
        if (nodo == null) {
            return "";
        }

        // Se encontrou o caractere, retorna o código atual
        if (nodo.caractere == caractere) {
            return codigoAtual;
        }

        // Busca no filho esquerdo (ponto)
        String codigoEsquerda = buscarCodigoMorseRecursivo(nodo.esquerda, caractere, concatenar(codigoAtual, "."));
        if (tamanhoString(codigoEsquerda) > 0) {
            return codigoEsquerda;
        }

        // Busca no filho direito (traço)
        String codgoDireita = buscarCodigoMorseRecursivo(nodo.direita, caractere, concatenar(codigoAtual, "-"));
        return codgoDireita;
    }

    // Exibe a árvore de forma hierárquica
    public void exibirArvore() {
        System.out.println("Estrutura da Árvore Morse:");
        exibirArvoreRecursivo(raiz, "", true);
    }

    // Método recursivo para exibir a árvore
    private void exibirArvoreRecursivo(Nodo nodo, String prefixo, boolean ehUltimo) {
        if (nodo == null) {
            return;
        }

        System.out.print(prefixo);

        if (ehUltimo) {
            System.out.print("└── ");
            prefixo = concatenar(prefixo, "    ");
        } else {
            System.out.print("├── ");
            prefixo = concatenar(prefixo, "│   ");
        }

        String valorNodo = nodo.caractere == '\0' ? "null" : String.valueOf(nodo.caractere);
        System.out.println(valorNodo);

        exibirArvoreRecursivo(nodo.esquerda, prefixo, nodo.direita == null);
        exibirArvoreRecursivo(nodo.direita, prefixo, true);
    }

    // Traduz uma mensagem em texto para código Morse
    public String traduzirParaMorse(String mensagem) {
        String resultado = "";

        for (int i = 0; i < tamanhoString(mensagem); i++) {
            char c = caracterNaPosicao(mensagem, i);

            // Converte para maiúscula se for letra
            if (c >= 'a' && c <= 'z') {
                c = (char)(c - 32);
            }

            if (c == ' ') {
                resultado = concatenar(resultado, "/ ");
            } else {
                String codigoMorse = buscarCodigoMorse(c);
                if (tamanhoString(codigoMorse) > 0) {
                    resultado = concatenar(resultado, codigoMorse);
                    resultado = concatenar(resultado, " ");
                }
            }
        }

        return resultado;
    }

    // Traduz uma mensagem em código Morse para texto
    public String traduzirParaTexto(String codigoMorse) {
        String resultado = "";
        String[] palavras = dividirString(codigoMorse, "/");

        for (int i = 0; i < tamanhoArray(palavras); i++) {
            String palavra = palavras[i];
            String[] letras = dividirString(palavra, " ");

            for (int j = 0; j < tamanhoArray(letras); j++) {
                String letra = letras[j];
                if (tamanhoString(letra) > 0) {
                    char c = buscar(letra);
                    if (c != '\0') {
                        resultado = concatenar(resultado, String.valueOf(c));
                    }
                }
            }

            if (i < tamanhoArray(palavras) - 1) {
                resultado = concatenar(resultado, " ");
            }
        }

        return resultado;
    }

    // Insere todos os caracteres do código Morse na árvore
    private void inserirTodosCaracteres() {
        // Letras
        inserir(".-", 'A');
        inserir("-...", 'B');
        inserir("-.-.", 'C');
        inserir("-..", 'D');
        inserir(".", 'E');
        inserir("..-.", 'F');
        inserir("--.", 'G');
        inserir("....", 'H');
        inserir("..", 'I');
        inserir(".---", 'J');
        inserir("-.-", 'K');
        inserir(".-..", 'L');
        inserir("--", 'M');
        inserir("-.", 'N');
        inserir("---", 'O');
        inserir(".--.", 'P');
        inserir("--.-", 'Q');
        inserir(".-.", 'R');
        inserir("...", 'S');
        inserir("-", 'T');
        inserir("..-", 'U');
        inserir("...-", 'V');
        inserir(".--", 'W');
        inserir("-..-", 'X');
        inserir("-.--", 'Y');
        inserir("--..", 'Z');

        // Números
        inserir("-----", '0');
        inserir(".----", '1');
        inserir("..---", '2');
        inserir("...--", '3');
        inserir("....-", '4');
        inserir(".....", '5');
        inserir("-....", '6');
        inserir("--...", '7');
        inserir("---..", '8');
        inserir("----.", '9');
    }

    // Métodos auxiliares para manipulação de strings (sem usar funções prontas)

    // Retorna o tamanho de uma string
    private int tamanhoString(String str) {
        return str.length();
    }

    // Retorna o caractere na posição especificada
    private char caracterNaPosicao(String str, int posicao) {
        return str.charAt(posicao);
    }

    // Concatena duas strings
    private String concatenar(String str1, String str2) {
        return str1 + str2;
    }

    // Divide uma string pelo delimitador
    private String[] dividirString(String str, String delimitador) {
        // Implementação manual de split
        int contador = 1;

        // Conta quantas partes terá o array
        for (int i = 0; i < tamanhoString(str); i++) {
            boolean encontrouDelimitador = true;

            // Verifica se encontrou o delimitador
            for (int j = 0; j < tamanhoString(delimitador) && i + j < tamanhoString(str); j++) {
                if (caracterNaPosicao(str, i + j) != caracterNaPosicao(delimitador, j)) {
                    encontrouDelimitador = false;
                    break;
                }
            }

            if (encontrouDelimitador) {
                contador++;
                i += tamanhoString(delimitador) - 1;
            }
        }

        // Cria o array de strings
        String[] resultado = new String[contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = "";
        }

        // Preenche o array
        int indiceAtual = 0;
        for (int i = 0; i < tamanhoString(str); i++) {
            boolean encontrouDelimitador = true;

            // Verifica se encontrou o delimitador
            for (int j = 0; j < tamanhoString(delimitador) && i + j < tamanhoString(str); j++) {
                if (caracterNaPosicao(str, i + j) != caracterNaPosicao(delimitador, j)) {
                    encontrouDelimitador = false;
                    break;
                }
            }

            if (encontrouDelimitador) {
                indiceAtual++;
                i += tamanhoString(delimitador) - 1;
            } else {
                resultado[indiceAtual] = concatenar(resultado[indiceAtual], String.valueOf(caracterNaPosicao(str, i)));
            }
        }

        return resultado;
    }

    // Retorna o tamanho de um array
    private int tamanhoArray(String[] array) {
        int contador = 0;
        try {
            while (true) {
                String temp = array[contador];
                contador++;
            }
        } catch (Exception e) {
            // Chegou ao fim do array
        }
        return contador;
    }
}
