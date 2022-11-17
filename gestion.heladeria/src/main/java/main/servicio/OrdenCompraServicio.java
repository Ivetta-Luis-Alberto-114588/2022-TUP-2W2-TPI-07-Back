package main.servicio;

import main.Repositorio.DetalleCompraRepositorio;
import main.Repositorio.OrdenCompraRepositorio;
import main.modelos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrdenCompraServicio {

    @Autowired
    private OrdenCompraRepositorio repositorio;

    @Autowired
    private DetalleCompraRepositorio detalleCompraRepositorio;

    public List<OrdenCompra> listarOrdenes()
    {
        return repositorio.findAll();
    }

    @Transactional
    public OrdenCompra guardarOrden(OrdenCompra ordenCompra)
    {
        OrdenCompra ordenGuardada = repositorio.save(ordenCompra);
        List<DetalleCompra> detalleCompra = ordenCompra.getItems();

        for(DetalleCompra detalle : detalleCompra){
            detalle.setId_compra(ordenGuardada.getId());
        }
        List<DetalleCompra> detalleCompraGuardado = detalleCompraRepositorio.saveAll(detalleCompra);
        ordenGuardada.setItems(detalleCompraGuardado);
        return ordenGuardada;
    }
    public OrdenCompra obtenerOrdenCompraPorId(Integer id)
    {
        return repositorio.findById(id).get();
    }

    public void eliminarOrdenCompra(Integer id)
    {
        repositorio.deleteById(id);
    }

    public List<OrdenCompra> filtrarFecha(String fecha1, String fecha2)
    {
        return repositorio.findAllBy(fecha1, fecha2);
    }

    public List<Reporte1> filtarMontosPorFecha(int id, String fecha1, String fecha2)
    {
        return repositorio.findAllById(id, fecha1, fecha2);
    }

    public List<Reporte2> listar10MasVendidos(String fecha1, String fecha2)
    {
        return repositorio.findAllProductosMasVendidos(fecha1, fecha2);
    }

    public List<OrdenCompra> obtenerTodosPorNombre(String nombre)
    {
        if(nombre != null)
        {
            return repositorio.findAll(nombre);
        }
        return repositorio.findAll();
    }
}
