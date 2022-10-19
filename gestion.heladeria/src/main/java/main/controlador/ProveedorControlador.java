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


    //LISTAR PROVEEDORES
    @CrossOrigin( allowedHeaders = {"Authorization", "Origin"})
    @GetMapping("/proveedores/listado")
    public List<Proveedor> listarProveedores()
    {
        return servicio.listarProveedores();
    }


    //BUSCAR PROVEEDOR POR ID
   // @CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
    @GetMapping("/proveedores/buscarId/{id}")
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
    //@CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
    //@CrossOrigin(origins="http://localhost:4200")
    @PostMapping("/proveedores/alta")
    public void registrarProveedor(@RequestBody Proveedor proveedor)
    {
        servicio.guardarProveedor(proveedor);
    }

    //ACTUALIZAR PROVEEDOR
    //@CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
    @PutMapping("proveedor/actualizar/{id}")
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
   // @CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
    @DeleteMapping("/proveedores/eliminar/{id}")
    public void eliminarProveedor(@PathVariable Integer id)
    {
        servicio.eliminarProveedor(id);
    }

    //BUSCAR PROVEEDORES POR NOMBRE
    @CrossOrigin( allowedHeaders = {"Authorization", "Origin"})
    @GetMapping("/proveedores/buscarNombre/{nombre}")
    public ResponseEntity<Proveedor> obtenerPorNombre(@PathVariable String nombre)
    {
        try {
            Proveedor proveedor = servicio.ObtenerPorNombre(nombre);
            return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
        }
    }

}
