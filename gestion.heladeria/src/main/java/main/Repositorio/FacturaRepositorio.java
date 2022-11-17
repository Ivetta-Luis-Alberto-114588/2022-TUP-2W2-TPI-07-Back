package main.Repositorio;

import main.modelos.Factura;
import main.modelos.Reporte1;
import main.modelos.Reporte2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface FacturaRepositorio extends JpaRepository<Factura, Integer>  {

    @PersistenceContext
    EntityManager entityManager = null;

    @Query("SELECT f FROM Factura f WHERE STR_TO_DATE(f.fecha,'%d/%m/%y') " +
            "BETWEEN STR_TO_DATE(?1,'%d%m%y') AND STR_TO_DATE(?2,'%d%m%y') order by f.fecha asc")
    public List<Factura> findAllBy(String fecha1, String fecha2);


    @Query("select new main.modelos.Reporte1(f.fecha, SUM(f.monto_total) as monto_total) from Factura f join Cliente c on c.id = f.cliente.id where c.id = ?1 and STR_TO_DATE(f.fecha,'%d/%m/%y') between STR_TO_DATE(?2,'%d%m%y') AND STR_TO_DATE(?3,'%d%m%y') group by f.fecha")
    public List<Reporte1> findAllById(int id, String fecha1, String fecha2);

    @Query("SELECT new main.modelos.Reporte2(sum(df.cantidad) as cantidad, p.descripcion) FROM DetalleFactura df, Factura f, Producto p, TipoProducto tp where df.id_factura=f.id and df.producto.id = p.id and STR_TO_DATE(f.fecha,'%d/%m/%y') between STR_TO_DATE(?1,'%d%m%y') and STR_TO_DATE(?2,'%d%m%y') and tp.id = 2 group by p.descripcion order by 1 desc")
    public List<Reporte2> findAllProductosMasVendidos(String fecha1, String fecha2);








//    @Query("SELECT new main.modelos.Reporte2(sum(df.cantidad) as cantidad, pro.descripcion) FROM DetalleFactura df, Factura fa, Producto pro where df.id_factura=fa.id and df.id_producto = pro.id and STR_TO_DATE(fecha,'%d/%m/%y') between STR_TO_DATE(?1,'%d/%m/%y') and STR_TO_DATE(?2,'%d/%m/%y') group by pro.descripcion order by 1 desc")
//    public List<Reporte2> findAllProductosMasVendidos(String fecha1, String fecha2);


//    public default List<Reporte2> findAllProductosMasVendidos(String fecha1, String fecha2)
//    {
//        return entityManager.createQuery("SELECT new main.modelos.Reporte2(sum(df.cantidad) as cantidad, pro.descripcion) FROM DetalleFactura df, Factura fa, Producto pro where df.id_factura=fa.id and df.id_producto = pro.id and STR_TO_DATE(fecha,'%d/%m/%y') between STR_TO_DATE(?1,'%d/%m/%y') and STR_TO_DATE(?2,'%d/%m/%y') group by pro.descripcion order by 1 desc", Reporte2.class).setMaxResults(10).getResultList();
//    }

}
