package Huerta;

public class Huerta extends Terreno {
    private boolean labrado;

    public Huerta() {
        super();
        this.labrado = false;
    }

    public void labrar() {
        this.labrado = true;
        System.out.println("El terreno ha sido labrado.");
    }

    public void regar() {
        for (Planta hortaliza : hortalizas) {
            if (hortaliza != null) {
                hortaliza.setRiego(hortaliza.getRiego() + 1);
            }
        }
        System.out.println("Todas las plantas han sido regadas.");
    }

    public void cosechar() {
        double factorCalidad;
        if (labrado) {
            factorCalidad = 1.0;
        } else {
            factorCalidad = 0.5;
        }
        double totalDinero = 0;

        for (Planta hortaliza : hortalizas) {
            if (hortaliza != null) {
                totalDinero += hortaliza.getCantidadHortalizas() * hortaliza.getPrecio() * factorCalidad;
                hortaliza.setCantidadHortalizas(0);
            }
        }

        System.out.println("Has cosechado un total de " + calcularTotalHortalizas() + " hortalizas.");
        System.out.println("Has ganado un total de " + totalDinero + " monedas.");
        labrado = false;
    }

    public void mostrarEstado() {
        for (Planta hortaliza : hortalizas) {
            System.out.println(hortaliza);
        }
    }

    public static void main(String[] args) {
        Huerta huerta = new Huerta();
        huerta.labrar();
        huerta.regar();
        huerta.mostrarEstado();
        huerta.cosechar();
        huerta.mostrarEstado();
    }
}