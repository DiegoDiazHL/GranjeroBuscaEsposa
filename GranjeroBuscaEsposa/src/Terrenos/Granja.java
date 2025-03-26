package Terrenos;

public class Granja extends Terreno{
    private boolean limpio;

    public Granja(Integer tamano, Integer capacidad, Integer precio, String tipo, boolean limpio) {
        super(tamano, capacidad, precio, tipo);
        this.limpio = limpio;
    }

    public boolean isLimpio() {
        return limpio;
    }

    public void setLimpio(boolean limpio) {
        this.limpio = limpio;
    }

    @Override
    public String toString() {
        return super.toString() + "Granja{" +
                "limpio=" + limpio +
                '}';
    }
}
