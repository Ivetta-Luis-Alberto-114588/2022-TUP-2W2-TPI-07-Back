package main.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "usuarios" , uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int legajo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String password;

   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_roles")
   private Rol rol;

    @Column(nullable = false)
    private boolean eliminado;


    public Usuario() {
    }

    public Usuario(int legajo, String nombre, String password, Rol rol, boolean eliminado) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.eliminado = eliminado;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
