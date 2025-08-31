package com.fooddelivery.view;

/**
 * Classe responsável pela exibição da tela inicial do sistema de delivery.
 * 
 * Esta classe contém o método para apresentar o menu principal com arte ASCII
 * do logotipo "TIA LU" e todas as opções disponíveis no sistema, organizadas
 * por categorias funcionais. Faz parte da camada de apresentação (view) e
 * serve como ponto de entrada visual para o usuário.
 */
public class TelaInicial {

    /**
     * Exibe a tela inicial do sistema com o menu principal.
     * 
     * Apresenta uma interface visual atrativa com:
     * - Logotipo "TIA LU" em arte ASCII
     * - Lista completa de todas as funcionalidades disponíveis
     * - Organização por categorias (Cardápio, Clientes, Pedidos, Relatórios)
     * - Instruções para navegação do usuário
     * 
     * A tela é formatada com bordas e espaçamento para melhor legibilidade
     * no terminal.
     */
    public static void exibir() {
        System.out.println(
                        "┌─────────────────────────────────────────────────────────────────┐\r\n" + //
                        "│                                                                 │\r\n" + //
                        "│          ████████╗ ██╗    █████╗     ██╗     ██╗   ██╗          │\r\n" + //
                        "│          ╚══██╔══╝ ██║  ║██╔══██╗    ██║     ██║   ██║          │\r\n" + //
                        "│             ██║    ██║  ║███████║    ██║     ██║   ██║          │\r\n" + //
                        "│             ██║    ██║  ║██╔══██║    ██║     ██║   ██║          │\r\n" + //
                        "│             ██║    ██║  ║██║  ██║    ███████╗╚██████╔╝          │\r\n" + //
                        "│             ╚═╝    ╚═╝  ╚══╝  ╚═╝    ╚══════╝ ╚═════╝           │\r\n" + //
                        "│                                                                 │\r\n" + //
                        "│  Sistema de Delivery - Versão 1.0                               │\r\n" + //
                        "│  =============================================================  │\r\n" + //
                        "│                                                                 │\r\n" + //
                        "│  Funções disponíveis:                                           │\r\n" + //
                        "│                                                                 │\r\n" + //
                        "│  GERENCIAMENTO DE CARDÁPIO:                                     │\r\n" + //
                        "│    1 - Cadastrar Novo Item                                      │\r\n" + //
                        "│    2 - Listar Itens                                             │\r\n" + //
                        "│                                                                 │\r\n" + //
                        "│  GERENCIAMENTO DE CLIENTES:                                     │\r\n" + //
                        "│    3 - Cadastrar Novo Cliente                                   │\r\n" + //
                        "│    4 - Listar Clientes                                          |\r\n" + //
                        "│                                                                 │\r\n" + //
                        "│  GERENCIAMENTO DE PEDIDOS:                                      │\r\n" + //
                        "│    5 - Registrar Novo Pedido                                    │\r\n" + //
                        "│    6 - Atualizar Status Pedido                                  │\r\n" + //
                        "│    7 - Consultar Pedidos por Status                             │\r\n" + //
                        "│                                                                 │\r\n" + //
                        "│  RELATÓRIOS:                                                    │\r\n" + //
                        "│    8 - Relatório Simplificado                                   │\r\n" + //
                        "│    9 - Relatório Detalhado                                      │\r\n" + //
                        "│                                                                 │\r\n" + //
                        "│  ENCERRAR SISTEMA:                                              │\r\n" + //
                        "│   10 - Sair                                                     │\r\n" + //
                        "│                                                                 │\r\n" + //
                        "│                                                                 │\r\n" + //
                        "│ Insira o número da função desejada e tecle Enter:               │\r\n" + //
                        "│                                                                 │\r\n" + //
                        "└─────────────────────────────────────────────────────────────────┘");
    }
}
