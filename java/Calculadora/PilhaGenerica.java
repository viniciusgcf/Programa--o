public class PilhaGenerica<T> {
    private ListaEncadeadaGenerica<T> elementos;
    private int quantidade = 0;

    public PilhaGenerica() {
        elementos = new ListaEncadeadaGenerica<T>();
    }

    public void empilhar(T valor) {
        elementos.adicionarFinal(valor);
        quantidade++;
    }

    public T desempilhar() {
        if (estaVazia()) {
            throw new IllegalStateException("A pilha está vazia. Não é possível desempilhar.");
        }
        quantidade--;
        return elementos.removerFinal();
    }

    public boolean estaVazia() {
        return quantidade == 0;
    }

    public void mostrarPilha() {
        elementos.imprimirLista();
    }

    public int tamanho() {
        return this.quantidade;
    }
}
