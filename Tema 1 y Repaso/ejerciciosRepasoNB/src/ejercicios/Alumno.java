package ejercicios;
import excepciones.CamposVaciosException;
import excepciones.MatriculaException;
     
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alber
 */
public class Alumno {
    
    private String nombre;
    private String matricula;
    private double nota1;
    private double nota2;
    
    public Alumno(){
        
    }

    public Alumno(String nombre, String matricula) throws CamposVaciosException, MatriculaException{
        setNombre(nombre);
        setMatricula(matricula);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws CamposVaciosException{
        
        if(nombre.length()<=0) {
            throw new CamposVaciosException("Error, el campo no debe estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws CamposVaciosException, MatriculaException{
        
        if(matricula.length() <= 0){
            throw new CamposVaciosException("Error, el campo no debe estar vacío.");
        }
        
        for (int x = 0; x < matricula.length(); x++) {
            char c = matricula.charAt(x);
            if (!Character.isDigit(c)) {
                throw new MatriculaException("Error, la matrícula debe ser numérica.");
            }
        }
        this.matricula = matricula;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", matricula=" + matricula + ", nota1=" + nota1 + ", nota2=" + nota2 + '}';
    }
    
    public void ponNota(double nota1, double nota2){
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
    
    public void muestraAlumno(){
        System.out.println("Nombre del alumno: " + nombre);
        System.out.println("Matricula del alumno: " + matricula);
        System.out.println("Primera nota: " + nota1);
        System.out.println("Segunda nota: " + nota2);
        double notaMedia = (nota1 + nota2) / 2;
        System.out.println("La nota media es: " + notaMedia);
    }
    
}
