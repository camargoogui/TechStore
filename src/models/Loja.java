package models;

import java.util.List;

public class Loja {
    private String nome;
    private List<Produto> produtos;

    public Loja(String nome, List<Produto> produtos) {
        this.nome = nome;
        this.produtos = produtos;
    }
}