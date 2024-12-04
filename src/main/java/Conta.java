import java.util.*;

public class Conta {

    int numero_conta;
    String titular_conta;
    double saldo;

    Scanner entrada = new Scanner(System.in);

    public Conta(String nome_titular, double saldo_inicial) {
        this.titular_conta = nome_titular;
        this.saldo = saldo_inicial;

        Random gerador_numero = new Random();
        numero_conta = gerador_numero.nextInt(1000); // Gerador randômico de números (class Random)
    }

    public void VerSaldo() {
        System.out.println("O número da conta é: " + numero_conta);
        System.out.println("O titular da conta é: " + titular_conta);
        System.out.println("O saldo da conta é: " + saldo);
    }

    public void Saque(double valor_saque) {
        if (saldo >= valor_saque) {
            saldo -= valor_saque;
            System.out.println("Seu saldo atual é de: " + saldo);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void Deposito(double valor_deposito) {
        if (valor_deposito <= 0) {
            System.out.println("Depósito inválido!");
        } else {
            saldo += valor_deposito;
            System.out.println("Depósito realizado com sucesso!");
            System.out.println("Seu saldo agora é de: " + saldo);
        }
    }

    public void SolicitarEmprestimo() {
        System.out.println("Digite o valor do empréstimo desejado: ");
        double valor_emprestimo = entrada.nextDouble();

        double limite_emprestimo = saldo * 0.5;

        if (valor_emprestimo <= limite_emprestimo) {
            saldo += valor_emprestimo;
            System.out.println("Empréstimo aprovado!");
            System.out.println("Você recebeu: " + valor_emprestimo);
            System.out.println("Seu saldo agora é de: " + saldo);
        } else {
            System.out.println("Empréstimo recusado! Você pode solicitar no máximo: " + limite_emprestimo);
        }
    }

    public void Iniciar() {
        int opcao;
        do {
            Exibir_menu();
            opcao = entrada.nextInt();
            Escolher_funcao(opcao);
        } while (opcao != 5);
    }

    public void PagarBoleto() {
        System.out.println("Digite o valor do boleto a ser pago: ");
        double valor_boleto = entrada.nextDouble();

        if (valor_boleto <= 0) {
            System.out.println("Valor inválido para pagamento!");
        } else if (saldo >= valor_boleto) {
            saldo -= valor_boleto;
            System.out.println("Boleto pago com sucesso!");
            System.out.println("Seu saldo atual é de: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para pagar o boleto!");
        }
    }

    public void Exibir_menu() {
        System.out.println("Bem-vindo ao Banco Vouvi");
        System.out.println("Escolha sua opção:");
        System.out.println("1 - Ver Saldo");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Solicitar Empréstimo");
        System.out.println("5 - Pagar Boleto"); // Nova opção adicionada
        System.out.println("6 - Finalizar");
    }

    public void Escolher_funcao(int opcao) {
        double saque;
        double deposito;

        switch (opcao) {
            case 1:
                VerSaldo();
                break;
            case 2:
                System.out.println("Digite o valor a ser sacado: ");
                saque = entrada.nextDouble();
                Saque(saque);
                break;
            case 3:
                System.out.println("Digite o valor a ser depositado: ");
                deposito = entrada.nextDouble();
                Deposito(deposito);
                break;
            case 4:
                SolicitarEmprestimo();
                break;
            case 5:
                PagarBoleto(); // Chama o método de pagamento de boleto
                break;
            case 6:
                System.out.println("Operação Finalizada!");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}
