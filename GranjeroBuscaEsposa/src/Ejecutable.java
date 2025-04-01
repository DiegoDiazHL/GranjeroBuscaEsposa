import Ficheros.CargarPartida;
import Ficheros.NuevaPartida;
import Terrenos.MateriaPrima;
import Terrenos.Terreno;
import Usuario_Vehiculo.Usuario;
import Usuario_Vehiculo.Vehiculo;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Ejecutable {
    // Primer Menú Inicial
    public static void main(String[] args) {
        ArrayList<MateriaPrima> p = new ArrayList<>();
        ArrayList<Vehiculo> ve = new ArrayList<>();
        ArrayList<Terreno> ter = new ArrayList<>();
        Terreno t = new Terreno("granja", 2, 10, 1000, FALSE);
        Vehiculo v1 = new Vehiculo("Tractor", "Labrar", 1000, 1);
        Vehiculo v2 = new Vehiculo("Tractor", "Labrar", 2000, 2);
        Vehiculo v3 = new Vehiculo("Tractor", "Labrar", 3000, 3);
        Vehiculo v4 = new Vehiculo("Limpiadora", "Limpiar", 1000, 1);
        Vehiculo v5 = new Vehiculo("Limpiadora", "Limpiar", 2000, 2);
        Vehiculo v6 = new Vehiculo("Limpiadora", "Limpiar", 3000, 3);
        ve.add(v1);
        ve.add(v2);
        ve.add(v3);
        ve.add(v4);
        ve.add(v5);
        ve.add(v6);
        MateriaPrima mp1 = new MateriaPrima("Vacas", 2, TRUE, 5);
        MateriaPrima mp2 = new MateriaPrima("Gallinas", 2, TRUE, 3);
        MateriaPrima mp3 = new MateriaPrima("Patatas", 3, TRUE, 2);
        MateriaPrima mp4 = new MateriaPrima("Tomates", 4, TRUE, 6);
        p.add(mp3);
        p.add(mp4);
        p.add(mp1);
        p.add(mp2);
        Usuario nuevoUsuario = null;
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar el menú
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Nueva Partida");
            System.out.println("2. Cargar Partida");
            System.out.println("3. Salir");

            opcion = Integer.parseInt(sc.nextLine());
            // sc.nextLine();
            // Evaluar opción con switch
            switch (opcion) {
                case 1:
                    System.out.println("Selecciona un nombre para crear tu partida");
                    NuevaPartida.crearPartida();
                    nuevoUsuario = Toolbox.crearUsuario();
                    System.out.println("Bienvenido " + nuevoUsuario.getNombre() + " aqui comienza tu aventura, la tía Paqui estaría orgullosa");
                    int option = 0;
                    while (option != 6) {
                        System.out.println("1. Trabajar terreno");
                        System.out.println("2. Vender recursos");
                        System.out.println("3. Comprar vehiculo");
                        System.out.println("4. Usar vehiculo");
                        System.out.println("5. Tirar ruleta");
                        System.out.println("6. Salir");
                        option = Integer.parseInt(sc.nextLine());
                        switch (option) {
                            case 1:
                                Toolbox.trabajar(t, nuevoUsuario);
                                break;
                            case 2:
                                Toolbox.vender(nuevoUsuario, p);
                                break;
                            case 3:
                                Toolbox.comprarVehiculo(nuevoUsuario, ve);
                                break;
                            case 4:
                                Toolbox.usarVehiculo(nuevoUsuario, t);
                                break;
                            case 5:
                                Toolbox.tirarRuleta(nuevoUsuario);
                                break;
                            case 6:
                                break;
                        }
                    }
                case 2:
                    System.out.println("Selecciona tu partida guardada");
                    CargarPartida.cargarPartida();
                    break;
                case 3:
                    System.out.println("Saliendo del programa");
                    break;
            }
        } while (opcion != 3);

        sc.close();
    }
}