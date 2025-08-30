/**
 * Esse arquivo atualmente só serve para testes dos métodos implementados.
 */

package com.fooddelivery;

import java.math.BigDecimal;
import com.fooddelivery.model.Cliente;
import com.fooddelivery.model.ItemCardapio;
import com.fooddelivery.model.ItemPedido;
import com.fooddelivery.service.ClienteService;
import com.fooddelivery.service.PedidoService;
import com.fooddelivery.service.CardapioService;
import com.fooddelivery.model.Pedido;
import com.fooddelivery.model.Pedido.StatusPedido;

public class Main {

    public static void main(String args[]) {

        ClienteService clientService = new ClienteService();
        CardapioService cardapioService = new CardapioService();
        PedidoService pedidoService = new PedidoService();

        System.out.println("-------------------------------");
        System.out.println("Cadastrando 5 clientes:");

        clientService.cadastrarCliente("Bruno", "77 9 8873 4773");
        clientService.cadastrarCliente("Claudio", "77 9 8815 1047");
        clientService.cadastrarCliente("Gabriel", "77 9 1234 5678");
        clientService.cadastrarCliente("Kéven", "77 9 8765 4321");
        clientService.cadastrarCliente("Artur", "77 9 9999 9999");

        System.out.println("--------------------------------------------------------");
        System.out.println("Lista de clientes cadastrados: (Total = " + clientService.listarClientes().size() + ")");
        System.out.println("--------------------------------------------------------");

        for (Cliente cliente : clientService.listarClientes()) {
            System.out.println("| ID: " + cliente.getId() + " | Nome: " + cliente.getNome() + " | Telefone: "
                    + cliente.getTelefone());
        }
        System.out.println("--------------------------------------------------------");

        System.out.println("\n\n-------------------------------");
        System.out.println("Cadastrando 5 itens no cardápio:");

        cardapioService.cadastrarItemCardapio("X-Burguer", new BigDecimal(42.00));
        cardapioService.cadastrarItemCardapio("Cola-Cola 1L", new BigDecimal(10.00));
        cardapioService.cadastrarItemCardapio("Batata Frita M", new BigDecimal(18.00));
        cardapioService.cadastrarItemCardapio("Fini", new BigDecimal(7.999));
        cardapioService.cadastrarItemCardapio("Picolé", new BigDecimal(3.996));

        System.out.println("--------------------------------------------------------");
        System.out.println(
                "Lista de itens cadastrados no cardápio: (Total = " + cardapioService.listarCardapio().size() + ")");
        System.out.println("--------------------------------------------------------");

        for (ItemCardapio itemCardapio : cardapioService.listarCardapio()) {
            System.out.println("| ID: " + itemCardapio.getId() + " | Item: " + itemCardapio.getNome() + " | Preço: "
                    + itemCardapio.getPreco());
        }
        System.out.println("--------------------------------------------------------");

        System.out.println("\n\n-------------------------------");
        System.out.println("Realizando 6 pedidos:");

        pedidoService.criarPedido(StatusPedido.ACEITO);
        pedidoService.criarPedido(StatusPedido.PREPARANDO);
        pedidoService.criarPedido(StatusPedido.FEITO);
        pedidoService.criarPedido(StatusPedido.AGUARDANDO_ENTREGADOR);
        pedidoService.criarPedido(StatusPedido.SAIU_PARA_ENTREGA);
        pedidoService.criarPedido(StatusPedido.ENTREGUE);

        System.out.println("--------------------------------------------------------");
        System.out.println("Lista de pedidos efetuados: (Total = " + pedidoService.listarPedidos().size() + ")");
        System.out.println("--------------------------------------------------------");

        for (Pedido pedido : pedidoService.listarPedidos()) {
            System.out.println("| ID: " + pedido.getId() + " | Data: " + pedido.getData() + " | Status: "
                    + pedido.getStatus());
        }
        System.out.println("--------------------------------------------------------");

        System.out.println("\n\n-------------------------------");
        System.out.println("Cadastrando 3 itens pedidos:");

        ItemPedido i1 = new ItemPedido(20, new BigDecimal(10.398));
        ItemPedido i2 = new ItemPedido(10, new BigDecimal(5.589));
        ItemPedido i3 = new ItemPedido(5, new BigDecimal(2.542));

        System.out.println("--------------------------------------------------------");
        System.out.println("Lista de itens pedidos:");
        System.out.println("--------------------------------------------------------");

        System.out.println("| Quantidade: " + i1.getQuantidade() + " | Preço Unitário: " + i1.getPrecoUnit());
        System.out.println("| Quantidade: " + i2.getQuantidade() + " | Preço Unitário: " + i2.getPrecoUnit());
        System.out.println("| Quantidade: " + i3.getQuantidade() + " | Preço Unitário: " + i3.getPrecoUnit());

        System.out.println("--------------------------------------------------------");
    }
}
