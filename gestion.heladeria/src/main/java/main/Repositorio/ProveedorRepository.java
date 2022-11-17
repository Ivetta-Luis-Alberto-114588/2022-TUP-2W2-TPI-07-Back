package main.Repositorio;

import main.modelos.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    @Query("SELECT DISTINCT p FROM Proveedor p WHERE p.nombre LIKE %?1%")
    public Proveedor findByName(String nombre);

    @Query("SELECT p FROM Proveedor p WHERE CONCAT(p.id, p.cuit, p.nombre, p.telefono, p.direccion, p.codigo_postal, p.email) LIKE %?1% AND p.eliminado=false")
    public List<Proveedor> findAll(String nombre);

    @Query("SELECT p FROM Proveedor p WHERE p.eliminado=false")
    public List<Proveedor> findAll();

    @Query("SELECT DISTINCT p FROM Proveedor p WHERE p.id = ?1 AND p.eliminado=false")
    public Proveedor findById(int id);

    @Modifying
    @Transactional
    @Query("UPDATE Proveedor p SET p.eliminado = true WHERE p.id = ?1")
    public void updateEliminar(int id);
}