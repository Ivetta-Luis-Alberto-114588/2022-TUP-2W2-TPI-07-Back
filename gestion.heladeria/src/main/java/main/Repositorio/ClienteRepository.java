package main.Repositorio;

import main.modelos.Cliente;
import main.modelos.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("SELECT DISTINCT c FROM Cliente c WHERE c.nombre LIKE %?1%")
    public Cliente findByName(String nombre);
}
