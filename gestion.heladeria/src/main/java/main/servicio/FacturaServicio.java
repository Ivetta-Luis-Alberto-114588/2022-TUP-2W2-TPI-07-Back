package main.servicio;

import main.Repositorio.DetalleFacturaRepositorio;
import main.Repositorio.FacturaRepositorio;
import main.modelos.DetalleFactura;
import main.modelos.Factura;
import main.modelos.Reporte1;
import main.modelos.Reporte2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FacturaServicio {

    @Autowired
    private FacturaRepositorio repositorio;
    @Autowired
    private DetalleFacturaRepositorio detalleFacturaRepositorio;

    public List<Factura> listarFacturas()
    {
        return repositorio.findAll();
    }

    @Transactional
    public Factura guardarFactura(Factura factura)
    {
        Factura facturaGuardada = repositorio.save(factura);
        //facturaGuardada = repositorio.getById(facturaGuardada.getId());
        List<DetalleFactura> detalleFactura = factura.getItems();

        for(DetalleFactura detalle : detalleFactura) {
            detalle.setId_factura(facturaGuardada.getId());
        }
        List<DetalleFactura> detalleFacturaGuardado = detalleFacturaRepositorio.saveAll(detalleFactura);
        facturaGuardada.setItems(detalleFacturaGuardado);
        return facturaGuardada;
    }

    public  Factura obtenerFacturaPorId(Integer id)
    {
        return repositorio.findById(id).get();
    }

    public void eliminarFactura(Integer id)
    {
        repositorio.deleteById(id);
    }

    public List<Factura> filtrarFecha(String fecha1, String fecha2)
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

}
