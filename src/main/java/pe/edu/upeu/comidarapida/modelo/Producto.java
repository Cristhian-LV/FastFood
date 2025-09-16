package pe.edu.upeu.comidarapida.modelo;

import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.comidarapida.enums.Categorias;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto {

    private StringProperty nombre;
    private StringProperty precio;
    private StringProperty stock;
    private Categorias categoria;

}
