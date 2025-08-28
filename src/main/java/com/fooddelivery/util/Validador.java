package com.fooddelivery.util;

public class Validador {

    /**
     * Valida um nome próprio.
     * Este método garante que o nome fornecido:
     * - Não seja nulo;
     * - Não esteja vazio;
     * - Não contenha números ou caracteres especiais.
     * - Remove espaços no início e no fim;
     * - Converte múltiplos espaços consecutivos em um único espaço
     *
     * @param nome O nome da pessoa a ser validado
     * @return O nome normalizado (trim)
     * @throws IllegalArgumentException se o nome for inválido
     */

    public static String validarNome(String nome) {

        // Verifica se o nome não é nulo
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Obrigatório inserir o nome.");
        }

        // Remove espaços extras no começo/fim e múltiplos espaços internos
        String nomeNormalizado = nome.trim().replaceAll("\\s+", " ");

        // Verifica se contém apenas letras e espaços
        if (!nome.matches("[\\p{L}\\s]+")) {
            throw new IllegalArgumentException("O nome não pode conter números ou caracteres especiais.");
        }

        return nomeNormalizado;
    }
}
