public class ListaEncadeada {

    Nodo inicio;

    private class Nodo {
        Integer valor;
        Nodo proximo;
    }

    void insereInicio(int n) {
        Nodo novo = new Nodo();
        novo.valor = n;
        novo.proximo = inicio;
        inicio = novo;
    }

    Integer removeInicio() {
        if (inicio != null) {
            int temp = inicio.valor;
            inicio = inicio.proximo;
            return temp;
        }
        return null;
    }

    Integer removeMeio(int n) {
        Nodo atual = inicio;
        Nodo anterior = null;
        while (atual != null && atual.valor != n) {
            anterior = atual;
            atual = atual.proximo;
        }
        if (atual == null) {
            return null;
        }
        if (anterior == null) {
            int x = atual.valor;
            inicio = inicio.proximo;
            return x;
        } else {
            int x = atual.valor;
            anterior.proximo = atual.proximo;
            return x;
        }
    }
}
