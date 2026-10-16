package vistas;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modelos.TipoTransporte;


public class LogisticaVista extends JFrame {

    private JTable tblEnvios;
    private JPanel pnlEditarEnvio, pnlEliminarEnvio;

    private JTextField txtCodigo, txtCliente, txtPeso, txtDistancia, txtCodigoEliminar;
    private JComboBox cmbTipo;
    private JLabel lblDistancia;

    private JTabbedPane tp;
    private JButton btnGuardarEnvio, btnEliminar, btnEliminarEnvio;

    public LogisticaVista() {
        setSize(600, 400);
        setTitle("Operador Logistico");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JToolBar tbEnvio = new JToolBar();

        JButton btnAgregarEnvio = new JButton();
        btnAgregarEnvio.setIcon(new ImageIcon(getClass().getResource("/iconos/agregar.png")));
        btnAgregarEnvio.setToolTipText("Agregar Envio");
        btnAgregarEnvio.addActionListener(evt -> {
            btnAgregarEnvioClick();                                                                                    //////revisar!
        });
        tbEnvio.add(btnAgregarEnvio);

        btnEliminar = new JButton();
        btnEliminar.setIcon(new ImageIcon(getClass().getResource("/iconos/eliminar.png")));
        btnEliminar.setToolTipText("Eliminar Envio");
        btnEliminar.addActionListener(evt -> {
            btnEliminarBarraClick();
        });
        tbEnvio.add(btnEliminar);

        
        
        JPanel pnlEnvios = new JPanel();
        pnlEnvios.setLayout(new BoxLayout(pnlEnvios, BoxLayout.Y_AXIS));

        
        pnlEditarEnvio = new JPanel();
        pnlEditarEnvio.setPreferredSize(new Dimension(pnlEditarEnvio.getWidth(), 100)); 
        pnlEditarEnvio.setLayout(null);

        JLabel lblCodigo = new JLabel("Código");
        lblCodigo.setBounds(10, 10, 100, 25);
        pnlEditarEnvio.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(110, 10, 100, 25);
        pnlEditarEnvio.add(txtCodigo);

        JLabel lblCliente = new JLabel("Cliente");
        lblCliente.setBounds(10, 40, 100, 25);
        pnlEditarEnvio.add(lblCliente);

        txtCliente = new JTextField();
        txtCliente.setBounds(110, 40, 100, 25);
        pnlEditarEnvio.add(txtCliente);

        JLabel lblPeso = new JLabel("Peso");
        lblPeso.setBounds(10, 70, 100, 25);
        pnlEditarEnvio.add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(110, 70, 100, 25);
        pnlEditarEnvio.add(txtPeso);

        cmbTipo = new JComboBox<>();
        cmbTipo.setBounds(220, 10, 100, 25);

        DefaultComboBoxModel<TipoTransporte> mdlTipo = new DefaultComboBoxModel<>(TipoTransporte.values());
        cmbTipo.setModel(mdlTipo);
        pnlEditarEnvio.add(cmbTipo);

        
        lblDistancia = new JLabel("Distancia en KM");
        lblDistancia.setBounds(220, 40, 100, 25);
        pnlEditarEnvio.add(lblDistancia);

        txtDistancia = new JTextField();
        txtDistancia.setBounds(320, 40, 100, 25);
        pnlEditarEnvio.add(txtDistancia);

        
        btnGuardarEnvio = new JButton("Guardar");
        btnGuardarEnvio.setBounds(220, 70, 100, 25);
        pnlEditarEnvio.add(btnGuardarEnvio);

        JButton btnCancelarEnvio = new JButton("Cancelar");
        btnCancelarEnvio.setBounds(320, 70, 100, 25);
        btnCancelarEnvio.addActionListener(evt -> {
            btnCancelarEnvioClick();                                                               ////revisar !!
        });
        pnlEditarEnvio.add(btnCancelarEnvio);

        pnlEditarEnvio.setVisible(false); 

        
        tblEnvios = new JTable();
        JScrollPane spListaEnvios = new JScrollPane(tblEnvios);

        
        pnlEnvios.add(pnlEditarEnvio);
        pnlEnvios.add(spListaEnvios);

        
        JScrollPane spEnvios = new JScrollPane(pnlEnvios);
        spEnvios.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Contenedor principal de Eliminar
        JPanel pnlEliminar = new JPanel();
        pnlEliminar.setLayout(new BoxLayout(pnlEliminar, BoxLayout.Y_AXIS));

        // Panel 1 (oculto por defecto)
        pnlEliminarEnvio = new JPanel();
        pnlEliminarEnvio.setPreferredSize(new Dimension(pnlEliminarEnvio.getWidth(), 100));
        pnlEliminarEnvio.setLayout(null);

        JLabel lblCodigoEliminar = new JLabel("Codigo a eliminar");
        lblCodigoEliminar.setBounds(10, 10, 100, 25);
        pnlEliminarEnvio.add(lblCodigoEliminar);

        txtCodigoEliminar = new JTextField();
        txtCodigoEliminar.setBounds(110, 10, 200, 25);
        pnlEliminarEnvio.add(txtCodigoEliminar);

        
        btnEliminarEnvio = new JButton("Eliminar");
        btnEliminarEnvio.setBounds(220, 70, 100, 25);
        pnlEliminarEnvio.add(btnEliminarEnvio);

        JButton btnCancelarEliminacion = new JButton("Cancelar");
        btnCancelarEliminacion.setBounds(320, 70, 100, 25);
        btnCancelarEliminacion.addActionListener(evt -> {
            btnCancelarEliminacionClick();
        });
        pnlEliminarEnvio.add(btnCancelarEliminacion);

        pnlEliminarEnvio.setVisible(false); 

        
        pnlEliminar.add(pnlEliminarEnvio);
        

        tp = new JTabbedPane();
        tp.addTab("Envios", spEnvios);
        tp.addTab("Eliminar", pnlEliminar);

        add(tbEnvio, BorderLayout.NORTH);
        add(tp, BorderLayout.CENTER);
    }

    // getters
    public String getCodigo() {
        return txtCodigo.getText();
    }

    public String getCliente() {
        return txtCliente.getText();
    }

    public double getPeso() {
        try {
            return Double.parseDouble(txtPeso.getText());
        } catch (Exception ex) {
            return 0;
        }
    }

    public double getDistancia() {
        try {
            return Double.parseDouble(txtDistancia.getText());
        } catch (Exception ex) {
            return 0;
        }
    }

    public TipoTransporte getTipoTransporte() {
        return (TipoTransporte) cmbTipo.getSelectedItem();
    }

    public int getFilaEnvioSeleccionado() {
        return tblEnvios.getSelectedRow();
    }

    public String getCodigoEliminar() {
        return txtCodigoEliminar.getText().trim();
    }
    
    // setters
    public void setGuardarEnvioClick(ActionListener escuchadorEvento) {
        btnGuardarEnvio.addActionListener(escuchadorEvento);
    }

    public void setEliminarEnvioClick(ActionListener escuchadorEvento) {
        btnEliminar.addActionListener(escuchadorEvento);
    }

    

    public void setEliminarClick(ActionListener escuchadorEvento) {
        btnEliminarEnvio.addActionListener(escuchadorEvento);
    }


    public void setAbrirEliminarBarraClick(ActionListener escuchador) {
        btnEliminar.addActionListener(escuchador);
    }
    
    public void mostrarEnvios(String[][] datos, String[] encabezados) {
        DefaultTableModel dtm = new DefaultTableModel(datos, encabezados);
        tblEnvios.setModel(dtm);
    }

     

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public boolean confirmar(String mensaje) {
        return JOptionPane.showConfirmDialog(null, mensaje, "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    

    public void ocultarEliminacionEnvio() {
        pnlEliminarEnvio.setVisible(false);
    }

    public void ocultarEdicionEnvio() {
        pnlEditarEnvio.setVisible(false);
    }


    public void limpiarCampos() {
        txtCodigo.setText("");
        txtCliente.setText("");
        txtPeso.setText("");
        txtDistancia.setText("");
        cmbTipo.setSelectedIndex(0);
    }

    public void limpiarCamposEliminar() {
        txtCodigoEliminar.setText("");
    }
    // eventos
    private void btnAgregarEnvioClick() {
        pnlEditarEnvio.setVisible(true);
        tp.setSelectedIndex(0);
        limpiarCampos();
    }

    private void btnEliminarBarraClick(){
        pnlEliminarEnvio.setVisible(true);
        tp.setSelectedIndex(1);
    }

    private void btnCancelarEnvioClick() {
        pnlEditarEnvio.setVisible(false);
        limpiarCampos();
    }

    
    private void btnCancelarEliminacionClick() {
        ocultarEliminacionEnvio();
    }

}
