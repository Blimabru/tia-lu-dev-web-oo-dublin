package com.fooddelivery.service;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.StringBuilder;
import com.fooddelivery.model.ItemCardapio;

/**
 * Serviço responsável pelo gerenciamento do cardápio do restaurante.
 * 
 * Esta classe oferece funcionalidades para cadastrar, listar e buscar
 * itens do cardápio. Mantém uma lista de itens disponíveis e gera
 * IDs únicos automaticamente para novos itens.
 */
public class CardapioService {
    /** Contador atômico para geração de IDs únicos dos itens */
    private AtomicInteger contador = new AtomicInteger(1);

    /** Lista de itens cadastrados no cardápio */
    private List<ItemCardapio> itensCardapio = new ArrayList<>();

    /**
     * Cadastra um novo item no cardápio com nome e preço especificados.
     * 
     * O item é criado com um ID único gerado automaticamente e adicionado
     * à lista do cardápio. Retorna uma mensagem de confirmação formatada.
     *
     * @param nome  Nome do item a ser cadastrado
     * @param preco Preço do item
     * @return Mensagem de confirmação do cadastro formatada
     * @throws IllegalArgumentException se o nome ou preço forem inválidos
     */
    public String cadastrarItemCardapio(String nome, BigDecimal preco) {
        ItemCardapio itemCardapio = new ItemCardapio(contador.getAndIncrement(), nome, preco);
        itensCardapio.add(itemCardapio);
        return new StringBuilder().append("Cadastrado com Sucesso!\n\n")
                .append("| Item: ").append(nome)
                .append(" | Preço: R$ ").append(preco)
                .append("\n")
                .toString();
    }

    /**
     * Retorna uma cópia da lista completa de itens do cardápio.
     * 
     * Retorna uma nova lista para evitar modificações externas
     * na coleção interna.
     *
     * @return Lista de todos os itens cadastrados no cardápio
     */
    public List<ItemCardapio> listarCardapio() {
        return new ArrayList<>(itensCardapio);
    }

    /**
     * Busca um item do cardápio pelo ID especificado.
     * 
     * Utiliza stream para encontrar o primeiro item que corresponda
     * ao ID fornecido.
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
