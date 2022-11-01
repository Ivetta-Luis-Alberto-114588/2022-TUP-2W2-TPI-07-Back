package main.Repositorio;

import main.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query("SELECT DISTINCT p FROM Producto p WHERE p.descripcion LIKE %?1%")
    public Producto findByName(String descripcion);
}
