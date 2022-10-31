package main.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @Column(nullable = false)
    private int codigo;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private int id_tipo;

    public Producto() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_producto() {
        return id_tipo;
    }

    public void setId_producto(int id_producto) {
        this.id_tipo = id_producto;
    }
}
