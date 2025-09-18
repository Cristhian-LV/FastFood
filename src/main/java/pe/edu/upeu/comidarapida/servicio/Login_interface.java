package pe.edu.upeu.comidarapida.servicio;

import pe.edu.upeu.comidarapida.modelo.Usuario_Model;

public interface Login_interface {

    boolean verificar_Inicio(String usuario, String contrasena);
    boolean verificar_registro(Usuario_Model nuevoUsuario);
}
