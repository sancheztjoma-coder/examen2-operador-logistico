package modelos;

public class Aereo extends Envio {

    private static final double TARIFA_KM = 5000;
    private static final double RECARGO_PESO = 4000;

    public Aereo(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }


    @Override 
    public double calcularCosto() {
        double costo = (getDistancia() * TARIFA_KM) + (getPeso() * RECARGO_PESO);
        return costo;
    }



    @Override
    public String toString() {
        return "AEREO #[" + getCodigo() + "] CLIENTE[" + getCliente() + "]";
    }

    @Override
    public String[] getDatos() {
        return new String[] {
            "AEREO",
            getCodigo(),
            getCliente(),
            String.valueOf(getPeso()),
            String.valueOf(getDistancia()),
            String.valueOf(calcularCosto())
        };
    }
}
