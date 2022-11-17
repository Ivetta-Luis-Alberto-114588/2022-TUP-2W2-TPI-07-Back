package main.controlador;

import main.modelos.Producto;
import main.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoControlador {

    @Autowired
    private ProductoServicio servicio;

    //listar porductos
    @GetMapping("/productos/listado")
    public List<Producto> listarProductos()
    {
        return servicio.listarProductos();
    }

    //buscar producto por id
    @GetMapping("/productos/buscarId{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Integer id)
    {
        try
        {
            Producto producto = servicio.obtenerProductoPorId(id);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    //Alta producto
    @PostMapping("/productos/alta")
    public void registrarProducto(@RequestBody Producto producto)
    {
        servicio.guardarProducto(producto);
    }

    //Actualizar cliente
    @PutMapping("/productos/actualizar/{id}")
    public ResponseEntity<?> actualizarProductos(@RequestBody Producto producto, @PathVariable Integer id)
    {
        try {
            Producto productoExistente = servicio.obtenerProductoPorId(id);

            productoExistente.setCodigo(producto.getCodigo());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setTipoProducto(producto.getTipoProducto());
            productoExistente.setMarca(producto.getMarca());
            productoExistente.setPrecio_unitario_compra(producto.getPrecio_unitario_compra());
            productoExistente.setPrecio_unitario_venta(producto.getPrecio_unitario_venta());
            productoExistente.setEliminado(producto.isEliminado());

            servicio.guardarProducto(productoExistente);
            return  new ResponseEntity<Producto>(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar producto
    @DeleteMapping("/productos/eliminar/{id}")
    public void eliminarProducto(@PathVariable Integer id)
    {
        servicio.eliminarProducto(id);
    }

    //BUSCAR priducto POR NOMBRE
    @GetMapping("/productos/buscarNombre/{nombre}")
    public ResponseEntity<Producto> obtenerPorNombre(@PathVariable String nombre)
    {
        try {
            Producto producto = servicio.obtenerPorNombre(nombre);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/productos/listarNombre/{nombre}")
    public ResponseEntity<List<Producto>>ListarPorNombre(@PathVariable String nombre)
    {
        return ResponseEntity.ok(servicio.obtenerTodosPorNombre(nombre));
    }
}
