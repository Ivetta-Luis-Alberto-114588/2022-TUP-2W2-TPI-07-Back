package main.modelos;

import javax.persistence.*;


@Entity
@Table(name = "oferta")
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int codigo_producto;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private int cantidad_puntos;
    @Column(nullable = false)
    private double beneficio;
    @Column(nullable = false)
    private String fecha_inicio;
    @Column(nullable = false)
    private String fecha_fin;

    public Oferta() {
    }

    public Oferta(int id, int codigo_producto, String descripcion, int cantidad_puntos, double beneficio, String fecha_inicio, String fecha_fin) {
        this.id = id;
        this.codigo_producto = codigo_producto;
        this.descripcion = descripcion;
        this.cantidad_puntos = cantidad_puntos;
        this.beneficio = beneficio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad_puntos() {
        return cantidad_puntos;
    }

    public void setCantidad_puntos(int cantidad_puntos) {
        this.cantidad_puntos = cantidad_puntos;
    }

    public double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(double beneficio) {
        this.beneficio = beneficio;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
