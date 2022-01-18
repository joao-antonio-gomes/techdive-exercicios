package semana09;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private static List<Conta> contas = new ArrayList<>();

    public void adiciona(Conta conta) {
        contas.add(conta);
    }

    public int getQuantidadeContas() {
        return contas.size();
    }

    public Conta buscaPorTitular(String nomeTitular) {
        for (Conta conta : contas) {
            if (conta.getNomeTitular().equals(nomeTitular)) {
                return conta;
            }
        }
        return null;
    }
}
