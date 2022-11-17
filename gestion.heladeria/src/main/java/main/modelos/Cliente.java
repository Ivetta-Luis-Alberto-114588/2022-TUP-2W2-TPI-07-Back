package main.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private int dni;
    @Column(nullable = false)
    private String nombre_apellido;
    @Column(nullable = false)
    private long telefono;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private boolean eliminado;

    @JsonIgnoreProperties({"cliente", "hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente" , cascade = CascadeType.ALL)
    private List<Factura> facturas;

    public Cliente() {
        this.facturas = new ArrayList<>();
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
}
