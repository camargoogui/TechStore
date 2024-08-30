import repository.IProduto;
import models.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean finish = false;

        do {
            System.out.println("***\n0 - Sair\n1 - Adicionar Produto\n2 - Listar Produtos\n3 - Buscar Produto por ID\n4 - Alterar Produto\n5 - Excluir Produto\n***");
            String opcao = leitor.nextLine().trim();
            switch (opcao) {
                case "0":
                    finish = true;
                    break;
                case "1":
                    IProduto.addProduto();
                    break;
                case "2":
                    IProduto.showProducts();
                    break;
                case "3":
                    System.out.println("Digite o ID do produto: ");
                    String idBusca = leitor.nextLine().trim();
                    Produto produto = IProduto.findProdutoById(idBusca);
                    if (produto != null) {
                        System.out.println(produto);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case "4":
                    System.out.println("Digite o ID do produto que deseja alterar: ");
                    String idAlterar = leitor.nextLine().trim();
                    IProduto.updateProduto(idAlterar);
                    break;
                case "5":
                    System.out.println("Digite o ID do produto que deseja excluir: ");
                    String idExcluir = leitor.nextLine().trim();
                    IProduto.deleteProduto(idExcluir);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (!finish);
    }
}
