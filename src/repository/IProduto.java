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

    public static void addProduto(Produto produto) {
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
        id = id.trim();
        System.out.println("Buscando produto com ID: " + id);
        System.out.println("Produtos disponíveis para busca:");
        produtos.forEach(p -> System.out.println("ID: " + p.getCodigo()));

        for (Produto p : produtos) {
            if (p.getCodigo().trim().equals(id)) {
                System.out.println("Produto encontrado: " + p);
                return p;
            }
        }
        System.out.println("Produto não encontrado.");
        return null;
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
