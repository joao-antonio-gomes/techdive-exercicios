package semana10;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.TemporalAdjusters.firstInMonth;

public class Exercicio3 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int todayYear = today.getYear();
        for (int i = 1; i <= 12; i++) {
            LocalDate monthLoop = LocalDate.of(todayYear, i, 1);
            System.out.println("O primeiro sábado do mês " + monthLoop.getMonthValue() + " é no dia " +
                    monthLoop.with(firstInMonth(DayOfWeek.SATURDAY)).format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
        }
    }
}
