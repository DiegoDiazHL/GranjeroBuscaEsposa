package Usuario_Vehiculo;

public class Vehiculo {
    private String nombre;
    private String funcion;
    private int precio;
    private int categoria;

    public Vehiculo(String nombre, String funcion, int precio, int categoria) {
        this.nombre = nombre;
        this.funcion = funcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Usuario_Vehiculo.Vehiculo{" +
                "nombre='" + nombre + '\'' +
                ", funcion='" + funcion + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                '}';
    }
}
