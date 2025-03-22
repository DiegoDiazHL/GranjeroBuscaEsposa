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

                opcion = sc.nextInt();

                // Evaluar opción con switch
                switch (opcion) {
                    case 1:
                        System.out.println("Selecciona un Slot para crear tu partida");
                        break;
                    case 2:
                        System.out.println("Selecciona tu partida guardada");
                        break;
                    case 3:
                        System.out.println("Saliendo del programa");
                        break;
                    }
            } while (opcion != 4);  // Se repite hasta que el usuario elija salir

            sc.close();  // Cerrar el Scanner
        }
    }

