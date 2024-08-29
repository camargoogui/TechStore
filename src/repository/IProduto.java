package repository;

import enums.CategoriaProduto;
import models.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public interface IProduto {
    Scanner leitor = new Scanner(System.in);
    List<Produto> produtos = new ArrayList<>();


    public static void addProduto() {
        System.out.println("Digite o código do produto");
        String codProd = leitor.nextLine();
        System.out.println("Digite o nome do produto");
        String nmProd = leitor.nextLine();
        System.out.println("Digite o preço do produto");
        String precoProd = leitor.nextLine(); //Arrumar o preco

        System.out.println("Qual é a categoria do produto?");
        String cat = leitor.nextLine();
        CategoriaProduto categoria;
        try{
            categoria = CategoriaProduto.valueOf(cat.toUpperCase());
        } catch (IllegalArgumentException e){
            System.out.println("Categoria inválida. Categorias existentes: teclado, monitor, headset, impressora ou webcam.");
            return;
        }

        Produto produto = new Produto(codProd, nmProd, parseDouble(precoProd), categoria);
        produtos.add(produto);
    }

    public static void showProducts(){
        produtos.forEach(x -> System.out.println(x.getCodigo() + x.getNome() + x.getPreco()));
    }
}
