package Usuario_Vehiculo;

public class Usuario {
    private String nombre;
    private int monedero = 100;
    private Vehiculo vehiculo;
    private int experiencia = 0;
    private int nivel = 1;
    private int resistencia = 100;

    public Usuario(String nombre, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.vehiculo = vehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMonedero() {
        return monedero;
    }

    public void setMonedero(int monedero) {
        this.monedero = monedero;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public String toCSV(){
        return this.nombre + "," + this.monedero + "," + this.vehiculo + "," + this.nivel + "," + this.resistencia;
    }


    public void ganarExperiencia(int puntos) {
        if (nivel < 100) {
            this.experiencia += puntos;
            subirNivel();
        }
    }

    private void subirNivel() {
        while (this.experiencia >= 100 && this.nivel < 10) { //Establecer si la experiencia ganada es igual o superior a 100 y el nivel sea inferior a 10 le suba un nivel y establezca la exp en 0.
            this.experiencia -= 100; // Asi no pierdes la exp restante ej si tienes 140 te deja los 40 sobrantes
            this.nivel += 1;
            this.resistencia += 100;
        }
        if (this.nivel >= 10) {
            this.experiencia = 100; // establece el maximo.
        }
    }

    public void dormir() {
        this.resistencia = getResistenciaMaxima(); // Restablece la resistencia al máximo actual
    }

    public int getResistenciaMaxima() {
        return this.nivel * 10; // Cada nivel aumenta el máximo en 10 se puede variar según veamos
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", monedero=" + monedero +
                ", vehiculo=" + vehiculo +
                ", experiencia=" + experiencia +
                ", nivel=" + nivel +
                ", resistencia=" + resistencia +
                '}';
    }
}
