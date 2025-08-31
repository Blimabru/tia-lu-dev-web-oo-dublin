package com.fooddelivery.util;

import java.util.Scanner;

/**
 * Classe utilitária para operações relacionadas à entrada de dados do usuário.
 * 
 * Esta classe fornece métodos auxiliares para manipulação de objetos Scanner,
 * especialmente para resolver problemas comuns de leitura de entrada mista
 * (números seguidos de strings) que podem deixar caracteres residuais no
 * buffer.
 */
public class Input {

    /**
     * Limpa o buffer do Scanner removendo caracteres residuais.
     * 
     * Este método é útil quando se faz leitura mista de dados (números e strings)
     * com Scanner. Após ler um número com nextInt() ou nextDouble(), pode sobrar
     * uma quebra de linha no buffer que interfere na próxima leitura de string.
     * Este método consome essa quebra de linha residual se ela existir.
     * 
     * Exemplo de uso:
     * 
     * - Scanner scanner = new Scanner(System.in);
     * - int numero = scanner.nextInt(); // Lê um número
     * - Input.limparBuffer(scanner); // Remove quebra de linha residual
     * - String texto = scanner.nextLine(); // Agora lê a string corretamente
     * 
     *
     * @param scanner Objeto Scanner cujo buffer deve ser limpo
     */
    public static void limparBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
