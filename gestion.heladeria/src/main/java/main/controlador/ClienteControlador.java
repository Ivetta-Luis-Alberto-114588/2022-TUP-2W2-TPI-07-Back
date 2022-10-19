package main.controlador;

import main.modelos.Cliente;
import main.modelos.Proveedor;
import main.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ClienteControlador {

    @Autowired
    private ClienteServicio servicio;

    //Listar clientes
    @CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
    @GetMapping("/clientes")
    public List<Cliente> listarClientes()
    {
        return servicio.listarClientes();
    }

    //Buscar cliente por Id
    @CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Integer id)
    {
        try
        {
            Cliente cliente = servicio.obtenerClientePorId(id);
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
    }

    //Alta cliente
    @CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
    @PostMapping("/clientes")
    public void registrarCliente(@RequestBody Cliente cliente)
    {
        servicio.guardarCliente(cliente);
    }

    //Actualizar cliente
    @CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
    @PutMapping("/cliente/{id}")
    public ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente, @PathVariable Integer id)
    {
        try {
            Cliente clienteExistente = servicio.obtenerClientePorId(id);

            clienteExistente.setDni(cliente.getDni());
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setTelefono(cliente.getTelefono());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setEmail(cliente.getEmail());

            servicio.guardarCliente(clienteExistente);
            return  new ResponseEntity<Cliente>(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar cliente
    @CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
    @DeleteMapping("/clientes/{id}")
    public void eliminarCliente(@PathVariable Integer id)
    {
        servicio.eliminarCliente(id);
    }
}
