package garagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroDeCarros {

    private static List<Carro> carros = new ArrayList<>();
    private static int proximoId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Carro");
            System.out.println("2. Listar Carros");
            System.out.println("3. Atualizar Carro");
            System.out.println("4. Deletar Carro");
            System.out.println("5. Aplicar Desconto ao Carro");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    adicionarCarro(scanner);
                    System.out.println("Carro adicionado com sucesso!");
                    break;
                case 2:
                    listarCarros();
                    System.out.println("Listagem concluída!");
                    break;
                case 3:
                    atualizarCarro(scanner);
                    System.out.println("Atualização concluída!");
                    break;
                case 4:
                    deletarCarro(scanner);
                    System.out.println("Carro deletado com sucesso!");
                    break;
                case 5:
                    aplicarDesconto(scanner);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void adicionarCarro(Scanner scanner) {
        System.out.print("Digite a marca do carro: ");
        String marca = scanner.nextLine();
        System.out.print("Digite o modelo do carro: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite o ano do carro: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o valor do carro: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Carro carro = new Carro(proximoId++, marca, modelo, ano, valor);
        carros.add(carro);
        System.out.println("Carro adicionado com sucesso!");
    }

    private static void listarCarros() {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro registrado.");
        } else {
            System.out.println("\nCarros registrados:");
            for (Carro carro : carros) {
                System.out.println(carro);
            }
        }
    }

    private static void atualizarCarro(Scanner scanner) {
        System.out.print("Digite o ID do carro que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Carro carroParaAtualizar = null;
        for (Carro c : carros) {
            if (c.getId() == id) {
                carroParaAtualizar = c;
                break;
            }
        }

        if (carroParaAtualizar != null) {
            System.out.print("Digite a nova marca do carro: ");
            carroParaAtualizar.setMarca(scanner.nextLine());
            System.out.print("Digite o novo modelo do carro: ");
            carroParaAtualizar.setModelo(scanner.nextLine());
            System.out.print("Digite o novo ano do carro: ");
            carroParaAtualizar.setAno(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Digite o novo valor do carro: ");
            carroParaAtualizar.setValor(scanner.nextDouble());
            scanner.nextLine();
            System.out.println("Atualização concluída!");
        } else {
            System.out.println("Carro com ID " + id + " não encontrado.");
        }
    }

    private static void aplicarDesconto(Scanner scanner) {
        System.out.print("Digite o ID do carro para aplicar desconto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Carro carroParaDesconto = null;
        for (Carro c : carros) {
            if (c.getId() == id) {
                carroParaDesconto = c;
                break;
            }
        }

        if (carroParaDesconto != null) {
            System.out.print("Digite a porcentagem de desconto (ex: 10 para 10%): ");
            double desconto = scanner.nextDouble();
            scanner.nextLine();
            double valorAtual = carroParaDesconto.getValor();
            double valorComDesconto = valorAtual - (valorAtual * desconto / 100);
            carroParaDesconto.setValor(valorComDesconto);
            System.out.println("Desconto aplicado. Novo valor: R$ " + valorComDesconto);
        } else {
            System.out.println("Carro com ID " + id + " não encontrado.");
        }
    }

    private static void deletarCarro(Scanner scanner) {
        System.out.print("Digite o ID do carro que deseja deletar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Carro carroParaDeletar = null;
        for (Carro c : carros) {
            if (c.getId() == id) {
                carroParaDeletar = c;
                break;
            }
        }

        if (carroParaDeletar != null) {
            carros.remove(carroParaDeletar);
            System.out.println("Carro deletado com sucesso!");
        } else {
            System.out.println("Carro com ID " + id + " não encontrado.");
        }
    }


}
