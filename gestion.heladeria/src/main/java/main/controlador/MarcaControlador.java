package main.controlador;

import main.modelos.Marca;
import main.servicio.MarcaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarcaControlador {

    @Autowired
    private MarcaServicio servicio;

    //Listar marcas
    @GetMapping("/marcas/listardo")
    public List<Marca>listarMarcas()
    {
        return servicio.listarMarcas();
    }
}
