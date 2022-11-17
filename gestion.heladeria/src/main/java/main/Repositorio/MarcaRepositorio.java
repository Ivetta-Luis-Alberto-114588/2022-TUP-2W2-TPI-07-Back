package main.Repositorio;

import main.modelos.Marca;
import main.modelos.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MarcaRepositorio extends JpaRepository<Marca, Integer> {
    @Query("SELECT DISTINCT m FROM Marca m WHERE m.nombre LIKE %?1%")
    public Marca findByName(String nombre);
}
