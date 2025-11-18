package modelo;

public class ActividadExtraescolar {
    
    private String nombreActividad;
    private String lugar;
    private String fecha;
    private String hora;
    private String destinadoA;
    private String tipoAct;
    private String curso;
    private String profesor;
    private String observaciones;
    private String departamento;

    public ActividadExtraescolar(String nombreActividad, String lugar, String fecha, String hora, String destinadoA, String tipoAct, String curso, String profesor, String observaciones, String departamento) {
        this.nombreActividad = nombreActividad;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.destinadoA = destinadoA;
        this.tipoAct = tipoAct;
        this.curso = curso;
        this.profesor = profesor;
        this.observaciones = observaciones;
        this.departamento = departamento;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDestinadoA() {
        return destinadoA;
    }

    public void setDestinadoA(String destinadoA) {
        this.destinadoA = destinadoA;
    }

    public String getTipoAct() {
        return tipoAct;
    }

    public void setTipoAct(String tipoAct) {
        this.tipoAct = tipoAct;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    
}
