package com.fooddelivery;

import com.fooddelivery.model.Cliente;

public class Main {
    public static void main(String args[]) {
        Cliente c1 = new Cliente("Bruno", "77 9 8873 4773");
        Cliente c2 = new Cliente("Bruno", "77 9 8873 4773");
        Cliente c3 = new Cliente("Bruno", "77 9 8873 4773");
        Cliente c4 = new Cliente("Bruno", "77 9 8873 4773");
        Cliente c5 = new Cliente("Bruno", "77 9 8873 4773");

        System.out.println("ID do cliente: " + c1.getId());
        System.out.println("ID do cliente: " + c2.getId());
        System.out.println("ID do cliente: " + c3.getId());
        System.out.println("ID do cliente: " + c4.getId());
        System.out.println("ID do cliente: " + c5.getId());
    }
}