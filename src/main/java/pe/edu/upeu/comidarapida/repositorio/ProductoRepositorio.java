package pe.edu.upeu.comidarapida.repositorio;

import javafx.beans.property.*;
import pe.edu.upeu.comidarapida.enums.Categorias;
import pe.edu.upeu.comidarapida.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductoRepositorio {
   public List<Producto> listaProductos =new ArrayList<>();

   public List<Producto> findAll(){
      listaProductos.add(
              new Producto(
                      new SimpleStringProperty("producto 1"),
                      new SimpleStringProperty("10.00"),
                      new SimpleStringProperty("1"),
                      Categorias.PARRILLAS
              )
      );
      listaProductos.add(
              new Producto(
                      new SimpleStringProperty("producto 2"),
                      new SimpleStringProperty("20.00"),
                      new SimpleStringProperty("2"),
                      Categorias.AGUAS
              )
      );
      listaProductos.add(
              new Producto(
                      new SimpleStringProperty("producto 3"),
                      new SimpleStringProperty("30.00"),
                      new SimpleStringProperty("3"),
                      Categorias.POLLOS_A_LA_BRAZA
              )
      );
      listaProductos.add(
              new Producto(
                      new SimpleStringProperty("producto 4"),
                      new SimpleStringProperty("40.00"),
                      new SimpleStringProperty("54"),
                      Categorias.PIQUEOS_Y_ENTRADAS
              )
      );
      return listaProductos;
   }

}
