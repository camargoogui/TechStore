package models;

import enums.CategoriaProduto;

public class Produto {
    private String codigo;
    private String nome;
    private double preco;
    private CategoriaProduto categoria;

    public Produto(String codigo, String nome, double preco, CategoriaProduto categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto [ID=" + codigo + ", Nome=" + nome + ", Preço=" + preco + ", Categoria=" + categoria + "]";
    }
}
