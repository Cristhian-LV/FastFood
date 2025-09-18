package pe.edu.upeu.comidarapida.servicio;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Navigation_service implements Navigation_interface{

    @Autowired
    private ApplicationContext context;

    @Override
    public void cerrarVentanaActual(ActionEvent event) {

        ((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();

    }

    @Override
    public void abrirVentana(String fxmlFile) {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource(fxmlFile));
            loader.setControllerFactory(context :: getBean);
            Parent parent = loader.load();

            Stage stage=new Stage();
            stage.setScene(new Scene(parent,950, 550));
            //stage.setScene(new Scene(parent));
            stage.setTitle("JCLV FastFood");
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
