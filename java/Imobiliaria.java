import java.util.ArrayList;
import java.util.Scanner;

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
                default -> {
                    System.out.println("Opção invalida, digite novamente: ");
                    opcao = leia.nextInt();
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

                break;
            }
            case 2 -> {

                break;
            }
            case 3 -> {

                break;
            }
            case 4 -> {

                break;
            }
            default -> {
                System.out.println("Opção inválida, digite novamente: ");
                opcao = leia.nextInt();
                break;
            }
        }
    }

    public void editar() {
        System.out.println("Digite o código da residencia que deseja excluir: ");
        int codigo = leia.nextInt();

        for (Imovel residencia : imovel) {
            if (codigo == residencia.getCodigo()) {

            }
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
            residencia.setTipo(Ntipo);
            System.out.println("Digite o preço da residencia: ");
            float Npreco = leia.nextFloat();
            residencia.setPreco(Npreco);
        }
    }

    public void excluir() {
        System.out.println("Digite o código da residência que deseja excluir: ");
        int codigo = leia.nextInt();

        imovel.removeIf(imoveis -> imoveis.getCodigo() == codigo);
    }
}
