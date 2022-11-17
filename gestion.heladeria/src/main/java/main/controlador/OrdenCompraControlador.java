package main.controlador;

import main.modelos.OrdenCompra;
import main.modelos.Reporte1;
import main.modelos.Reporte2;
import main.modelos.Usuario;
import main.servicio.OrdenCompraServicio;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdenCompraControlador {

    @Autowired
    private OrdenCompraServicio servicio;

    //Listar Ordenes de compras
    @GetMapping("/ordenes/listado")
    public List<OrdenCompra> listarOrdenes()
    {
        return servicio.listarOrdenes();
    }

    //REPORTE: Listar facturas por fecha sumando sus montos totales
    @GetMapping("/ordenes/montosPorFecha/{id}/{fecha1}/{fecha2}")
    public List<Reporte1> listarMontosPorFecha(@PathVariable Integer id, @PathVariable String fecha1, @PathVariable String fecha2)
    {
        return servicio.filtarMontosPorFecha(id, fecha1, fecha2);
    }

    //REPORTE: Lista los 10 produtos mas vendidos en un rango de fechas
    @GetMapping("/ordenes/masVendidos/{fecha1}/{fecha2}")
    public List<Reporte2> listarLos10MasVendidos(@PathVariable String fecha1, @PathVariable String fecha2)
    {
        return servicio.listar10MasVendidos(fecha1, fecha2);
    }

    //Buscar orden por Id
    @GetMapping("/ordenes/buscarId{id}")
    public ResponseEntity<OrdenCompra> obtenerOrden(@PathVariable Integer id)
    {
        try
        {
            OrdenCompra ordenCompra = servicio.obtenerOrdenCompraPorId(id);
            return new ResponseEntity<OrdenCompra>(ordenCompra, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<OrdenCompra>(HttpStatus.NOT_FOUND);
        }
    }

    //Alta orden
    @PostMapping("/ordenes/alta")
    public ResponseEntity<OrdenCompra> registrarOrden(@RequestBody OrdenCompra ordenCompra)
    {
        return ResponseEntity.created(null).body(servicio.guardarOrden(ordenCompra));
    }

    //Actualizar orden
    @PutMapping("/ordenes/actualizar/{id}")
    public ResponseEntity<?> actualizarOrden(@RequestBody OrdenCompra ordenCompra, @PathVariable Integer id)
    {
        try {
            OrdenCompra ordenCompraExistente = servicio.obtenerOrdenCompraPorId(id);

            ordenCompraExistente.setProveedor(ordenCompra.getProveedor());
            ordenCompraExistente.setItems(ordenCompra.getItems());
            ordenCompraExistente.setFecha_emision(ordenCompra.getFecha_emision());
            ordenCompraExistente.setFecha_fin(ordenCompra.getFecha_fin());
            ordenCompraExistente.setMonto_total(ordenCompra.getMonto_total());

            servicio.guardarOrden(ordenCompraExistente);
            return  new ResponseEntity<OrdenCompra>(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<OrdenCompra>(HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar orden
    @DeleteMapping("/ordenes/eliminar/{id}")
    public void eliminarOrden(@PathVariable Integer id)
    {
        servicio.eliminarOrdenCompra(id);
    }

    //Lista las ordenes buscadas a travez de todos los campos
    @GetMapping("/ordenes/listarNombre/{nombre}")
    public ResponseEntity<List<OrdenCompra>>ListarPorNombre(@PathVariable String nombre)
    {
        return ResponseEntity.ok(servicio.obtenerTodosPorNombre(nombre));
    }

}
