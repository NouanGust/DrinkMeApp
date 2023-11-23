package com.example.drinkmeapp;

public class Drink {
    private String nome;
    private String descricao;
    private String preco;

    private String imagePath;


    public Drink(String nome, String descricao, String preco, String imagePath) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagePath = imagePath;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPreco() {
        return preco;
    }

    public String getImagePath() {
        return imagePath;
    }
}
