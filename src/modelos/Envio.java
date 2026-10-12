package modelos;

public abstract class Envio {
    private String codigo;
    private String cliente;
    private double peso;
    private double distancia;

    public Envio() {
    }

    public Envio(String codigo, String cliente, double peso, double distancia) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.peso = peso;
        this.distancia = distancia;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public double getPeso() {
        return peso;
    }

    public double getDistancia() {
        return distancia;
    }

    
    protected void setPeso(double valor) {
        peso = valor;
    }

    protected void setDistancia(double valor) {
        distancia = valor;
    }

    
    public abstract double calcularCosto();

    public abstract String[] getDatos();

}
