package repository;

import enums.CategoriaProduto;
import models.Loja;
import models.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;

public interface IProduto {
    Scanner leitor = new Scanner(System.in);
    List<Produto> produtos = new ArrayList<>();
    List<Loja> lojas = new ArrayList<>();

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
        final String finalId = id.trim();
        Optional<Produto> produtoOptional = produtos.stream()
                .filter(p -> p.getCodigo().equals(finalId))
                .findFirst();

        produtoOptional.ifPresentOrElse(
                produto -> System.out.println("Produto encontrado: " + produto),
                () -> System.out.println("Produto não encontrado.")
        );

        return produtoOptional.orElse(null);
    }

    public static Produto collectProdutoByNome(String nome) {
        final String finalNome = nome.trim();
        List<Produto> produtoColetado = produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(finalNome))
                .collect(Collectors.toList());

        if (produtoColetado.isEmpty()) {
            System.out.println("Nenhum produto encontrado com o nome: " + finalNome);
            return null;
        } else {
            Produto produto = produtoColetado.get(0);
            System.out.println("Produto encontrado: " + produto);
            return produto;
        }
    }

    public static void lojasComProduto(String nomeProduto) {
        final String finalNomeProduto = nomeProduto.trim();
        List<String> lojasComProduto = lojas.stream()
                .filter(loja -> loja.getProdutos().stream()
                        .anyMatch(produto -> produto.getNome().equalsIgnoreCase(finalNomeProduto)))
                .map(Loja::getNome)
                .collect(Collectors.toList());

        if (lojasComProduto.isEmpty()) {
            System.out.println("Nenhuma loja possui o produto: " + finalNomeProduto);
        } else {
            System.out.println("Lojas que possuem o produto " + finalNomeProduto + ":");
            lojasComProduto.forEach(System.out::println);
        }
    }

    public static void addLoja(Loja loja) {
        lojas.add(loja);
        System.out.println("Loja adicionada com sucesso!");
    }

    public static void addProdutoToLoja(String nomeLoja, Produto produto) {
        final String finalNomeLoja = nomeLoja.trim();
        Optional<Loja> lojaOptional = lojas.stream()
                .filter(loja -> loja.getNome().equalsIgnoreCase(finalNomeLoja))
                .findFirst();

        if (lojaOptional.isPresent()) {
            Loja loja = lojaOptional.get();
            loja.getProdutos().add(produto);
            System.out.println("Produto adicionado à loja " + loja.getNome() + " com sucesso!");
        } else {
            System.out.println("Loja não encontrada.");
        }
    }

    public static void showLojas() {
        if (lojas.isEmpty()) {
            System.out.println("Nenhuma loja cadastrada.");
        } else {
            lojas.forEach(loja -> System.out.println("Loja: " + loja.getNome()));
        }
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
