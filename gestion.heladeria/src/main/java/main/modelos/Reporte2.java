package main.modelos;


import lombok.AllArgsConstructor;
import lombok.Getter;

public class Reporte2 {

    public long cantidad;
    public String descripcion;

    public Reporte2() {
    }

    public Reporte2(long cantidad, String descripcion) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }
}
