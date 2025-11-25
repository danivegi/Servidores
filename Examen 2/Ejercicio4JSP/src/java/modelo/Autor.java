package modelo;

public class Autor {

    private int idAutor;
    private String nombre, apellido;
    private int anioNac;

    public Autor() {

    }

    public Autor(int idAutor, String nombre, String apellido, int anioNac) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioNac = anioNac;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAnioNac() {
        return anioNac;
    }

    public void setAnioNac(int anioNac) {
        this.anioNac = anioNac;
    }

}
