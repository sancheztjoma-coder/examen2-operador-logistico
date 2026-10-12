package controladores;

import modelos.DatosEnvio;
import vistas.LogisticaVista;

import servicios.EnvioServicio;

public class LogisticaControlador {

    private LogisticaVista vista;

    public LogisticaControlador(LogisticaVista vista) {
        this.vista = vista;
        this.vista.setGuardarEnvioClick(evento -> guardarEnvio());
        this.vista.setEliminarEnvioClick(evento -> eliminarEnvio());
        mostrarEnvios();
    }

    private void mostrarEnvios() {
        vista.mostrarEnvios(EnvioServicio.getDatos(), EnvioServicio.getEncabezados());
    }

    private void guardarEnvio() {
        var tipo = vista.getTipoTransporte();
        var codigo = vista.getCodigo();
        var cliente = vista.getCliente();
        var peso = vista.getPeso();
        var distancia = vista.getDistancia();


        var cuentaAgregada = EnvioServicio.agregar(tipo,
                new DatosEnvio(codigo, cliente, peso, distancia));
        if (cuentaAgregada != null) {
            vista.setEnvio(cuentaAgregada.toString());

            mostrarEnvios();

            vista.ocultarEdicionEnvio();
        } else {
            vista.mostrarMensaje("No se puede agregar el envío");
        }
    }

    private void eliminarEnvio() {
        if (vista.getFilaEnvioSeleccionado() >= 0) {
            if (vista.confirmar("¿Está seguro de eliminar el envío?")) {
                EnvioServicio.eliminar(vista.getFilaEnvioSeleccionado());
                vista.quitarEnvio(vista.getFilaEnvioSeleccionado());
                mostrarEnvios();
            }
        } else {
            vista.mostrarMensaje("Debe seleccionar un envio para eliminarlo");
        }
    }

    
}
