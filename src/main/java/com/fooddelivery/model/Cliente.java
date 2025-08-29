package com.fooddelivery.model;

import com.fooddelivery.util.Validador;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
import java.util.ArrayList;

/**
 * Representa um cliente do sistema de delivery de alimentos.
 * 
 * Esta classe mantém informações sobre os clientes, como nome e telefone,
 * e gerencia a lista de todos os clientes cadastrados no sistema.
 * Cada cliente recebe um ID único gerado automaticamente.
 * 
 * Os dados do cliente são validados durante a criação e atualização
 * através da classe Validador.
 */
public class Cliente {
    /** Identificador único do cliente */
    private int id;

    /** Nome completo do cliente */
    private String nome;

    /** Número de telefone do cliente */
    private String telefone;

    /** Contador atômico para geração de IDs únicos sequenciais */
    private static AtomicInteger contador = new AtomicInteger(1);

    /** Lista que mantém referência a todos os clientes cadastrados */
    private static List<Cliente> clientes = new ArrayList<>();

    /**
     * Cria um novo cliente com nome e telefone especificados.
     * 
     * O cliente criado recebe um ID único e é automaticamente adicionado
     * à lista de clientes do sistema. Os dados são validados antes de
     * serem atribuídos.
     *
     * @param nome     Nome do cliente
     * @param telefone Número de telefone do cliente
     * @throws IllegalArgumentException se o nome ou telefone forem inválidos
     */
    public Cliente(String nome, String telefone) {
        this.id = contador.getAndIncrement();
        this.nome = Validador.nomeCliente(nome);
        this.telefone = Validador.telefone(telefone);
        clientes.add(this);
    }

    /**
     * Retorna o ID único do cliente.
     *
     * @return ID do cliente
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome do cliente.
     *
     * @return Nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o número de telefone do cliente.
     *
     * @return Número de telefone do cliente
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Retorna uma cópia da lista de todos os clientes cadastrados no sistema.
     * 
     * Uma nova lista é criada para evitar modificações externas na lista
     * interna de clientes.
     *
     * @return Lista com todos os clientes cadastrados
     */
    public static List<Cliente> getListaClientes() {
        return new ArrayList<>(clientes);
    }

    /**
     * Atualiza o nome do cliente.
     * 
     * O novo nome é validado antes de ser atribuído.
     *
     * @param nome Novo nome do cliente
     * @throws IllegalArgumentException se o nome for inválido
     */
    public void setNome(String nome) {
        this.nome = Validador.nomeCliente(nome);
    }

    /**
     * Atualiza o número de telefone do cliente.
     * 
     * O novo telefone é validado antes de ser atribuído.
     *
     * @param telefone Novo número de telefone do cliente
     * @throws IllegalArgumentException se o telefone for inválido
     */
    public void setTelefone(String telefone) {
        this.telefone = Validador.telefone(telefone);
    }
}
