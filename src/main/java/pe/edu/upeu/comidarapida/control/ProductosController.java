package pe.edu.upeu.comidarapida.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.comidarapida.enums.Categorias;
import pe.edu.upeu.comidarapida.modelo.Producto;
import pe.edu.upeu.comidarapida.servicio.ProductoServicioI;

@Controller
public class ProductosController {

    @FXML
    private TextField txtNombre, txtPrecio, txtStock;
    @FXML
    private ComboBox<Categorias> cbxCategoria;

    @FXML
    private TableView<Producto> tableView;
    ObservableList<Producto> listaProductos;
    @FXML
    private TableColumn<Producto, String> nombreColum, precioColum, stockColum, categoriaColum;
    private TableColumn<Producto, Void> opcColum;

    @Autowired
    ProductoServicioI ps;
    int indexE=-1;

    @FXML
    public void initialize(){
        cbxCategoria.getItems().setAll(Categorias.values());
        definirColumnas();
        listarParticipantes();
    }

    public void limpiarFormulario(){
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        cbxCategoria.setValue(null);
    }

    @FXML
    public void crearProducto(){
        Producto p = new Producto();
        p.setNombre(new SimpleStringProperty(txtNombre.getText()));
        p.setPrecio(new SimpleStringProperty(txtPrecio.getText()));
        p.setStock(new SimpleStringProperty(txtStock.getText()));
        p.setCategoria(cbxCategoria.getSelectionModel().getSelectedItem());
        if(indexE==-1){
            ps.save(p);
        }else{
            ps.update(p,  indexE);
            indexE=-1;
        }
        limpiarFormulario();
        listarParticipantes();
    }

    public void definirColumnas(){
        nombreColum=new TableColumn("Nombre");
        precioColum=new TableColumn("Precio");
        stockColum=new TableColumn("Stock");
        categoriaColum=new TableColumn("Categoría");
        opcColum=new TableColumn("Opciones");
        opcColum.setMinWidth(200);
        tableView.getColumns().addAll(nombreColum, precioColum, stockColum, categoriaColum, opcColum);
    }

    public void agregarAccionBotones(){
        Callback<TableColumn<Producto, Void> , TableCell<Producto, Void> > cellFactory =
                param->new  TableCell<>(){
                private final Button editarBtn = new Button("Editar");
                private final Button eliminarBtn = new Button("Eliminar");
                    {
                        editarBtn.setOnAction(event -> {
                            Producto producto =getTableView().getItems().get(getIndex());
                            editarParticipante(producto, getIndex());
                        });
                        eliminarBtn.setOnAction(event -> {
                            eliminarParticipante(getIndex());
                        });
                    }
                @Override
                public void updateItem(Void item, boolean empty){
                    super.updateItem(item, empty);
                    if(empty){
                        setGraphic(null);
                    }else {
                        HBox hbox = new HBox(editarBtn, eliminarBtn);
                        hbox.setSpacing(10);
                        setGraphic(hbox);
                    }
                }
                };
            opcColum.setCellFactory(cellFactory);
    }
    public void listarParticipantes(){
        nombreColum.setCellValueFactory(cellData->cellData.getValue().getNombre());
        precioColum.setCellValueFactory(cellData->cellData.getValue().getPrecio());
        stockColum.setCellValueFactory(cellData->cellData.getValue().getStock());
        categoriaColum.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getCategoria().toString()));
        agregarAccionBotones();
        listaProductos =FXCollections.observableArrayList(ps.findAll());
        tableView.setItems(listaProductos);
    }
    public void eliminarParticipante(int index){
        ps.delete(index);
        listarParticipantes();
    }

    public void editarParticipante(Producto p, int index){
        txtNombre.setText(p.getNombre().getValue());
        txtPrecio.setText(p.getPrecio().getValue());
        txtStock.setText(p.getStock().getValue());
        cbxCategoria.setValue(p.getCategoria());
        indexE=index;
    }



}
