package main.Repositorio;

import main.modelos.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OfertaRepository extends JpaRepository<Oferta, Integer> {
    @Query("SELECT DISTINCT o FROM Oferta o WHERE o.descripcion LIKE %?1%")
    public Oferta findByName(String nombre);
}
