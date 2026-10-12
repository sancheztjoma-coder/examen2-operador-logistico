package modelos;

public class Terrestre extends Envio {

    private static final double TARIFA_KM = 1500;
    private static final double RECARGO_PESO = 2000;

    public Terrestre(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }


    @Override 
    public double calcularCosto() {
        double costo = (getDistancia() * TARIFA_KM) + (getPeso() * RECARGO_PESO);
        return costo;
    }



    @Override
    public String toString() {
        return "TERRESTRE #[" + getCodigo() + "] CLIENTE[" + getCliente() + "]";
    }

    @Override
    public String[] getDatos() {
        return new String[] {
            "TERRESTRE",
            getCodigo(),
            getCliente(),
            String.valueOf(getPeso()),
            String.valueOf(getDistancia()),
            String.valueOf(calcularCosto())
        };
    }
}
