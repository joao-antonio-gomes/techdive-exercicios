package semana10.sistemaBancario;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Teste {
    public static void main(String[] args) throws IOException {
        criaContasBancoDeDados();
    }

    public static void criaContasBancoDeDados() throws IOException {
        File listaDeContas = new File("lista_de_contas.txt");
        String absolutePath = listaDeContas.getAbsolutePath();

        FileInputStream fis = new FileInputStream(absolutePath);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);


        ArrayList<Map> listaContasMap = new ArrayList<>();
        String linha = br.readLine();
        while (linha != null) {
            String[] linhaSplit = linha.split(":");
            linha = br.readLine();

            Map<String, String> conta = new HashMap<>();
            if (linhaSplit[0].contains("-")) {
                continue;
            }

            int ultimaPosicao = listaContasMap.size() - 1;
            if (listaContasMap.size() >= 1 && !listaContasMap.get(ultimaPosicao).containsKey("Numero Conta")) {
                listaContasMap.get(ultimaPosicao).put(linhaSplit[0], linhaSplit[1]);
            } else {
                conta.put(linhaSplit[0], linhaSplit[1]);
                listaContasMap.add(conta);
                continue;
            }
        }

        for (Map<String, String> conta :
                listaContasMap) {
            new Conta(conta.get("Nome Cliente"), Integer.parseInt(conta.get("Numero Conta").trim()));
        }
    }
}
