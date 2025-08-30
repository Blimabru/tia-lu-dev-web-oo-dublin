package com.fooddelivery.view;

import java.util.Scanner;
import java.util.List;
import com.fooddelivery.service.PedidoService;
import com.fooddelivery.util.Input;
import com.fooddelivery.service.ClienteService;
import com.fooddelivery.service.CardapioService;
import com.fooddelivery.model.Pedido;
import com.fooddelivery.model.Cliente;
import com.fooddelivery.model.ItemCardapio;
import com.fooddelivery.model.Pedido.StatusPedido;

public class MenuPedido {

    // Registrar novo pedido
    public static void registrarPedido(Scanner teclado, PedidoService pedidoService, ClienteService clienteService, CardapioService cardapioService) {
        System.out.println("\n=== REGISTRAR NOVO PEDIDO ===\n");

        // 1. Verificar se existem clientes
        if (clienteService.listarClientes().isEmpty()) {
            System.out.println("Nenhum cliente cadastrado! Cadastre um cliente primeiro.");
            System.out.println("\nPressione Enter para continuar...");
            teclado.nextLine();
            return;
        }

        // 2. Verificar se existem itens no cardápio
        if (cardapioService.listarCardapio().isEmpty()) {
            System.out.println("Nenhum item no cardápio! Cadastre itens primeiro.");
            System.out.println("\nPressione Enter para continuar...");
            teclado.nextLine();
            return;
        }

        // 3. Selecionar cliente
        System.out.println("Clientes disponíveis:");
        for (Cliente cliente : clienteService.listarClientes()) {
            System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome() + " | Telefone: " + cliente.getTelefone());
        }

        System.out.print("\nInforme o ID do cliente: ");
        int idCliente = teclado.nextInt();
        Input.limparBuffer(teclado);

        Cliente cliente = clienteService.buscarClientePorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            System.out.println("\nPressione Enter para continuar...");
            teclado.nextLine();
            return;
        }

        // 4. Criar pedido
        Pedido pedido = pedidoService.criarPedido(cliente);
        System.out.println("\nPedido #" + pedido.getId() + " criado para " + cliente.getNome());

        // 5. Adicionar itens ao pedido
        boolean continuarAdicionando = true;
        while (continuarAdicionando) {
            System.out.println("\n--- CARDÁPIO ---");
            for (ItemCardapio item : cardapioService.listarCardapio()) {
                System.out.println("ID: " + item.getId() + " | " + item.getNome() + " | R$ " + item.getPreco());
            }

            System.out.print("\nInforme o ID do item (0 para finalizar): ");
            int idItem = teclado.nextInt();
            
            if (idItem == 0) {
                continuarAdicionando = false;
                continue;
            }

            ItemCardapio itemCardapio = cardapioService.buscarItemPorId(idItem);
            if (itemCardapio == null) {
                System.out.println("Item não encontrado!");
                continue;
            }

            System.out.print("Quantidade: ");
            int quantidade = teclado.nextInt();
            Input.limparBuffer(teclado);

            if (quantidade <= 0) {
                System.out.println("Quantidade deve ser maior que zero!");
                continue;
            }

            String resultado = pedidoService.adicionarItemAoPedido(pedido.getId(), itemCardapio, quantidade);
            System.out.println(resultado);
        }

        // 6. Finalizar pedido
        if (pedido.getItens().isEmpty()) {
            System.out.println("Pedido cancelado - nenhum item adicionado.");
        } else {
            System.out.println("\n--- RESUMO DO PEDIDO ---");
            System.out.println("Pedido #" + pedido.getId());
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("Total: R$ " + pedido.calcularTotal());
            System.out.println("Status: " + pedido.getStatus());
            System.out.println("\nPedido registrado com sucesso!");
        }

        System.out.println("\nPressione Enter para continuar...");
        teclado.nextLine();
    }

    // Atualizar status do pedido
    public static void atualizarEstado(Scanner teclado, PedidoService pedidoService) {
        System.out.println("\n=== ATUALIZAR STATUS PEDIDO ===\n");

        List<Pedido> pedidos = pedidoService.listarTodosPedidos();
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado!");
            System.out.println("\nPressione Enter para continuar...");
            teclado.nextLine();
            return;
        }

        // Mostrar pedidos
        System.out.println("Pedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println("ID: " + pedido.getId() + " | Cliente: " + pedido.getCliente().getNome() + 
                             " | Status: " + pedido.getStatus() + " | Total: R$ " + pedido.calcularTotal());
        }

        System.out.print("\nInforme o ID do pedido: ");
        int idPedido = teclado.nextInt();
        Input.limparBuffer(teclado);

        Pedido pedido = pedidoService.buscarPedidoPorId(idPedido);
        if (pedido == null) {
            System.out.println("Pedido não encontrado!");
            System.out.println("\nPressione Enter para continuar...");
            teclado.nextLine();
            return;
        }

        // Mostrar status atual e próximo status possível
        System.out.println("\nStatus atual: " + pedido.getStatus());
        StatusPedido proximoStatus = getProximoStatus(pedido.getStatus());
        
        if (proximoStatus != null) {
            System.out.println("Próximo status possível: " + proximoStatus);
            System.out.print("Deseja atualizar para o próximo status? (s/n): ");
            String resposta = teclado.nextLine().toLowerCase();
            
            if (resposta.equals("s") || resposta.equals("sim")) {
                String resultado = pedidoService.atualizarStatusPedido(idPedido, proximoStatus);
                System.out.println(resultado);
            } else {
                System.out.println("Status não alterado.");
            }
        } else {
            System.out.println("Pedido já está no status final (ENTREGUE).");
        }

        System.out.println("\nPressione Enter para continuar...");
        teclado.nextLine();
    }

    // Consultar pedidos por status
    public static void consultarPedidoPorStatus(Scanner teclado, PedidoService pedidoService) {
        System.out.println("\n=== CONSULTAR PEDIDOS POR STATUS ===\n");

        System.out.println("Status disponíveis:");
        StatusPedido[] statuses = StatusPedido.values();
        for (int i = 0; i < statuses.length; i++) {
            System.out.println((i + 1) + " - " + statuses[i]);
        }

        System.out.print("\nEscolha o status (1-" + statuses.length + "): ");
        int opcao = teclado.nextInt();
        Input.limparBuffer(teclado);

        if (opcao < 1 || opcao > statuses.length) {
            System.out.println("Opção inválida!");
            System.out.println("\nPressione Enter para continuar...");
            teclado.nextLine();
            return;
        }

        StatusPedido statusSelecionado = statuses[opcao - 1];
        List<Pedido> pedidos = pedidoService.listarPedidosPorStatus(statusSelecionado);

        System.out.println("\nPedidos com status " + statusSelecionado + ":");
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido encontrado com este status.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println("ID: " + pedido.getId() + 
                                 " | Cliente: " + pedido.getCliente().getNome() + 
                                 " | Data: " + pedido.getDataHora() + 
                                 " | Total: R$ " + pedido.calcularTotal());
            }
        }

        System.out.println("\nPressione Enter para continuar...");
        teclado.nextLine();
    }

    // Método auxiliar para obter próximo status
    private static StatusPedido getProximoStatus(StatusPedido statusAtual) {
        switch (statusAtual) {
            case ACEITO:
                return StatusPedido.PREPARANDO;
            case PREPARANDO:
                return StatusPedido.FEITO;
            case FEITO:
                return StatusPedido.AGUARDANDO_ENTREGADOR;
            case AGUARDANDO_ENTREGADOR:
                return StatusPedido.SAIU_PARA_ENTREGA;
            case SAIU_PARA_ENTREGA:
                return StatusPedido.ENTREGUE;
            case ENTREGUE:
                return null;
            default:
                return null;
        }
    }
}
