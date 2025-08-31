package com.fooddelivery.view;

import java.util.Scanner;
import com.fooddelivery.service.RelatorioService;

/**
 * Classe responsável pela interface de usuário para geração de relatórios.
 * 
 * Esta classe contém métodos estáticos que implementam as telas para
 * visualização de relatórios do sistema, incluindo relatórios simplificados
 * e detalhados dos pedidos do dia. Faz parte da camada de apresentação (view)
 * e fornece uma interface amigável para consulta de dados gerenciais.
 */
public class MenuRelatorio {

    /**
     * Exibe a tela de relatório simplificado.
     * 
     * Gera e apresenta um relatório resumido com informações consolidadas
     * dos pedidos do dia atual, incluindo total de pedidos, valor total
     * arrecadado e valor médio por pedido. Aguarda o usuário pressionar
     * Enter antes de retornar ao menu principal.
     *
     * @param teclado          Scanner para aguardar interação do usuário
     * @param relatorioService Serviço responsável pela geração de relatórios
     */
    public static void relatorioSimplificado(Scanner teclado, RelatorioService relatorioService) {
        String relatorio = relatorioService.gerarRelatorioSimplificado();
        System.out.println(relatorio);

        System.out.println("\nPressione Enter para continuar...");
        teclado.nextLine();
    }

    /**
     * Exibe a tela de relatório detalhado.
     * 
     * Gera e apresenta um relatório completo com informações detalhadas
     * de todos os pedidos do dia atual, incluindo dados dos clientes,
     * itens pedidos, quantidades, preços e totais individuais. Também
     * inclui um resumo geral ao final. Aguarda o usuário pressionar
     * Enter antes de retornar ao menu principal.
     *
     * @param teclado          Scanner para aguardar interação do usuário
     * @param relatorioService Serviço responsável pela geração de relatórios
     */
    public static void relatorioDetalhado(Scanner teclado, RelatorioService relatorioService) {
        String relatorio = relatorioService.gerarRelatorioDetalhado();
        System.out.println(relatorio);

        System.out.println("\nPressione Enter para continuar...");
        teclado.nextLine();
    }
}
