package main.controlador;

import main.modelos.DetalleFactura;
import main.servicio.DetalleFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class DetalleFacturaControlador {

    @Autowired
    private DetalleFacturaServicio servicio;

    //Listar Detalles
    @GetMapping("/detalles/listado")
    public List<DetalleFactura> listarDetalles()
    {
        return servicio.listarDetalles();
    }

    //Buscar detalles por id
    @GetMapping("/detalles/buscarId/{id}")
    public ResponseEntity<DetalleFactura> obtenerDetalle(@PathVariable Integer id)
    {
        try {
            DetalleFactura detalleFactura = servicio.obtenerDetallePorId(id);
            return new ResponseEntity<DetalleFactura>(detalleFactura, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<DetalleFactura>(HttpStatus.NOT_FOUND);
        }
    }

    //Alta detalle
    @PostMapping("/detalles/alta")
    public void registrarDetalle(@RequestBody DetalleFactura detalleFactura)
    {
        servicio.guardarDetalle(detalleFactura);
    }

    //Actualizar detalle
    @PutMapping("/detalles/actualizar/{id}")
    public ResponseEntity<?> actualizarDetalle(@RequestBody DetalleFactura detalleFactura, @PathVariable Integer id)
    {
        try{
            DetalleFactura detalleExistente = servicio.obtenerDetallePorId(id);

            detalleExistente.setProducto(detalleFactura.getProducto());
            detalleExistente.setCantidad(detalleFactura.getCantidad());

            servicio.guardarDetalle(detalleExistente);
            return new ResponseEntity<DetalleFactura>(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<DetalleFactura>(HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar detalle
    @DeleteMapping("/detalles/eliminar/{id}")
    public void eliminarDetalle(@PathVariable Integer id)
    {
        servicio.eliminarDetalle(id);
    }


}
