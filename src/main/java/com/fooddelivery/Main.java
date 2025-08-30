/**
 * Esse arquivo atualmente só serve para testes dos métodos implementados.
 */

package com.fooddelivery;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.fooddelivery.model.Cliente;
import com.fooddelivery.model.ItemCardapio;
import com.fooddelivery.service.ClienteService;
import com.fooddelivery.service.CardapioService;
import com.fooddelivery.model.Pedido;

public class Main {

    public static void main(String args[]) {

        ClienteService clientService = new ClienteService();
        CardapioService cardapioService = new CardapioService();

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
        System.out.println("Realizando 3 pedidos:");

        Pedido p1 = new Pedido(1, LocalDate.now(), Pedido.StatusPedido.ACEITO);
        Pedido p2 = new Pedido(2, LocalDate.now(), Pedido.StatusPedido.PREPARANDO);
        Pedido p3 = new Pedido(3, LocalDate.now(), Pedido.StatusPedido.ENTREGUE);

        System.out.println("--------------------------------------------------------");
        System.out.println("Lista de pedidos efetuados: ");
        System.out.println("--------------------------------------------------------");

        System.out.println("ID: " + p1.getId() + " | Data: " + p1.getData() + " | Status: " + p1.getStatus());
        System.out.println("ID: " + p2.getId() + " | Data: " + p2.getData() + " | Status: " + p2.getStatus());
        System.out.println("ID: " + p3.getId() + " | Data: " + p3.getData() + " | Status: " + p3.getStatus());

        System.out.println("--------------------------------------------------------");
    }
}
