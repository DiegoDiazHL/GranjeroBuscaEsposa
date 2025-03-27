package Terrenos;

public abstract class Terreno {
    private String tipo;
    private Integer tamano;
    private Integer capacidad;
    private Integer precio;

    public Terreno(Integer tamano, Integer capacidad, Integer precio, String tipo) {
        this.tamano = tamano;
        this.capacidad = capacidad;
        this.precio = precio;
        this.tipo = tipo;
    }

    public Integer getTamano() {
        return tamano;
    }

    public void setTamano(Integer tamano) {
        this.tamano = tamano;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

}
