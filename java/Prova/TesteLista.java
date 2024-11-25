public class TesteLista {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        ListaDuplamenteEncadeada listaPares = lista.retornaListaPares();

        lista.insereOrdenado(2);
        lista.insereOrdenado(4);
        lista.insereOrdenado(7);
        lista.insereOrdenado(9);
        lista.insereOrdenado(8);
        lista.insereOrdenado(8);

        System.out.println("Lista em ordem:");
        lista.print();

        System.out.println("Lista só com numeros pares:");
        listaPares.print();
    }
}