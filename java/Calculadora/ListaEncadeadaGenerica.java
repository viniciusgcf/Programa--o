class ListaEncadeadaGenerica<Item> {
    Nodo inicio;

    public class Nodo {
        Item dados;
        Nodo proximo;
    }

    void insereInicio(Item n) {
        Nodo novo = new Nodo();
        novo.dados = n;
        novo.proximo = inicio;
        inicio = novo;
    }

    Item removeInicio() {
        if (inicio != null) {
            Item valor = inicio.dados;
            inicio = inicio.proximo;
            return valor;
        }
        return null;
    }

    Item removeMeio(Item n) {
        Nodo atual = inicio;
        Nodo anterior = null;

        while (atual.dados != null && !atual.dados.equals(n)) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual.equals(null)) {
            return null;
        }

        if (anterior.equals(null)) {
            return removeInicio();
        } else {
            anterior.proximo = atual.proximo;
            Item x = atual.dados;
            return x;
        }
    }

    void inserefinal(Item n) {
        Nodo novo = new Nodo();
        novo.dados = n;
        novo.proximo = null;

        if (inicio == null) {
            inicio = novo;

        } else {
            Nodo atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }

    }

    Item removeFinal() {
        if (inicio == null) {
            return null;
        }

        if (inicio.proximo == null) {
            Item valor = inicio.dados;
            inicio = null;
            return valor;
        }

        Nodo atual = inicio;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        Item x = atual.proximo.dados;
        atual.proximo = null;
        return x;
    }

    void imprimeLista() {
        Nodo temp = inicio;
        while (temp != null) {
            System.out.printf("'" + temp.dados + "'" + " -> ");
            temp = temp.proximo;
        }
        System.out.println();
    }

}