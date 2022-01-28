package semana10;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExercicioCinco {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite um ano e um mês");

        int ano = 0;
        int mes = 0;
        try {
            System.out.println("Digite o ano:");
            ano = sc.nextInt();
            System.out.println("Digite o mês:");
            mes = sc.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Por favor, ano e mês devem ser números!");
            main(args);
        }

        LocalDate data = LocalDate.of(ano, mes, 01);
        LocalDate ultimaDiaDoMes = data.with(TemporalAdjusters.lastDayOfMonth());
        for (int i = 1; i <= ultimaDiaDoMes.getDayOfMonth(); i++) {
            LocalDate dataLoop = LocalDate.of(ano, mes, i);
            DayOfWeek diaDaSemanaLoop = dataLoop.getDayOfWeek();
            if (diaDaSemanaLoop == DayOfWeek.MONDAY) {
                System.out.println(dataLoop.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
            }

        }

    }
}
