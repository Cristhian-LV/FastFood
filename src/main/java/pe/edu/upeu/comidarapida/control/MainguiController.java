package pe.edu.upeu.comidarapida.control;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;


@Controller
public class MainguiController {

    @FXML
    private BorderPane bp;
    @FXML
    MenuBar menuBar;
    @FXML
    Menu menuArchivo;
    @FXML
    TabPane tabPane;

    private Menu menuEstilos = new Menu("Cambiar Estilo");
    private ComboBox<String> comboBox =new ComboBox<>();
    private CustomMenuItem customMenuEstilo =new CustomMenuItem(comboBox);

    private MenuItem miAjustes=new MenuItem("Ajustes");
    private MenuItem miAcercaDe=new MenuItem("Acerca de");
    private MenuItem miSalir=new MenuItem("Salir");

    @Autowired
    ApplicationContext context;

    @FXML
    public void initialize(){
        menuArchivo.getItems().addAll(miAjustes, miAcercaDe, miSalir);
        comboBox.getItems().addAll("Estilo por defecto","Estilo Oscuro","Estilo Azul","Estilo Rosado", "Estilo Verde");

        comboBox.setOnAction(actionEvent -> cambiarEstilo());
        customMenuEstilo.setHideOnClick(false);
        menuEstilos.getItems().addAll(customMenuEstilo);

        menuBar.getMenus().addAll(menuEstilos);

        miSalir.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });

        String[][] tabs=new String[][]{
                {"/fxml/main_01_productos.fxml","Productos"},
                {"/fxml/main_02_menu.fxml","Menu"},
                {"/fxml/main_03_pedidos.fxml","Pedidos"},
                {"/fxml/main_04_pagos.fxml","Pagos"},
                {"/fxml/main_05_reportes.fxml","Reportes"}
        };
        tabPane.getTabs().clear();

        for (String[] tab : tabs){
            añadirTab(tab[0],tab[1]);
        }

    }

    private void añadirTab(String fxmlPath, String tittle){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            fxmlLoader.setControllerFactory(context::getBean);
            Parent root = fxmlLoader.load();

            ScrollPane  scrollPane = new  ScrollPane(root);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);

            Tab newTab = new Tab(tittle, scrollPane);
            tabPane.getTabs().add(newTab);

        }catch (IOException ex){
            new RuntimeException(ex);
        }
    }

    public void cambiarEstilo(){
        String estiloSeleccionado=comboBox.getSelectionModel().getSelectedItem();
        Scene scene=tabPane.getScene();
        switch (estiloSeleccionado){
            case "Estilo Oscuro": scene.getStylesheets().add(getClass().getResource("/css/estilo-oscuro.css").toExternalForm());
                break;
            case "Estilo Azul": scene.getStylesheets().add(getClass().getResource("/css/estilo-azul.css").toExternalForm());
                break;
            case "Estilo Rosado": scene.getStylesheets().add(getClass().getResource("/css/estilo-rosado.css").toExternalForm());
                break;
            case "Estilo Verde": scene.getStylesheets().add(getClass().getResource("/css/estilo-verde.css").toExternalForm());
                break;
            default: scene.getStylesheets().clear();
                break;
        }
    }
}
