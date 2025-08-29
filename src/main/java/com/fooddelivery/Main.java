package com.fooddelivery;

import com.fooddelivery.model.Cliente;
import com.fooddelivery.model.ItemCardapio;
import java.util.List;
import java.math.BigDecimal;

public class Main {
    public static void main(String args[]) {

        System.out.println("-------------------------------");
        System.out.println("Cadastrando 5 clientes:");

        Cliente c1 = new Cliente("Bruno", "77 9 8873 4773");
        Cliente c2 = new Cliente("Claudio", "77 9 8815 1047");
        Cliente c3 = new Cliente("Gabriel", "77 9 1234 5678");
        Cliente c4 = new Cliente("Kéven", "77 9 8765 4321");
        Cliente c5 = new Cliente("Artur", "77 9 9999 9999");

        List<Cliente> clientes = Cliente.getListaClientes();

        System.out.println("--------------------------------------------------------");
        System.out.println("Lista de clientes cadastrados: (Total = " + clientes.size() + ")");
        System.out.println("--------------------------------------------------------");

        for (Cliente cliente : clientes) {
            System.out.println("| ID: " + cliente.getId() + " | Nome: " + cliente.getNome() + " | Telefone: "
                    + cliente.getTelefone());
        }

        System.out.println("\n\n-------------------------------");
        System.out.println("Cadastrando 5 itens no cardápio:");

        ItemCardapio i1 = new ItemCardapio("X-Burguer", new BigDecimal(42.00));
        ItemCardapio i2 = new ItemCardapio("Cola-Cola 1L", new BigDecimal(10.00));
        ItemCardapio i3 = new ItemCardapio("Batata Frita M", new BigDecimal(18.00));
        ItemCardapio i4 = new ItemCardapio("Fini", new BigDecimal(7.999));
        ItemCardapio i5 = new ItemCardapio("Picolé", new BigDecimal(3.996));

        List<ItemCardapio> itensCardapio = ItemCardapio.getListaCardapio();

        System.out.println("--------------------------------------------------------");
        System.out.println("Lista de itens cadastrados no cardápio: (Total = " + itensCardapio.size() + ")");
        System.out.println("--------------------------------------------------------");

        for (ItemCardapio item : itensCardapio) {
            System.out.println("| ID: " + item.getId() + " | Nome: " + item.getNome() + " | Preço: " + item.getPreco());
        }
    }
}
