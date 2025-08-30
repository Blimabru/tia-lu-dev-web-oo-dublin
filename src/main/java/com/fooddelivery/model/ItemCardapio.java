package com.fooddelivery.model;

import com.fooddelivery.util.Validador;
import java.math.BigDecimal;

/**
 * Representa um item do cardápio no sistema de delivery de alimentos.
 * 
 * Esta classe mantém informações sobre os itens disponíveis para pedido,
 * como identificador único, nome e preço. Os dados do item são validados
 * durante a criação e atualização através da classe Validador.
 */
public class ItemCardapio {
    /** Identificador único do item */
    private int id;

    /** Nome do item no cardápio */
    private String nome;

    /** Preço do item */
    private BigDecimal preco;

    /**
     * Cria um novo item de cardápio com id, nome e preço especificados.
     * 
     * Os dados são validados antes de serem atribuídos.
     *
     * @param id    Identificador único do item
     * @param nome  Nome do item
     * @param preco Preço do item
     * @throws IllegalArgumentException se o nome ou preço forem inválidos
     */
    public ItemCardapio(int id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = Validador.itemCardapio(nome);
        this.preco = Validador.preco(preco);
    }

    /**
     * Retorna o ID único do item.
     *
     * @return ID do item
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome do item.
     *
     * @return Nome do item
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o preço do item.
     *
     * @return Preço do item
     */
    public BigDecimal getPreco() {
        return preco;
    }

    /**
     * Atualiza o nome do item.
     * 
     * O novo nome é validado antes de ser atribuído.
     *
     * @param nome Novo nome do item
     * @throws IllegalArgumentException se o nome for inválido
     */
    public void setNome(String nome) {
        this.nome = Validador.itemCardapio(nome);
    }

    /**
     * Atualiza o preço do item.
     * 
     * O novo preço é validado antes de ser atribuído.
     *
     * @param preco Novo preço do item
     * @throws IllegalArgumentException se o preço for inválido
     */
    public void setPreco(BigDecimal preco) {
        this.preco = Validador.preco(preco);
    }
}
