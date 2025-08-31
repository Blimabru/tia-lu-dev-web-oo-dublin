package com.fooddelivery.service;

import com.fooddelivery.model.Cliente;
import com.fooddelivery.model.ItemCardapio;
import com.fooddelivery.model.Pedido;
import java.util.List;

/**
 * Central de dados que implementa o padrão Singleton para gerenciar todos os
 * serviços do sistema.
 * 
 * Esta classe serve como ponto único de acesso aos serviços de cliente,
 * cardápio, pedido e relatório.
 * Garante que existe apenas uma instância dos serviços durante toda a execução
 * da aplicação,
 * facilitando o compartilhamento de dados entre diferentes partes do sistema.
 */
public class CentralDados {
    /** Instância única da central de dados (padrão Singleton) */
    private static CentralDados instancia;

    /** Serviço de gerenciamento de clientes */
    private ClienteService clienteService;

    /** Serviço de gerenciamento do cardápio */
    private CardapioService cardapioService;

    /** Serviço de gerenciamento de pedidos */
    private PedidoService pedidoService;

    /** Serviço de geração de relatórios */
    private RelatorioService relatorioService;

    /**
     * Construtor privado que inicializa todos os serviços.
     * 
     * Cria instâncias dos serviços de cliente, cardápio, pedido e relatório.
     * O construtor é privado para garantir o padrão Singleton.
     */
    private CentralDados() {
        this.clienteService = new ClienteService();
        this.cardapioService = new CardapioService();
        this.pedidoService = new PedidoService();
        this.relatorioService = new RelatorioService(pedidoService);
    }

    /**
     * Retorna a instância única da central de dados.
     * 
     * Implementa o padrão Singleton de forma lazy (criação sob demanda).
     * Se a instância não existir, cria uma nova; caso contrário, retorna a
     * existente.
     *
     * @return Instância única da CentralDados
     */
    public static CentralDados getInstancia() {
        if (instancia == null) {
            instancia = new CentralDados();
        }
        return instancia;
    }

    /**
     * Retorna o serviço de gerenciamento de clientes.
     *
     * @return Instância do ClienteService
     */
    public ClienteService getClienteService() {
        return clienteService;
    }

    /**
     * Retorna o serviço de gerenciamento do cardápio.
     *
     * @return Instância do CardapioService
     */
    public CardapioService getCardapioService() {
        return cardapioService;
    }

    /**
     * Retorna o serviço de gerenciamento de pedidos.
     *
     * @return Instância do PedidoService
     */
    public PedidoService getPedidoService() {
        return pedidoService;
    }

    /**
     * Retorna o serviço de geração de relatórios.
     *
     * @return Instância do RelatorioService
     */
    public RelatorioService getRelatorioService() {
        return relatorioService;
    }

    /**
     * Retorna uma lista de todos os clientes cadastrados.
     * 
     * Método de conveniência que delega para o ClienteService.
     *
     * @return Lista de todos os clientes
     */
    public List<Cliente> getTodosClientes() {
        return clienteService.listarClientes();
    }

    /**
     * Retorna uma lista de todos os itens do cardápio.
     * 
     * Método de conveniência que delega para o CardapioService.
     *
     * @return Lista de todos os itens do cardápio
     */
    public List<ItemCardapio> getTodosItensCardapio() {
        return cardapioService.listarCardapio();
    }

    /**
     * Retorna uma lista de todos os pedidos.
     * 
     * Método de conveniência que delega para o PedidoService.
     *
     * @return Lista de todos os pedidos
     */
    public List<Pedido> getTodosPedidos() {
        return pedidoService.listarTodosPedidos();
    }
}
