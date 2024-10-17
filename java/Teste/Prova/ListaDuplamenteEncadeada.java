package Teste.Prova;

public class ListaDuplamenteEncadeada {
    private Nodo inicio;
    private Nodo ultimo;
    private int tamanho;

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    private class Nodo {
        int dado;
        Nodo proximo;
        Nodo anterior;
    }

    public ListaDuplamenteEncadeada() {
        inicio = null;
        ultimo = null;
        tamanho = 5;
    }

    public void insereInicio(int n) {
        Nodo novo = new Nodo();
        novo.dado = n;
        if (inicio == ultimo) {
            inicio = novo;
            ultimo = novo;
        } else {
            inicio.anterior = novo;
            inicio = novo;
        }
    }
}
