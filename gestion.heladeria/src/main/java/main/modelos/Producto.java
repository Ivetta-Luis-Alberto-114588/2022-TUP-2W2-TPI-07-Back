package main.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private int codigo_barra;

    @Column(nullable = false)
    private String descripcion;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo")
    private TipoProducto tipoProducto;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca")
    private Marca marca;

    @Column(nullable = false)
    private double precio_unitario_venta;

    @Column(nullable = false)
    private double precio_unitario_compra;

    @Column(nullable = false)
    private boolean eliminado;

    public Producto() {
    }

    public Producto(Integer id, int codigo_barra, String descripcion, TipoProducto tipoProducto, Marca marca, double precio_unitario_venta, double precio_unitario_compra, boolean eliminado) {
        this.id = id;
        this.codigo_barra = codigo_barra;
        this.descripcion = descripcion;
        this.tipoProducto = tipoProducto;
        this.marca = marca;
        this.precio_unitario_venta = precio_unitario_venta;
        this.precio_unitario_compra = precio_unitario_compra;
        this.eliminado = eliminado;
    }

    public int getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(int codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo_barra;
    }

    public void setCodigo(int codigo) {
        this.codigo_barra = codigo_barra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public double getPrecio_unitario_venta() {
        return precio_unitario_venta;
    }

    public void setPrecio_unitario_venta(double precio_unitario_venta) {
        this.precio_unitario_venta = precio_unitario_venta;
    }

    public double getPrecio_unitario_compra() {
        return precio_unitario_compra;
    }

    public void setPrecio_unitario_compra(double precio_unitario_compra) {
        this.precio_unitario_compra = precio_unitario_compra;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    private static final long serialVersionUID = 1L;
}
