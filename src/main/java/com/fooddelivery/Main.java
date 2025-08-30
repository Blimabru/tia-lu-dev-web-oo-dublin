/**
 * Classe principal do sistema FoodDelivery.
 * Responsável por inicializar o sistema e gerenciar o menu principal.
 */

package com.fooddelivery;

import java.util.Scanner;
import com.fooddelivery.service.CentralDados;
import com.fooddelivery.util.Input;
import com.fooddelivery.view.TelaInicial;
import com.fooddelivery.view.MenuCardapio;
import com.fooddelivery.view.MenuCliente;
import com.fooddelivery.view.MenuPedido;
import com.fooddelivery.view.MenuRelatorio;

public class Main {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String args[]) {
        // Usar a central de dados única
        CentralDados centralDados = CentralDados.getInstancia();

        int opcaoEscolhida;

        do {
            TelaInicial.exibir();
            opcaoEscolhida = teclado.nextInt();
            Input.limparBuffer(teclado);

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
                    MenuPedido.registrarPedido(teclado, centralDados.getPedidoService(), centralDados.getClienteService(), centralDados.getCardapioService());
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

                default:
                    System.out.println("Opcao invalida");

                    System.out.println("\nPressione Enter para continuar...");
                    teclado.nextLine();
                    break;
            }
        } while (opcaoEscolhida != 10);

    }
}
