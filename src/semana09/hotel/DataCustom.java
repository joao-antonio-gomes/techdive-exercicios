package semana09.hotel;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DataCustom {
    private LocalDate data;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DataCustom() {
    }

    public DataCustom(String data) throws ParseException {
        this.data = obtemDataLocalDatePorString(data);
    }

    public String obtemDataEmString() {
        return data.format(formato);
    }

    public LocalDate obtemDataLocalDatePorString(String data) throws ParseException {
        return LocalDate.parse(data, formato);
    }

    public String criaDataAtual() {
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.format(formato);
    }

    public int verificaDiferencaEntreDatas(String dataInicial, String dataFinal) throws ParseException {
        LocalDate dataI = obtemDataLocalDatePorString(dataInicial);
        LocalDate dataF = obtemDataLocalDatePorString(dataFinal);

        return (int) ChronoUnit.DAYS.between(dataI, dataF);
    }

    public DataCustom adicionaDias(int dias) throws ParseException {
        LocalDate date = this.data.plusDays(dias);
        return new DataCustom(date.format(formato));
    }

    @Override
    public String toString() {
        return obtemDataEmString();
    }
}
