package com.fooddelivery.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class Pedido {
    private int id;
    private LocalDateTime dataHora;
    private StatusPedido status;
    private Cliente cliente; // Associação com Cliente - todo pedido pertence a um cliente
    private List<ItemPedido> itens; // Agregação de ItemPedido - um pedido pode ter vários itens

    // Construtor
    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.dataHora = LocalDateTime.now();
        this.status = StatusPedido.ACEITO;
        this.itens = new ArrayList<>();
    }

    public enum StatusPedido {
        ACEITO,
        PREPARANDO,
        FEITO,
        AGUARDANDO_ENTREGADOR,
        SAIU_PARA_ENTREGA,
        ENTREGUE
    }

    /**
     * Adiciona um item ao pedido
     */
    public void adicionarItem(ItemCardapio itemCardapio, int quantidade) {
        ItemPedido itemPedido = new ItemPedido(itemCardapio, quantidade);
        this.itens.add(itemPedido);
    }

    /**
     * Calcula o valor total do pedido
     */
    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemPedido item : itens) {
            total = total.add(item.calcularSubtotal());
        }
        return total;
    }

    /**
     * Atualiza o status do pedido seguindo as regras de transição
     */
    public boolean atualizarStatus(StatusPedido novoStatus) {
        if (isTransicaoValida(this.status, novoStatus)) {
            this.status = novoStatus;
            return true;
        }
        return false;
    }

    /**
     * Verifica se a transição de status é válida
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

    // Getters

    public int getId() {
        return id;
    }

    public String getData() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataHora.format(formatoData);
    }

    public String getDataHora() {
        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataHora.format(formatoDataHora);
    }

    public StatusPedido getStatus() {
        return status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return new ArrayList<>(itens);
    }

    // Setter:

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
