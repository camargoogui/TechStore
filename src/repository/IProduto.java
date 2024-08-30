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
        System.out.println("Digite o código do produto:");
        String codProd = leitor.nextLine().trim(); // Removendo espaços em branco
        System.out.println("Digite o nome do produto:");
        String nmProd = leitor.nextLine().trim(); // Removendo espaços em branco
        System.out.println("Digite o preço do produto:");
        String precoProd = leitor.nextLine().trim(); // Removendo espaços em branco e arrumando o preço

        System.out.println("Qual é a categoria do produto?");
        String cat = leitor.nextLine().trim().toUpperCase(); // Removendo espaços em branco e convertendo para maiúsculas
        CategoriaProduto categoria;
        try {
            categoria = CategoriaProduto.valueOf(cat);
        } catch (IllegalArgumentException e) {
            System.out.println("Categoria inválida. Categorias existentes: teclado, monitor, headset, impressora ou webcam.");
            return;
        }

        Produto produto = new Produto(codProd, nmProd, parseDouble(precoProd), categoria);
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
        System.out.println("Produtos atualmente armazenados: ");
        produtos.forEach(p -> System.out.println(p.getCodigo() + " - " + p.getNome()));
    }

    public static void showProducts() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            produtos.forEach(x -> System.out.println("Código: " + x.getCodigo() + ", Nome: " + x.getNome() + ", Preço: " + x.getPreco()));
        }
    }

    public static Produto findProdutoById(String id) {
        id = id.trim(); // Removendo espaços em branco
        System.out.println("Buscando produto com ID: " + id);
        System.out.println("Produtos disponíveis para busca:");
        produtos.forEach(p -> System.out.println("ID: " + p.getCodigo()));

        for (Produto p : produtos) {
            System.out.println("Verificando produto com ID: " + p.getCodigo().trim());
            if (p.getCodigo().trim().equals(id)) {
                System.out.println("Produto encontrado: " + p);
                return p;
            }
        }
        System.out.println("Produto não encontrado.");
        return null; // Retorna null se o produto não for encontrado
    }

    public static void updateProduto(String id) {
        Produto produto = findProdutoById(id);
        if (produto != null) {
            System.out.println("Alterar Produto");
            System.out.println("Novo nome:");
            String novoNome = leitor.nextLine().trim();
            System.out.println("Novo preço:");
            String novoPreco = leitor.nextLine().trim();
            System.out.println("Nova categoria:");
            String novaCategoria = leitor.nextLine().trim().toUpperCase();
            CategoriaProduto categoria;
            try {
                categoria = CategoriaProduto.valueOf(novaCategoria);
            } catch (IllegalArgumentException e) {
                System.out.println("Categoria inválida. Categorias existentes: teclado, monitor, headset, impressora ou webcam.");
                return;
            }
            produto.setNome(novoNome);
            produto.setPreco(parseDouble(novoPreco));
            produto.setCategoria(categoria);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public static void deleteProduto(String id) {
        Produto produto = findProdutoById(id);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }
}
