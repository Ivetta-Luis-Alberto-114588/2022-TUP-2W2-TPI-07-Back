package main.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(nullable = false)
    private int dni;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private long telefono;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private int cantidad_puntos;

    @JsonIgnoreProperties({"cliente", "hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente" , cascade = CascadeType.ALL)
    private List<Factura> facturas;

    public Cliente() {
        this.facturas = new ArrayList<>();
    }


    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCantidad_puntos() {
        return cantidad_puntos;
    }

    public void setCantidad_puntos(int cantidad_puntos) {
        this.cantidad_puntos = cantidad_puntos;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
}
