package semana06.exercicio1;

public class ContaCorrente {
    protected int idConta;
    protected double saldoConta;
    private final double taxaSaque = 1.5;

    public double getSaldoConta() {
        return saldoConta;
    }

    public void depositaValor(double valor) {
        this.saldoConta += valor;
    }

    public void sacaValor(double valor) {
        try {
            valor = valor + taxaSaque;
            if (valor > this.getSaldoConta()) {
                throw new SaldoException("Saldo insuficiente");
            }
            this.saldoConta -= valor;
        } catch (SaldoException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getTaxaSaque() {
        return taxaSaque;
    }
}
