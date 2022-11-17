package main.Repositorio;

import main.modelos.OrdenCompra;
import main.modelos.Reporte1;
import main.modelos.Reporte2;
import main.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface OrdenCompraRepositorio extends JpaRepository<OrdenCompra, Integer> {

    @PersistenceContext
    EntityManager entityManager = null;

    @Query("SELECT o FROM OrdenCompra o WHERE o.fecha_emision BETWEEN ?1 AND ?2  order by o.fecha_emision asc")
    public List<OrdenCompra> findAllBy(String fecha1, String fecha2);

    @Query("select new main.modelos.Reporte1(o.fecha_emision, SUM(o.monto_total) as monto_total) from OrdenCompra o join Proveedor p on p.id = o.proveedor.id where p.id = ?1 and STR_TO_DATE(o.fecha_emision,'%d/%m/%y') between STR_TO_DATE(?2,'%d%m%y') AND STR_TO_DATE(?3,'%d%m%y') group by o.fecha_emision")
    public List<Reporte1> findAllById(int id, String fecha1, String fecha2);

    @Query("SELECT new main.modelos.Reporte2(sum(dc.cantidad) as cantidad, p.descripcion) FROM DetalleCompra dc, OrdenCompra o, Producto p, TipoProducto tp where dc.id_compra=o.id and dc.producto.id = p.id and STR_TO_DATE(o.fecha_emision,'%d/%m/%y') between STR_TO_DATE(?1,'%d%m%y') and STR_TO_DATE(?2,'%d%m%y') and tp.id = 2 group by p.descripcion order by 1 desc")
    public List<Reporte2> findAllProductosMasVendidos(String fecha1, String fecha2);

    @Query("SELECT o FROM OrdenCompra o WHERE CONCAT(o.id, o.proveedor.nombre, o.fecha_emision, o.fecha_fin) LIKE %?1% order by o.fecha_emision asc")
    public List<OrdenCompra> findAll(String nombre);
}
