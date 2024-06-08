import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Imobiliaria {
    ArrayList<Imovel> imovel = new ArrayList<>();

    Scanner leia = new Scanner(System.in);

    public void menu() {
        int opcao = 10;
        while (opcao != 0) {
            System.out.println("""
                    ================================
                    1.Cadastrar novo imóvel.
                    2.Listar todos imóveis.
                    3.Mostrar imóveis por condição.
                    4.Editar imóvel.
                    5.Excluir imóvel.
                    0.Sair
                    ================================
                    """);
            opcao = leia.nextInt();
            switch (opcao) {
                case 1 -> {
                    registrar();
                    break;
                }
                case 2 -> {
                    listar();
                    break;
                }
                case 3 -> {
                    filtrar();
                    break;
                }
                case 4 -> {
                    editar();
                    break;
                }
                case 5 -> {
                    excluir();
                    break;
                }
                case 0 -> {
                    break;
                }
                case 9 -> {
                    Imovel teste1 = new Imovel("Ararangua", "Mato Alto", 1, 1, 1, 1, 1, 1);
                    imovel.add(teste1);
                    Imovel teste2 = new Imovel("Ararangua", "Mato Alto", 2, 2, 2, 2, 2, 2);
                    imovel.add(teste2);
                    Imovel teste3 = new Imovel("Criciuma", "Balo", 1, 1, 1, 1, 1, 1);
                    imovel.add(teste3);
                    Imovel teste4 = new Imovel("Criciuma", "Jale", 2, 2, 2, 2, 2, 2);
                    imovel.add(teste4);
                    break;
                }
                default -> {
                    regular(opcao, 5);
                    break;
                }
            }
        }
    }

    public void registrar() {
        leia.nextLine();
        System.out.println("Digite o bairro onde a residência esta localizada: ");
        String bairro = leia.nextLine();
        System.out.println("Digite a cidade onde a residência esta localizada: ");
        String cidade = leia.nextLine();
        System.out.println("Digite o código da residencia: ");
        int codigo = leia.nextInt();
        System.out.println("Digite a área construida no lote: ");
        float areaconstruida = leia.nextFloat();
        System.out.println("Digite a área total do lote: ");
        float areatotal = leia.nextFloat();
        System.out.println("Digite o número de quartos: ");
        int numeroquartos = leia.nextInt();
        System.out.println("Digite o tipo de residencia, 0 para casa e 1 para apartamento: ");
        int tipo = leia.nextInt();
        tipo = regular(tipo, 1);
        System.out.println("Digite o preço da residencia: ");
        float preco = leia.nextFloat();
        Imovel residencia = new Imovel(cidade, bairro, codigo, areaconstruida, areatotal, numeroquartos,
                tipo, preco);
        imovel.add(residencia);
    }

    public void listar() {
        for (Imovel residencia : imovel) {
            System.out.println(residencia);
        }
    }

    public void filtrar() {
        int opcao;
        System.out.println("""
                ============================
                Digite o metodo de filtragem
                1.Por tipo
                2.Por cidade
                3.Por bairro
                4.Por faixa de preço
                ============================
                """);
        opcao = leia.nextInt();
        switch (opcao) {
            case 1 -> {
                System.out.println("Digite 0 para listar casas e 1 para apartamentos: ");
                int otipo = leia.nextInt();
                otipo = regular(otipo, 1);
                for (Imovel residencia : imovel) {
                    if (otipo == residencia.getTipo()) {
                        System.out.println(residencia);
                    }
                }
                break;
            }
            case 2 -> {
                List<String> cidadesR = new ArrayList<>();
                for (Imovel residencia : imovel) {
                    cidadesR.add(residencia.getCidade());
                }
                System.out.println("Cidades disponiveis, digite o nome de qual deseja pesquisar");
                Set<String> cidadesU = new HashSet<>(cidadesR);
                for (String cidade : cidadesU) {
                    System.out.println(cidade);
                }
                String cidadeT = leia.nextLine();
                for (Imovel residencia : imovel) {
                    if (cidadeT.equals(residencia.getCidade())) {
                        System.out.println(residencia);
                    }
                }

                break;
            }
            case 3 -> {

                break;
            }
            case 4 -> {
                System.out.println("Digite o preço minimo que deseja pesquisar: ");
                int min = leia.nextInt();
                System.out.println("Digite o preço maximo: ");
                int max = leia.nextInt();
                for (Imovel residencia : imovel) {
                    if (residencia.getPreco() < max && residencia.getPreco() > min) {
                        System.out.println(residencia);
                    }
                }
                break;
            }
            default -> {
                opcao = regular(opcao, 4);
                break;
            }
        }
    }

    public void editar() {
        System.out.println("Digite o código da residencia que deseja excluir: ");
        int codigo = leia.nextInt();

        for (Imovel residencia : imovel) {
            if (codigo == residencia.getCodigo()) {

                leia.nextLine();
                System.out.println("Digite o bairro onde a residência esta localizada: ");
                String Nbairro = leia.nextLine();
                residencia.setBairro(Nbairro);
                System.out.println("Digite a cidade onde a residência esta localizada: ");
                String Ncidade = leia.nextLine();
                residencia.setCidade(Ncidade);
                System.out.println("Digite o código da residencia: ");
                int Ncodigo = leia.nextInt();
                residencia.setCodigo(Ncodigo);
                System.out.println("Digite a área construida no lote: ");
                float Nareaconstruida = leia.nextFloat();
                residencia.setAreaconstruida(Nareaconstruida);
                System.out.println("Digite a área total do lote: ");
                float Nareatotal = leia.nextFloat();
                residencia.setAreatotal(Nareatotal);
                System.out.println("Digite o número de quartos: ");
                int Nnumeroquartos = leia.nextInt();
                residencia.setNumeroquartos(Nnumeroquartos);
                System.out.println("Digite o tipo de residencia, 0 para casa e 1 para apartamento: ");
                int Ntipo = leia.nextInt();
                Ntipo = regular(Ntipo, 1);
                residencia.setTipo(Ntipo);
                System.out.println("Digite o preço da residencia: ");
                float Npreco = leia.nextFloat();
                residencia.setPreco(Npreco);
            }
        }
    }

    public void excluir() {
        System.out.println("Digite o código da residência que deseja excluir: ");
        int codigo = leia.nextInt();

        imovel.removeIf(imoveis -> imoveis.getCodigo() == codigo);
    }

    public int regular(int a, int b) {
        while (a > b) {
            System.out.println("Opção invalida, digite novamente: ");
            a = leia.nextInt();
        }
        return a;
    }
}
