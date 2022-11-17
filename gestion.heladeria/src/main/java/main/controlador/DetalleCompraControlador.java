package main.controlador;

import main.modelos.DetalleCompra;
import main.servicio.DetalleCompraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class DetalleCompraControlador {

    @Autowired
    private DetalleCompraServicio servicio;

    //listar Detalles
    @GetMapping("/detallesCompra/listado")
    public List<DetalleCompra> listarDetallesCompra()
    {
        return servicio.listarDetallesCompra();
    }

    //Buscar detalleComra por id
    @GetMapping("/detallesCompra/buscarId/{id}")
    public ResponseEntity<DetalleCompra> otenerDetalleCompra(@PathVariable Integer id)
    {
        try {
            DetalleCompra detalleCompra = servicio.obtenerDetalleCompraPorId(id);
            return new ResponseEntity<DetalleCompra>(detalleCompra, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<DetalleCompra>(HttpStatus.NOT_FOUND);
        }
    }

    //Alta detalleComra
    @PostMapping("/detallesCompra/actualizar/{id}")
    public ResponseEntity<?> actualizarDetalleCompra(@RequestBody DetalleCompra detalleCompra, @PathVariable Integer id)
    {
        try {
            DetalleCompra detalleCompraExistente = servicio.obtenerDetalleCompraPorId(id);

            detalleCompraExistente.setProducto(detalleCompra.getProducto());
            detalleCompraExistente.setCantidad(detalleCompra.getCantidad());

            servicio.guardarDetalleCompra(detalleCompraExistente);
            return new ResponseEntity<DetalleCompra>(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<DetalleCompra>(HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar detalleCompra
    @DeleteMapping("/detalleCompra/eliminar/{id}")
    public void eliminarDetalleCompra(@PathVariable Integer id)
    {
        servicio.eliminarDetalleCompra(id);
    }
}
