package com.fooddelivery.view;

import java.math.BigDecimal;
import java.util.Scanner;
import com.fooddelivery.service.CardapioService;
import com.fooddelivery.util.Input;
import com.fooddelivery.model.ItemCardapio;

/**
 * Classe responsável pela interface de usuário para gerenciamento do cardápio.
 * 
 * Esta classe contém métodos estáticos que implementam as telas e funcionalidades
 * relacionadas ao cardápio do restaurante, como cadastro de novos itens e
 * listagem dos itens existentes. Faz parte da camada de apresentação (view)
 * e interage diretamente com o usuário através do terminal.
 */
public class MenuCardapio {

    /**
     * Exibe a tela de cadastro de novo item no cardápio.
     * 
     * Coleta as informações do usuário (nome e preço) e utiliza o CardapioService
     * para cadastrar o novo item. Exibe mensagens de confirmação ou erro conforme
     * o resultado da operação. Inclui tratamento para limpeza do buffer do Scanner.
     *
     * @param teclado         Scanner para leitura de dados do usuário
     * @param cardapioService Serviço responsável pelo gerenciamento do cardápio
     */
    public static void cadastrarItem(Scanner teclado, CardapioService cardapioService) {
        System.out.println("\n=== CADASTRAR NOVO ITEM ===\n");

        System.out.print("Nome: ");
        String nomeItem = teclado.nextLine();

        System.out.print("\nDICA: Utilize . (ponto) para inserir os centavos\nPreço: ");
        BigDecimal preco = teclado.nextBigDecimal();
        Input.limparBuffer(teclado);

        System.out.println("\n" + cardapioService.cadastrarItemCardapio(nomeItem, preco));

        System.out.println("Pressione Enter para continuar...");
        teclado.nextLine();
    }

    /**
     * Exibe a tela de listagem de todos os itens do cardápio.
     * 
     * Busca todos os itens cadastrados através do CardapioService e os exibe
     * em formato tabular com ID, nome e preço. Se não houver itens cadastrados,
     * exibe uma mensagem informativa. Aguarda o usuário pressionar Enter antes
     * de retornar ao menu principal.
     *
     * @param teclado         Scanner para aguardar interação do usuário
     * @param cardapioService Serviço responsável pelo gerenciamento do cardápio
     */
    public static void listarItens(Scanner teclado, CardapioService cardapioService) {
        System.out.println("\n=== ITENS DO CARDAPIO ===\n");

        if (cardapioService.listarCardapio().isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            for (ItemCardapio item : cardapioService.listarCardapio()) {
                System.out.println("| ID: " + item.getId() + " | Nome: " + item.getNome()
                        + " | Preco: " + item.getPreco() + " |");
            }
        }

        System.out.println("\nPressione Enter para continuar...");
        teclado.nextLine();
    }
}
