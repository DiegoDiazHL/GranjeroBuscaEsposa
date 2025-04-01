import Ficheros.CargarPartida;
import Ficheros.NuevaPartida;
import Terrenos.*;
import Usuario_Vehiculo.Usuario;
import Usuario_Vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.Random;
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
                    nuevoUsuario = crearUsuario();
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
                                trabajar(t, nuevoUsuario);
                                break;
                            case 2:
                                vender(nuevoUsuario, p);
                                break;
                            case 3:
                                comprarVehiculo(nuevoUsuario, ve);
                                break;
                            case 4:
                                usarVehiculo(nuevoUsuario, t);
                                break;
                            case 5:
                                tirarRuleta(nuevoUsuario);
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

    public static void trabajar(Terreno terreno, Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué tipo de terreno quieres trabajar, huerta o granja?");
        String a = sc.nextLine();
        if (terreno.getTipo().equals(a)) {
            if (!terreno.isTrabajado()) {
                System.out.println("¿Quieres trabajar? Si/No");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("si")) {
                    terreno.setTrabajado(TRUE);
                    usuario.setResistencia(usuario.getResistencia() - 50);
                    usuario.setExperiencia(usuario.getExperiencia() + 20);
                    System.out.println("Tu resistencia después de trabajar:" + usuario.getResistencia());
                    System.out.println("Tu experiencia actual es de:" + usuario.getExperiencia());
                } else {
                    System.out.println("Saliendo . . .");
                }
            } else {
                System.out.println("El terreno ya está trabajado");
            }
        } else {
            System.out.println("Error al elegir terreno para trabajar, elige entre granja o huerta");
        }
    }

    public static Usuario crearUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre de usuario");
        String a = sc.nextLine();
        return new Usuario(a, null);
    }

    public static void vender(Usuario usuario, ArrayList<MateriaPrima> p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quieres vender? Si/No");
        String a = sc.nextLine();
        if (a.equalsIgnoreCase("si")) {
            System.out.println("¿Que quieres vender?Vacas,Gallinas,Patatas,Tomates ");
            String b = sc.nextLine();
            for (MateriaPrima pe : p) {
                if (pe.isAlimentado() && pe.getRecurso() != 0) {
                    if (pe.getTipo().equalsIgnoreCase(b)) {
                        int precioVenta = (int) (pe.getRecurso() * (Math.random() * 4 + 2) * pe.getPrecio());
                        usuario.setMonedero((int) (precioVenta + usuario.getMonedero()));
                        pe.setAlimentado(FALSE);
                        pe.setRecurso(0);
                        System.out.println("Has vendido " + b + " por " + precioVenta + " monedas.");
                        break;
                    }
                }
            }
        }
    }

    public static void comprarVehiculo(Usuario usuario, ArrayList<Vehiculo> ve) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quieres comprar un vehiculo?Si/No");
        String a = sc.nextLine();
        if (a.equalsIgnoreCase("si")) {
            System.out.println("¿Qué función quieres que tenga, limpiar o labrar?");
            String b = sc.nextLine();
            if ((b.equalsIgnoreCase("limpiar"))) {
                System.out.println("Elige nivel de categoria que quieras comprar entre estas opciones: (1,2,3)");
                int c = Integer.parseInt(sc.nextLine());
                for (Vehiculo v : ve) {
                    if (v.getCategoria() == c) {
                        if (v.getFuncion().equalsIgnoreCase(b)) {
                            if (v.getPrecio() <= usuario.getMonedero()) {
                                usuario.setVehiculo(v);
                                usuario.setMonedero(usuario.getMonedero() - v.getPrecio());
                                System.out.println("¡Has comprado un vehículo de categoría " + c + " para " + b + "!");
                                System.out.println("Te quedan " + usuario.getMonedero() + " monedas.");
                                break;
                            } else {
                                System.out.println("No tienes suficiente dinero tu dinero actual es: " + usuario.getMonedero());
                                break;
                            }
                        }
                    }
                }
            } else if (b.equalsIgnoreCase("labrar")) {
                System.out.println("Elige nivel de categoria que quieras comprar entre estas opciones: (1,2,3)");
                int c = Integer.parseInt(sc.nextLine());
                for (Vehiculo v : ve) {
                    if (v.getCategoria() == c) {
                        if (v.getPrecio() <= usuario.getMonedero()) {
                            usuario.setVehiculo(v);
                            usuario.setMonedero(usuario.getMonedero() - v.getPrecio());
                            System.out.println("¡Has comprado un vehículo de categoría " + c + " para " + b + "!");
                            System.out.println("Te queda " + usuario.getMonedero() + " monedas.");
                        } else {
                            System.out.println("No tienes suficiente dinero tu dinero actual es: " + usuario.getMonedero());
                        }
                    }
                }
            }
        } else {
            System.out.println("Saliendo de la tienda ...");
        }
    }


    public static void usarVehiculo(Usuario usuario, Terreno terreno) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quieres usar tu vehiculo?Si/No");
        String a = sc.nextLine();
        if (a.equalsIgnoreCase("si")) {
            if (usuario.getVehiculo() != null) {
                if (!terreno.isTrabajado()) {
                    if (usuario.getVehiculo().getCategoria() == 1) {
                        if (terreno.getTipo().equals(usuario.getVehiculo().getFuncion())) {
                            if (usuario.getResistencia() <= 30) {
                                terreno.setTrabajado(true);
                                usuario.setResistencia(usuario.getResistencia() - 30);
                                usuario.setExperiencia(usuario.getExperiencia() + 20);
                                System.out.println("Tu resistencia después de trabajar:" + usuario.getResistencia());
                                System.out.println("Tu experiencia actual es de:" + usuario.getExperiencia());
                            } else {
                                System.out.println("No tienes la resistencia necesaria, tu resistencia actual es " + usuario.getResistencia());
                            }
                        }
                    } else if (usuario.getVehiculo().getCategoria() == 2) {
                        if (terreno.getTipo().equals(usuario.getVehiculo().getFuncion())) {
                            if (usuario.getResistencia() <= 15) {
                                terreno.setTrabajado(true);
                                usuario.setResistencia(usuario.getResistencia() - 15);
                                usuario.setExperiencia(usuario.getExperiencia() + 20);
                                System.out.println("Tu resistencia después de trabajar:" + usuario.getResistencia());
                                System.out.println("Tu experiencia actual es de:" + usuario.getExperiencia());
                            } else {
                                System.out.println("No tienes la resistencia necesaria, tu resistencia actual es " + usuario.getResistencia());
                            }
                        }
                    }
                    if (usuario.getVehiculo().getCategoria() == 3) {
                        if (terreno.getTipo().equals(usuario.getVehiculo().getFuncion())) {
                            if (usuario.getResistencia() < 15) {
                                terreno.setTrabajado(true);
                                usuario.setExperiencia(usuario.getExperiencia() + 20);
                                System.out.println("Tu resistencia después de trabajar:" + usuario.getResistencia());
                                System.out.println("Tu experiencia actual es de:" + usuario.getExperiencia());
                            } else {
                                System.out.println("No tienes la resistencia necesaria, tu resistencia actual es " + usuario.getResistencia());
                            }
                        }
                    } else {
                        System.out.println("No cuentas con ningún vehiculo en propiedad " + usuario.getVehiculo());
                    }
                } else {
                    System.out.println("El terreno ya está trabajado");
                }
            } else {
                System.out.println("No tienes vehiculo en posesion");
            }
        } else {
            System.out.println("Saliendo ...");
        }
    }

    public static void tirarRuleta(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bienvenido al Casino!!!");
        System.out.println("¿Cuántas monedas quieres apostar?");

        int a = Integer.parseInt(sc.nextLine());

        if (a <= usuario.getMonedero()) {
            int premio = a * (generateRandomNumber(0, 2, random));
            usuario.setMonedero(usuario.getMonedero() + premio);
            System.out.println("Ganaste " + premio + " monedas!");
        } else {
            System.out.println("No tienes suficientes monedas.");
        }
    }

    public static int generateRandomNumber(int min, int max, Random random) {
        return random.nextInt((max - min) + 1) + min;
    }
}







