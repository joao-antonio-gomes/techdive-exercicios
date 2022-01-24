package semana09.hotel;

import lombok.Getter;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Getter
public class Reserva {
    private Hospede responsavelReserva;
    private List<Hospede> hospedes;
    private DataCustom dataReservaInicial;
    private DataCustom dataReservaFinal;
    private int quantidadeDiasReservado;
    private Quarto quarto;
    private double valorDiaria;
    private double valorTotal;
    private static double valorTotalReservas;

    public Reserva(List<Hospede> hospedes, String dataReserva, int quantidadeDiasReservado, TipoQuartoEnum quarto) throws Exception {
        this.verificaDataReservaAte60Dias(dataReserva);

        this.responsavelReserva = hospedes.get(0);
        this.hospedes = hospedes;
        this.dataReservaInicial = new DataCustom(dataReserva);
        this.quantidadeDiasReservado = quantidadeDiasReservado;
        this.dataReservaFinal = new DataCustom(dataReserva).adicionaDias(quantidadeDiasReservado);
        this.quarto = new Quarto(quarto);
        this.valorDiaria = this.calculaValorDiaria(dataReserva);
        this.valorTotal = this.valorDiaria * this.quantidadeDiasReservado;
        valorTotalReservas += this.valorTotal;
    }

    private void verificaDataReservaAte60Dias(String dataReserva) throws ParseException {
        String dataReservada = new DataCustom(dataReserva).obtemDataEmString();
        String dataAtual = new DataCustom().criaDataAtual();
        int diasDiferenca = 0;
        diasDiferenca = new DataCustom().verificaDiferencaEntreDatas(dataAtual, dataReservada);
        try {
            if (!(diasDiferenca <= 60)) throw new Exception("Data de reserva deve ser inferior a 60 dias");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private double calculaValorDiaria(String dataReserva) throws ParseException {
        LocalDate data = dataReservaInicial.obtemDataLocalDatePorString(dataReserva);
        int mesDataReserva = data.getMonthValue();
        if (mesDataReserva >= 11 || mesDataReserva <= 3) {
            return this.quarto.getPrecoQuartoTemporada();
        }
        return this.quarto.getPrecoQuartoNormal();
    }

    public boolean cancelaReserva() {
        valorTotalReservas -= this.valorTotal;
        Quarto.addNovoQuartoReservaCancelada(this.quarto.getTipoQuarto());
        return true;
    }

    public static double getValorTotalReservas() {
        return valorTotalReservas;
    }
}
