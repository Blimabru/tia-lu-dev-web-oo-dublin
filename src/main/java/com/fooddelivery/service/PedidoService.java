package com.fooddelivery.service;

import com.fooddelivery.model.Pedido;
import com.fooddelivery.model.Cliente;
import com.fooddelivery.model.ItemCardapio;
import com.fooddelivery.model.Pedido.StatusPedido;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PedidoService {
    private AtomicInteger contador = new AtomicInteger(1);
    private List<Pedido> pedidos = new ArrayList<>();

    /**
     * Cria um novo pedido para um cliente
     */
    public Pedido criarPedido(Cliente cliente) {
        Pedido pedido = new Pedido(contador.getAndIncrement(), cliente);
        pedidos.add(pedido);
        return pedido;
    }

    /**
     * Adiciona um item ao pedido
     */
    public String adicionarItemAoPedido(int idPedido, ItemCardapio itemCardapio, int quantidade) {
        Pedido pedido = buscarPedidoPorId(idPedido);
        if (pedido == null) {
            return "Pedido não encontrado!";
        }
        
        pedido.adicionarItem(itemCardapio, quantidade);
        return "Item adicionado ao pedido com sucesso!";
    }

    /**
     * Atualiza o status de um pedido
     */
    public String atualizarStatusPedido(int idPedido, StatusPedido novoStatus) {
        Pedido pedido = buscarPedidoPorId(idPedido);
        if (pedido == null) {
            return "Pedido não encontrado!";
        }

        if (pedido.atualizarStatus(novoStatus)) {
            return "Status do pedido atualizado para: " + novoStatus;
        } else {
            return "Transição de status inválida! Status atual: " + pedido.getStatus();
        }
    }

    /**
     * Lista pedidos por status
     */
    public List<Pedido> listarPedidosPorStatus(StatusPedido status) {
        return pedidos.stream()
                .filter(pedido -> pedido.getStatus() == status)
                .collect(Collectors.toList());
    }

    /**
     * Lista todos os pedidos
     */
    public List<Pedido> listarTodosPedidos() {
        return new ArrayList<>(pedidos);
    }

    /**
     * Busca pedido por ID
     */
    public Pedido buscarPedidoPorId(int id) {
        return pedidos.stream()
                .filter(pedido -> pedido.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Lista pedidos do dia atual
     */
    public List<Pedido> listarPedidosHoje() {
        String hoje = java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return pedidos.stream()
                .filter(pedido -> pedido.getData().equals(hoje))
                .collect(Collectors.toList());
    }
}
