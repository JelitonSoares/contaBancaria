import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nomeCliente = "Jeliton Soares";
        double saldoInicial = 2500.00;

        String mensagem = """
                ***********************
                Dados iniciais do cliente:
                                
                Nome: %s
                Tipo conta: Corrente
                Saldo inicial: R$ %.2f
                ***********************""".formatted(nomeCliente, saldoInicial);

        System.out.println(mensagem);

        boolean sair = false;

        while (!sair) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("""
                    Operações
                    
                    1 - Consultar saldo
                    2 - Receber valor
                    3 - Transferir valor
                    4 - sair
                    
                    Digite a opção desejada: """);
            int opcao = scanner.nextInt();
            double valor = 0;

           switch (opcao) {
               case 1:
                   System.out.println(String.format("Saldo atual: %.2f", saldoInicial));
                   break;
               case 2:
                   System.out.println("Digite qual o valor que será creditado: ");
                   valor = scanner.nextDouble();
                   saldoInicial += valor;
                   System.out.println(String.format("Saldo atual: %.2f", saldoInicial));
                   break;
               case 3:
                   System.out.println("Digite qual o valor que será debitado: ");
                   valor = scanner.nextDouble();
                   if (valor > saldoInicial) {
                       System.out.println("Saldo insuficiente!!");
                       System.out.println(String.format("Saldo atual: %.2f", saldoInicial));
                   } else {
                       saldoInicial -= valor;
                       System.out.println(String.format("Saldo atual: %.2f", saldoInicial));
                   }
                   break;
               case 4:
                   System.out.println("Até logo!!");
                   sair = true;
                   break;
               default:
                   System.out.println("Insira um número relacionado a uma opção válida!!");
            }
        }
    }
}