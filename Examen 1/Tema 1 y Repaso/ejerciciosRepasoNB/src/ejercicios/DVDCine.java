package ejercicios;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alber
 */
public class DVDCine {
    
    private String titulo;
    private String director;
    private String actores;
    private String genero;
    private String resumen;
    private int duracion ;
    
    public DVDCine() {
        
    }

    public DVDCine(String titulo, String director, String actores, String genero, String resumen, int duracion) {
        this.titulo = titulo;
        this.director = director;
        this.actores = actores;
        this.genero = genero;
        this.resumen = resumen;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "DVDCine{" + "titulo=" + titulo + ", director=" + director + ", actores=" + actores + ", genero=" + genero + ", resumen=" + resumen + ", duracion=" + duracion + '}';
    }
    
    public void muestraTodo(){
        System.out.println("Titulo de la pelicula: ");
        System.out.println(titulo.toUpperCase());
        System.out.println("Actores principales: " + actores);
        System.out.println("Director: " + director);
        System.out.println("Genero principal: " + genero);
        System.out.println("Resumen: " + resumen);
        esThriller();
        
    }
 
    
    
    public void esThriller() {
        if (genero.equalsIgnoreCase("thriller")) {
            System.out.println("Es Thriller");
        } else {
            System.out.println("NO es Thriller");
        }
    }
    
    public String muestraDuracion() {
        String cadena = duracion + " min";
        return cadena;
    }
    
    
}
