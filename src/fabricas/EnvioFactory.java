package fabricas;

import modelos.Envio;
import modelos.DatosEnvio;
import modelos.TipoTransporte;

public abstract class EnvioFactory {

    public abstract Envio crearEnvio(DatosEnvio datos);

    public static EnvioFactory getFactory(TipoTransporte tipo) {
        return switch (tipo) {
            case TERRESTRE -> new TerrestreFactory();
            case MARITIMO -> new MaritimoFactory();
            case AEREO -> new AereoFactory();
        };
    }
}
