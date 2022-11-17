package main.controlador;

import main.modelos.Cliente;
import main.modelos.Rol;
import main.modelos.Usuario;
import main.servicio.RolServicio;
import main.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio servicio;
    private RolServicio servicioR;


    //Listar usuarios
    @GetMapping("/usuarios/listado")
    public List<Usuario> listarUsuarios()
    {
        return servicio.listarUsuario();
    }

    //Alta usuario
    @PostMapping("/usuarios/alta")
    public void registrarUsuario(@RequestBody Usuario usuario)
    {
        servicio.guardarUsuario(usuario);
    }

    //Actualizar usuario
    @PutMapping("/usuario/actualizar/{id}")
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id)
    {
        try{
            Usuario usuarioExistente = servicio.obtenerUsuarioPorId(id);

            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setPassword(usuario.getPassword());
            usuarioExistente.setEliminado(usuario.isEliminado());
            usuarioExistente.setRol(usuario.getRol());

            servicio.guardarUsuario(usuarioExistente);
            return new ResponseEntity<Usuario>(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar usuario
    @DeleteMapping("/usuarios/eliminar/{id}")
    public void eliminarUsuario(@PathVariable Integer id)
    {
        servicio.eliminarUsuario(id);
    }


    //Login
    @GetMapping("usuarios/login/{nombre}/{pass}")
    public ResponseEntity<Usuario> login(@PathVariable String nombre, @PathVariable String pass)
    {
        try
        {
            Usuario usuario = servicio.login(nombre, pass);
            return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }

    //Listar los usuarios buscardos a travez de todos los campos
    @GetMapping("/usuarios/listarNombre/{nombre}")
    public ResponseEntity<List<Usuario>>ListarPorNombre(@PathVariable String nombre)
    {
        return ResponseEntity.ok(servicio.obtenerTodosPorNombre(nombre));
    }

}


