package semana09.hotel;

import java.util.ArrayList;
import java.util.List;

public class TestsHotel {
    public static void main(String[] args) throws Exception {
        Hospede joao = new Hospede("Joao", "09355872925", "04/12/1996");
        List<Hospede> hospedes = new ArrayList<>(List.of(joao));
        System.out.println("---- TESTE RESERVA ALTA TEMPORADA ----");
        Reserva reserva1 = new Reserva(hospedes, "23/11/2021", 2, TipoQuartoEnum.SIMPLES);
        Reserva reserva2 = new Reserva(hospedes, "23/11/2021", 2, TipoQuartoEnum.SIMPLES);
        Reserva reserva3 = new Reserva(hospedes, "23/11/2021", 2, TipoQuartoEnum.SIMPLES);
        Reserva reserva4 = new Reserva(hospedes, "23/11/2021", 2, TipoQuartoEnum.SIMPLES);
        Reserva reserva5 = new Reserva(hospedes, "23/11/2021", 2, TipoQuartoEnum.SIMPLES);
        Reserva reserva6 = new Reserva(hospedes, "23/11/2021", 2, TipoQuartoEnum.SIMPLES);
        Reserva reserva7 = new Reserva(hospedes, "23/11/2021", 2, TipoQuartoEnum.SIMPLES);
        Reserva reserva8 = new Reserva(hospedes, "23/11/2021", 2, TipoQuartoEnum.SIMPLES);
        Reserva reserva9 = new Reserva(hospedes, "23/11/2021", 2, TipoQuartoEnum.SIMPLES);
        Reserva reserva10 = new Reserva(hospedes, "23/11/2021", 2, TipoQuartoEnum.SIMPLES);
        System.out.println("Valor esperado: 2800.00");
        System.out.println("Valor total de reservas: " + Reserva.getValorTotalReservas());
    }
}
