import java.util.Scanner;

public class CadastroDePessoas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa = null;
        int opcao;

        do {
            System.out.println("Sistema de Cadastro de Pessoas");
            System.out.println("==============================");
            System.out.println("1 - Cadastrar Pessoa");
            System.out.println("2 - Mostrar Pessoa");
            System.out.println("3 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a idade:");
                    int idade = scanner.nextInt();
                    System.out.println("Digite o CPF:");
                    String cpf = scanner.nextLine();
                    System.out.println("Escolha o sexo (M/F):");
                    char sexo = scanner.next().charAt(0);
                    if (sexo == 'M' || sexo == 'F') {
                        pessoa = new Pessoa(nome, cpf, idade, sexo);
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 2:
                    if (pessoa != null) {
                        pessoa.imprimir();
                    } else {
                        System.out.println("Nenhuma pessoa cadastrada");
                    }
                    break;

                case 3:
                    System.out.println("Saindo... Valeu Flw!");
                    System.out.println("Feito por: https://github.com/vidaaal");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
                    break;
            }

        } while (opcao != 3);

        scanner.close();

    }
}

class Pessoa {
    private String nome;
    private String cpf;
    private int idade;
    private char sexo;

    public Pessoa(String nome, String cpf, int idade, char sexo) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public void imprimir() {
        System.out.println("== Dados da Pessoa ==");
        System.out.println("Nome:" + nome);
        System.out.println("Idade:" + idade);
        System.out.println("CPF:" + cpf);
        System.out.println("Sexo:" + sexo);
    }
}
