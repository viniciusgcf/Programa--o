package ArvoreBinaria;

class Nodo {
    int dados;
    Nodo esq;
    Nodo dir;

    public Nodo(int dados) {
        this.dados = dados;
    }
}

public class ArvoreBinaria {

    Nodo raiz;

    public void add(int dados) {
        raiz = adicionar(raiz, dados);
    }

    public Nodo adicionar(Nodo raiz, int dados) {
        if (raiz == null) {
            raiz = new Nodo(dados);
        } else if (dados < raiz.dados) {
            raiz.esq = adicionar(raiz.esq, dados);
        } else if (dados > raiz.dados) {
            raiz.dir = adicionar(raiz.dir, dados);
        }
        return raiz;
    }

    public void preOrdemInicio() {
        preOrdem(raiz);
    }

    public void preOrdem(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.dados + " ");
            preOrdem(raiz.esq);
            preOrdem(raiz.dir);
        }
    }

    public void emOrdemInicio() {
        emOrdem(raiz);
    }

    public void emOrdem(Nodo raiz) {
        if (raiz != null) {
            emOrdem(raiz.esq);
            System.out.print(raiz.dados + " ");
            emOrdem(raiz.dir);
        }
    }

    public void posOrdemInicio() {
        posOrdem(raiz);
    }

    public void posOrdem(Nodo raiz) {
        if (raiz != null) {
            posOrdem(raiz.esq);
            posOrdem(raiz.dir);
            System.out.print(raiz.dados + " ");
        }
    }

    public int tamanhoInicio() {
        return tamanho(raiz);
    }

    public int tamanho(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        return 1 + tamanho(raiz.esq) + tamanho(raiz.dir);
    }

    public Nodo inverteInicio() {
        return inverte(raiz);
    }

    public Nodo inverte(Nodo raiz) {
        if (raiz == null) {
            return raiz;
        }
        Nodo esq = inverte(raiz.esq);
        Nodo dir = inverte(raiz.dir);

        raiz.dir = esq;
        raiz.esq = dir;

        return raiz;
    }
}
