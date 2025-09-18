package pe.edu.upeu.comidarapida.servicio;

import javafx.event.ActionEvent;

public interface Navigation_interface {
    void cerrarVentanaActual(ActionEvent event);
    void abrirVentana(String fxmlFile);
}
