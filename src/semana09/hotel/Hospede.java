package semana09.hotel;

import lombok.Getter;

import java.text.ParseException;

@Getter
public class Hospede {
    private String documentoIdentificacao;
    private DataCustom dataNascimento;
    private String nome;

    public Hospede(String nome, String documentoIdentificacao, String dataNascimento) throws ParseException {
        this.nome = nome;
        this.documentoIdentificacao = documentoIdentificacao;
        this.dataNascimento = new DataCustom(dataNascimento);
    }
}