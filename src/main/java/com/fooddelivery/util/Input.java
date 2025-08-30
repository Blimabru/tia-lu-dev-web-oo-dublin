package com.fooddelivery.util;

import java.util.Scanner;

public class Input {

    public static void limparBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}