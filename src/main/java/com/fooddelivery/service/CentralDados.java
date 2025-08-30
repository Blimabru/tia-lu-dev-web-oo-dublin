package com.fooddelivery.service;

import com.fooddelivery.model.Cliente;
import com.fooddelivery.model.ItemCardapio;
import com.fooddelivery.model.Pedido;
import java.util.List;

public class CentralDados {
    private static CentralDados instancia;

    private ClienteService clienteService;
    private CardapioService cardapioService;
    private PedidoService pedidoService;
    private RelatorioService relatorioService;

    private CentralDados() {
        this.clienteService = new ClienteService();
        this.cardapioService = new CardapioService();
        this.pedidoService = new PedidoService();
        this.relatorioService = new RelatorioService(pedidoService);
    }

    // Retorna a instância única da central de dados
    public static CentralDados getInstancia() {
        if (instancia == null) {
            instancia = new CentralDados();
        }
        return instancia;
    }

    // Getters:
    public ClienteService getClienteService() {
        return clienteService;
    }

    public CardapioService getCardapioService() {
        return cardapioService;
    }

    public PedidoService getPedidoService() {
        return pedidoService;
    }

    public RelatorioService getRelatorioService() {
        return relatorioService;
    }

    // Métodos de acesso unificado aos dados
    public List<Cliente> getTodosClientes() {
        return clienteService.listarClientes();
    }

    public List<ItemCardapio> getTodosItensCardapio() {
        return cardapioService.listarCardapio();
    }

    public List<Pedido> getTodosPedidos() {
        return pedidoService.listarTodosPedidos();
    }
}
