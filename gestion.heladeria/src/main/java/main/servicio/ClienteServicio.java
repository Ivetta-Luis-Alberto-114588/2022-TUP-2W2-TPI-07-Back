package main.servicio;

import main.Repositorio.ClienteRepository;
import main.modelos.Cliente;
import main.modelos.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepository repositorio;

    public List<Cliente> listarClientes()
    {
        return repositorio.findAll();
    }

    public void guardarCliente(Cliente cliente)
    {
        repositorio.save(cliente);
    }

    public Cliente obtenerClientePorId(Integer id)
    {
        return repositorio.findById(id).get();
    }

    public void eliminarCliente(Integer id)
    {
        repositorio.updateEliminar(id);
    }

    public Cliente ObtenerPorNombre(String nombre_apellido)
    {
        return repositorio.findByName(nombre_apellido);
    }

    public List<Cliente> obtenerTodosPorNombre(String nombre)
    {
        if(nombre != null)
        {
            return repositorio.findAll(nombre);
        }
        return repositorio.findAll();
    }
}
