package com.fooddelivery;

import java.util.Scanner;
import com.fooddelivery.service.CentralDados;
import com.fooddelivery.util.Input;
import com.fooddelivery.view.TelaInicial;
import com.fooddelivery.view.MenuCardapio;
import com.fooddelivery.view.MenuCliente;
import com.fooddelivery.view.MenuPedido;
import com.fooddelivery.view.MenuRelatorio;

/**
 * Classe principal do sistema FoodDelivery.
 * 
 * Esta classe contém o método main que serve como ponto de entrada da
 * aplicação.
 * Gerencia o loop principal do sistema, exibindo o menu inicial e direcionando
 * as operações para as classes de view apropriadas baseado na escolha do
 * usuário.
 * Utiliza o padrão Singleton através da CentralDados para acessar todos os
 * serviços.
 */
public class Main {

    /** Scanner global para leitura de entrada do usuário */
    private static Scanner teclado = new Scanner(System.in);

    /**
     * Método principal que inicia a execução do sistema FoodDelivery.
     * 
     * Implementa o loop principal da aplicação que:
     * 1. Obtém a instância única da CentralDados (padrão Singleton)
     * 2. Exibe o menu inicial repetidamente
     * 3. Lê a opção escolhida pelo usuário
     * 4. Direciona para a funcionalidade correspondente
     * 5. Continua até que o usuário escolha sair (opção 10)
     * 
     * O sistema está organizado em categorias:
     * - Opções 1-2: Gerenciamento de Cardápio
     * - Opções 3-4: Gerenciamento de Clientes
     * - Opções 5-7: Gerenciamento de Pedidos
     * - Opções 8-9: Relatórios
     * - Opção 10: Encerramento
     *
     * @param args Argumentos da linha de comando (não utilizados)
     */
    public static void main(String args[]) {
        // Usar a central de dados única (padrão Singleton)
        CentralDados centralDados = CentralDados.getInstancia();

        int opcaoEscolhida;

        // Loop principal do sistema
        do {
            // Exibir menu inicial
            TelaInicial.exibir();
            opcaoEscolhida = teclado.nextInt();
            Input.limparBuffer(teclado);

            // Processar opção escolhida
            switch (opcaoEscolhida) {
                // GERENCIAMENTO DE CARDÁPIO
                case 1:
                    MenuCardapio.cadastrarItem(teclado, centralDados.getCardapioService());
                    break;
                case 2:
                    MenuCardapio.listarItens(teclado, centralDados.getCardapioService());
                    break;

                // GERENCIAMENTO DE CLIENTES
                case 3:
                    MenuCliente.cadastrarCliente(teclado, centralDados.getClienteService());
                    break;
                case 4:
                    MenuCliente.listarClientes(teclado, centralDados.getClienteService());
                    break;

                // GERENCIAMENTO DE PEDIDOS
                case 5:
                    MenuPedido.registrarPedido(teclado, centralDados.getPedidoService(),
                            centralDados.getClienteService(),
                            centralDados.getCardapioService());
                    break;
                case 6:
                    MenuPedido.atualizarEstado(teclado, centralDados.getPedidoService());
                    break;
                case 7:
                    MenuPedido.consultarPedidoPorStatus(teclado, centralDados.getPedidoService());
                    break;

                // RELATÓRIOS
                case 8:
                    MenuRelatorio.relatorioSimplificado(teclado, centralDados.getRelatorioService());
                    break;
                case 9:
                    MenuRelatorio.relatorioDetalhado(teclado, centralDados.getRelatorioService());
                    break;

                // ENCERRAR SISTEMA
                case 10:
                    System.out.println("Encerrando sistema...");
                    break;

                // OPÇÃO INVÁLIDA
                default:
                    System.out.println("Opção inválida! Escolha uma opção de 1 a 10.");
                    System.out.println("\nPressione Enter para continuar...");
                    teclado.nextLine();
                    break;
            }
        } while (opcaoEscolhida != 10);

        // Fechar recursos
        teclado.close();
        System.out.println("Sistema encerrado com sucesso!");
    }
}
