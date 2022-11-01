package main.controlador;

import main.modelos.TipoProducto;
import main.servicio.TIpoProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TipoProductoControlador {

    @Autowired
    private TIpoProductoServicio servicio;

    //Listar tipos de productos
    @GetMapping("tipoProducto/listado")
    public List<TipoProducto>listarTipoProductos()
    {
        return servicio.listarTipoProductos();
    }
}
