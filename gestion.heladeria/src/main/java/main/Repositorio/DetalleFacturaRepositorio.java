package main.Repositorio;

import main.modelos.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepositorio extends JpaRepository<DetalleFactura, Integer> {

}
