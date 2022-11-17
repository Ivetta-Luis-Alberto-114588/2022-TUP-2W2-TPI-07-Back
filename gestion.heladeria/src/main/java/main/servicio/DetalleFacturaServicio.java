package main.servicio;

import main.Repositorio.DetalleFacturaRepositorio;
import main.modelos.DetalleFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServicio {

    @Autowired
    private DetalleFacturaRepositorio repositorio;

    public List<DetalleFactura> listarDetalles()
    {
        return repositorio.findAll();
    }

    public void guardarDetalle(DetalleFactura detalleFactura)
    {
        repositorio.save(detalleFactura);
    }

    public DetalleFactura obtenerDetallePorId(Integer id)
    {
        return repositorio.findById(id).get();
    }

    public void eliminarDetalle(Integer id)
    {
        repositorio.deleteById(id);
    }
}
