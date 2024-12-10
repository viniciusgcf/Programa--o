package ArvoreBinaria;

public class ArvoreMain {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.add(8);
        arvore.add(2);
        arvore.add(6);
        arvore.add(9);
        arvore.add(12);
        arvore.add(17);
        arvore.add(4);
        arvore.add(11);
        arvore.add(3);
        arvore.add(5);

        arvore.emOrdemInicio();
        System.out.println();
        arvore.preOrdemInicio();
        System.out.println();
        arvore.posOrdemInicio();
        System.out.println();
        System.out.println(arvore.tamanhoInicio());
        System.out.println();
        arvore.inverteInicio();
        arvore.emOrdemInicio();
    }
}