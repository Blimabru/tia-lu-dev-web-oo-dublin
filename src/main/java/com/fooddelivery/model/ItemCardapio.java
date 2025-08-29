package com.fooddelivery.model;

import com.fooddelivery.util.Validador;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Representa um item do cardápio no sistema de delivery de alimentos.
 * 
 * Esta classe mantém informações sobre os itens disponíveis para pedido,
 * como nome e preço, e gerencia a lista de todos os itens cadastrados no
 * sistema.
 * Cada item recebe um ID único gerado automaticamente.
 * 
 * Os dados do item são validados durante a criação e atualização
 * através da classe Validador.
 */
public class ItemCardapio {
    /** Identificador único do item */
    private int id;

    /** Nome do item no cardápio */
    private String nome;

    /** Preço do item */
    private BigDecimal preco;

    /** Contador atômico para geração de IDs únicos sequenciais */
    private static AtomicInteger contador = new AtomicInteger(1);

    /** Lista que mantém referência a todos os itens cadastrados */
    private static List<ItemCardapio> itensCardapio = new ArrayList<>();

    /**
     * Cria um novo item de cardápio com nome e preço especificados.
     * 
     * O item criado recebe um ID único e é automaticamente adicionado
     * à lista de itens do cardápio. Os dados são validados antes de
     * serem atribuídos.
     *
     * @param nome  Nome do item
     * @param preco Preço do item
     * @throws IllegalArgumentException se o nome ou preço forem inválidos
     */
    public ItemCardapio(String nome, BigDecimal preco) {
        this.id = contador.getAndIncrement();
        this.nome = Validador.itemCardapio(nome);
        this.preco = Validador.preco(preco);
        itensCardapio.add(this);
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
     * Retorna uma cópia da lista de todos os itens cadastrados no cardápio.
     * 
     * Uma nova lista é criada para evitar modificações externas na lista
     * interna de itens.
     *
     * @return Lista com todos os itens cadastrados no cardápio
     */
    public static List<ItemCardapio> getListaCardapio() {
        return new ArrayList<>(itensCardapio);
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
