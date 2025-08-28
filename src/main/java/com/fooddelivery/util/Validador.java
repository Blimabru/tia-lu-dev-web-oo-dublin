package com.fooddelivery.util;

/**
 * Classe utilitária para validação e normalização de dados de entrada do
 * sistema.
 * 
 * Contém métodos que garantem a integridade e consistência de:
 * - Nomes de clientes;
 * - Números de telefone;
 * - Textos gerais.
 * 
 * Cada método realiza verificações específicas e lança exceções em caso de
 * dados inválidos.
 */

public class Validador {

    /**
     * Valida e normaliza o nome de um cliente.
     * 
     * Regras aplicadas:
     * 
     * - Não pode ser nulo ou vazio;
     * - Não pode conter números ou caracteres especiais;
     * - Remove espaços no início e no fim;
     * - Substitui múltiplos espaços consecutivos por um único espaço.
     * 
     *
     * @param nome Nome a ser validado
     * @return Nome normalizado
     * @throws IllegalArgumentException se o nome for inválido
     */

    public static String nomeCliente(String nome) {
        if (isNulo(nome)) {
            throw new IllegalArgumentException("Obrigatório inserir o nome");
        }
        if (!isAlfabetico(nome)) {
            throw new IllegalArgumentException(
                    "O nome não pode conter números ou quaisquer outros caracteres especiais");
        }
        return normalizarTexto(nome);
    }

    /**
     * Valida e normaliza um número de telefone.
     * 
     * Regras aplicadas:
     * 
     * - Não pode ser nulo ou vazio;
     * - Não pode conter letras ou símbolos não numéricos;
     * - Todos os caracteres que não sejam dígitos (0–9) são removidos;
     * - Deve conter no mínimo 11 dígitos (formato: DDD + número com 9 dígitos).
     * 
     *
     * @param telefone Número de telefone a ser validado
     * @return Número de telefone apenas com dígitos
     * @throws IllegalArgumentException se o número de telefone for inválido
     */

    public static String telefone(String telefone) {
        if (isNulo(telefone)) {
            throw new IllegalArgumentException("É obrigatório inserir o número de telefone");
        }
        if (isAlfabetico(telefone)) {
            throw new IllegalArgumentException(
                    "O telefone não pode conter letras, parentesis ou quaisquer outros caracteres especiais");
        }

        String numeroNormalizado = normalizarNumero(telefone);

        if (numeroNormalizado.length() < 10 || numeroNormalizado.length() > 11) {
            throw new IllegalArgumentException(
                    "Número de telefone inválido ou digitado incorretamente. Formato: 77900000000 (DDD + 8 ou 9 dígitos)");
        }
        return numeroNormalizado;
    }

    /**
     * Verifica se um texto é nulo ou vazio.
     *
     * @param texto Texto a ser verificado
     * @return {@code true} se o texto for nulo ou vazio, caso contrário
     *         {@code false}
     * @throws IllegalArgumentException se o texto for nulo ou vazio
     */

    public static boolean isNulo(String texto) {
        // Verifica se o texto é nulo
        if (texto == null || texto.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Verifica se um texto contém apenas caracteres alfabéticos e espaços.
     *
     * @param texto Texto a ser verificado
     * @return {@code true} se o texto for alfabético, caso contrário {@code false}
     */

    public static boolean isAlfabetico(String texto) {
        // Verifica se o texto contém apenas letras e espaços
        return texto.matches(".*[\\p{L}].*");
    }

    /**
     * Normaliza um texto removendo espaços extras.
     * 
     * Regras aplicadas:
     * 
     * - Remove espaços no início e no fim;
     * - Substitui múltiplos espaços consecutivos por um único espaço.
     * 
     *
     * @param texto Texto a ser normalizado
     * @return Texto normalizado
     */

    public static String normalizarTexto(String texto) {
        // Remove espaços extras no começo/fim e múltiplos espaços internos do texto
        String textoNormalizado = texto.trim().replaceAll("\\s+", " ");
        return textoNormalizado;
    }

    /**
     * Normaliza uma string numérica.
     * 
     * Regras aplicadas:
     * 
     * - Remove todos os caracteres que não sejam dígitos (0–9);
     * - Remove espaços no início e no fim.
     * 
     *
     * @param numero Texto contendo número a ser normalizado
     * @return String contendo apenas dígitos
     */

    public static String normalizarNumero(String numero) {
        // Remove tudo que não seja numérico (0–9)
        String numeroNormalizado = numero.trim().replaceAll("[^0-9]", "");
        return numeroNormalizado;
    }
}
