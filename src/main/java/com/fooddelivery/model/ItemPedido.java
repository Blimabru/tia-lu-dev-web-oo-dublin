package com.fooddelivery.model;

import com.fooddelivery.util.Validador;
import java.math.BigDecimal;

public class ItemPedido {
    private ItemCardapio item; // Associação com ItemCardapio
    private int quantidade;

    // Construtor
    public ItemPedido(ItemCardapio item, int quantidade) {
        this.item = item;
        this.quantidade = Validador.quantidadePedido(quantidade);
    }

    /**
     * Calcula o subtotal do item (preço × quantidade)
     */
    public BigDecimal calcularSubtotal() {
        return item.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }

    // Getters:

    public ItemCardapio getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return item.getPreco();
    }

    // Setters

    public void setQuantidade(int quantidade) {
        this.quantidade = Validador.quantidadePedido(quantidade);
    }

    public void setItem(ItemCardapio item) {
        this.item = item;
    }
}
