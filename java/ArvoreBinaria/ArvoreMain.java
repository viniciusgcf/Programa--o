package ArvoreBinaria;

import java.util.ArrayList;
import java.util.Scanner;

public class ArvoreMain {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        ArrayList<ArvoreBinaria> arvores = new ArrayList<>();
        int opcao = 10;

        while (opcao != 0) {
            System.out.println("----------------------------------------");
            System.out.println("1. Criar nova árvore");
            System.out.println("2. Adicionar dados a uma árvore");
            System.out.println("3. Exibir ávores em pre-ordem");
            System.out.println("4. Exibir ávores em ordem");
            System.out.println("5. Exibir ávores em pós-ordem");
            System.out.println("6. Comparar árvores");
            System.out.println("0. Sair");
            System.out.println("----------------------------------------");
            opcao = leia.nextInt();

            switch (opcao) {
                case 1:
                    ArvoreBinaria arvore = new ArvoreBinaria();
                    arvores.add(arvore);
                    System.out.println("ID da nova árvore: " + (arvores.size() - 1));
                    break;
                case 2:
                    if (arvores.isEmpty()) {
                        System.out.println("Nenhuma árvore foi criada");
                    } else {
                        System.out.println("Digite o ID da árvore que deseja adicionar dados:");
                        int idArvore = leia.nextInt();
                        if (idArvore == arvores.size() - 1) {
                            System.out.println("Digite o valor a ser adicionado, ou digite 0 para parar. ");
                            int valor = 1;
                            while (valor != 0) {
                                valor = leia.nextInt();
                                arvores.get(idArvore).add(valor);
                            }
                            System.out.println("Operação completa.");
                        } else {
                            System.out.println("ID inválido");
                        }
                    }
                    break;
                case 3:
                    if (arvores.isEmpty()) {
                        System.out.println("Nenhuma árvore criada ainda.");
                    } else {
                        for (int i = 0; i < arvores.size(); i++) {
                            System.out.println("Árvore " + i + " em pré ordem: ");
                            arvores.get(i).preOrdemInicio();
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    if (arvores.isEmpty()) {
                        System.out.println("Nenhuma árvore criada ainda.");
                    } else {
                        for (int i = 0; i < arvores.size(); i++) {
                            System.out.println("Árvore " + i + " em ordem: ");
                            arvores.get(i).emOrdemInicio();
                            System.out.println();
                        }
                    }
                    break;
                case 5:
                    if (arvores.isEmpty()) {
                        System.out.println("Nenhuma árvore criada ainda.");
                    } else {
                        for (int i = 0; i < arvores.size(); i++) {
                            System.out.println("Árvore " + i + " em pós ordem: ");
                            arvores.get(i).posOrdemInicio();
                            System.out.println();
                        }
                    }
                    break;
                case 6:
                    if (arvores.size() < 2) {
                        System.out.println("É preciso criar no minimo 2 árvores.");
                    } else {
                        System.out.println("Digite o ID da primeira árvore: ");
                        int id1 = leia.nextInt();
                        System.out.println("Digite o ID da segunda árvore: ");
                        int id2 = leia.nextInt();
                        if (condition) {

                        }
                    }

                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção invalida.");
                    break;
            }
        }
        leia.close();
    }
}