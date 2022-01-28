package semana06.exercicio3;

import java.util.ArrayList;

public class Testes {
    public static void main(String[] args) {
        Computador computador = new Computador(1, "Joao", "DELL", "1 TB", "16 GB DDR4", "AMD Ryzen 5 1600");
        computador.addPeriferico("Monitor");
        ArrayList<String> perifericos = computador.getPerifericos();

        System.out.println(perifericos);

    }
}
