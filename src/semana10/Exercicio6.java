package semana10;

import java.io.*;

public class Exercicio6 {
    public static void main(String[] args) throws IOException {
        File file = new File("lista_de_filmes.txt");
        String absolutePathFile = file.getAbsolutePath();
        FileInputStream fis = new FileInputStream(absolutePathFile);
        double bytes = fis.read();
        double kilobytes = (bytes/1024);
        double megabytes = (kilobytes/1024);

        System.out.println("O arquivo tem: " + bytes + " bytes.");
        System.out.println("O arquivo tem: " + kilobytes + " kilobytes.");
        System.out.println("O arquivo tem: " + megabytes + " megabytes.");
    }
}
