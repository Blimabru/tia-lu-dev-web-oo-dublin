package com.fooddelivery.view;

import java.math.BigDecimal;
import java.util.Scanner;
import com.fooddelivery.service.CardapioService;
import com.fooddelivery.util.Input;
import com.fooddelivery.model.ItemCardapio;

public class MenuCardapio {

    // Cadastrar novo item no cardápio
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

    // Lista todos os itens do cardápio
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
