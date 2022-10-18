package main.controlador;

import main.Repositorio.ProveedorRepository;
import main.modelos.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.servicio.ProveedorServicio;

import java.util.List;

@RestController
public class ProveedorControlador {

    @Autowired
    private ProveedorServicio servicio;
    private ProveedorRepository repositorio;


    //LISTAR PROVEEDORES
    @CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
    @GetMapping("/proveedores")
    public List<Proveedor> listarProveedores()
    {
        return servicio.listarProveedores();
    }


    //BUSCAR PROVEEDOR POR ID
    @CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
    @GetMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> obtenerProveedor(@PathVariable Integer id)
    {
        try {
            Proveedor proveedor = servicio.obtenerProveedorPorId(id);
            return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
        }
    }

    //ALTA PROVEEDOR
    @CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
    @PostMapping("/proveedores")
    public void registrarProveedor(@RequestBody Proveedor proveedor)
    {
        servicio.guardarProveedor(proveedor);
    }

    //ACTUALIZAR PROVEEDOR
    @CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
    @PutMapping("proveedor/{id}")
    public ResponseEntity<?> actualizarProveedor(@RequestBody Proveedor proveedor, @PathVariable Integer id)
    {
        try {
            Proveedor proveedorExistente = servicio.obtenerProveedorPorId(id);

            proveedorExistente.setNombre(proveedor.getNombre());
            proveedorExistente.setTelefono(proveedor.getTelefono());
            proveedorExistente.setPais(proveedor.getPais());
            proveedorExistente.setDireccion(proveedor.getDireccion());
            proveedorExistente.setCodigo_postal(proveedor.getCodigo_postal());
            proveedorExistente.setEmail(proveedor.getEmail());
            proveedorExistente.setLatitud(proveedor.getLatitud());
            proveedorExistente.setLongitud(proveedor.getLongitud());

            servicio.guardarProveedor(proveedorExistente);
            return new ResponseEntity<Proveedor>(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
        }
    }

    //ELIMINAR PROVEEDOR
    @CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
    @DeleteMapping("/proveedores/{id}")
    public void eliminarProveedor(@PathVariable Integer id)
    {
        servicio.eliminarProveedor(id);
    }



}
