package main.Repositorio;

import main.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    @Query("SELECT DISTINCT u FROM Usuario u WHERE u.nombre LIKE %?1% AND u.eliminado = false")
    public Usuario findByName(String nombre);

    @Query("SELECT u FROM Usuario u WHERE u.nombre = ?1 AND u.password = ?2 AND u.eliminado = false")
    public Usuario findUsuarioBy(String nombre, String pass);

    @Query("SELECT u FROM Usuario u WHERE u.eliminado = false")
    public List<Usuario> findAll();

    @Query("SELECT u FROM Usuario u WHERE CONCAT(u.legajo, u.nombre, u.password, u.eliminado, u.rol.rol) LIKE %?1% AND u.eliminado = false")
    public List<Usuario> findAll(String nombre);

    @Query("SELECT DISTINCT u FROM Usuario u WHERE u.legajo=?1 AND u.eliminado = false")
    public Usuario findById(int legajo);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.eliminado = true WHERE u.legajo = ?1")
    public void updateEliminar(int legajo);
}

