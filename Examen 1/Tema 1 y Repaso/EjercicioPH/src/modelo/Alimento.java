/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepciones.CVException;

/**
 *
 * @author alber
 */
public class Alimento {
    
    private String nombre;
    private double ph;
    private double aw;
    
    public Alimento() {
        
    }

    public Alimento(String nombre, double ph, double aw){
        setNombre(nombre);
        setPh(ph);
        setAw(aw);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getAw() {
        return aw;
    }

    public void setAw(double aw) {
        this.aw = aw;
    }

    @Override
    public String toString() {
        return "Alimento{" + "nombre=" + nombre + ", ph=" + ph + ", aw=" + aw + '}';
    }
    
    
    
    public boolean esAcido() {
        return ph < 7;
    }

    public boolean esAlcalino() {
        return ph > 7;
    }

    public boolean esNeutro() {
        return ph == 7;
    }
    
    public String condicionesDeConservacion() {
        if (esAcido()) {
            if (ph < 4.6) {
                return "Conservacion natural o refrigeracion";
            } else { // 4.6 <= pH < 7
                return "Refrigeracion o congelacion";
            }
        } else if (esNeutro() || (ph >= 4.6 && ph < 7)) {
            return "Refrigeracion o congelacion";
        } else { // alcalino
            return "Atmosfera modificada o secado";
        }
    }
    
    public boolean esPerecedero() {
        String conservacion = condicionesDeConservacion().toLowerCase();
        return conservacion.contains("refrigeracion") || conservacion.contains("congelacion");
    }
    
    public String vidaUtil() {
        if (aw >= 0.85 && aw <= 1) {
            return "El alimento tiene una vida util corta";
        } else if (aw >= 0.6 && aw < 0.85) {
            return "El alimento tiene una vida util media";
        } else { // 0 <= aw < 0.6
            return "El alimento tiene una vida util alta";
        }
    }
     
    public void mostrarAlimento() {
        System.out.println("==== Información del alimento ====");
        System.out.println("Nombre: " + nombre);
        System.out.println("Analisis:");
        System.out.println("        ph: " + ph);
        System.out.println("        aw: " + aw);
        System.out.println("Condiciones de conservacion recomendadas: " + condicionesDeConservacion());
        System.out.println("Es perecedero: " + (esPerecedero() ? "Si" : "No"));
        System.out.println(vidaUtil());
    }

}
