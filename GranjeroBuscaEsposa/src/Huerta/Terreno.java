package Huerta;

import java.util.ArrayList;
import java.util.List;

public class Terreno {
    protected List<Planta> hortalizas;

    public Terreno() {
        hortalizas = new ArrayList<>();
        hortalizas.add(new Planta("Tomate", 5, 10, 2.5));
        hortalizas.add(new Planta("Lechuga", 3, 8, 1.5));
        hortalizas.add(new Planta("Zanahoria", 4, 12, 3.0));
        hortalizas.add(new Planta("Pepino", 6, 15, 4.0));
        hortalizas.add(new Planta("Pimiento", 2, 7, 1.0));
        hortalizas.add(new Planta("Calabacín", 5, 9, 2.0));
        hortalizas.add(new Planta("Berenjena", 3, 11, 2.8));
        hortalizas.add(new Planta("Cebolla", 4, 13, 3.5));
        hortalizas.add(new Planta("Ajo", 6, 14, 4.5));
        hortalizas.add(new Planta("Patata", 2, 6, 1.2));
    }

    public int calcularTotalHortalizas() {
        int total = 0;
        for (Planta hortaliza : hortalizas) {
            total += hortaliza.getCantidadHortalizas();
        }
        return total;
    }

    public void plantar(Planta nuevaPlanta) {
        hortalizas.add(nuevaPlanta);
        System.out.println("Planta " + nuevaPlanta.getNombre() + " plantada.");
    }

    public void eliminarPlanta(String nombre) {
        hortalizas.removeIf(hortaliza -> hortaliza.getNombre().equals(nombre));
        System.out.println("Planta " + nombre + " eliminada.");
    }

    public static void main(String[] args) {
        Terreno terreno = new Terreno();
        for (Planta hortaliza : terreno.hortalizas) {
            System.out.println(hortaliza);
        }
        System.out.println("Total de hortalizas: " + terreno.calcularTotalHortalizas());
    }
}