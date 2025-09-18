package pe.edu.upeu.comidarapida.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.comidarapida.modelo.Usuario_Model;
import pe.edu.upeu.comidarapida.servicio.Login_interface;
import pe.edu.upeu.comidarapida.servicio.Navigation_interface;


@Controller
public class Login_ff {
    @FXML
    private TextField tfUsuario, tfContrasena;

    @Autowired
    private Login_interface login_Service;
    @Autowired
    private Navigation_interface navegar;

    @FXML
    public void initialize(){

    }

    @FXML
    private void btn_IniciarSesion(ActionEvent event){
        String user = tfUsuario.getText();
        String pass = tfContrasena.getText();

        if (login_Service.verificar_Inicio(user, pass)){
            System.out.println("Inicio de sesion exitoso");
            navegar.cerrarVentanaActual(event);
            navegar.abrirVentana("/fxml/maingui.fxml");
        }else{
            System.out.println("Usuario o contraseña incorrectos");
        }

    }

    @FXML
    private void btn_Registrarse(ActionEvent event) {
        String user = tfUsuario.getText();
        String pass = tfContrasena.getText();

        if (login_Service.verificar_registro(new Usuario_Model(user,pass))){
            System.out.println("Usuario registrado con éxito");
        }else{
            System.out.println("El nombre de usuario ya existe");
        }
    }
}
