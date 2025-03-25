package Terrenos;

public class Animal extends Granja{
        String tipo;
        Integer recurso;
        Integer comida;

    public Animal(Integer tamano, Integer capacidad, Integer precio, String tipo, boolean limpio) {
        super(tamano, capacidad, precio, tipo, limpio);
        this.tipo = tipo;
        this.recurso = recurso;
        this.comida = comida;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getRecurso() {
        return recurso;
    }

    public void setRecurso(Integer recurso) {
        this.recurso = recurso;
    }

    public Integer getComida() {
        return comida;
    }

    public void setComida(Integer comida) {
        this.comida = comida;
    }

    @Override
    public String toString() {
        return  super.toString() + "Animal{" +
                "tipo='" + tipo + '\'' +
                ", recurso=" + recurso +
                ", comida=" + comida +
                '}';
    }
}
