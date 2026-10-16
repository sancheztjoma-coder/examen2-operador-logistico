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
            mostrarEnvios();               
            vista.ocultarEdicionEnvio();  
            vista.limpiarCampos();        
            vista.mostrarMensaje("Envío guardado exitosamente.");
        } else {
            vista.mostrarMensaje("No se pudo agregar el envío.");
        }
    }

    private void eliminarEnvio() {
        String codigo = vista.getCodigoEliminar();
        
        if (codigo.isEmpty()) {
            vista.mostrarMensaje("Debe ingresar un código de envío para eliminar.");
            return;
        }

        if (vista.confirmar("¿Está seguro de eliminar el envío con código " + codigo + "?")) {
            boolean eliminado = EnvioServicio.eliminarPorCodigo(codigo);
            if (eliminado) {
                mostrarEnvios();
                vista.ocultarEliminacionEnvio();
                vista.limpiarCamposEliminar();
                vista.mostrarMensaje("Envío eliminado exitosamente.");
            } else {
                // Cumple con el requisito: "Si el código no existe, informar al usuario"
                vista.mostrarMensaje("El código del envío no existe.");
            }
        }
    }

    
}
