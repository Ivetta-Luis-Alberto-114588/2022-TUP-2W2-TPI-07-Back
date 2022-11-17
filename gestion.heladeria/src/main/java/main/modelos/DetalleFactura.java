package main.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detalles_facturas")
public class DetalleFactura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private int id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(nullable = false)
    private int cantidad;

    @JoinColumn(name="id_factura")
    private int id_factura;

    public DetalleFactura() {
    }

    public DetalleFactura(int id, Producto producto, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Double getImporte()
    {
        return cantidad * producto.getPrecio_unitario_venta();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_factura() {
        return this.id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    private static final long serialVersionUID = 1L;
}
