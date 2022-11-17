package main.servicio;

import main.Repositorio.MarcaRepositorio;
import main.modelos.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MarcaServicio {

    @Autowired
    private MarcaRepositorio repositorio;

    public List<Marca> listarMarcas()
    {
        return repositorio.findAll();
    }

    public void guardarMarca(Marca marca)
    {
        repositorio.save(marca);
    }

    public Marca obtenerMarcaPorId(Integer id)
    {
        return repositorio.findById(id).get();
    }

    public void eliminarMarca(Integer id)
    {
        repositorio.deleteById(id);
    }

    public Marca obtenerMarcaPorNombre(String nombre)
    {
        return repositorio.findByName(nombre);
    }
}
