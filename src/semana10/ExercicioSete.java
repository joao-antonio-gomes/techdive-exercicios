package semana10;

import java.io.*;
import java.util.Scanner;

public class ExercicioSete {
    public static void main(String[] args) throws IOException {
        File file = new File("lista_de_filmes.txt");
        String absolutePath = file.getAbsolutePath();

        FileInputStream fis = new FileInputStream(absolutePath);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("Qual caracter você deseja conta?");
        Scanner scanner = new Scanner(System.in);
        String caracter = scanner.nextLine();

        int count = 0;
        String linha = br.readLine();
        while (linha != null) {
            String[] linhaSplit = linha.split("");
            for (String letra :
                    linhaSplit) {
                if (letra.equalsIgnoreCase(caracter)) {
                    count++;
                }
            }
            linha = br.readLine();
        }

        System.out.println("O caracter foi encontrado " + count + " vezes!");
    }
}
