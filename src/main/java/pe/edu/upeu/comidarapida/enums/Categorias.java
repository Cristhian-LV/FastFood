package pe.edu.upeu.comidarapida.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Categorias {

    POLLOS_A_LA_BRAZA("Pollos a la braza"),
    PARRILLAS("Parrillas"),
    SALTADOS_Y_ARROCES_CHAUFA("Saltados y arroces chaufa"),
    PIQUEOS_Y_ENTRADAS("Piqueos y Entradas"),
    GASEOSAS("Gaseosas"),
    BEBIDAS_NATURALES("Bebidas naturales"),
    AGUAS("Aguas"),
    CERVEZAS("Cervezas");

    private String descripcion;

}
