import Ficheros.CargarPartida;
import Ficheros.NuevaPartida;

import java.util.Scanner;

public class Ejecutable {
    // Primer Menú Inicial
    public static void main(String[] args) {
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
}
