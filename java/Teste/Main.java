public class Main {
    private void resize(int max) {
        Integer[] temp = new Integer[max];
        for (int i = 0; i < this.quantidade; i++) {
            temp[i] = this.dados[i];
        }
        this.dados = temp;
    }
}
