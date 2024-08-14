import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ControladorFinanceiro {
    public static void main(String[] args) {
        RepositorioDeDespesas repositorio = new RepositorioDeDespesas();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("\nControle de Despesas:");
            System.out.println("1. Adicionar Despesa");
            System.out.println("2. Editar Despesa");
            System.out.println("3. Deletar Despesa");
            System.out.println("4. Ver Todas as Despesas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();  // consumir a nova linha

            switch (escolha) {
                case 1:
                    System.out.print("Digite a descrição da despesa: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite o valor da despesa: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();  // consumir a nova linha
                    System.out.print("Digite a categoria da despesa: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Digite a data da despesa (dd/MM/yyyy): ");
                    String dataStr = scanner.nextLine();
                    LocalDate data = LocalDate.parse(dataStr, formatter);
                    repositorio.adicionarDespesa(descricao, valor, categoria, data);
                    break;
                case 2:
                    System.out.print("Digite o ID da despesa para editar: ");
                    int idEdicao = scanner.nextInt();
                    scanner.nextLine();  // consumir a nova linha
                    System.out.print("Digite a nova descrição da despesa: ");
                    String novaDescricao = scanner.nextLine();
                    System.out.print("Digite o novo valor da despesa: ");
                    double novoValor = scanner.nextDouble();
                    scanner.nextLine();  // consumir a nova linha
                    System.out.print("Digite a nova categoria da despesa: ");
                    String novaCategoria = scanner.nextLine();
                    System.out.print("Digite a nova data da despesa (dd/MM/yyyy): ");
                    String novaDataStr = scanner.nextLine();
                    LocalDate novaData = LocalDate.parse(novaDataStr, formatter);
                    repositorio.editarDespesa(idEdicao, novaDescricao, novoValor, novaCategoria, novaData);
                    break;
                case 3:
                    System.out.print("Digite o ID da despesa para deletar: ");
                    int idDeletar = scanner.nextInt();
                    repositorio.deletarDespesa(idDeletar);
                    break;
                case 4:
                    System.out.println("Despesas:");
                    for (Despesa despesa : repositorio.obterTodasDespesas()) {
                        System.out.println(despesa);
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
