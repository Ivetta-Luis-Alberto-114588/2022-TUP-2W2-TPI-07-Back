package main.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @Column(nullable = false)
    private int cuil;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private long telefono;
    @Column(nullable = false)
    private String pais;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private int codigo_postal;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private double latitud;
    @Column(nullable = false)
    private double longitud;

    public Proveedor() {
    }

    public Proveedor(int cuil, String nombre, long telefono, String pais, String direccion, int codigo_postal, String email, double latitud, double longitud) {
        this.cuil = cuil;
        this.nombre = nombre;
        this.telefono = telefono;
        this.pais = pais;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.email = email;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
