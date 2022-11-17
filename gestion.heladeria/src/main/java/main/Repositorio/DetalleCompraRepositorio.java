package main.Repositorio;

import main.modelos.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleCompraRepositorio extends JpaRepository <DetalleCompra, Integer> {
}
