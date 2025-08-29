package com.fooddelivery.model;

import com.fooddelivery.util.Validador;

/**
 * Representa um cliente do sistema de delivery de alimentos.
 * 
 * Esta classe mantém informações sobre os clientes, como identificador único,
 * nome e telefone. Os dados do cliente são validados durante a criação e
 * atualização através da classe Validador.
 */
public class Cliente {
    /** Identificador único do cliente */
    private int id;

    /** Nome completo do cliente */
    private String nome;

    /** Número de telefone do cliente */
    private String telefone;

    /**
     * Cria um novo cliente com ID, nome e telefone especificados.
     * 
     * Os dados são validados antes de serem atribuídos.
     *
     * @param id       Identificador único do cliente
     * @param nome     Nome do cliente
     * @param telefone Número de telefone do cliente
     * @throws IllegalArgumentException se o nome ou telefone forem inválidos
     */
    public Cliente(int id, String nome, String telefone) {
        this.id = id;
        this.nome = Validador.nomeCliente(nome);
        this.telefone = Validador.telefone(telefone);
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
