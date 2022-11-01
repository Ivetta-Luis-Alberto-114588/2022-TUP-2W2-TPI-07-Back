package main.servicio;

import main.Repositorio.ProductoRepository;
import main.modelos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepository repositorio;

    public List<Producto> listarProductos()
    {
        return repositorio.findAll();
    }

    public void guardarProducto(Producto producto)
    {
        repositorio.save(producto);
    }

    public Producto obtenerProductoPorId(int id)
    {
        return repositorio.findById(id).get();
    }

    public void eliminarProducto(int id)
    {
        repositorio.deleteById(id);
    }

    public Producto obtenerPorNombre(String nombre)
    {
        return repositorio.findByName(nombre);
    }
}
