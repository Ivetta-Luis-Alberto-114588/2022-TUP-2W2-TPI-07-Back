package main.controlador;

import main.modelos.Producto;
import main.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
