package main.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    private int cuil;
    private String nombre;
    private int telefono;
    private String pais;
    private String direccion;
    private int codigo_postal;
    private String email;
    private double latitud;
    private double longitud;

    public Proveedor() {
    }

    public Proveedor(int cuil, String nombre, int telefono, String pais, String direccion, int codigo_postal, String email, double latitud, double longitud) {
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
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
