import Ficheros.CargarPartida;
import Ficheros.NuevaPartida;
import Terrenos.*;
import Usuario_Vehiculo.Usuario;
import Usuario_Vehiculo.Vehiculo;

import java.util.Scanner;

import static java.lang.Boolean.FALSE;

public class Ejecutable {
    // Primer Menú Inicial
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Tractor","Labrar",1000,1);
        Vehiculo v0 = new Vehiculo(null,null,0,0);
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar el menú
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Nueva Partida");
            System.out.println("2. Cargar Partida");
            System.out.println("3. Salir");

            opcion = Integer.parseInt(sc.nextLine());
//            sc.nextLine();
            // Evaluar opción con switch
            switch (opcion) {
                case 1:
                    System.out.println("Selecciona un nombre para crear tu partida");
                    NuevaPartida.crearPartida();
                    break;
                case 2:
                    System.out.println("Selecciona tu partida guardada");
                    CargarPartida.cargarPartida();
                    break;
                case 3:
                    System.out.println("Saliendo del programa");
                    break;
            }
        } while (opcion != 3);  // Se repite hasta que el usuario elija salir

        sc.close();  // Cerrar el Scanner
    }
    public void labrar(Plantas plantas){
        Scanner sc = new Scanner(System.in);
        if(plantas.isLabrado() == FALSE){
            System.out.println("¿Quieres labrar la tierra? Si/No");
            String a = sc.nextLine();
            if(a.equalsIgnoreCase("si")){

            }
        }
    }
    public void crearUsuario(){
        Scanner sc = new Scanner(System.in);
        Vehiculo v0 = new Vehiculo(null,null,0,0);

        System.out.println("Nombre de usuario");
        String a = sc.nextLine();
        Usuario u1 = new Usuario(a,v0);
    }

}
