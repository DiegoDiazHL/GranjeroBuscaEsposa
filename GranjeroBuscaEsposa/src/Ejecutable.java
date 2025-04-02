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
        Terreno granja = new Terreno("granja", 2, 10, 1000, FALSE);
        Terreno huerta = new Terreno("huerta", 2, 10, 1000, FALSE);
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

            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Nueva Partida");
            System.out.println("2. Cargar Partida");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Selecciona un nombre para crear tu partida");
                        NuevaPartida.crearPartida();
                        nuevoUsuario = Toolbox.crearUsuario();
                        System.out.println("Bienvenido " + nuevoUsuario.getNombre() + ", aquí comienza tu aventura. La tía Paqui estaría orgullosa.");

                        int option;
                        do {
                            System.out.println("\n1. Trabajar terreno");
                            System.out.println("2. Usar vehículo");
                            System.out.println("3. Mercado");
                            System.out.println("4. Salir al menú principal");
                            System.out.print("Selecciona una opción: ");
                            option = Integer.parseInt(sc.nextLine());

                            switch (option) {
                                case 1:
                                    Toolbox.trabajar(ter, nuevoUsuario);
                                    break;
                                case 2:
                                    Toolbox.usarVehiculo(nuevoUsuario, ter, ve);
                                    break;
                                case 3:
                                    int opcionMercado;
                                    do {
                                        System.out.println("\nBienvenido al mercado, ¿qué quieres hacer?");
                                        System.out.println("1. Vender materia prima");
                                        System.out.println("2. Mejorar terreno");
                                        System.out.println("3. Comprar vehículo");
                                        System.out.println("4. Tirar ruleta");
                                        System.out.println("5. Salir del mercado");
                                        System.out.print("Selecciona una opción: ");
                                        opcionMercado = Integer.parseInt(sc.nextLine());

                                        switch (opcionMercado) {
                                            case 1:
                                                Toolbox.vender(nuevoUsuario, p);
                                                break;
                                            case 2:
                                                Toolbox.mejorarTerreno(nuevoUsuario, ter);
                                                break;
                                            case 3:
                                                Toolbox.comprarVehiculo(nuevoUsuario, ve);
                                                break;
                                            case 4:
                                                Toolbox.tirarRuleta(nuevoUsuario);
                                                break;
                                            case 5:
                                                System.out.println("Saliendo del mercado...");
                                                break;
                                            default:
                                                System.out.println("Opción no válida. Inténtalo de nuevo.");
                                        }
                                    } while (opcionMercado != 5);
                                    break;
                                case 4:
                                    System.out.println("Regresando al menú principal...");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                            }
                        } while (option != 4);
                        break;

                    case 2:
                        System.out.println("Selecciona tu partida guardada");
                        CargarPartida.cargarPartida();
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Debes ingresar un número.");
                opcion = 0;
            }

        } while (opcion != 3);

        sc.close();
    }
}


