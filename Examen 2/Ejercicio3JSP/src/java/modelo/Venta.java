package modelo;

import java.time.LocalDate;
import java.util.Date;

public class Venta {
    
    private String codComercial;
    private String refProducto;
    private int cantidad;
    private LocalDate fecha;

    public Venta() {
        
    }

    public Venta(String codComercial, String refProducto, int cantidad, LocalDate fecha) {
        this.codComercial = codComercial;
        this.refProducto = refProducto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    Venta(String comercial, String producto, int cantidad, double precio, double total, int descuento, double totalDescuento, Date fecha) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getCodComercial() {
        return codComercial;
    }

    public void setCodComercial(String codComercial) {
        this.codComercial = codComercial;
    }

    public String getRefProducto() {
        return refProducto;
    }

    public void setRefProducto(String refProducto) {
        this.refProducto = refProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Venta{" + "codComercial=" + codComercial + ", refProducto=" + refProducto + ", cantidad=" + cantidad + ", fecha=" + fecha + '}';
    }
    
}
