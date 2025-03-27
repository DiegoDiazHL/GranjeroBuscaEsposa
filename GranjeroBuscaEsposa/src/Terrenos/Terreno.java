package Terrenos;

public class Terreno {
    private String tipo;
    private Integer tamano;
    private Integer capacidad;
    private Integer precio;
    private boolean trabajado;

    public Terreno(String tipo, Integer tamano, Integer capacidad, Integer precio, boolean trabajado) {
        this.tipo = tipo;
        this.tamano = tamano;
        this.capacidad = capacidad;
        this.precio = precio;
        this.trabajado = trabajado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public boolean isTrabajado() {
        return trabajado;
    }

    public void setTrabajado(boolean trabajado) {
        this.trabajado = trabajado;
    }
    public String toCSV(){
        return this.tipo + "," + this.tamano + "," + this.capacidad + "," + this.precio + "," + this.trabajado ;
    }
    @Override
    public String toString() {
        return "Terreno{" +
                "tipo='" + tipo + '\'' +
                ", tamano=" + tamano +
                ", capacidad=" + capacidad +
                ", precio=" + precio +
                ", trabajado=" + trabajado +
                '}';
    }
}
