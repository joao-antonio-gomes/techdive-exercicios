package semana10;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Exercicio4 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite uma data para saber se é sexta-feira 13 (dd/mm/aaaa):");
        String data = sc.nextLine();

        LocalDate sextaFeiraTreze = null;
        try {
            String[] dataSplit = data.split("/");
            int dia = Integer.parseInt(dataSplit[0]);
            if (dia != 13) {
                System.out.println("Não é dia 13!");
                return;
            }
            int mes = Integer.parseInt(dataSplit[1]);
            int ano = Integer.parseInt(dataSplit[2]);
            sextaFeiraTreze = LocalDate.of(ano, mes, dia);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException exception) {
            System.out.println("Data inválida!");
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            main(args);
        }

        DayOfWeek dayOfWeek = sextaFeiraTreze.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.FRIDAY) {
            System.out.println("Essa data é sexta-feira 13!!!");
            return;
        }

        System.out.println("É dia 13 mas não é sexta-feira...");
    }
}
