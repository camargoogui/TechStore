package tests;

import repository.IProduto;
import models.Produto;
import models.Loja;
import enums.CategoriaProduto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean finish = false;

        do {
            System.out.println("==================================");
            System.out.println("|   Bem-vindo ao TechStore       |");
            System.out.println("==================================");
            System.out.println("| 0 - Sair                       |");
            System.out.println("| 1 - Adicionar Produto          |");
            System.out.println("| 2 - Listar Produtos            |");
            System.out.println("| 3 - Buscar Produto por ID      |");
            System.out.println("| 4 - Alterar Produto            |");
            System.out.println("| 5 - Excluir Produto            |");
            System.out.println("| 6 - Buscar Produto por Nome    |");
            System.out.println("| 7 - Lojas com Produto          |");
            System.out.println("| 8 - Adicionar Loja             |");
            System.out.println("| 9 - Adicionar Produto à Loja   |");
            System.out.println("==================================");
            System.out.print("Escolha uma opção: ");
            String opcao = leitor.nextLine().trim();
            switch (opcao) {
                case "0":
                    finish = true;
                    break;
                case "1":
                    addProduto();
                    break;
                case "2":
                    IProduto.showProducts();
                    break;
                case "3":
                    IProduto.showProducts();
                    System.out.print("Digite o ID do produto: ");
                    String idBusca = leitor.nextLine().trim();
                    Produto produto = IProduto.findProdutoById(idBusca);
                    if (produto != null) {
                        System.out.println(produto);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case "4":
                    System.out.print("Digite o ID do produto que deseja alterar: ");
                    String idAlterar = leitor.nextLine().trim();
                    IProduto.updateProduto(idAlterar);
                    break;
                case "5":
                    System.out.print("Digite o ID do produto que deseja excluir: ");
                    String idExcluir = leitor.nextLine().trim();
                    IProduto.deleteProduto(idExcluir);
                    break;
                case "6":
                    System.out.print("Digite o nome do produto que deseja buscar: ");
                    String nomeBusca = leitor.nextLine().trim();
                    IProduto.collectProdutoByNome(nomeBusca);
                    break;
                case "7":
                    System.out.print("Digite o nome do produto para verificar as lojas que o possuem: ");
                    String nomeProduto = leitor.nextLine().trim();
                    IProduto.lojasComProduto(nomeProduto);
                    break;
                case "8":
                    addLoja();
                    break;
                case "9":
                    addProdutoToLoja();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (!finish);
    }

    private static void addProduto() {
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o código do produto: ");
        String codigo = leitor.nextLine().trim();

        System.out.print("Digite o nome do produto: ");
        String nome = leitor.nextLine().trim();

        System.out.println("Escolha a categoria do produto:");
        CategoriaProduto[] categorias = CategoriaProduto.values();
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + " - " + categorias[i]);
        }
        System.out.print("Digite o número da categoria: ");
        int categoriaIndex = Integer.parseInt(leitor.nextLine().trim()) - 1;
        CategoriaProduto categoria = categorias[categoriaIndex];

        System.out.print("Digite o preço do produto: ");
        double preco = Double.parseDouble(leitor.nextLine().trim());

        Produto produto = new Produto(codigo, nome, preco, categoria);
        IProduto.addProduto(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void addLoja() {
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o nome da loja: ");
        String nomeLoja = leitor.nextLine().trim();

        Loja loja = new Loja(nomeLoja, new ArrayList<>());
        IProduto.addLoja(loja);
    }

    private static void addProdutoToLoja() {
        Scanner leitor = new Scanner(System.in);
        IProduto.showLojas();
        System.out.print("Digite o nome da loja: ");
        String nomeLoja = leitor.nextLine().trim();

        IProduto.showProducts();
        System.out.print("Digite o ID do produto que deseja adicionar à loja: ");
        String idProduto = leitor.nextLine().trim();

        Produto produto = IProduto.findProdutoById(idProduto);
        if (produto != null) {
            IProduto.addProdutoToLoja(nomeLoja, produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
