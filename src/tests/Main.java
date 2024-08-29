package tests;

import repository.IProduto;

import java.util.Scanner;

public class Main implements IProduto{
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean finish = false;

        do{
            System.out.println("""
                    0 - Sair
                    1 - Adicionar Produto
                    2 - Listar Produtos
                    """);

            switch (leitor.next()){
                case "0":
                    finish = true;
                case "1":
                    IProduto.addProduto();
                    break;
                case "2":
                    IProduto.showProducts();
                    break;
            }
        }while(!finish);
    }
}
