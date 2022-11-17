package main.Repositorio;

import main.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("SELECT DISTINCT c FROM Cliente c WHERE c.nombre_apellido LIKE %?1% AND c.eliminado = false")
    public Cliente findByName(String nombre_apellido);

    @Query("SELECT c FROM Cliente c WHERE CONCAT(c.id, c.dni, c.nombre_apellido, c.telefono, c.direccion, c.email) LIKE %?1% AND c.eliminado = false")
    public List<Cliente> findAll(String nombre_apellido);

    @Query("SELECT c FROM Cliente c WHERE c.eliminado = false")
    public List<Cliente> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE Cliente c SET c.eliminado = true WHERE c.id = ?1")
    public void updateEliminar(int id);
}
