package main.servicio;

import main.Repositorio.TipoProductoRepository;
import main.modelos.TipoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TIpoProductoServicio {

    @Autowired
    private TipoProductoRepository repositorio;

    public List<TipoProducto>listarTipoProductos()
    {
        return repositorio.findAll();
    }

    public void guardarTipoProducto(TipoProducto tipoProducto)
    {
        repositorio.save(tipoProducto);
    }

    public TipoProducto obtenerTipoProductoPorId(Integer id)
    {
        return repositorio.findById(id).get();
    }

    public void eliminarTipoProducto(Integer id)
    {
        repositorio.deleteById(id);
    }

    public TipoProducto obtenerTipoProductoPorNombre(String nombre)
    {
        return repositorio.findByName(nombre);
    }
}
