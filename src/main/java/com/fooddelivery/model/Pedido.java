package com.fooddelivery.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

/**
 * Representa um pedido no sistema de delivery de alimentos.
 * 
 * Esta classe gerencia informações sobre pedidos, incluindo identificador
 * único,
 * data/hora, status, cliente associado e lista de itens. Controla o fluxo de
 * status do pedido seguindo regras específicas de transição.
 */
public class Pedido {
    /** Identificador único do pedido */
    private int id;

    /** Data e hora de criação do pedido */
    private LocalDateTime dataHora;

    /** Status atual do pedido */
    private StatusPedido status;

    /** Cliente que fez o pedido */
    private Cliente cliente; // Associação com Cliente - todo pedido pertence a um cliente

    /** Lista de itens do pedido */
    private List<ItemPedido> itens; // Agregação de ItemPedido - um pedido pode ter vários itens

    /**
     * Enumeration que define os possíveis status de um pedido.
     * O pedido segue um fluxo sequencial específico entre os status.
     */
    public enum StatusPedido {
        /** Pedido foi aceito pelo restaurante */
        ACEITO,
        /** Pedido está sendo preparado */
        PREPARANDO,
        /** Pedido foi finalizado na cozinha */
        FEITO,
        /** Pedido aguarda disponibilidade de entregador */
        AGUARDANDO_ENTREGADOR,
        /** Entregador saiu para entregar o pedido */
        SAIU_PARA_ENTREGA,
        /** Pedido foi entregue ao cliente */
        ENTREGUE
    }

    /**
     * Cria um novo pedido com ID e cliente especificados.
     * 
     * O pedido é inicializado com status ACEITO, data/hora atual
     * e lista de itens vazia.
     *
     * @param id      Identificador único do pedido
     * @param cliente Cliente que está fazendo o pedido
     */
    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.dataHora = LocalDateTime.now();
        this.status = StatusPedido.ACEITO;
        this.itens = new ArrayList<>();
    }

    /**
     * Adiciona um item ao pedido com a quantidade especificada.
     *
     * @param itemCardapio Item do cardápio a ser adicionado
     * @param quantidade   Quantidade do item
     */
    public void adicionarItem(ItemCardapio itemCardapio, int quantidade) {
        ItemPedido itemPedido = new ItemPedido(itemCardapio, quantidade);
        this.itens.add(itemPedido);
    }

    /**
     * Calcula o valor total do pedido somando os subtotais de todos os itens.
     *
     * @return Valor total do pedido
     */
    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemPedido item : itens) {
            total = total.add(item.calcularSubtotal());
        }
        return total;
    }

    /**
     * Atualiza o status do pedido seguindo as regras de transição válidas.
     * 
     * O método verifica se a transição do status atual para o novo status
     * é permitida antes de fazer a atualização.
     *
     * @param novoStatus Novo status desejado para o pedido
     * @return true se o status foi atualizado com sucesso, false caso contrário
     */
    public boolean atualizarStatus(StatusPedido novoStatus) {
        if (isTransicaoValida(this.status, novoStatus)) {
            this.status = novoStatus;
            return true;
        }
        return false;
    }

    /**
     * Verifica se a transição entre dois status é válida.
     * 
     * Define as regras de fluxo sequencial do pedido.
     *
     * @param statusAtual Status atual do pedido
     * @param novoStatus  Status desejado
     * @return true se a transição é válida, false caso contrário
     */
    private boolean isTransicaoValida(StatusPedido statusAtual, StatusPedido novoStatus) {
        switch (statusAtual) {
            case ACEITO:
                return novoStatus == StatusPedido.PREPARANDO;
            case PREPARANDO:
                return novoStatus == StatusPedido.FEITO;
            case FEITO:
                return novoStatus == StatusPedido.AGUARDANDO_ENTREGADOR;
            case AGUARDANDO_ENTREGADOR:
                return novoStatus == StatusPedido.SAIU_PARA_ENTREGA;
            case SAIU_PARA_ENTREGA:
                return novoStatus == StatusPedido.ENTREGUE;
            case ENTREGUE:
                return false;
            default:
                return false;
        }
    }

    /**
     * Retorna o ID único do pedido.
     *
     * @return ID do pedido
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna a data do pedido formatada (dd/MM/yyyy).
     *
     * @return Data do pedido no formato brasileiro
     */
    public String getData() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataHora.format(formatoData);
    }

    /**
     * Retorna a data e hora do pedido formatadas (dd/MM/yyyy HH:mm).
     *
     * @return Data e hora do pedido formatadas
     */
    public String getDataHora() {
        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataHora.format(formatoDataHora);
    }

    /**
     * Retorna o status atual do pedido.
     *
     * @return Status do pedido
     */
    public StatusPedido getStatus() {
        return status;
    }

    /**
     * Retorna o cliente associado ao pedido.
     *
     * @return Cliente do pedido
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Retorna uma cópia da lista de itens do pedido.
     * 
     * Retorna uma nova lista para evitar modificações externas.
     *
     * @return Lista de itens do pedido
     */
    public List<ItemPedido> getItens() {
        return new ArrayList<>(itens);
    }

    /**
     * Atualiza o status do pedido diretamente.
     * 
     * Este método não verifica regras de transição.
     *
     * @param status Novo status do pedido
     */
    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
