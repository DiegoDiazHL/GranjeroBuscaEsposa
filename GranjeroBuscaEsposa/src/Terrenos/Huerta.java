package Terrenos;

public class Huerta extends Terreno{
    private boolean labrado;

    public Huerta(Integer tamano, Integer capacidad, Integer precio, boolean labrado, String tipo) {
        super(tamano, capacidad, precio, tipo);
        this.labrado = labrado;
    }

    public boolean isLabrado() {
        return labrado;
    }

    public void setLabrado(boolean labrado) {
        this.labrado = labrado;
    }

    @Override
    public String toString() {
        return "Huerta{" +
                "labrado=" + labrado +
                '}';
    }
}
