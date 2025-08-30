package com.fooddelivery.util;

public class ConfiguraTerminal {
    public static void caracteres() {
        // Tenta configurar o terminal para usar caracteres UTF-8:
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            // Se falhar, ignora configuração e continua execução da aplicação
            System.err.println("Erro ao configurar terminal para utilizar UTF-8: " +
                    e.getMessage());
        }
    }
}
