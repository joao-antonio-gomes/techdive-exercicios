package semana10;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio2 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite a data de saída do vôo (dd/mm/aaaa):");
        String dataSaida = sc.nextLine();
        System.out.println("Digita a hora de saída do vôo (hh:MM):");
        String horaSaida = sc.nextLine();

        LocalDateTime dataHoraSaida = null;
        try {
            String[] dataSplit = dataSaida.split("/");
            int dia = Integer.parseInt(dataSplit[0]);
            int mes = Integer.parseInt(dataSplit[1]);
            int ano = Integer.parseInt(dataSplit[2]);

            String[] horaSplit = horaSaida.split(":");
            int hora = Integer.parseInt(horaSplit[0]);
            int minuto = Integer.parseInt(horaSplit[1]);

            dataHoraSaida = LocalDateTime.of(ano, mes, dia, hora, minuto);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException exception) {
            System.out.println("Data inválida!");
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            main(args);
        }

        String dataHoraSaidaFormatada = dataHoraSaida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println("Data e hora de saída do vôo: " + dataHoraSaidaFormatada);
        System.out.println();
        System.out.println("Digite a data de chegada do vôo (dd/mm/aaaa):");
        String dataChegada = sc.nextLine();
        System.out.println("Digita a hora de chegada do vôo (hh:MM):");
        String horaChegada = sc.nextLine();

        LocalDateTime dataHoraChegada = null;
        try {
            String[] dataSplit = dataChegada.split("/");
            int dia = Integer.parseInt(dataSplit[0]);
            int mes = Integer.parseInt(dataSplit[1]);
            int ano = Integer.parseInt(dataSplit[2]);

            String[] horaSplit = horaChegada.split(":");
            int hora = Integer.parseInt(horaSplit[0]);
            int minuto = Integer.parseInt(horaSplit[1]);

            dataHoraChegada = LocalDateTime.of(ano, mes, dia, hora, minuto);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException exception) {
            System.out.println("Data inválida!");
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            main(args);
        }

        String dataHoraChegadaFormatada = dataHoraChegada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println("Data e hora de chegada do vôo: " + dataHoraChegadaFormatada);

        long horasDiferenca = Duration.between(dataHoraSaida, dataHoraChegada).toHours();

        System.out.println("\nHoras de diferença entre saída e chegada: " + horasDiferenca);
    }
}
