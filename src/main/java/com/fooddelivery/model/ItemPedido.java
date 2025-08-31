package com.fooddelivery.model;

import com.fooddelivery.util.Validador;
import java.math.BigDecimal;

/**
 * Representa um item dentro de um pedido no sistema de delivery de alimentos.
 * 
 * Esta classe associa um item do cardápio com uma quantidade específica,
 * permitindo calcular subtotais e gerenciar os itens de um pedido.
 * A quantidade é validada através da classe Validador.
 */
public class ItemPedido {
    /** Item do cardápio associado */
    private ItemCardapio item; // Associação com ItemCardapio

    /** Quantidade do item no pedido */
    private int quantidade;

    /**
     * Cria um novo item de pedido com item do cardápio e quantidade especificados.
     * 
     * A quantidade é validada antes de ser atribuída.
     *
     * @param item       Item do cardápio
     * @param quantidade Quantidade do item no pedido
     * @throws IllegalArgumentException se a quantidade for inválida
     */
    public ItemPedido(ItemCardapio item, int quantidade) {
        this.item = item;
        this.quantidade = Validador.quantidadePedido(quantidade);
    }

    /**
     * Calcula o subtotal do item (preço × quantidade).
     *
     * @return Valor do subtotal do item
     */
    public BigDecimal calcularSubtotal() {
        return item.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }

    /**
     * Retorna o item do cardápio associado.
     *
     * @return Item do cardápio
     */
    public ItemCardapio getItem() {
        return item;
    }

    /**
     * Retorna a quantidade do item no pedido.
     *
     * @return Quantidade do item
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Retorna o preço unitário do item.
     *
     * @return Preço unitário do item
     */
    public BigDecimal getPrecoUnitario() {
        return item.getPreco();
    }

    /**
     * Atualiza a quantidade do item no pedido.
     * 
     * A nova quantidade é validada antes de ser atribuída.
     *
     * @param quantidade Nova quantidade do item
     * @throws IllegalArgumentException se a quantidade for inválida
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = Validador.quantidadePedido(quantidade);
    }

    /**
     * Atualiza o item do cardápio associado.
     *
     * @param item Novo item do cardápio
     */
    public void setItem(ItemCardapio item) {
        this.item = item;
    }
}
