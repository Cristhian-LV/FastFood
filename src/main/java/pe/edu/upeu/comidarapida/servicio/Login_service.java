package pe.edu.upeu.comidarapida.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.comidarapida.modelo.Usuario_Model;
import pe.edu.upeu.comidarapida.repositorio.Usuarios_Repositorio;

@Service
public class Login_service extends Usuarios_Repositorio implements Login_interface{

    @Override
    public boolean verificar_Inicio(String usuario, String contrasena) {

        for (Usuario_Model user : lista_Usuarios){
            if (user.getNombre().equals(usuario) && user.getContrasena().equals(contrasena)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean verificar_registro(Usuario_Model nuevoUsuario) {

        for (Usuario_Model user : lista_Usuarios){
            if (user.getNombre().equals(nuevoUsuario.getNombre())){
                return false;
            }
        }
        lista_Usuarios.add(nuevoUsuario);
        return true;
    }
}
