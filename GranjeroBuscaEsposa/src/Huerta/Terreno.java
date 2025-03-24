package Huerta;

public class Terreno {
    private Planta[] hortalizas;

    public Terreno() {
        hortalizas = new Planta[10];
        hortalizas[0] = new Planta("Tomate", 5, 10, 2.5);
        hortalizas[1] = new Planta("Lechuga", 3, 8, 1.5);
        hortalizas[2] = new Planta("Zanahoria", 4, 12, 3.0);
        hortalizas[3] = new Planta("Pepino", 6, 15, 4.0);
        hortalizas[4] = new Planta("Pimiento", 2, 7, 1.0);
        hortalizas[5] = new Planta("Calabacín", 5, 9, 2.0);
        hortalizas[6] = new Planta("Berenjena", 3, 11, 2.8);
        hortalizas[7] = new Planta("Cebolla", 4, 13, 3.5);
        hortalizas[8] = new Planta("Ajo", 6, 14, 4.5);
        hortalizas[9] = new Planta("Patata", 2, 6, 1.2);
    }

    public int calcularTotalHortalizas() {
        int total = 0;
        for (Planta hortaliza : hortalizas) {
            total += hortaliza.getCantidadHortalizas();
        }
        return total;
    }

    public static void main(String[] args) {
        Terreno terreno = new Terreno();
        for (Planta hortaliza : terreno.hortalizas) {
            System.out.println(hortaliza);
        }
        System.out.println("Total de hortalizas: " + terreno.calcularTotalHortalizas());
    }
}