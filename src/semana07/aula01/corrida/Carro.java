package semana07.aula01.corrida;

public class Carro {
    private String categoria;
    private String numero;
    private String marca;
    private String potencia;
    private int capacidadeCombustivel;
    private int velocidadeAtual = 0;
    private int velocidadeMaximaRegistada;

    public void acelera() {
        velocidadeAtual++;
    }

    public void freia() {
        velocidadeAtual--;
    }
}
