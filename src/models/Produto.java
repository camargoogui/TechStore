package models;

public class Produto {
    private String codigo;
    private String nome;
    private String marca;
    private double preco;
    private CategoriaProduto categoria;

    public Produto(String codigo, String nome, String marca, double preco, CategoriaProduto categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.categoria = categoria;
    }
}