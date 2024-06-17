package trabalho;

public class Imovel extends Endereco {
    private int codigo;
    private float areaconstruida;
    private float areatotal;
    private int numeroquartos;
    private int tipo;
    private float preco;

    public Imovel(String cidade, String bairro, int codigo, float areaconstruida, float areatotal,
            int numeroquartos, int tipo, float preco) {
        super(cidade, bairro);
        this.codigo = codigo;
        this.areaconstruida = areaconstruida;
        this.areatotal = areatotal;
        this.numeroquartos = numeroquartos;
        this.tipo = tipo;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getAreaconstruida() {
        return areaconstruida;
    }

    public void setAreaconstruida(float areaconstruida) {
        this.areaconstruida = areaconstruida;
    }

    public float getAreatotal() {
        return areatotal;
    }

    public void setAreatotal(float areatotal) {
        this.areatotal = areatotal;
    }

    public int getNumeroquartos() {
        return numeroquartos;
    }

    public void setNumeroquartos(int numeroquartos) {
        this.numeroquartos = numeroquartos;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return super.toString() + " | codigo = " + codigo + " | area construida = " + areaconstruida
                + " | area total = "
                + areatotal + " | numero de quartos = " + numeroquartos + " | tipo = " + tipo + " | preço = " + preco
                + "]";
    }

}