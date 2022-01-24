package semana09.hotel;

import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;

@Getter
public class Quarto {
    private TipoQuartoEnum tipoQuarto;
    private int precoQuartoNormal;
    private int precoQuartoTemporada;
    private static int numQuartosSimplesDisponiveis = TipoQuartoEnum.SIMPLES.getQuantidadeDisponiveis();
    private static int numQuartosLuxoDisponiveis = TipoQuartoEnum.LUXO.getQuantidadeDisponiveis();
    private static int numQuartosSupremoDisponiveis = TipoQuartoEnum.SUPREMO.getQuantidadeDisponiveis();

    public Quarto(TipoQuartoEnum tipoQuarto) {
        verificaLotacaoQuartos(tipoQuarto);
        this.tipoQuarto = tipoQuarto;
        this.precoQuartoNormal = tipoQuarto.getValorNormal();
        this.precoQuartoTemporada = tipoQuarto.getValorTemporada();
        setNumQuartosDisponiveis(tipoQuarto);
    }

    private void verificaLotacaoQuartos(TipoQuartoEnum tipoQuarto) {
        int numeroQuartosDisponiveis = Quarto.getNumQuartosDisponiveis(tipoQuarto);
        try {
            if (numeroQuartosDisponiveis <= 0) throw new Exception("Não há quartos do tipo " + tipoQuarto + " disponíveis!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setNumQuartosDisponiveis(TipoQuartoEnum tipoQuarto) {
        switch (tipoQuarto) {
            case LUXO -> numQuartosLuxoDisponiveis--;
            case SIMPLES -> numQuartosSimplesDisponiveis--;
            case SUPREMO -> numQuartosSupremoDisponiveis--;
        }
    }

    public static int getNumQuartosDisponiveis(TipoQuartoEnum tipoQuarto) {
        int numQuartos;
        switch (tipoQuarto) {
            case LUXO -> numQuartos = numQuartosLuxoDisponiveis;
            case SIMPLES -> numQuartos = numQuartosSimplesDisponiveis;
            case SUPREMO -> numQuartos = numQuartosSupremoDisponiveis;
            default -> throw new IllegalStateException("Unexpected value: " + tipoQuarto);
        }
        return numQuartos;
    }

    public static void addNovoQuartoReservaCancelada(TipoQuartoEnum quarto) {
        switch (quarto) {
            case LUXO -> numQuartosLuxoDisponiveis++;
            case SIMPLES -> numQuartosSimplesDisponiveis++;
            case SUPREMO -> numQuartosSupremoDisponiveis++;
        }
    }

    @Override
    public String toString() {
        return "Quarto tipo " + tipoQuarto;
    }
}