import java.util.Scanner;

public class MenuDeOpcoes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno aluno = null; // Variável para armazenar o aluno cadastrado
        int opcao;

        do {
            System.out.println("=== Menu de Opções ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Mostrar Aluno");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a idade do aluno: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    aluno = new Aluno(nome, idade);
                    System.out.println("Aluno cadastrado com sucesso!");
                    break;

                case 2:
                    if (aluno != null) {
                        aluno.imprimir();
                    } else {
                        System.out.println("Nenhum aluno cadastrado.");
                    }
                    break;

                case 3:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }
}

class Aluno {
    private String nome;
    private int idade;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void imprimir() {
        System.out.println("=== Dados do Aluno ===");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}   