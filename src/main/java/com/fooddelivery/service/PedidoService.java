package com.fooddelivery.service;

import com.fooddelivery.model.Pedido;
import com.fooddelivery.model.Cliente;
import com.fooddelivery.model.ItemCardapio;
import com.fooddelivery.model.Pedido.StatusPedido;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Serviço responsável pelo gerenciamento de pedidos no sistema de delivery de
 * alimentos.
 * 
 * Esta classe implementa operações de negócio relacionadas aos pedidos, como
 * criação,
 * adição de itens, atualização de status e consultas. Mantém uma lista
 * centralizada
 * de todos os pedidos do sistema e controla a geração de identificadores
 * únicos.
 */
public class PedidoService {
    /** Contador atômico para geração de IDs únicos dos pedidos */
    private AtomicInteger contador = new AtomicInteger(1);

    /** Lista que armazena todos os pedidos cadastrados no sistema */
    private List<Pedido> pedidos = new ArrayList<>();

    /**
     * Cria um novo pedido para um cliente especificado.
     * 
     * O pedido é criado com um ID único gerado automaticamente,
     * status inicial ACEITO e adicionado à lista de pedidos.
     *
     * @param cliente Cliente que está fazendo o pedido
     * @return Pedido criado
     */
    public Pedido criarPedido(Cliente cliente) {
        Pedido pedido = new Pedido(contador.getAndIncrement(), cliente);
        pedidos.add(pedido);
        return pedido;
    }

    /**
     * Adiciona um item ao pedido especificado.
     * 
     * Busca o pedido pelo ID e adiciona o item com a quantidade especificada.
     * A validação da quantidade é feita pela classe ItemPedido.
     *
     * @param idPedido     ID do pedido onde adicionar o item
     * @param itemCardapio Item do cardápio a ser adicionado
     * @param quantidade   Quantidade do item
     * @return Mensagem de confirmação ou erro
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
     * Atualiza o status de um pedido seguindo as regras de transição.
     * 
     * Busca o pedido pelo ID e tenta atualizar seu status. A validação
     * das transições é feita pela classe Pedido.
     *
     * @param idPedido   ID do pedido a ser atualizado
     * @param novoStatus Novo status desejado para o pedido
     * @return Mensagem de confirmação ou erro
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
     * Lista todos os pedidos que possuem um status específico.
     * 
     * Utiliza stream para filtrar os pedidos pelo status especificado.
     *
     * @param status Status dos pedidos a serem listados
     * @return Lista de pedidos com o status especificado
     */
    public List<Pedido> listarPedidosPorStatus(StatusPedido status) {
        return pedidos.stream()
                .filter(pedido -> pedido.getStatus() == status)
                .collect(Collectors.toList());
    }

    /**
     * Retorna uma lista com todos os pedidos cadastrados no sistema.
     * 
     * Uma nova lista é criada e retornada para evitar modificações acidentais
     * na lista original de pedidos.
     *
     * @return Uma cópia da lista de todos os pedidos
     */
    public List<Pedido> listarTodosPedidos() {
        return new ArrayList<>(pedidos);
    }

    /**
     * Busca um pedido pelo ID especificado.
     * 
     * Utiliza stream para encontrar o primeiro pedido que corresponda
     * ao ID fornecido.
     *
     * @param id ID do pedido a ser buscado
     * @return Pedido encontrado ou null se não existir
     */
    public Pedido buscarPedidoPorId(int id) {
        return pedidos.stream()
                .filter(pedido -> pedido.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Lista todos os pedidos feitos no dia atual.
     * 
     * Compara a data dos pedidos com a data atual no formato dd/MM/yyyy
     * para filtrar apenas os pedidos de hoje.
     *
     * @return Lista de pedidos feitos hoje
     */
    public List<Pedido> listarPedidosHoje() {
        String hoje = java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return pedidos.stream()
                .filter(pedido -> pedido.getData().equals(hoje))
                .collect(Collectors.toList());
    }
}
