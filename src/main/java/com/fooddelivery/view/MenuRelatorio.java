package com.fooddelivery.view;

import java.util.Scanner;
import com.fooddelivery.service.RelatorioService;

public class MenuRelatorio {

    // Gerar relatório simplificado
    public static void relatorioSimplificado(Scanner teclado, RelatorioService relatorioService) {
        String relatorio = relatorioService.gerarRelatorioSimplificado();
        System.out.println(relatorio);

        System.out.println("\nPressione Enter para continuar...");
        teclado.nextLine();
    }

    // Gerar relatório detalhado
    public static void relatorioDetalhado(Scanner teclado, RelatorioService relatorioService) {
        String relatorio = relatorioService.gerarRelatorioDetalhado();
        System.out.println(relatorio);

        System.out.println("\nPressione Enter para continuar...");
        teclado.nextLine();
    }
}
