package vista;

import excepciones.pHException;
import java.util.Scanner;
import modelo.Alimento;


public class Main {
    
    public static void main(String[] args) {
        System.out.println("Ejercicio del PH");
        Scanner leer = new Scanner(System.in);
        
        String nombre;
        String phStr;
        double ph = 0;
        String awStr;
        double aw = 0;
        
        do {
            System.out.println("Introduce el nombre del alimento:");
            nombre = leer.nextLine();
            if(nombre.isEmpty()) {
                System.out.println("Campo vacio, introduzca un nombre:");
            }
        } while(nombre.isEmpty());
        
        
        boolean correcto = true;
        do{
            System.out.println("Introduce el pH del alimento (0-14):");
            correcto = true;
            phStr = leer.nextLine();
            if(phStr.isEmpty()) {
                correcto = false;
            }
            try {
                ph = Double.parseDouble(phStr);
                if (ph <= 0 || ph > 14) {
                    System.out.println("Error, el pH debe ser entre 0 y 14");
                    correcto = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, el pH debe ser un valor numerico entre 0 y 14");
                correcto = false;
            }
        } while(!correcto);
        
        
        correcto = true;
        do {
            System.out.println("Introduce la aW del alimento (0-1):");
            correcto = true;
            awStr = leer.nextLine();
            if(awStr.isEmpty()) {
                correcto = false;
            }
            try{
                aw = Double.parseDouble(awStr);
                if (aw <= 0 || aw > 1) {
                    System.out.println("Error, la AW debe ir entre 0 y 1.");
                    correcto = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, la AW debe ser numerico e ir entre 0 y 1.");
                correcto = false;
            }
        } while(!correcto);
        
        Alimento alimento = new Alimento(nombre, ph, aw);
        alimento.mostrarAlimento();
        if (ph < 7) {
            System.out.println("Es acido");
        } else if (ph > 7) {
            System.out.println("Es alcalino");
        } else {
            System.out.println("Es neutro");
        }
        
    }
    
}
