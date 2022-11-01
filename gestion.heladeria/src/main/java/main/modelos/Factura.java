package main.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @JsonIgnoreProperties({"facturas", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dni")
    private Cliente cliente;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
<<<<<<< HEAD
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "factura")
    //@JoinColumn(name = "id_factura")
=======
<<<<<<< HEAD
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "factura")
    //@JoinColumn(name = "id_factura")
=======
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_detalle")
>>>>>>> cad2137c5db568840f96129bccfffa433623ea5a
>>>>>>> 1a8b96a3032eb0bf5cfe09ba20032d914218df6a
    private List<DetalleFactura> items;

    @Column(nullable = false)
    private String fecha;

    @Column(nullable = false)
    private double monto_total;

    public Factura() {
<<<<<<< HEAD
        
=======
<<<<<<< HEAD
        
=======
        items = new ArrayList<>();
>>>>>>> cad2137c5db568840f96129bccfffa433623ea5a
>>>>>>> 1a8b96a3032eb0bf5cfe09ba20032d914218df6a
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
