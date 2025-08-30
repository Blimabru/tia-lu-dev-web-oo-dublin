package com.fooddelivery.model;

import com.fooddelivery.util.Validador;
import java.math.BigDecimal;

public class ItemPedido {
    private int quantidade;
    private BigDecimal precoUnit;

    // Construtor
    public ItemPedido(int quantidade, BigDecimal precoUnit) {
        this.quantidade = Validador.quantidadePedido(quantidade);
        this.precoUnit = Validador.preco(precoUnit);
    }

    // Getters:

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnit() {
        return precoUnit;
    }

    // Setters

    public void setQuantidade(int quantidade) {
        this.quantidade = Validador.quantidadePedido(quantidade);
    }

    public void setPrecoUnit(BigDecimal precoUnit) {
        this.precoUnit = Validador.preco(precoUnit);
    }
}
