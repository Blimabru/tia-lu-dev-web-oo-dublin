package com.fooddelivery.view;

import java.util.Scanner;
import com.fooddelivery.service.ClienteService;
import com.fooddelivery.model.Cliente;

public class MenuCliente {

    // Cadastrar novo cliente
    public static void cadastrarCliente(Scanner teclado, ClienteService clienteService) {
        System.out.println("\n=== CADASTRAR NOVO CLIENTE ===\n");

        System.out.print("Nome: ");
        String nomeCliente = teclado.nextLine();

        System.out.print("Telefone: ");
        String telefone = teclado.nextLine();

        String resultado = clienteService.cadastrarCliente(nomeCliente, telefone);
        System.out.println(resultado);

        System.out.println("Pressione Enter para continuar...");
        teclado.nextLine();
    }

    // Lista todos os clientes cadastrados
    public static void listarClientes(Scanner teclado, ClienteService clienteService) {
        System.out.println("\n=== CLIENTES CADASTRADOS ===\n");

        if (clienteService.listarClientes().isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clienteService.listarClientes()) {
                System.out.println("| ID: " + cliente.getId() + " | Nome: " + cliente.getNome()
                        + " | Telefone: " + cliente.getTelefone() + " |");
            }
        }

        System.out.println("\n Pressione Enter para continuar...");
        teclado.nextLine();
    }
}