import vistas.LogisticaVista;
import controladores.LogisticaControlador;

public class App {
    public static void main(String[] args) throws Exception {
        var vista = new LogisticaVista();

        new LogisticaControlador(vista);

        vista.setVisible(true);
    }
}
