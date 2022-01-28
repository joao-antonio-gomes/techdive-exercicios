package semana06.exercicio1;

public class ContaCorrenteVip extends ContaCorrente {
    private final double taxaSaque = 5.5;

    @Override
    public double getTaxaSaque() {
        return taxaSaque;
    }
}
