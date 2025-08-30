package com.fooddelivery.service;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.StringBuilder;
import com.fooddelivery.model.ItemCardapio;

public class CardapioService {
    private AtomicInteger contador = new AtomicInteger(1);
    private List<ItemCardapio> itensCardapio = new ArrayList<>();

    public String cadastrarItemCardapio(String nome, BigDecimal preco) {
        ItemCardapio itemCardapio = new ItemCardapio(contador.getAndIncrement(), nome, preco);
        itensCardapio.add(itemCardapio);
        return new StringBuilder().append("Cadastrado com Sucesso!\n\n")
                .append("| Item: ").append(nome)
                .append(" | Preço: R$ ").append(preco)
                .append("\n")
                .toString();
    }

    public List<ItemCardapio> listarCardapio() {
        return new ArrayList<>(itensCardapio);
    }

    /**
     * Busca um item do cardápio pelo ID
     * 
     * @param id ID do item a ser buscado
     * @return ItemCardapio encontrado ou null se não existir
     */
    public ItemCardapio buscarItemPorId(int id) {
        return itensCardapio.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
