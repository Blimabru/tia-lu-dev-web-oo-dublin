/**
 * Esse arquivo atualmente só serve para testes dos métodos implementados.
 */

package com.fooddelivery;

import com.fooddelivery.view.TelaInicial;

public class Main {
    public static void main(String args[]) {

        // Tenta configurar o terminal para usar caracteres UTF-8:
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            // Se falhar, ignora configuração e continua execução da aplicação
            System.err.println("Erro ao configurar terminal para utilizar UTF-8: " + e.getMessage());
        }

        TelaInicial.exibir();

        int opcaoEscolhida = 0;

        switch (opcaoEscolhida) {
            // GERENCIAMENTO DE CARDÁPIO
            case 1:
                System.out.println("Cadastrando novo item no cardápio...");
                break;
            case 2:
                System.out.println("Listando itens do cardápio...");
                break;

            // GERENCIAMENTO DE CLIENTES
            case 3:
                System.out.println("Cadastrando novo cliente...");
                break;
            case 4:
                System.out.println("Listando clientes cadastrados...");
                break;

            // GERENCIAMENTO DE PEDIDOS
            case 5:
                System.out.println("Registrando novo pedido...");
                break;
            case 6:
                System.out.println("Atualizando status do pedido...");
                break;
            case 7:
                System.out.println("Consultando pedidos por status...");
                break;

            // RELATÓRIOS
            case 8:
                System.out.println("Gerando relatório simplificado...");
                break;
            case 9:
                System.out.println("Gerando relatório detalhado...");
                break;

            // ENCERRAR SISTEMA
            case 10:
                System.out.println("Encerrando sistema...");
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }

    }
}
