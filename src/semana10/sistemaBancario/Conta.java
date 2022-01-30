package semana10.sistemaBancario;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    public void deposita(int valor) throws IOException {
        double saldoAnterior = this.saldo;
        this.saldo += valor;
        System.out.println("Depositado valor de R$ " + valor);
        String mensagem =
                "Operação: Depósito" +
                "\nSaldo antes depósito:" + saldoAnterior +
                "\nValor depósito:" + valor +
                "\nSaldo atual:" + this.saldo +
                "\n----------------------------------------";
        this.salvarHistorico(mensagem);
    }

    public boolean verificaSeTemValorMaiorIgualQue(int valor) {
        return this.saldo >= valor;
    }

    public void sacar(int valor) throws IOException {
        if (verificaSeTemValorMaiorIgualQue(valor)) {
            double saldoAnterior = this.saldo;
            this.saldo -= valor;
            System.out.println("Sacado valor de R$ " + valor);
            String mensagem =
                    "Operação: Saque" +
                    "\nSaldo antes transferência:" + saldoAnterior +
                    "\nValor transferido:" + valor +
                    "\nSaldo atual:" + this.saldo +
                    "\n----------------------------------------";;
            this.salvarHistorico(mensagem);
            return;
        }

        System.out.println("Você não tem todo esse valor na conta para sacar!");
    }

    public void transferir(Conta conta, int valor) throws IOException {
        if (verificaSeTemValorMaiorIgualQue(valor)) {
            this.saldo -= valor;
            conta.deposita(valor);
            String mensagem =
                    "Operação: Transferência" +
                    "\nConta origem:" + this.numeroDaConta +
                    "\nSaldo atual conta origem:" + this.saldo +
                    "\nConta destino:" + conta.getNumeroDaConta() +
                    "\nSaldo transferido:" + valor +
                    "\n----------------------------------------";;
            this.salvarHistorico(mensagem);
            return;
        }

        System.out.println("Você não tem todo esse valor na conta para transferir!");
    }

    @Override
    public String toString() {
        return
                "Nome Cliente: " + this.cliente.getNome() +
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

    public void salvarHistorico(String msg) throws IOException {
        FileWriter listaDeContas = new FileWriter("transacoes_banco.txt", true);
        PrintWriter pw = new PrintWriter(listaDeContas);
        pw.append(msg);
        pw.println();
        pw.close();
    }
}
