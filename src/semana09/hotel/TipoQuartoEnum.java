package semana09.hotel;

import lombok.Getter;

@Getter
public enum TipoQuartoEnum {
    SIMPLES(90, 140, 10),
    LUXO(150, 400, 5),
    SUPREMO(500, 800, 2);

    private int valorNormal;
    private int valorTemporada;
    private int quantidadeDisponiveis;

    TipoQuartoEnum(int valorNormal, int valorTemporada, int quantidadeDisponiveis) {
        this.valorNormal = valorNormal;
        this.valorTemporada = valorTemporada;
        this.quantidadeDisponiveis = quantidadeDisponiveis;
    }
}
