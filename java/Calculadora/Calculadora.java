public class Calculadora {
    private PilhaGenerica<Float> numeros;
    private PilhaGenerica<Character> operadores;

    public Calculadora() {
        numeros = new PilhaGenerica<Float>();
        operadores = new PilhaGenerica<Character>();
    }

    public void mostrarPilhaNumeros() {
        numeros.mostrarPilha();
    }

    public void mostrarPilhaOperadores() {
        operadores.mostrarPilha();
    }

    public void adicionarNumero(Float aux) {
        numeros.empilhar(aux);
        System.out.println("Número adicionado com sucesso.");
    }

    public void adicionarOperador(Character aux) {
        if (operadorEhValido(aux)) {
            operadores.empilhar(aux);
            System.out.println("Operador adicionado com sucesso.");
        } else {
            System.out.println("Operador inválido!");
        }
    }

    public void executarCalculo() {
        if (!pilhasInsuficientes()) {
            float numero2 = numeros.desempilhar();
            float numero1 = numeros.desempilhar();
            Character operador = operadores.desempilhar();
            float resultado = calcularOperacao(numero1, numero2, operador);

            System.out.printf("%.2f %c %.2f = %.2f%n", numero1, operador, numero2, resultado);
            adicionarNumero(resultado);
        }
    }

    public boolean operadorEhValido(Character aux) {
        return "+-*/".indexOf(aux) >= 0;
    }

    public boolean pilhasInsuficientes() {
        int quantidadeNumeros = numeros.tamanho();

        if (quantidadeNumeros < 2) {
            System.out.println("São necessários mais " + (2 - quantidadeNumeros) + " número(s) na pilha.");
            return true;
        } else if (operadores.tamanho() < 1) {
            System.out.println("Não há operadores suficientes. Adicione ao menos 1 operador.");
            return true;
        }
        return false;
    }

    private float calcularOperacao(float numero1, float numero2, Character operador) {
        switch (operador) {
            case '/':
                if (numero2 == 0) {
                    throw new IllegalArgumentException("Divisão por zero não é permitida.");
                }
                return numero1 / numero2;
            case '*':
                return numero1 * numero2;
            case '+':
                return numero1 + numero2;
            case '-':
                return numero1 - numero2;
            default:
                System.out.println("Operador desconhecido.");
                return 0;
        }
    }

    public void carregarTeste() {
        adicionarNumero(2.2f);
        adicionarNumero(4.2f);
        adicionarNumero(6.2f);
        adicionarNumero(8.2f);
        adicionarNumero(10.2f);

        adicionarOperador('-');
        adicionarOperador('*');
        adicionarOperador('+');
        adicionarOperador('/');
    }
}
