package main.modelos;

import java.io.Serializable;

public class Reporte1 implements Serializable {

    public String fecha;
    public double monto;

    public Reporte1(String fecha, double monto) {
        this.fecha = fecha;
        this.monto = monto;
    }

    public static final long serialVersionUID = 1L;
}
