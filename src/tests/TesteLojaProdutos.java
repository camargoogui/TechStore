package tests;

import models.CategoriaProduto;
import models.Loja;
import models.Produto;

import java.util.ArrayList;
import java.util.List;

public class TesteLojaProdutos {
    public static void main(String[] args) {
        Produto mouse = new Produto("001", "MX Master 3", "Logitech", 499.99, CategoriaProduto.MOUSE);
        Produto teclado = new Produto("002", "K95 RGB Platinum", "Corsair", 999.99, CategoriaProduto.TECLADO);
        Produto monitor = new Produto("003", "UltraSharp 27", "Dell", 1599.99, CategoriaProduto.MONITOR);

        List<Produto> produtos = new ArrayList<>();
        produtos.add(mouse);
        produtos.add(teclado);
        produtos.add(monitor);

        Loja loja = new Loja("TechStore", produtos);

        System.out.println("Teste de instânciação da loja e produtos concluído.");
    }
}