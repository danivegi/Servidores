
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;


public class ActividadExtraescolar implements Comparable<ActividadExtraescolar>{
    
    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;
    private String lugar;
    private String destinatario;
    private String[] tipoActividad;
    private String curso;
    private String responsable;
    private String observaciones;
    private String DptoOrganizador;

    public ActividadExtraescolar(String nombre, LocalDate fecha, LocalTime hora, String lugar, String destinatario, String[] tipoActividad, String curso, String responsable, String observaciones, String DptoOrganizador) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.destinatario = destinatario;
        this.tipoActividad = tipoActividad;
        this.curso = curso;
        this.responsable = responsable;
        this.observaciones = observaciones;
        this.DptoOrganizador = DptoOrganizador;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getLugar() {
        return lugar;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String[] getTipoActividad() {
        return tipoActividad;
    }

    public String getCurso() {
        return curso;
    }

    public String getResponsable() {
        return responsable;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setTipoActividad(String[] tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDptoOrganizador() {
        return DptoOrganizador;
    }

    public void setDptoOrganizador(String DptoOrganizador) {
        this.DptoOrganizador = DptoOrganizador;
    }

    @Override
    public String toString() {
        return "ActividadExtraescolar{" + "nombre=" + nombre + ", fecha=" + fecha + ", hora=" + hora + ", lugar=" + lugar + ", destinatario=" + destinatario + ", tipoActividad=" + tipoActividad + ", curso=" + curso + ", responsable=" + responsable + ", observaciones=" + observaciones + ", DptoOrganizador=" + DptoOrganizador + '}';
    }

    @Override
    public int compareTo(ActividadExtraescolar o) {
       int resultado = this.fecha.compareTo(fecha);
       return resultado;
    }
    
    

    
    
    
    
}
