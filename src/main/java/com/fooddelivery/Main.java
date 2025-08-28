package com.fooddelivery;

import java.util.List;

import com.fooddelivery.model.Cliente;

public class Main {
    public static void main(String args[]) {

        System.out.println("\n\nCadastrar Clientes:\n\n");

        Cliente c1 = new Cliente("Bruno", "77 9 8873 4773");
        System.out.println("Cliente: " + c1.getNome() + " | Telefone: " + c1.getTelefone());

        Cliente c2 = new Cliente("Claudio", "77 9 8815 1047");

        System.out.println("Cliente: " + c2.getNome() + " | Telefone: " + c2.getTelefone());
        Cliente c3 = new Cliente("Gabriel", "77 9 1234 5678");

        System.out.println("Cliente: " + c3.getNome() + " | Telefone: " + c3.getTelefone());
        Cliente c4 = new Cliente("Kéven", "77 9 8765 4321");

        System.out.println("Cliente: " + c4.getNome() + " | Telefone: " + c4.getTelefone());

        Cliente c5 = new Cliente("Artur", "77 9 9999 9999");
        System.out.println("Cliente: " + c5.getNome() + " | Telefone: " + c5.getTelefone());

        List<Cliente> clientes = Cliente.getListaClientes();

        System.out.println("\n\nQuantidade de Clientes cadastrados: " + clientes.size() + "\n\n");

        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() + " | Telefone: " + cliente.getTelefone());
        }
    }
}
