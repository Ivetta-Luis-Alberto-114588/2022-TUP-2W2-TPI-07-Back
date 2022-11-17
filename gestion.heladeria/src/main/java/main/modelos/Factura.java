package main.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private int id;

    @JsonIgnoreProperties({"facturas", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura")
    private List<DetalleFactura> items;

    @Column(nullable = false)
    private String fecha;

    @Column(nullable = false)
    private double monto_total;



    public Factura() {
        items = new ArrayList<>();
    }

    public Double getTotal()
    {
        Double total = 0.00;
        for(DetalleFactura items : items)
        {
            total += items.getImporte();
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(double monto_total) {
        this.monto_total = monto_total;
    }

    public List<DetalleFactura> getItems() {
        return items;
    }

    public void setItems(List<DetalleFactura> items) {
        this.items = items;
    }

    public static final long serialVersionUID = 1L;
}
