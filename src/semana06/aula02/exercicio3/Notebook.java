package semana06.aula02.exercicio3;

public class Notebook extends Computador {
    private String bateria;
    private String teclado;
    private String tela;

    public Notebook(int idComputador, String nome, String modelo, String hd, String memoria,
                    String processador, String bateria, String teclado, String tela) {
        super(idComputador, nome, modelo, hd, memoria, processador);
        this.bateria = bateria;
        this.teclado = teclado;
        this.tela = tela;
    }
}
