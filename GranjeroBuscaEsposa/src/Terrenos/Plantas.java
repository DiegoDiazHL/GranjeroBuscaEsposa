package Terrenos;


public class Plantas extends Huerta {
    Integer recurso;
    Integer regado;

    public Plantas(Integer tamano, Integer capacidad, Integer precio, boolean labrado, String tipo, Integer recurso, Integer regado) {
        super(tamano, capacidad, precio, labrado, tipo);
        this.recurso = recurso;
        this.regado = regado;
    }


    public Integer getRecurso() {
        return recurso;
    }

    public void setRecurso(Integer recurso) {
        this.recurso = recurso;
    }

    public Integer getRegado() {
        return regado;
    }

    public void setRegado(Integer regado) {
        this.regado = regado;
    }

    @Override
    public String toString() {
        return super.toString() + "Plantas{" +
                "recurso=" + recurso +
                ", regado=" + regado +
                '}';
    }
}
