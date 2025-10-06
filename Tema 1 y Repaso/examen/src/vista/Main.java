package vista;

import java.util.Scanner;
import modelo.Alimento;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Examen");
        Scanner leer = new Scanner(System.in);
        boolean correcto = true;
        String nombre;
        String proteinasStr;
        String lipidosStr;
        String hidratosStr;
        double proteinas = 0;
        double lipidos = 0;
        double hidratos = 0;
        String minerales;
        String vitaminas;
        String origenAn;
        
        do {
            System.out.print("Denominacion de un alimento: ");
            correcto = true;
            nombre = leer.nextLine();
            if (nombre.isEmpty()) {
                correcto = false;
                System.out.println("Campo nombre vacio, porfavor introduzcalo de nuevo.");
            }
        } while(!correcto);
        
        
        do {
            

        do {
            System.out.print("Contenido en % de proteinas: ");
            correcto = true;
            proteinasStr = leer.nextLine();
            if (proteinasStr.isEmpty()) {
                correcto = false;
                System.out.println("Campo proteinas vacio, porfavor introduzcalo de nuevo.");
            }
            try {
                proteinas = Double.parseDouble(proteinasStr);
            } catch (NumberFormatException e) {
                System.out.println("Error, el porcentaje de proteinas debe ir entre 0 y 100.");
                correcto = false;
            }
            if (proteinas > 100 || proteinas < 0) {
                correcto = false;
                System.out.println("Error, el porcentaje de proteinas debe ir entre 0 y 100.");
            }
        } while(!correcto);
        
        do {
            System.out.print("Contenido en % de lipidos: ");
            correcto = true;
            lipidosStr = leer.nextLine();
            if (lipidosStr.isEmpty()) {
                correcto = false;
                System.out.println("Campo lipidos vacio, porfavor introduzcalo de nuevo.");
            }
            try {
                lipidos = Double.parseDouble(lipidosStr);
            } catch (NumberFormatException e) {
                System.out.println("Error, el porcentaje de lipidos debe ir entre 0 y 100.");
                correcto = false;
            }
            if (lipidos > 100 || lipidos < 0) {
                correcto = false;
                System.out.println("Error, el porcentaje de lipidos debe ir entre 0 y 100.");
            }
        } while(!correcto);
        
        do {
            System.out.print("Contenido en % de hidratos: ");
            correcto = true;
            hidratosStr = leer.nextLine();
            if (hidratosStr.isEmpty()) {
                correcto = false;
                System.out.println("Campo hidratos vacio, porfavor introduzcalo de nuevo.");
            }
            try {
                hidratos = Double.parseDouble(hidratosStr);
            } catch (NumberFormatException e) {
                System.out.println("Error, el porcentaje de hidratos debe ir entre 0 y 100.");
                correcto = false;
            }
            if (hidratos > 100 || hidratos < 0) {
                correcto = false;
                System.out.println("Error, el porcentaje de hidratos debe ir entre 0 y 100.");
            }
        } while(!correcto);
        
        if ((proteinas + lipidos + hidratos) > 100) {
            System.out.println("Error, la suma de los tres porcentajes no puede ser mayor de 100.");
        }
                } while((proteinas + lipidos + hidratos) > 100);
        
        
        do {
            System.out.println("A - Alto /// M - Medio /// B - Bajo");
            System.out.print("Contenido en minerales: ");
            correcto = false;
            minerales = leer.next();
            if (minerales.equalsIgnoreCase("a")) {
                correcto = true;
            } else if (minerales.equalsIgnoreCase("m")) {
                correcto = true;
            } else if (minerales.equalsIgnoreCase("b")) {
                correcto = true;
            } else {
                System.out.println("Error, profavor introduzca un valor correcto.");
            }
            
            minerales = minerales.toUpperCase();
        } while (!correcto);
        
        do {
            System.out.print("Contenido en vitaminas: ");
            correcto = false;
            vitaminas = leer.next();
            if (vitaminas.equalsIgnoreCase("a")) {
                correcto = true;
            } else if (vitaminas.equalsIgnoreCase("m")) {
                correcto = true;
            } else if (vitaminas.equalsIgnoreCase("b")) {
                correcto = true;
            } else {
                System.out.println("Error, profavor introduzca un valor correcto.");
            }
            
            vitaminas = vitaminas.toUpperCase();
        } while (!correcto);
        
        do {
            System.out.print("¿Es de origen animal?: (S/N): ");
            correcto = false;
            origenAn = leer.next();
            if (origenAn.equalsIgnoreCase("s")) {
                correcto = true;
            } else if (origenAn.equalsIgnoreCase("n")) {
                correcto = true;
            } else {
                System.out.println("Error, profavor introduzca un valor correcto.");
            }
            
            origenAn = origenAn.toUpperCase();
        } while (!correcto);
        
        
        
        Alimento alimento = new Alimento(nombre, lipidos, hidratos, proteinas, origenAn, minerales, vitaminas);
        
        alimento.mostrarAlimento(nombre, lipidos, hidratos, proteinas, vitaminas, minerales, origenAn);
        System.out.println(alimento.esDietetico(lipidos, vitaminas));
        System.out.println(alimento.recomendable(proteinas, lipidos, hidratos));
        System.out.println(alimento.contEnergetico(proteinas, lipidos, hidratos));
        
    }
    
}
