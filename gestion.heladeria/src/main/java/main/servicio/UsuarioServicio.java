package main.servicio;

import main.Repositorio.UsuarioRepositorio;
import main.modelos.Cliente;
import main.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio repositorio;

    public List<Usuario> listarUsuario()
    {
        return repositorio.findAll();
    }

    public Usuario buscarPorNombre(String nombre)
    {
        return repositorio.findByName(nombre);
    }

    public void guardarUsuario(Usuario usuario)
    {
        repositorio.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(Integer id)
    {
        return repositorio.findById(id).get();
    }

    public void eliminarUsuario(Integer id)
    {
        repositorio.updateEliminar(id);
    }

    public Usuario login(String nombre, String pass)
    {
        return repositorio.findUsuarioBy(nombre, pass);
    }

    public List<Usuario> obtenerTodosPorNombre(String nombre)
    {
        if(nombre != null)
        {
            return repositorio.findAll(nombre);
        }
        return repositorio.findAll();
    }
}
