package main.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private long cuit;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private long telefono;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private int codigo_postal;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private boolean eliminado;

    public Proveedor() {
    }

    public Proveedor(int id, long cuit, String nombre, long telefono, String direccion, int codigo_postal, String email, boolean eliminado) {
        this.id = id;
        this.cuit = cuit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.email = email;
        this.eliminado = eliminado;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}