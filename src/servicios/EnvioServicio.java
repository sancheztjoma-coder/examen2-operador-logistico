package servicios;

import java.util.ArrayList;
import java.util.List;

import fabricas.EnvioFactory;
import modelos.*;

public class EnvioServicio {

    private static final String[] encabezados = {"Tipo", "Codigo", "Cliente", "Peso", "Distancia", "Costo"};

    private static List<Envio> envios = new ArrayList<>();

    public static String[] getEncabezados() {
        return encabezados;
    }

    public static Envio get(int posicion) {
        if (posicion >= 0 && posicion < envios.size()) {
            return envios.get(posicion);
        }
        return null;
    }

    public static Envio agregar(TipoTransporte tipo,
                                 DatosEnvio datos) {
        var Envio= EnvioFactory.getFactory(tipo).crearEnvio(datos);
        if (Envio != null)
            envios.add(Envio);
        return Envio;
    }

    public static String[][] getDatos() {
        String[][] datos = new String[envios.size()][encabezados.length];
        int fila = 0;
        for (var Envio : envios) {
            int columna = 0;
            for (var dato : Envio.getDatos()) {
                if (columna < encabezados.length) {
                    datos[fila][columna] = dato;
                }
                columna++;
            }
            fila++;
        }
        return datos;
    }

    public static boolean eliminar(int posicion) {
        if (posicion >= 0 && posicion < envios.size()) {
            envios.remove(posicion);
            return true;
        }
        return false;
    }

}
