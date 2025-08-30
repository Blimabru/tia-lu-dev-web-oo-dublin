package com.fooddelivery.service;

import com.fooddelivery.model.Pedido;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
import java.util.ArrayList;

public class PedidoService {
    private AtomicInteger contador = new AtomicInteger(1);
    private List<Pedido> pedidos = new ArrayList<>();

    public Pedido criarPedido(Pedido.StatusPedido status) {
        Pedido pedido = new Pedido(contador.getAndIncrement(), status);
        pedidos.add(pedido);
        return pedido;
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }
}
