public class ListaEncadeadaGenerica<T> {
    private Nodo<T> inicio;

    @SuppressWarnings("hiding")
    public class Nodo<T> {
        T valor;
        Nodo<T> proximo;
    }

    public void adicionarInicio(T valor) {
        Nodo<T> novo = new Nodo<>();
        novo.valor = valor;
        novo.proximo = inicio;
        inicio = novo;
    }

    public void adicionarFinal(T valor) {
        Nodo<T> novo = new Nodo<>();
        novo.valor = valor;
        novo.proximo = null;
        if (inicio == null) {
            inicio = novo;
        } else {
            Nodo<T> atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    public T removerInicio() {
        if (inicio != null) {
            T valor = inicio.valor;
            inicio = inicio.proximo;
            return valor;
        }
        return null;
    }

    public T removerElemento(T valor) {
        Nodo<T> atual = inicio;
        Nodo<T> anterior = null;

        while (atual != null && !atual.valor.equals(valor)) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual == null) {
            return null; // Elemento não encontrado
        }

        if (anterior == null) {
            return removerInicio();
        } else {
            anterior.proximo = atual.proximo;
            return atual.valor; // Retorna o valor removido
        }
    }

    public T removerFinal() {
        if (inicio == null) {
            return null;
        }

        if (inicio.proximo == null) {
            T valor = inicio.valor;
            inicio = null;
            return valor;
        }

        Nodo<T> atual = inicio;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        T valorFinal = atual.proximo.valor;
        atual.proximo = null;
        return valorFinal;
    }

    public void imprimirLista() {
        Nodo<T> atual = inicio;
        while (atual != null) {
            System.out.print("'" + atual.valor + "' -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
}
