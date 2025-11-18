package modelo;

import java.util.Date;

public class Reserva {
    
    private String nombre;
    private String apellidos;
    private String dni;
    private String ss;
    private String telefono;
    private String email;
    private String provincia;
    private Date fechaEntrada;
    private Date fechaSalida;
    private String alojamiento;
    private String extras;
    
    public Reserva() {
        
    }

    public Reserva(String nombre, String apellidos, String dni, String ss, String telefono, String email, String provincia, Date fechaEntrada, Date fechaSalida, String alojamiento, String extras) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.ss = ss;
        this.telefono = telefono;
        this.email = email;
        this.provincia = provincia;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.alojamiento = alojamiento;
        this.extras = extras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(String alojamiento) {
        this.alojamiento = alojamiento;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "Reserva{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", ss=" + ss + ", telefono=" + telefono + ", email=" + email + ", provincia=" + provincia + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", alojamiento=" + alojamiento + ", extras=" + extras + '}';
    }
    
    
    
}
