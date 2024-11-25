public class ListaDuplamenteEncadeada {

    Nodo inicio, ultimo;

    private class Nodo {
        Nodo proximo, anterior;
        Integer dado;

        Nodo(Integer dado) {
            this.dado = dado;
            this.proximo = null;
            this.anterior = null;
        }
    }

    ListaDuplamenteEncadeada() {
        inicio = null;
        ultimo = null;
    }

    Integer remove02() {
        Integer n = ultimo.dado;
        if (inicio == ultimo) {
            inicio = ultimo = null;
        } else {
            ultimo = ultimo.anterior;
            ultimo.proximo = null;
        }
        return n;
    }

    boolean insereOrdenado(Integer valor) {
        if (inicio == null) {
            Nodo novo = new Nodo(valor);
            inicio = ultimo = novo;
            return true;
        }

        Nodo a = inicio;

        while (a != null) {
            if (a.dado.equals(valor)) {
                return false;
            }
            a = a.proximo;
        }

        Nodo novo = new Nodo(valor);

        if (valor < inicio.dado) {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
            return true;
        }

        if (valor > ultimo.dado) {
            novo.anterior = ultimo;
            ultimo.proximo = novo;
            ultimo = novo;
            return true;
        }

        Nodo insere = inicio;

        while (insere != null && insere.dado < valor) {
            insere = insere.proximo;
        }

        novo.proximo = insere;
        novo.anterior = insere.anterior;
        if (insere.anterior != null) {
            insere.anterior.proximo = novo;
        }
        insere.anterior = novo;

        return true;
    }

    ListaDuplamenteEncadeada retornaListaPares() {
        ListaDuplamenteEncadeada LPares = new ListaDuplamenteEncadeada();
        Nodo atual = inicio;

        while (atual != null) {
            if (atual.dado % 2 == 0) {
                LPares.insereOrdenado(atual.dado);
            }
            atual = atual.proximo;
        }
        return LPares;
    }

    void print() {
        Nodo atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}