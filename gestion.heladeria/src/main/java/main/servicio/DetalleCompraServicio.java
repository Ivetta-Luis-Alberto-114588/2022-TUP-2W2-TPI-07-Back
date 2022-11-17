package main.servicio;

import main.Repositorio.DetalleCompraRepositorio;
import main.modelos.DetalleCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleCompraServicio {

    @Autowired
    private DetalleCompraRepositorio repositorio;

    public List<DetalleCompra> listarDetallesCompra()
    {
        return repositorio.findAll();
    }

    public void guardarDetalleCompra(DetalleCompra detalleCompra)
    {
        repositorio.save(detalleCompra);
    }

    public DetalleCompra obtenerDetalleCompraPorId(Integer id)
    {
        return repositorio.findById(id).get();
    }

    public void eliminarDetalleCompra(Integer id)
    {
        repositorio.deleteById(id);
    }
}
