import Ficheros.*;
import Ficheros.NuevaPartida;
import Terrenos.MateriaPrima;
import Ficheros.GuardarPartida;
import Terrenos.Terreno;
import Usuario_Vehiculo.Usuario;
import Usuario_Vehiculo.Vehiculo;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Ejecutable {

    public static void main(String[] args) {
        ArrayList<MateriaPrima> p = inicializarMateriaPrima();
        ArrayList<Vehiculo> ve = inicializarVehiculos();
        ArrayList<Terreno> ter = new ArrayList<>();
        Terreno t2 = new Terreno("huerta", 2, 10, 1000, FALSE,0);
        Terreno t1 = new Terreno("granja", 2, 10, 1000, FALSE,0);
        ter.add(t2);
        ter.add(t1);
        Usuario nuevoUsuario = new Usuario("Invitado", null);
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    nuevoUsuario = iniciarNuevaPartida(sc);
                    ejecutarMenuJuego(nuevoUsuario, ter, ve, p, sc);
                    break;
                case 2:
                    cargarPartidaExistente(nuevoUsuario, sc,ter);
                    ejecutarMenuJuego(nuevoUsuario, ter, ve, p, sc);
                    break;
                case 3:
                    System.out.println("Saliendo del programa");
                    break;
            }
        } while (opcion != 3);

        sc.close();
    }

    private static ArrayList<MateriaPrima> inicializarMateriaPrima() {
        ArrayList<MateriaPrima> p = new ArrayList<>();
        p.add(new MateriaPrima("Vacas", 2, TRUE, 5));
        p.add(new MateriaPrima("Gallinas", 2, TRUE, 3));
        p.add(new MateriaPrima("Patatas", 3, TRUE, 2));
        p.add(new MateriaPrima("Tomates", 4, TRUE, 6));
        return p;
    }

    private static ArrayList<Vehiculo> inicializarVehiculos() {
        ArrayList<Vehiculo> ve = new ArrayList<>();
        ve.add(new Vehiculo("Tractor", "Labrar", 1000, 1));
        ve.add(new Vehiculo("Tractor", "Labrar", 2000, 2));
        ve.add(new Vehiculo("Tractor", "Labrar", 3000, 3));
        ve.add(new Vehiculo("Limpiadora", "Limpiar", 1000, 1));
        ve.add(new Vehiculo("Limpiadora", "Limpiar", 2000, 2));
        ve.add(new Vehiculo("Limpiadora", "Limpiar", 3000, 3));
        return ve;
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Nueva Partida");
        System.out.println("2. Cargar Partida");
        System.out.println("3. Salir");
    }

    private static Usuario iniciarNuevaPartida(Scanner sc) {
        System.out.println("Selecciona un nombre para crear tu partida");
        NuevaPartida.crearPartida();
        Usuario nuevoUsuario = Toolbox.crearUsuario();
        System.out.println("Bienvenido " + nuevoUsuario.getNombre() + " aquí comienza tu aventura, la tía Paqui estaría orgullosa");
        return nuevoUsuario;
    }

    private static void cargarPartidaExistente(Usuario usuario, Scanner sc,ArrayList<Terreno> ter) {
        System.out.println("Selecciona tu partida guardada");
        CargarPartida.cargarPartida(usuario, sc, ter);
        System.out.println("Bienvenido de nuevo " + usuario.getNombre());
    }

    private static void ejecutarMenuJuego(Usuario usuario, ArrayList<Terreno> ter, ArrayList<Vehiculo> ve, ArrayList<MateriaPrima> p, Scanner sc) {
        int opcion;
        do {
            mostrarMenuJuego();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    Toolbox.trabajar(ter, usuario);
                    break;
                case 2:
                    Toolbox.vender(usuario, p , ter);
                    break;
                case 3:
                    Toolbox.comprarVehiculo(usuario, ve);
                    break;
                case 4:
                    Toolbox.usarVehiculo(usuario, ter);
                    break;
                case 5:
                    Toolbox.tirarRuleta(usuario);
                    break;
                case 6:
                    GuardarPartida.guardarPartida(usuario,ter);
                    break;
                case 7:
                    Toolbox.dormir(usuario);
                    break;
                case 8:
                    Toolbox.mejorarTerreno(ter, usuario);
                    break;
                case 9:
                    System.out.println("Saliendo del juego");
                    break;
            }
        } while (opcion != 9);
    }

    private static void mostrarMenuJuego() {
        System.out.println("\n=== MENÚ DE JUEGO ===");
        System.out.println("1. Trabajar terreno");
        System.out.println("2. Vender recursos");
        System.out.println("3. Comprar vehiculo");
        System.out.println("4. Usar vehiculo");
        System.out.println("5. Tirar ruleta");
        System.out.println("6. Guardar Partida");
        System.out.println("7. Dormir");
        System.out.println("8. Mejorar terreno");
        System.out.println("9. Salir");
    }
}