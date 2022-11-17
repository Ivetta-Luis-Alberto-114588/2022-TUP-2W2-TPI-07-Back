package main.servicio;

import main.Repositorio.RolRepositorio;
import main.modelos.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServicio {

    @Autowired
    private RolRepositorio repositorio;

    public List<Rol> listarRol()
    {
        return repositorio.findAll();
    }

    public void guardarRol(Rol rol)
    {
        repositorio.save(rol);
    }

    public Rol obtenerRolPorId(Integer id)
    {
        return repositorio.findById(id).get();
    }

    public void eliminarRol(Integer id)
    {
        repositorio.deleteById(id);
    }
}
