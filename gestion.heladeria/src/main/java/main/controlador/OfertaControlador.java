package main.controlador;

import main.modelos.Oferta;
import main.servicio.OfertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfertaControlador {

    @Autowired
    private OfertaServicio servicio;

    //LISTAR OFERTAS
    @GetMapping("/ofertas/listado")
    public ResponseEntity<List<Oferta>> listarOfertas()
    {
        return ResponseEntity.ok(servicio.listarOfertas());
    }


    //BUSCAR OFERTA POR ID
    @GetMapping("/ofertas/buscarId/{id}")
    public ResponseEntity<Oferta> obtenerOferta(@PathVariable Integer id)
    {
        try {
            Oferta oferta = servicio.obtenerOfertaPorId(id);
            return new ResponseEntity<Oferta>(oferta, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Oferta>(HttpStatus.NOT_FOUND);
        }
    }

    //ALTA OFERTA
    @PostMapping("/ofertas/alta")
    public void registrarOferta(@RequestBody Oferta oferta)
    {
        servicio.guardarOferta(oferta);
    }

    //ACTUALIZAR PROVEEDOR
    @PutMapping("ofertas/actualizar/{id}")
    public ResponseEntity<?> actualizarOferta(@RequestBody Oferta oferta, @PathVariable Integer id)
    {
        try {
            Oferta ofertaExistente = servicio.obtenerOfertaPorId(id);

            ofertaExistente.setCodigo_producto(oferta.getCodigo_producto());
            ofertaExistente.setDescripcion(oferta.getDescripcion());
            ofertaExistente.setCantidad_puntos(oferta.getCantidad_puntos());
            ofertaExistente.setBeneficio(oferta.getBeneficio());
            ofertaExistente.setFecha_inicio(oferta.getFecha_inicio());
            ofertaExistente.setFecha_fin(oferta.getFecha_fin());

            servicio.guardarOferta(ofertaExistente);
            return new ResponseEntity<Oferta>(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Oferta>(HttpStatus.NOT_FOUND);
        }
    }

    //ELIMINAR OFERTA
    @DeleteMapping("/ofertas/eliminar/{id}")
    public void eliminarOferta(@PathVariable Integer id)
    {
        servicio.eliminarOferta(id);
    }

    //BUSCAR OFERTA POR NOMBRE
    @GetMapping("/ofertas/buscarNombre/{nombre}")
    public ResponseEntity<Oferta> obtenerPorNombre(@PathVariable String nombre)
    {
        try {
            Oferta oferta = servicio.ObtenerPorNombre(nombre);
            return new ResponseEntity<Oferta>(oferta, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Oferta>(HttpStatus.NOT_FOUND);
        }
    }

}
