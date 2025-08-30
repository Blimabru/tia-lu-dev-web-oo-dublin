/**
 * Classe principal do sistema FoodDelivery.
 * Responsável por inicializar o sistema e gerenciar o menu principal.
 */

package com.fooddelivery;

import java.util.Scanner;
import com.fooddelivery.service.ClienteService;
import com.fooddelivery.service.CardapioService;
import com.fooddelivery.service.PedidoService;
import com.fooddelivery.util.Input;
import com.fooddelivery.view.TelaInicial;
import com.fooddelivery.view.MenuCardapio;
import com.fooddelivery.view.MenuCliente;
import com.fooddelivery.view.MenuPedido;

public class Main {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String args[]) {
        ClienteService clienteService = new ClienteService();
        CardapioService cardapioService = new CardapioService();
        PedidoService pedidoService = new PedidoService();

        int opcaoEscolhida;

        do {
            TelaInicial.exibir();
            opcaoEscolhida = teclado.nextInt();
            Input.limparBuffer(teclado);

            switch (opcaoEscolhida) {
                // GERENCIAMENTO DE CARDÁPIO
                case 1:
                    MenuCardapio.cadastrarItem(teclado, cardapioService);
                    break;
                case 2:
                    MenuCardapio.listarItens(teclado, cardapioService);
                    break;

                // GERENCIAMENTO DE CLIENTES
                case 3:
                    MenuCliente.cadastrarCliente(teclado, clienteService);
                    break;
                case 4:
                    MenuCliente.listarClientes(teclado, clienteService);
                    break;

                // GERENCIAMENTO DE PEDIDOS
                case 5:
                    MenuPedido.registrarPedido(teclado, pedidoService);
                    break;
                case 6:
                    MenuPedido.atualizarEstado(teclado, pedidoService);
                    break;
                case 7:
                    MenuPedido.consultarPedidoPorStatus(teclado, pedidoService);
                    break;

                // RELATÓRIOS
                case 8:
                    MenuRelatorio.relatorioSimplificado(teclado, relatorioService);
                    break;
                case 9:
                    MenuRelatorio.relatorioDetalhado(teclado, relatorioService);
                    break;

                // ENCERRAR SISTEMA
                case 10:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida");

                    System.out.println("\nPressione Enter para continuar...");
                    teclado.nextLine();
                    break;
            }
        } while (opcaoEscolhida != 10);

    }
}
