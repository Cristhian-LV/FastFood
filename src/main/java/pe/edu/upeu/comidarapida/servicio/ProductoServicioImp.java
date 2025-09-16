package pe.edu.upeu.comidarapida.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.comidarapida.modelo.Producto;
import pe.edu.upeu.comidarapida.repositorio.ProductoRepositorio;

import java.util.List;

@Service
public class ProductoServicioImp extends ProductoRepositorio implements ProductoServicioI {

    @Override
    public void save(Producto producto) {
        listaProductos.add(producto);
    }

    @Override
    public List<Producto> findAll() {
        if(listaProductos.isEmpty()){
            return super.findAll();
        }
        return listaProductos;
    }

    @Override
    public void update(Producto producto, int index) {
        listaProductos.set(index, producto);
    }

    @Override
    public void delete(int index) {
        listaProductos.remove(index);
    }

    @Override
    public Producto findById(int index) {
        return listaProductos.get(index);
    }
}
