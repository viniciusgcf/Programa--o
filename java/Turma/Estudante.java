public class Estudante extends Pessoa {
    private String matricula;
    private float nota1;
    private float nota2;

    public Estudante(String nome, String cpf, String matricula, float nota1, float nota2) {
        super(nome, cpf);
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public String getMatricula() {
        return matricula;
    }

    public float getNota1() {
        return nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public double getMedia() {
        return (nota1 + nota2) / 2.0;
    }

    public String getEstudanteCSV() {
        return String.join(";", getNome(), getCpf(), getMatricula(), Float.toString(nota1), Float.toString(nota2));
    }

    public void setEstudanteCSV(String linha) {
        String[] Linha = linha.split(";");
        if (Linha.length == 5) {
            setNome(Linha[0]);
            setCpf(Linha[1]);
            matricula = Linha[2];
            nota1 = Float.parseFloat(Linha[3]);
            nota2 = Float.parseFloat(Linha[4]);
        } else {
            throw new IllegalArgumentException("Formato inválido para linha CSV de estudante.");
        }
    }

}
