package main.servicio;

import main.Repositorio.PasswordRepositorio;
import main.modelos.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordServicio {
    @Autowired
    private PasswordRepositorio repositorio;

    public List<Password> listarPasswords()
    {
        return repositorio.findAll();
    }

    public void guardarPassword(Password password)
    {
        repositorio.save(password);
    }

    public Password obtenerPasswordPorId(Integer id)
    {
        return repositorio.findById(id).get();
    }

    public void eliminarPassword(Integer id)
    {
        repositorio.deleteById(id);
    }
}
