package semana06.aula02.exercicio3;

import java.util.ArrayList;

public class Computador {
    private int idComputador;
    private String nome;
    private String modelo;
    private String hd;
    private String memoria;
    private String processador;
    private ArrayList<String> perifericos = new ArrayList<>();
    private boolean ligado;

    public Computador(int idComputador, String nome, String modelo, String hd, String memoria, String processador) {
        this.idComputador = idComputador;
        this.nome = nome;
        this.modelo = modelo;
        this.hd = hd;
        this.memoria = memoria;
        this.processador = processador;
    }

    protected void setLigado(boolean bool) {
        ligado = bool;
    }

    public void ligar() {
        setLigado(true);
    }

    public void desligar() {
        setLigado(false);
    }

    public void suspender() {
        desligar();
    }

    public boolean isLigado() {
        return ligado;
    }

    public int getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(int idComputador) {
        this.idComputador = idComputador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public ArrayList<String> getPerifericos() {
        return perifericos;
    }

    public void addPeriferico(String periferico) {
        perifericos.add(periferico);
    }
}
