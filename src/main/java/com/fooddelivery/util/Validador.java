package com.fooddelivery.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Classe utilitária para validação e normalização de dados de entrada do
 * sistema.
 * 
 * Contém métodos que garantem a integridade e consistência de:
 * - Nomes de clientes;
 * - Números de telefone;
 * - Textos gerais;
 * - Preços de produtos.
 * 
 * Cada método realiza verificações específicas e lança exceções em caso de
 * dados inválidos.
 */
public class Validador {

    /**
     * Valida e normaliza o nome de um cliente.
     * 
     * Regras aplicadas:
     * - Não pode ser nulo ou vazio;
     * - Não pode conter números ou caracteres especiais;
     * - Remove espaços no início e no fim;
     * - Substitui múltiplos espaços consecutivos por um único espaço.
     *
     * @param nome Nome a ser validado
     * @return Nome normalizado
     * @throws IllegalArgumentException se o nome for inválido
     */
    public static String nomeCliente(String nome) {
        if (isNulo(nome)) {
            throw new IllegalArgumentException("Insira o nome do cliente");
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
     * - Não pode ser nulo ou vazio;
     * - Não pode conter letras ou símbolos não numéricos;
     * - Todos os caracteres que não sejam dígitos (0–9) são removidos;
     * - Deve conter entre 10 e 11 dígitos (formato: DDD + número com 8 ou 9
     * dígitos).
     *
     * @param telefone Número de telefone a ser validado
     * @return Número de telefone apenas com dígitos
     * @throws IllegalArgumentException se o número de telefone for inválido
     */
    public static String telefone(String telefone) {
        if (isNulo(telefone)) {
            throw new IllegalArgumentException("Insira o número de telefone");
        }
        if (isAlfabetico(telefone)) {
            throw new IllegalArgumentException(
                    "O telefone não pode conter letras, parênteses ou quaisquer outros caracteres especiais");
        }

        String numeroNormalizado = normalizarNumero(telefone);

        if (numeroNormalizado.length() < 10 || numeroNormalizado.length() > 11) {
            throw new IllegalArgumentException(
                    "Número de telefone inválido ou digitado incorretamente. Formato: 77900000000 (DDD + 8 ou 9 dígitos)");
        }
        return numeroNormalizado;
    }

    /**
     * Valida e normaliza o nome de um item do cardápio.
     * 
     * Regras aplicadas:
     * - Não pode ser nulo ou vazio;
     * - Remove espaços no início e no fim;
     * - Substitui múltiplos espaços consecutivos por um único espaço.
     *
     * @param nome Nome do item a ser validado
     * @return Nome do item normalizado
     * @throws IllegalArgumentException se o nome for nulo ou vazio
     */
    public static String itemCardapio(String nome) {
        if (isNulo(nome)) {
            throw new IllegalArgumentException("Insira o nome do item");
        }
        return normalizarTexto(nome);
    }

    /**
     * Valida e normaliza o preço de um item.
     * 
     * Regras aplicadas:
     * - Não pode ser nulo;
     * - Não pode ser zero ou negativo;
     * - O valor é formatado para ter exatamente 2 casas decimais, utilizando o
     * arredondamento matemático convencional (para cima quando o dígito seguinte é
     * maior ou igual a 5, para baixo quando é menor que 5).
     *
     * @param preco Preço a ser validado
     * @return Preço normalizado com 2 casas decimais
     * @throws IllegalArgumentException se o preço for nulo ou menor/igual a zero
     */
    public static BigDecimal preco(BigDecimal preco) {
        if (preco == null) {
            throw new IllegalArgumentException("Insira o valor do item");
        }
        if (preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do item não pode ser zero ou negativo");
        }
        return preco.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Valida a quantidade de itens inseridos no pedido.
     * 
     * Regra aplicada:
     * - A quantidade não pode ser zero ou um valor negativo.
     * 
     * @param quantidade Quantidade a ser validada
     * @return Retorna a quantidade validada
     * @throws IllegalArgumentException caso a quantidade seja menor ou igual a zero
     */
    public static int quantidadePedido(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade de itens não pode ser menor ou igual a zero");
        }
        return quantidade;
    }

    /**
     * Verifica se um texto é nulo ou vazio.
     *
     * @param texto Texto a ser verificado
     * @return {@code true} se o texto for nulo ou vazio, {@code false} caso
     *         contrário
     */
    public static boolean isNulo(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    /**
     * Verifica se um texto contém apenas caracteres alfabéticos e espaços.
     *
     * @param texto Texto a ser verificado
     * @return {@code true} se o texto contiver ao menos um caractere alfabético,
     *         {@code false} caso contrário
     */
    public static boolean isAlfabetico(String texto) {
        return texto.matches(".*[\\p{L}].*");
    }

    /**
     * Normaliza um texto removendo espaços extras.
     * 
     * Regras aplicadas:
     * - Remove espaços no início e no fim;
     * - Substitui múltiplos espaços consecutivos por um único espaço.
     *
     * @param texto Texto a ser normalizado
     * @return Texto normalizado
     */
    public static String normalizarTexto(String texto) {
        return texto.trim().replaceAll("\\s+", " ");
    }

    /**
     * Normaliza uma string numérica.
     * 
     * Regras aplicadas:
     * - Remove todos os caracteres que não sejam dígitos (0–9);
     * - Remove espaços no início e no fim.
     *
     * @param numero Texto contendo número a ser normalizado
     * @return String contendo apenas dígitos
     */
    public static String normalizarNumero(String numero) {
        return numero.trim().replaceAll("[^0-9]", "");
    }
}
