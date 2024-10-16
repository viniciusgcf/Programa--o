public class Programa {
    public static void main(String[] args) {
        ListaLigada a = new ListaLigada();
        a.adicionar("AC");
        a.adicionar("BA");
        a.adicionar("CE");
        a.adicionar("DF");
        a.adicionar("SC");
        System.out.println("Tamanho = " + a.getTamanho());
        System.out.println("Primeiro = " + a.getPrimeiro().getValor());
        System.out.println("Ultimo = " + a.getUltimo().getValor());
        System.out.println(a.get(1).getValor());
        System.out.println(a.get(2).getValor());
        System.out.println(a.get(3).getValor());
        System.out.println(a.get(4).getValor());
        System.out.println(a.get(5).getValor());
    }
}
