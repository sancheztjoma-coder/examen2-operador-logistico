package fabricas;

import modelos.Maritimo;
import modelos.Envio;
import modelos.DatosEnvio;

public class MaritimoFactory extends EnvioFactory {
    @Override
    public Envio crearEnvio(DatosEnvio datos) {
        return new Maritimo(datos.codigo(), datos.cliente(), datos.peso(), datos.distancia());
    }
}
