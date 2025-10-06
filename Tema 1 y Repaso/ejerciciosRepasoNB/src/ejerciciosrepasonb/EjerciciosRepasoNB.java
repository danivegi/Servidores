/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosrepasonb;

import ejercicios.Alumno;
import ejercicios.DVDCine;
import ejercicios.Vehiculo;
import excepciones.CamposVaciosException;
import excepciones.MatriculaException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alber
 */
public class EjerciciosRepasoNB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Ejercicios de repaso");
        //Ejercicio 1
        // Realizar un programa que muestre los números pares menores de 10.
        // Resultado de ejecutar el programa:
        // Números pares menor es de 10
        // 2 4 6 8
        /*System.out.println("Ejercicio 1:");
        System.out.println("Los numeros pares menores que 10 son:");
        for (int x = 1; x < 10; x++) {
            if (x % 2 == 0) {
                System.out.print(x + " ");
            }
        }
        System.out.println();
        System.out.println();
        */
        
        /*
        //Ejercicio 2
        System.out.println("Ejercicio 2:");
        // Realizar un programa que muestre todos los números primos menores de 15.
        // Resutado de ejecutar el programa:
        // Números primos menores de 15
        // 1 2 3 5 7 11 13 
        
        System.out.println("Numeros primos menores de 15:");
        boolean primo = true;
        for (int x = 1; x < 15; x++) {
            primo = true;
            for (int y = 2; y < x; y++) {
                if (x % y == 0) {
                    primo = false;
                    break;
                }
            }
            if (primo == true) {
                System.out.print(x + " ");
            }
            
        }
        System.out.println();
        System.out.println();
        */
        
        /*
        //Ejercicio 3
        System.out.println("Ejercicio 3:");
        // Realizar un programa que muestre todos los números enteros entre 100 y 150, que
        // sean divisibles entre 3 y 7, mostrar igualmente la suma de todos los números que
        // cumplan la condición anterior.
        // Resutado de ejecutar el programa:
        // Números divisibles por 3 y 7 entre 100 y 150
        // 105 126 147
        // La suma es: 378 
        
        System.out.println("Los numeros entre 100 y 150 divisibles por 3 y 7 son:");
        int suma = 0;
        for (int x = 100; x <= 150; x++) {
            if (x % 3 == 0 && x % 7 == 0){
                suma += x;
                System.out.print(x + " ");
            }
        }
        
        System.out.println();
        System.out.println("La suma de ellos es: " + suma);
        System.out.println();
        */
        
        //Ejercicio 4
        //System.out.println("Ejercicio 4:");
        // Escribe una clase que represente un pelicula DVD de nombre DVD-Cine con los
        // atributos necesarios para mostrar la ficha que se recoge en el apartado segundo.
        // Esta clase contará con un constructor que admite como argumentos todos los
        // atributos de la clase.
        /*Scanner leer = new Scanner(System.in);
        System.out.println("Introduce el titulo de la pelicula: ");
        String titulo = leer.nextLine();
        
        System.out.println("Introduce los actores de la pelicula: ");
        String actores = leer.nextLine();
        
        System.out.println("Introduce el director de la pelicula: ");
        String director = leer.nextLine();
        
        System.out.println("Introduce el genero de la pelicula: ");
        String genero = leer.nextLine();
        
        boolean valido;
        String duracionStr;
        do {
        System.out.println("Introduce la duracion en minutos de la pelicula: ");
        duracionStr = leer.nextLine();
        valido = true;
        for (int x = 0; x < duracionStr.length(); x++) {
            char c = duracionStr.charAt(x);
            if (!Character.isDigit(c)) {
                valido = false;
                System.out.println("Error: debes introducir solo numeros.");
                break;
            }
        }
        } while(!valido);
        int duracion = Integer.parseInt(duracionStr);
        
        System.out.println("Introduce el resumen de la pelicula: ");
        String resumen = leer.nextLine();
        
        DVDCine dvd=new DVDCine(titulo, director, actores, genero, resumen, duracion);
        System.out.println();
        dvd.muestraTodo();
        dvd.muestraDuracion();
    */
       
        //Ejercicio 5 
        /*System.out.println("Ejercicio 5");
        Scanner leer = new Scanner(System.in);
        
        String nombre = "";
        String matricula = "";
        double nota1 = 0;
        double nota2 = 0;
        boolean valido = false;
        do {
            try {
                System.out.println("Introduce el nombre del alumno:");
                nombre = leer.nextLine();
                if (nombre == null || nombre.trim().isEmpty()) {
                    throw new CamposVaciosException("❌ Error: el campo nombre no debe estar vacío.");
                }
                valido = true;
            } catch (CamposVaciosException ex) {
                System.out.println(ex.getMessage());
            }
        } while (!valido);

        // MATRÍCULA
        valido = false;
        do {
            try {
                System.out.println("Introduce la matrícula del alumno:");
                matricula = leer.nextLine();
                if (matricula == null || matricula.trim().isEmpty()) {
                    throw new CamposVaciosException("❌ Error: el campo matrícula no debe estar vacío.");
                }
                for (int i = 0; i < matricula.length(); i++) {
                    if (!Character.isDigit(matricula.charAt(i))) {
                        throw new MatriculaException("❌ Error: la matrícula debe ser numérica.");
                    }
                }
                valido = true;
            } catch (CamposVaciosException | MatriculaException ex) {
                System.out.println(ex.getMessage());
            }
        } while (!valido);

        // NOTA 1
        System.out.println("Introduce la primera nota del alumno:");
        nota1 = leer.nextDouble();

        // NOTA 2
        System.out.println("Introduce la segunda nota del alumno:");
        nota2 = leer.nextDouble();

        // Crear alumno y mostrar datos
        try {
            Alumno alum = new Alumno(nombre, matricula);
            alum.ponNota(nota1, nota2);
            alum.muestraAlumno();
        } catch (CamposVaciosException | MatriculaException ex) {
            System.out.println("❌ " + ex.getMessage());
        }*/
        
        //Ejercicio 6
        System.out.println("Ejercicio 6");
        Scanner leer = new Scanner(System.in);
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        
        while(true) {
            System.out.println("Introduce el modelo del vehículo (Fin para terminar): ");
            String modelo = leer.nextLine();
            
            if(modelo.equalsIgnoreCase("Fin")){
                break;
            }
            
            Vehiculo veh=new Vehiculo(modelo);
            
        }
        
    
                   }
}
