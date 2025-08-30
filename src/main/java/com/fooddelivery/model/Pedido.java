package com.fooddelivery.model;

import java.time.LocalDate;

public class Pedido {
    private int id;
    private LocalDate data;
    private StatusPedido status;

    // Construtor
    public Pedido(int id, LocalDate data, StatusPedido status) {
        this.id = id;
        this.data = LocalDate.now();
        this.status = status;
    }

    public enum StatusPedido {
        ACEITO,
        PREPARANDO,
        FEITO,
        AGUARDANDO_ENTREGADOR,
        SAIU_PARA_ENTREGA,
        ENTREGUE
    }

    // Getters

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    // Setters:

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
