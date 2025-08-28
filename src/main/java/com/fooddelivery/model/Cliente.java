package com.fooddelivery.model;

import com.fooddelivery.util.Validador;
import java.util.concurrent.atomic.AtomicInteger;

public class Cliente {
    private int id;
    private String nome;
    private String telefone;

    private static AtomicInteger contador = new AtomicInteger(1);

    // Construtor
    public Cliente(String nome, String telefone) {
        this.id = contador.getAndIncrement();
        this.nome = Validador.validarNome(nome);
        this.telefone = telefone;
    }

    // Getters:

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    // Setters

    public void setNome(String nome) {

        Validador.validarNome(nome);
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
