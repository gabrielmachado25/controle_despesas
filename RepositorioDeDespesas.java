import java.util.ArrayList;
import java.util.List;

public class RepositorioDeDespesas {
    private List<Despesa> despesas;
    private int proximoId;

    public RepositorioDeDespesas() {
        despesas = new ArrayList<>();
        proximoId = 1;
    }

    public void adicionarDespesa(String descricao, double valor, String categoria, LocalDate data) {
        Despesa despesa = new Despesa(proximoId++, descricao, valor, categoria, data);
        despesas.add(despesa);
    }

    public void editarDespesa(int id, String descricao, double valor, String categoria, LocalDate data) {
        for (Despesa despesa : despesas) {
            if (despesa.getId() == id) {
                despesa.setDescricao(descricao);
                despesa.setValor(valor);
                despesa.setCategoria(categoria);
                despesa.setData(data);
                break;
            }
        }
    }

    public void deletarDespesa(int id) {
        despesas.removeIf(despesa -> despesa.getId() == id);
    }

    public List<Despesa> obterTodasDespesas() {
        return despesas;
    }
}
