import java.util.Scanner;

public class ContaBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta conta = new Conta();
        int opcao;

        do {
            System.out.println("=== Menu de Opções ===");
            System.out.println("1. Depositar Valor");
            System.out.println("2. Sacar Valor");
            System.out.println("3. Ver Saldo");
            System.out.println("4. Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor a ser depositado:");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;

                case 2:
                    System.out.println("Digite o valor a ser sacado:");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;

                case 3:
                    System.out.println("Seu saldo:");
                    conta.verSaldo();
                    break;

                case 4:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}

    class Conta {
        private double saldo;

        public Conta() {
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado.");
        } else {
            System.out.println("Depósito Inválidado pelo valor.");
        }
    }
        public void sacar(double valor) {
            if (valor > 0 && valor <=saldo) {
                saldo -= valor;
                System.out.println("Saque de R$" + valor + "Realizado!");
            } else {
                System.out.println("Saque inválido. Verifique o seu saldo.");
            }
        }

        public void verSaldo() {
            System.out.printf("Saldo atual: R$%.2f\n", saldo);
        }
    }

    

