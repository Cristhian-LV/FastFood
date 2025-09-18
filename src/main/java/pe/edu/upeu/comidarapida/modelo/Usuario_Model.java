package pe.edu.upeu.comidarapida.modelo;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data

public class Usuario_Model {

//    private StringProperty nombre;
//    private StringProperty contrasena;

    private String nombre;
    private String contrasena;

    public Usuario_Model(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
