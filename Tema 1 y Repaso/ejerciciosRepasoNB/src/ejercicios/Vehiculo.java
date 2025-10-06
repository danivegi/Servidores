package ejercicios;

public class Vehiculo {
    
    private String modelo;
    private double potenica;
    private boolean cRuedas;
    
    public Vehiculo(){
        
    }

    public Vehiculo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPotenica() {
        return potenica;
    }

    public void setPotenica(double potenica) {
        this.potenica = potenica;
    }

    public boolean iscRuedas() {
        return cRuedas;
    }

    public void setcRuedas(boolean cRuedas) {
        this.cRuedas = cRuedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "modelo=" + modelo + ", potenica=" + potenica + ", cRuedas=" + cRuedas + '}';
    }
    
    
    
}
