package main.controlador;


import main.modelos.Factura;
import main.modelos.Reporte1;
import main.modelos.Reporte2;
import main.servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacturaControlador {

    @Autowired
    private FacturaServicio servicio;

    //Listar facturas
    @GetMapping("/facturas/listado")
    public List<Factura> listarFacturas()
    {
        return servicio.listarFacturas();
    }

    //REPORTE:  Listar facturas por fechas
    @GetMapping("/facturas/porFechas/{fecha1}/{fecha2}")
    public List<Factura> listarPorFechas(@PathVariable String fecha1, @PathVariable String fecha2)
    {
        return servicio.filtrarFecha(fecha1, fecha2);
    }

    //REPORTE: Listar facturas por fecha sumando sus montos totales
    @GetMapping("/facturas/montosPorFecha/{id}/{fecha1}/{fecha2}")
    public List<Reporte1> listarMontosPorFecha(@PathVariable Integer id, @PathVariable String fecha1, @PathVariable String fecha2)
    {
        return servicio.filtarMontosPorFecha(id, fecha1, fecha2);
    }

    //REPORTE: Lista los 10 produtos mas vendidos en un rango de fechas
    @GetMapping("/facturas/masVendidos/{fecha1}/{fecha2}")
    public List<Reporte2> listarLos10MasVendidos(@PathVariable String fecha1, @PathVariable String fecha2)
    {
        return servicio.listar10MasVendidos(fecha1, fecha2);
    }

    //Buscar factura por Id
    @GetMapping("/facturas/buscarId{id}")
    public ResponseEntity<Factura> obtenerFactura(@PathVariable Integer id)
    {
        try
        {
            Factura factura = servicio.obtenerFacturaPorId(id);
            return new ResponseEntity<Factura>(factura, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Factura>(HttpStatus.NOT_FOUND);
        }
    }

    //Alta factura
    @PostMapping("/facturas/alta")
    public ResponseEntity<Factura> registrarFactura(@RequestBody Factura factura)
    {
        return ResponseEntity.created(null).body(servicio.guardarFactura(factura));
    }


    //Actualizar factura
    @PutMapping("/facturas/actualizar/{id}")
    public ResponseEntity<?> actualizarFactura(@RequestBody Factura factura, @PathVariable Integer id)
    {
        try {
            Factura facturaExistente = servicio.obtenerFacturaPorId(id);

            facturaExistente.setCliente(factura.getCliente());
            facturaExistente.setItems(factura.getItems());
            facturaExistente.setFecha(factura.getFecha());
            facturaExistente.setMonto_total(factura.getMonto_total());

            servicio.guardarFactura(facturaExistente);
            return  new ResponseEntity<Factura>(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Factura>(HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar factura
    @DeleteMapping("/facturas/eliminar/{id}")
    public void eliminarFactura(@PathVariable Integer id)
    {
        servicio.eliminarFactura(id);
    }


}
