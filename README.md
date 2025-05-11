# Implementação de Árvore Binária com Código Morse

## Descrição do Projeto

Este projeto implementa uma árvore binária onde cada nó corresponde a um símbolo do código Morse. O código Morse é um método de codificação de texto que utiliza pontos (.) e traços (-) para representar caracteres alfanuméricos. O objetivo é representar cada letra do alfabeto e os números de 0 a 9 em uma árvore binária, onde cada caminho da raiz a um nó folha descreve a sequência de pontos e traços correspondente.

## Estrutura da Árvore

A árvore binária é estruturada da seguinte forma:

- A raiz é um nó vazio (sem caractere)
- Cada nó pode ter dois filhos: esquerdo e direito
- O filho esquerdo representa um ponto (.)
- O filho direito representa um traço (-)
- Cada nó folha (ou nó intermediário com caractere) armazena um caractere alfanumérico

Por exemplo, para encontrar o caractere 'A' (representado por '.-' em código Morse), partimos da raiz, seguimos para a esquerda (ponto) e depois para a direita (traço).

## Estrutura do Código

O projeto é composto por duas classes principais:

### 1. MorseCodeTree

Esta classe implementa a árvore binária e contém:

- Uma classe interna `Nodo` que representa cada nó da árvore
- Métodos para inicializar a árvore e inserir caracteres
- Métodos para buscar caracteres a partir do código Morse
- Métodos para buscar o código Morse a partir de caracteres
- Métodos para traduzir mensagens entre texto e código Morse
- Método para exibir a estrutura hierárquica da árvore
- Métodos auxiliares para manipulação de strings

### 2. MorseCodeMain

Esta classe contém o método `main` e implementa:

- Inicialização da árvore Morse
- Testes básicos de funcionalidade
- Interface de usuário via console
- Menu interativo para utilização do programa

## Restrições de Implementação

Este projeto foi desenvolvido seguindo restrições específicas:

1. **Uso limitado de funções prontas**: Apenas String, int, float, try-catch e algumas funções de input podem ser utilizadas.
2. **Uso restrito de length()**: O método length() só pode ser utilizado na manipulação de String.
3. **Proibição de estruturas de dados complexas**: Não é permitido o uso de funções automatizadas como list, arrays (exceto o básico necessário), tipos abstratos, StringBuilder, etc.

Devido a estas restrições, várias funcionalidades básicas foram implementadas manualmente, como:
- Divisão de strings (equivalente ao split)
- Contagem de elementos em arrays
- Concatenação de strings

## Funcionalidades

O programa oferece as seguintes funcionalidades:

1. **Inserção de caracteres**: Cada letra do alfabeto e número é inserido na árvore de acordo com sua representação em código Morse.
2. **Busca de caracteres**: É possível buscar qualquer letra ou número na árvore e retornar sua representação em código Morse.
3. **Exibição da árvore**: A árvore é exibida de maneira hierárquica, mostrando claramente a estrutura de cada subárvore.
4. **Tradução de mensagens**: O programa permite traduzir mensagens de texto para código Morse e vice-versa.
5. **Interface interativa**: Uma interface de console permite ao usuário interagir com todas as funcionalidades do programa.

## Como Compilar e Executar

Para compilar o projeto, utilize o seguinte comando:

```bash
javac MorseCodeTree.java MorseCodeMain.java
