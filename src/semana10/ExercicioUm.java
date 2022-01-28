package semana10;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Scanner;

public class ExercicioUm {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Digite sua data de nascimento (dd/mm/aaaa): ");
        LocalDate dataAtual = LocalDate.now();

        String data = input.nextLine();

        LocalDate dataNascimento = null;
        try {
            String[] dataSplit = data.split("/");
            int dia = Integer.parseInt(dataSplit[0]);
            int mes = Integer.parseInt(dataSplit[1]);
            int ano = Integer.parseInt(dataSplit[2]);
            dataNascimento = LocalDate.of(ano, mes, dia);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException exception) {
            System.out.println("Data inválida!");
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            main(args);
        }

        int anos = Period.between(Objects.requireNonNull(dataNascimento), dataAtual).getYears();
        System.out.println("Você tem " + anos + " anos.");

        if (anos >= 18) {
            System.out.println("Você pode acessar o sistema.");
            return;
        }

        System.out.println("Você não pode acessar o sistema.");
    }
}
