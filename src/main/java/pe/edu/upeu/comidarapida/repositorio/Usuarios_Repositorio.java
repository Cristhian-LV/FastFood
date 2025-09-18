package pe.edu.upeu.comidarapida.repositorio;

import pe.edu.upeu.comidarapida.modelo.Usuario_Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuarios_Repositorio {

    public List<Usuario_Model> lista_Usuarios;

    public Usuarios_Repositorio(){
        this.lista_Usuarios = new ArrayList<>();
//        this.lista_Usuarios.add(new Usuario_Model(
//                new SimpleStringProperty("admin"),
//                new SimpleStringProperty("1234567")
//                )
//        );
        this.lista_Usuarios.add(new Usuario_Model("admin","1234567"));
        this.lista_Usuarios.add(new Usuario_Model("jclv","1234567"));
        this.lista_Usuarios.add(new Usuario_Model("cris","1234567"));
    }

}
