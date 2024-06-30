public class Estudante extends Pessoa {
    private String matricula;
    private float nota1;
    private float nota2;

    public String getMatricula() {
        return matricula;
    }

    public float getNota1() {
        return nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public float getMedia() {
        return (this.nota1 + this.nota2) / 2;
    }

    public String getEstudanteCSV() {
        return "a";
    }

    public void setEstudanteCSV(String linha) {

    }

}
