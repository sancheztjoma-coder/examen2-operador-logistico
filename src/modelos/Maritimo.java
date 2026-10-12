package modelos;

public class Maritimo extends Envio {

    private static final double TARIFA_KM = 800;
    private static final double RECARGO_PESO = 1000;

    public Maritimo(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }


    @Override 
    public double calcularCosto() {
        double costo = (getDistancia() * TARIFA_KM) + (getPeso() * RECARGO_PESO);
        return costo;
    }



    @Override
    public String toString() {
        return "MARITIMO #[" + getCodigo() + "] CLIENTE[" + getCliente() + "]";
    }

    @Override
    public String[] getDatos() {
        return new String[] {
            "MARITIMO",
            getCodigo(),
            getCliente(),
            String.valueOf(getPeso()),
            String.valueOf(getDistancia()),
            String.valueOf(calcularCosto())
        };
    }
}
