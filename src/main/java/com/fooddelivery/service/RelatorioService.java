package com.fooddelivery.service;

import com.fooddelivery.model.Pedido;
import com.fooddelivery.model.ItemPedido;
import java.math.BigDecimal;
import java.util.List;

/**
 * Serviço responsável pela geração de relatórios no sistema de delivery de
 * alimentos.
 * 
 * Esta classe oferece funcionalidades para gerar relatórios simplificados e
 * detalhados
 * dos pedidos realizados no dia atual. Os relatórios incluem informações como
 * total
 * de pedidos, valores arrecadados e detalhes específicos de cada pedido.
 */
public class RelatorioService {

    /** Serviço de pedidos usado para obter dados dos relatórios */
    private PedidoService pedidoService;

    /**
     * Cria uma nova instância do serviço de relatórios.
     * 
     * @param pedidoService Serviço de pedidos necessário para obter dados
     */
    public RelatorioService(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    /**
     * Gera um relatório simplificado com resumo dos pedidos do dia atual.
     * 
     * O relatório inclui total de pedidos, valor total arrecadado e valor
     * médio por pedido. É formatado de forma concisa para visualização rápida.
     *
     * @return String formatada contendo o relatório simplificado do dia
     */
    public String gerarRelatorioSimplificado() {
        List<Pedido> pedidosHoje = pedidoService.listarPedidosHoje();

        int totalPedidos = pedidosHoje.size();
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (Pedido pedido : pedidosHoje) {
            valorTotal = valorTotal.add(pedido.calcularTotal());
        }

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("\n=== RELATÓRIO SIMPLIFICADO - ")
                .append(java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .append(" ===\n\n");
        relatorio.append("Total de Pedidos: ").append(totalPedidos).append("\n");
        relatorio.append("Valor Total Arrecadado: R$ ").append(valorTotal).append("\n");
        relatorio.append("Valor Médio por Pedido: R$ ");

        if (totalPedidos > 0) {
            BigDecimal valorMedio = valorTotal.divide(BigDecimal.valueOf(totalPedidos), 2, BigDecimal.ROUND_HALF_UP);
            relatorio.append(valorMedio);
        } else {
            relatorio.append("0.00");
        }

        return relatorio.toString();
    }

    /**
     * Gera um relatório detalhado com lista completa de todos os pedidos do dia
     * atual.
     * 
     * O relatório inclui informações detalhadas de cada pedido como ID, data/hora,
     * dados do cliente, status, itens pedidos com quantidades e preços, e totais
     * individuais. Também apresenta um resumo geral ao final.
     *
     * @return String formatada contendo o relatório detalhado do dia
     */
    public String gerarRelatorioDetalhado() {
        List<Pedido> pedidosHoje = pedidoService.listarPedidosHoje();

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("\n=== RELATÓRIO DETALHADO - ")
                .append(java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .append(" ===\n\n");

        if (pedidosHoje.isEmpty()) {
            relatorio.append("Nenhum pedido registrado hoje.\n");
        } else {
            BigDecimal valorTotalGeral = BigDecimal.ZERO;

            for (Pedido pedido : pedidosHoje) {
                relatorio.append("──────────────────────────────────────────────────\n");
                relatorio.append("Pedido #").append(pedido.getId()).append(" - ").append(pedido.getDataHora())
                        .append("\n");
                relatorio.append("Cliente: ").append(pedido.getCliente().getNome()).append(" (ID: ")
                        .append(pedido.getCliente().getId()).append(")\n");
                relatorio.append("Telefone: ").append(pedido.getCliente().getTelefone()).append("\n");
                relatorio.append("Status: ").append(pedido.getStatus()).append("\n\n");

                relatorio.append("Itens:\n");
                for (ItemPedido item : pedido.getItens()) {
                    relatorio.append(" | ").append(item.getItem().getNome());
                    relatorio.append(" | Qtd: ").append(item.getQuantidade());
                    relatorio.append(" | Preço Unit: R$ ").append(item.getPrecoUnitario());
                    relatorio.append(" | Subtotal: R$ ").append(item.calcularSubtotal()).append("\n");
                }

                BigDecimal totalPedido = pedido.calcularTotal();
                relatorio.append("\nTOTAL DO PEDIDO: R$ ").append(totalPedido).append("\n\n");
                valorTotalGeral = valorTotalGeral.add(totalPedido);
            }

            relatorio.append("──────────────────────────────────────────────────\n\n");
            relatorio.append("RESUMO GERAL:\n");
            relatorio.append("Total de Pedidos: ").append(pedidosHoje.size()).append("\n");
            relatorio.append("Valor Total Arrecadado: R$ ").append(valorTotalGeral).append("\n");
        }

        return relatorio.toString();
    }
}
