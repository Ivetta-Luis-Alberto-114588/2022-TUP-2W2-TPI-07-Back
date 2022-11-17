package main.controlador;

import main.modelos.Cliente;
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
    @GetMapping("/clientes/listado")
    public List<Cliente> listarClientes()
    {
        return servicio.listarClientes();
    }

    //Buscar cliente por Id
    @GetMapping("/clientes/buscarId{id}")
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
    @PostMapping("/clientes/alta")
    public void registrarCliente(@RequestBody Cliente cliente)
    {
        servicio.guardarCliente(cliente);
    }

    //Actualizar cliente
    @PutMapping("/cliente/actualizar/{id}")
    public ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente, @PathVariable Integer id)
    {
        try {
            Cliente clienteExistente = servicio.obtenerClientePorId(id);

            clienteExistente.setDni(cliente.getDni());
            clienteExistente.setNombre_apellido(cliente.getNombre_apellido());
            clienteExistente.setTelefono(cliente.getTelefono());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setEliminado(cliente.isEliminado());

            servicio.guardarCliente(clienteExistente);
            return  new ResponseEntity<Cliente>(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar cliente
    @DeleteMapping("/clientes/eliminar/{id}")
    public void eliminarCliente(@PathVariable Integer id)
    {
        servicio.eliminarCliente(id);
    }

    //BUSCAR CLIENTE POR NOMBRE
    @GetMapping("/clientes/buscarNombre/{nombre}")
    public ResponseEntity<Cliente> obtenerPorNombre(@PathVariable String nombre)
    {
        try {
            Cliente cliente = servicio.ObtenerPorNombre(nombre);
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/clientes/listarNombre/{nombre}")
    public ResponseEntity<List<Cliente>>ListarPorNombre(@PathVariable String nombre)
    {
        return ResponseEntity.ok(servicio.obtenerTodosPorNombre(nombre));
    }
}
