import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Disciplina disciplina = new Disciplina();
        disciplina.carregaDoArquivo();
        disciplina.Menu();
    }
}
