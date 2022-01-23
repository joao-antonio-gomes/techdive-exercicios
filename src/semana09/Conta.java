package semana09;

abstract public class Conta {
    private Cliente clienteTitular;

    public Conta(Cliente clienteTitular) {
        this.clienteTitular = clienteTitular;
    }

    public Cliente getClienteTitular() {
        return clienteTitular;
    }

    public void setClienteTitular(Cliente clienteTitular) {
        this.clienteTitular = clienteTitular;
    }
}
