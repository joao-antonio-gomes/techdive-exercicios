package semana10.sistemaBancario;

import java.io.*;

public class Conta {
    private Cliente cliente;
    private int numeroDaConta;
    private int saldo = 0;

    public Conta(Cliente cliente, int numeroDaConta) throws IOException {
        this.cliente = cliente;
        this.numeroDaConta = numeroDaConta;
        this.registraConta();
    }

    public Conta(String nome, int numeroDaConta) throws IOException {
        this.cliente = new Cliente(nome);
        this.numeroDaConta = numeroDaConta;
        this.registraConta();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void deposita(int valor) {
        this.saldo += valor;
        System.out.println("Depositado valor de R$ " + valor);
    }

    public boolean verificaSeTemValorMaiorIgualQue(int valor) {
        return this.saldo >= valor;
    }

    public void sacar(int valor) {
        if (verificaSeTemValorMaiorIgualQue(valor)) {
            this.saldo -= valor;
            System.out.println("Sacado valor de R$ " + valor);
            return;
        }

        System.out.println("Você não tem todo esse valor na conta para sacar!");
    }

    public void transferir(Conta conta, int valor) {
        if (verificaSeTemValorMaiorIgualQue(valor)) {
            this.saldo -= valor;
            conta.deposita(valor);
            return;
        }

        System.out.println("Você não tem todo esse valor na conta para transferir!");
    }

    @Override
    public String toString() {
        return "Nome Cliente: " + this.cliente.getNome() +
                "\nNumero Conta: " + this.numeroDaConta +
                "\n----------------------------------------";
    }

    public void registraConta() throws IOException {
        FileWriter listaDeContas = new FileWriter("lista_de_contas.txt", true);
        PrintWriter pw = new PrintWriter(listaDeContas);
        pw.append(this.toString());
        pw.println();
        pw.close();
    }
}
