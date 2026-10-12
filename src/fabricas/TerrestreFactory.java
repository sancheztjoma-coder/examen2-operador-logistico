package fabricas;

import modelos.Terrestre;
import modelos.Envio;
import modelos.DatosEnvio;

public class TerrestreFactory extends EnvioFactory {
    @Override
    public Envio crearEnvio(DatosEnvio datos) {
        return new Terrestre(datos.codigo(), datos.cliente(), datos.peso(), datos.distancia());
    }
}
