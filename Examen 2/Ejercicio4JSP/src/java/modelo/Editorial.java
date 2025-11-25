package modelo;

public class Editorial {

    private int idEditorial;
    private String name;

    public Editorial() {

    }

    public Editorial(int idEditorial, String name) {
        this.idEditorial = idEditorial;
        this.name = name;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
