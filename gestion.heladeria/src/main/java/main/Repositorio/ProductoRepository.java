package main.Repositorio;

import main.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query("SELECT DISTINCT p FROM Producto p WHERE p.descripcion LIKE %?1% AND p.eliminado = false")
    public Producto findByName(String descripcion);

    @Query("SELECT p FROM Producto p WHERE CONCAT(p.id, p.codigo_barra, p.descripcion, p.tipoProducto.tipo, p.marca.nombre) LIKE %?1% AND p.eliminado = false")
    public List<Producto> findAll(String descripcion);

    @Query("SELECT p FROM Producto p WHERE p.eliminado = false")
    public List<Producto> findAll();

    @Query("SELECT DISTINCT p FROM Producto p WHERE p.id = ?1 AND p.eliminado = false")
    public Producto findById(int id);

    @Modifying
    @Transactional
    @Query("UPDATE Producto po SET po.eliminado = true WHERE po.id = ?1")
    public void updateEliminar(int id);
}
