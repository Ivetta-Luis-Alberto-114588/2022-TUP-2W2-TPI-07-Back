package main.Repositorio;

import main.modelos.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    @Query("SELECT DISTINCT p FROM Proveedor p WHERE p.nombre LIKE %?1%")
    public Proveedor findByName(String nombre);

}