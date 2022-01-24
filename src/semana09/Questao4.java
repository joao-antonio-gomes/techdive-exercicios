package semana09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Eu sei dividir");

        boolean valorInvalido = false;
        int valor1 = 0;
        do {
            System.out.println("Informe o primeiro valor: ");
            int valor = 0;
            try {
                valor = teclado.nextInt();
                valorInvalido = false;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido, digite um número válido!");
                teclado.nextLine();
                valorInvalido = true;
            }
            valor1 = valor;
        } while (valorInvalido);

        int valor2 = 0;
        do {
            System.out.println("Informe o segundo valor: ");
            int valor = 0;
            try {
                valor = teclado.nextInt();
                valorInvalido = false;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido, digite um número válido!");
                teclado.nextLine();
                valor = 1;
                valorInvalido = true;
            }
            if (valor == 0) {
                System.out.println("Não é possível dividir por zero!");
                valorInvalido = true;
            }
            valor2 = valor;
        } while (valorInvalido);
        double resultado = valor1 / valor2;
        System.out.println("O resultado da divisão é: " + resultado);
    }
}
