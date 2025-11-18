package modelo;


public class Alimento {
    
    private String nombre;
    private double lipidos;
    private double hidratos;
    private double proteinas;
    private String origenAn;
    private String contMin;
    private String contVit;
    
    public Alimento() {
        
    }

    public Alimento(String nombre, double lipidos, double hidratos, double proteinas, String origenAn, String contMin, String contVit) {
        this.nombre = nombre;
        this.lipidos = lipidos;
        this.hidratos = hidratos;
        this.proteinas = proteinas;
        this.origenAn = origenAn;
        this.contMin = contMin;
        this.contVit = contVit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLipidos() {
        return lipidos;
    }

    public void setLipidos(double lipidos) {
        this.lipidos = lipidos;
    }

    public double getHidratos() {
        return hidratos;
    }

    public void setHidratos(double hidratos) {
        this.hidratos = hidratos;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public String getOrigenAn() {
        return origenAn;
    }

    public void setOrigenAn(String origenAn) {
        this.origenAn = origenAn;
    }

    public String getContMin() {
        return contMin;
    }

    public void setContMin(String contMin) {
        this.contMin = contMin;
    }

    public String getContVit() {
        return contVit;
    }

    public void setContVit(String contVit) {
        this.contVit = contVit;
    }

    @Override
    public String toString() {
        return "Alimento{" + "nombre=" + nombre + ", lipidos=" + lipidos + ", hidratos=" + hidratos + ", proteinas=" + proteinas + ", origenAn=" + origenAn + ", contMin=" + contMin + ", contVit=" + contVit + '}';
    }

    public String esDietetico(double lipidos, String vitaminas) {
        if (lipidos > 20) {
            return "El alimento NO es dietetico.";
        }
        if (vitaminas.equalsIgnoreCase("b")) {
            return "El alimento NO es dietetico.";
        }
        return "El alimento SI es dietetico.";
    }

    public String recomendable(double proteinas, double lipidos, double hidratos) {
        if (proteinas < 10 || proteinas > 15) {
            return "No es recomendable para deportistas.";
        }
        if (lipidos < 30 || lipidos > 35) {
            return "No es recomendable para deportistas.";
        }
        if (hidratos < 55 || hidratos > 65) {
            return "No es recomendable para deportistas.";
        }
        return "Es recomendable para deportistas.";
    }

    public String contEnergetico(double proteinas, double lipidos, double hidratos) {
       double total = 0;
       proteinas = proteinas * 5.3;
       lipidos = lipidos * 9.4;
       hidratos = hidratos * 4.1;
       total = proteinas + lipidos + hidratos;
       return "Contenido energetico: " + total + " Kcal/gr";
    }

    public void mostrarAlimento(String nombre, double lipidos, double hidratos, double proteinas, String vitaminas, String minerales, String origenAn) {
        System.out.println("Nombre: " + nombre);
        System.out.println("Analisis:");
        System.out.println("        Lipidos: " + lipidos + " %.");
        System.out.println("        Hidratos de carbono: " + hidratos + " %.");
        System.out.println("        Proteinas: " + proteinas + " %.");
        if (vitaminas.equalsIgnoreCase("a")) {
            vitaminas = "alto";
        } else if (vitaminas.equalsIgnoreCase("m")) {
            vitaminas = "medio";
        } else if (vitaminas.equalsIgnoreCase("b")) {
            vitaminas = "bajo";
        }
        if (minerales.equalsIgnoreCase("a")) {
            minerales = "alto";
        } else if (minerales.equalsIgnoreCase("m")) {
            minerales = "medio";
        } else if (minerales.equalsIgnoreCase("b")) {
            minerales = "bajo";
        }
        System.out.println("Contenido en vitaminas: " + vitaminas);
        System.out.println("Contenido en minerales: " + minerales);
        if(origenAn.equalsIgnoreCase("s")) {
            origenAn = "Es de origen animal.";
        } else if(origenAn.equalsIgnoreCase("n")) {
            origenAn = "NO es de origen animal.";
        }
        System.out.println(origenAn);
    }
    
    
    
}
