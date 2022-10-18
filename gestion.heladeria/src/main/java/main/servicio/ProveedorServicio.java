package main.servicio;

import main.Repositorio.ProveedorRepository;
import main.modelos.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServicio {

    @Autowired
    private ProveedorRepository repositorio;

    public List<Proveedor> listarProveedores()
    {
        return repositorio.findAll();
    }

    public void guardarProveedor(Proveedor proveedor)
    {
        repositorio.save(proveedor);
    }

    public Proveedor obtenerProveedorPorId(Integer id)
    {
        return repositorio.findById(id).get();
    }

    public void eliminarProveedor(Integer id)
    {
        repositorio.deleteById(id);
    }
}
