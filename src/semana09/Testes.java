package semana09;

public class Testes {
    public static void main(String[] args) {
        System.out.println("Teste de lista de contas");
        ContaCorrente cc1 = new ContaCorrente("Joao");
        ContaPoupanca cp1 = new ContaPoupanca("Maria");
        Agencia ag1 = new Agencia();
        ag1.adiciona(cc1);
        ag1.adiciona(cp1);
        System.out.println(ag1.getQuantidadeContas());


        System.out.println("Teste busca pelo nome");
        Conta maria = ag1.buscaPorTitular("Maria");
        System.out.println(maria.getNomeTitular());
    }
}
