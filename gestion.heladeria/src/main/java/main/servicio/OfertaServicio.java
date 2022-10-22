package main.servicio;

import main.Repositorio.OfertaRepository;
import main.modelos.Oferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfertaServicio {

    @Autowired
    private OfertaRepository repositorio;

    public List<Oferta> listarOfertas()
    {
        return repositorio.findAll();
    }

    public void guardarOferta(Oferta oferta)
    {
        repositorio.save(oferta);
    }

    public Oferta obtenerOfertaPorId(Integer id)
    {
        return repositorio.findById(id).get();
    }

    public void eliminarOferta(Integer id)
    {
        repositorio.deleteById(id);
    }

    public Oferta ObtenerPorNombre(String nombre)
    {
        return repositorio.findByName(nombre);
    }
}
