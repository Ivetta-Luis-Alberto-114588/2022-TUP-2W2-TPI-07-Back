package main.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_productos")
public class TipoProducto{
    @Id
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String tipo;

    public TipoProducto() {
    }

    public TipoProducto(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
