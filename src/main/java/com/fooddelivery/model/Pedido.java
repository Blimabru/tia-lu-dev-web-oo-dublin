package com.fooddelivery.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pedido {
    private int id;
    private LocalDate data;
    private StatusPedido status;

    // Construtor
    public Pedido(int id, StatusPedido status) {
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

    public String getData() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(formatoData);
        return dataFormatada;
    }

    public StatusPedido getStatus() {
        return status;
    }

    // Setter:

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
