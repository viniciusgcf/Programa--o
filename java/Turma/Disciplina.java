import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Disciplina {
    private ArrayList<Estudante> turma = new ArrayList<>();

    public ArrayList<Estudante> getTurma() {
        return turma;
    }

    public void listarEstudantes() {
        for (Estudante estudante : turma) {
            System.out.println("-------------------------");
            System.out.println("| Nome = " + estudante.getNome());
            System.out.println("| CPF = " + estudante.getCpf());
            System.out.println("| Matricula = " + estudante.getMatricula());
            System.out.println("| Nota 1 = " + estudante.getNota1());
            System.out.println("| Nota 2 = " + estudante.getNota2());
            System.out.println("| Média = " + estudante.getMedia());
            System.out.println("-------------------------");
        }
    }

    public void mediaTurma() {
        double mediaTurma = 0;
        for (Estudante estudante : turma) {
            mediaTurma += estudante.getMedia();
        }
        System.out.println("A média da turma é: " + mediaTurma / turma.size());
    }

    Scanner leia = new Scanner(System.in);

    public void insereEstudante() {
        leia.nextLine();
        System.out.println("Digite o nome do estudante: ");
        String nome = leia.nextLine();
        System.out.println("Digite o CPF do estudante: ");
        String CPF = leia.nextLine();
        System.out.println("Digite a matricula do estudante: ");
        String matricula = leia.nextLine();
        System.out.println("Digite a primeira nota do estudante: ");
        Float nota1 = leia.nextFloat();
        System.out.println("Digite a segunda nota do estudante: ");
        Float nota2 = leia.nextFloat();
        Estudante estudante = new Estudante(nome, CPF, matricula, nota1, nota2);
        turma.add(estudante);
    }

    public void alteraEstudante() {
        leia.nextLine();
        System.out.println("Digite a matricula do aluno que deseja modificar: ");
        String matricula1 = leia.nextLine();
        for (Estudante estudante : turma) {
            if (matricula1.equals(estudante.getMatricula())) {
                leia.nextLine();
                System.out.println("Digite o nome do estudante: ");
                String nome = leia.nextLine();
                estudante.setNome(nome);
                System.out.println("Digite o CPF do estudante: ");
                String CPF = leia.nextLine();
                estudante.setCpf(CPF);
                System.out.println("Digite a matricula do estudante: ");
                String matricula = leia.nextLine();
                estudante.setMatricula(matricula);
                System.out.println("Digite a primeira nota do estudante: ");
                Float nota1 = leia.nextFloat();
                estudante.setNota1(nota1);
                System.out.println("Digite a segunda nota do estudante: ");
                Float nota2 = leia.nextFloat();
                estudante.setNota2(nota2);
            } else {
                System.out.println("Matricula inexistente");
            }
        }
    }

    public void removeEstudante() {
        leia.nextLine();
        System.out.println("Digite o numero de matricula do estudante que deseja remover: ");
        String matricula1 = leia.nextLine();
        turma.removeIf(turma -> turma.getMatricula() == matricula1);
    }

    public void getEstudante() {
        leia.nextLine();
        System.out.println("Digite o numero da matricula do estudante que deseja procurar: ");
        String matricula1 = leia.nextLine();
        for (Estudante estudante : turma) {
            if (matricula1.equals(estudante.getMatricula())) {
                System.out.println("-------------------------");
                System.out.println("| Nome = " + estudante.getNome());
                System.out.println("| CPF = " + estudante.getCpf());
                System.out.println("| Matricula = " + estudante.getMatricula());
                System.out.println("| Nota 1 = " + estudante.getNota1());
                System.out.println("| Nota 2 = " + estudante.getNota2());
                System.out.println("| Média = " + estudante.getMedia());
                System.out.println("-------------------------");
            }
        }
    }

    public void listarEstudantesAcima6() {
        for (Estudante estudante : turma) {
            if (estudante.getMedia() >= 6) {
                System.out.println("-------------------------");
                System.out.println("| Nome = " + estudante.getNome());
                System.out.println("| CPF = " + estudante.getCpf());
                System.out.println("| Matricula = " + estudante.getMatricula());
                System.out.println("| Nota 1 = " + estudante.getNota1());
                System.out.println("| Nota 2 = " + estudante.getNota2());
                System.out.println("| Média = " + estudante.getMedia());
                System.out.println("-------------------------");
            }
        }
    }

    public void listarEstudantesAbaixo6() {
        for (Estudante estudante : turma) {
            if (estudante.getMedia() < 6) {
                System.out.println("-------------------------");
                System.out.println("| Nome = " + estudante.getNome());
                System.out.println("| CPF = " + estudante.getCpf());
                System.out.println("| Matricula = " + estudante.getMatricula());
                System.out.println("| Nota 1 = " + estudante.getNota1());
                System.out.println("| Nota 2 = " + estudante.getNota2());
                System.out.println("| Média = " + estudante.getMedia());
                System.out.println("-------------------------");
            }
        }
    }

    public void gravaArquivo() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("estudantes.csv"))) {
            for (Estudante estudante : turma) {
                bw.write(estudante.getEstudanteCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao gravar dados dos estudantes no arquivo.");
        }
    }

    public void carregaDoArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader("estudantes.csv"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Estudante estudante = new Estudante(linha, linha, linha, 0, 0);
                estudante.setEstudanteCSV(linha);
                turma.add(estudante);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados dos estudantes do arquivo.");
        }
    }

    public void Menu() throws IOException {
        int opcao = 10;

        while (opcao != 0) {
            System.out.println("""
                    ----------------------------------------------
                    | 1. Registrar novo estudante                |
                    | 2. Remover Estudante                       |
                    | 3. Alterar Estudante                       |
                    | 4. Procurar um estudante                   |
                    | 5. Listar estudantes                       |
                    | 6. Listar estudantes com média maior que 6 |
                    | 7. Listar estudantes com média menor que 6 |
                    | 8. Mostrar média da turma                  |
                    | 0. Sair                                    |
                    ----------------------------------------------
                    """);
            opcao = leia.nextInt();
            switch (opcao) {
                case 1:
                    insereEstudante();
                    gravaArquivo();
                    break;
                case 2:
                    removeEstudante();
                    gravaArquivo();
                    break;
                case 3:
                    alteraEstudante();
                    gravaArquivo();
                    break;
                case 4:
                    getEstudante();
                    break;
                case 5:
                    listarEstudantes();
                    break;
                case 6:
                    listarEstudantesAcima6();
                    break;
                case 7:
                    listarEstudantesAbaixo6();
                    break;
                case 8:
                    mediaTurma();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("opção inválida, digite novamente.");
                    break;
            }
        }
        leia.close();
    }
}
