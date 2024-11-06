import java.util.Scanner;

public class TestaCalculadora {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        Scanner scanner = new Scanner(System.in);
        int opcao = 10;

        while (opcao != 0) {
            System.out.println("-------------------------");
            System.out.println("1 - Adicionar operador");
            System.out.println("2 - Adicionar valor");
            System.out.println("3 - Calcular resultado");
            System.out.println("4 - Exibir pilhas");
            System.out.println("0 - Sair da calculadora.");
            System.out.println("-------------------------");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite um dos operadores válidos:");
                    System.out.println("Operadores válidos: +, -, /, *");
                    scanner.nextLine();
                    String entradaOperador = scanner.nextLine();
                    Character operador = entradaOperador.charAt(0);
                    calculadora.adicionarOperador(operador);
                    break;
                case 2:
                    System.out.println("Digite um número real para adicionar:");
                    float valor = scanner.nextFloat();
                    calculadora.adicionarNumero(valor);
                    break;

                case 3:
                    System.out.println("Executando cálculo...");
                    calculadora.executarCalculo();
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Exibindo pilhas...");
                    calculadora.mostrarPilhaOperadores();
                    System.out.println();
                    calculadora.mostrarPilhaNumeros();
                    System.out.println();
                    break;

                case 0:
                    System.out.println("Saindo da calculadora.");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}
