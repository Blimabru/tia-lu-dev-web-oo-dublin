package com.fooddelivery.view;

import java.util.Scanner;
import com.fooddelivery.service.ClienteService;
import com.fooddelivery.model.Cliente;

/**
 * Classe responsável pela interface de usuário para gerenciamento de clientes.
 * 
 * Esta classe contém métodos estáticos que implementam as telas e
 * funcionalidades
 * relacionadas aos clientes do sistema, como cadastro de novos clientes e
 * listagem dos clientes existentes. Faz parte da camada de apresentação (view)
 * e interage diretamente com o usuário através do terminal.
 */
public class MenuCliente {

    /**
     * Exibe a tela de cadastro de novo cliente.
     * 
     * Coleta as informações do usuário (nome e telefone) e utiliza o ClienteService
     * para cadastrar o novo cliente. Exibe mensagens de confirmação ou erro
     * conforme
     * o resultado da operação. Aguarda o usuário pressionar Enter antes de retornar
     * ao menu principal.
     *
     * @param teclado        Scanner para leitura de dados do usuário
     * @param clienteService Serviço responsável pelo gerenciamento de clientes
     */
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

    /**
     * Exibe a tela de listagem de todos os clientes cadastrados.
     * 
     * Busca todos os clientes cadastrados através do ClienteService e os exibe
     * em formato tabular com ID, nome e telefone. Se não houver clientes
     * cadastrados,
     * exibe uma mensagem informativa. Aguarda o usuário pressionar Enter antes
     * de retornar ao menu principal.
     *
     * @param teclado        Scanner para aguardar interação do usuário
     * @param clienteService Serviço responsável pelo gerenciamento de clientes
     */
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
