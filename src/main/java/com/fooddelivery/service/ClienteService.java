package com.fooddelivery.service;

import com.fooddelivery.model.Cliente;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.StringBuilder;

/**
 * Serviço responsável pelo gerenciamento de clientes no sistema de delivery de
 * alimentos.
 * 
 * Esta classe implementa operações de negócio relacionadas aos clientes, como
 * cadastro, listagem e gerenciamento do ciclo de vida dos objetos Cliente.
 * Mantém uma lista centralizada de todos os clientes do sistema e controla
 * a geração de identificadores únicos para cada cliente.
 */
public class ClienteService {
    /** Contador atômico para geração de IDs únicos sequenciais */
    private AtomicInteger contador = new AtomicInteger(1);

    /** Lista que armazena todos os clientes cadastrados no sistema */
    private List<Cliente> clientes = new ArrayList<>();

    /**
     * Cadastra um novo cliente no sistema com nome e telefone especificados.
     * 
     * Gera automaticamente um ID único para o cliente e o adiciona à lista
     * de clientes do sistema.
     *
     * @param nome     Nome do cliente a ser cadastrado
     * @param telefone Número de telefone do cliente
     * @return O objeto Cliente criado e cadastrado no sistema
     * @throws IllegalArgumentException se o nome ou telefone forem inválidos
     */
    public String cadastrarCliente(String nome, String telefone) {
        Cliente cliente = new Cliente(contador.getAndIncrement(), nome, telefone);
        clientes.add(cliente);

        return new StringBuilder().append("\nCadastrado com Sucesso!\n\n")
                .append(" | ID: ").append(cliente.getId())
                .append(" Nome: ").append(nome)
                .append(" | Telefone: ").append(telefone)
                .append("\n")
                .toString();
    }

    /**
     * Retorna uma lista com todos os clientes cadastrados no sistema.
     * 
     * Uma nova lista é criada e retornada para evitar modificações acidentais
     * na lista original de clientes.
     *
     * @return Uma cópia da lista de todos os clientes
     */
    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }
}
