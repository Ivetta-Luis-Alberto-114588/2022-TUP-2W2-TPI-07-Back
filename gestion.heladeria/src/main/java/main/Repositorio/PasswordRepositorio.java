package main.Repositorio;

import main.modelos.Password;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PasswordRepositorio extends JpaRepository<Password, Integer> {
}
