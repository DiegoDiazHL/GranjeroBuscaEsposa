package Huerta;

import java.util.Random;

public class Planta {
    private String nombre;
    private int riego;
    private int tamaño;
    private double precio;
    private int cantidadHortalizas;

    public Planta(String nombre, int riego, int tamaño, double precio) {
        this.nombre = nombre;
        this.riego = riego;
        this.tamaño = tamaño;
        this.precio = precio;
        this.cantidadHortalizas = generarCantidadHortalizas();
    }

    private int generarCantidadHortalizas() {
        Random random = new Random();
        return random.nextInt(10) + 2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRiego() {
        return riego;
    }

    public void setRiego(int riego) {
        this.riego = riego;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadHortalizas() {
        return cantidadHortalizas;
    }

    public void setCantidadHortalizas(int cantidadHortalizas) {
        this.cantidadHortalizas = cantidadHortalizas;
    }

    public void crecer() {
        this.tamaño += 1;
        System.out.println("La planta " + nombre + " ha crecido. Tamaño actual: " + tamaño);
    }

    public boolean listaParaCosechar() {
        return this.tamaño >= 10;
    }

    @Override
    public String toString() {
        return "Planta{" +
                "nombre='" + nombre + '\'' +
                ", riego=" + riego +
                ", tamaño=" + tamaño +
                ", precio=" + precio +
                ", cantidadHortalizas=" + cantidadHortalizas +
                '}';
    }
}