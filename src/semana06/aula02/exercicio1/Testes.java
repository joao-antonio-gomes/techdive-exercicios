package semana06.aula02.exercicio1;

public class Testes {

    public static void main(String[] args) {
        double taxaSaqueCC = new ContaCorrente().getTaxaSaque();

        double taxaSaqueCCV = new ContaCorrenteVip().getTaxaSaque();

        System.out.println("Taxa de saque da Conta Corrente: " + taxaSaqueCC);
        System.out.println("Taxa de saque da Conta Corrente Vip: " + taxaSaqueCCV);


    }
}
