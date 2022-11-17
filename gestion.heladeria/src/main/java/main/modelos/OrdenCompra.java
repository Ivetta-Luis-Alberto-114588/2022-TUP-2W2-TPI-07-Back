package main.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordenes_compras")
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private int id;

    @JsonIgnoreProperties({"facturas", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compra")
    private List<DetalleCompra> items;

    @Column(nullable = false)
    private String fecha_emision;

    @Column(nullable = false)
    private String fecha_fin;

    @Column(nullable = false)
    private double monto_total;

    public OrdenCompra() {
        items = new ArrayList<>();
    }

    public OrdenCompra(int id, Proveedor proveedor, List<DetalleCompra> items, String fecha_emision, String fecha_fin, double monto_total) {
        this.id = id;
        this.proveedor = proveedor;
        this.items = items;
        this.fecha_emision = fecha_emision;
        this.fecha_fin = fecha_fin;
        this.monto_total = monto_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<DetalleCompra> getItems() {
        return items;
    }

    public void setItems(List<DetalleCompra> items) {
        this.items = items;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(double monto_total) {
        this.monto_total = monto_total;
    }
}
