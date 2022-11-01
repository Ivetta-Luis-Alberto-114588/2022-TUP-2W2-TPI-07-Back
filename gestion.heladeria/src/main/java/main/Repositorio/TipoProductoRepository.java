package main.Repositorio;

import main.modelos.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TipoProductoRepository extends JpaRepository<TipoProducto, Integer> {
    @Query("SELECT DISTINCT t FROM TipoProducto t WHERE t.tipo LIKE %?1%")
    public TipoProducto findByName(String tipo);
}
