package com.fooddelivery.service;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import com.fooddelivery.model.ItemCardapio;

public class CardapioService {
    private AtomicInteger contador = new AtomicInteger(1);
    private List<ItemCardapio> itensCardapio = new ArrayList<>();

    public ItemCardapio cadastrarItemCardapio(String nome, BigDecimal preco) {
        ItemCardapio itemCardapio = new ItemCardapio(contador.getAndIncrement(), nome, preco);
        itensCardapio.add(itemCardapio);
        return itemCardapio;
    }

    public List<ItemCardapio> listarCardapio() {
        return new ArrayList<>(itensCardapio);
    }
}
