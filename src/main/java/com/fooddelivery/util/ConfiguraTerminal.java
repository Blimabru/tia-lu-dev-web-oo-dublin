package com.fooddelivery.util;

/**
 * Classe utilitária para configuração do terminal e codificação de caracteres.
 * 
 * Esta classe fornece métodos para configurar adequadamente o terminal da
 * aplicação,
 * garantindo que caracteres especiais e acentos sejam exibidos corretamente.
 * É especialmente útil em ambientes onde a codificação padrão pode não suportar
 * caracteres UTF-8.
 */
public class ConfiguraTerminal {

    /**
     * Configura o terminal para usar codificação UTF-8.
     * 
     * Este método tenta configurar a saída padrão do sistema (System.out) para
     * utilizar codificação UTF-8, garantindo que caracteres especiais, acentos
     * e símbolos sejam exibidos corretamente no terminal. Se a configuração
     * falhar, a aplicação continua executando normalmente com a codificação padrão.
     * 
     * É recomendado chamar este método no início da aplicação, antes de qualquer
     * saída de texto que contenha caracteres especiais.
     */
    public static void caracteres() {
        try {
            // Configura a saída padrão para usar UTF-8 com auto-flush habilitado
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            // Se a codificação UTF-8 não for suportada, exibe erro mas continua execução
            System.err.println("Erro ao configurar terminal para utilizar UTF-8: " + e.getMessage());
            System.err.println("A aplicação continuará com a codificação padrão do sistema.");
        }
    }
}
