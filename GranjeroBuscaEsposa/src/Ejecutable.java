import Ficheros.CargarPartida;
import Ficheros.NuevaPartida;
import Terrenos.*;
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
        Vehiculo v1 = new Vehiculo("Tractor", "Labrar", 1000, 1);
        Vehiculo v2 = new Vehiculo("Tractor", "Labrar", 2000, 2);
        Vehiculo v3 = new Vehiculo("Tractor", "Labrar", 3000, 3);
        Vehiculo v4 = new Vehiculo("Limpiadora", "Limpiar", 1000, 1);
        Vehiculo v5 = new Vehiculo("Limpiadora", "Limpiar", 2000, 2);
        Vehiculo v6 = new Vehiculo("Limpiadora", "Limpiar", 3000, 3);
        Vehiculo v0 = new Vehiculo(null, null, 0, 0);
        ve.add(v0);
        ve.add(v1);
        ve.add(v2);
        ve.add(v3);
        ve.add(v4);
        ve.add(v5);
        ve.add(v6);
        MateriaPrima mp1 = new MateriaPrima("Vaca", 2, TRUE, 5);
        MateriaPrima mp2 = new MateriaPrima("Gallina", 2, TRUE, 3);
        MateriaPrima mp3 = new MateriaPrima("Patatas", 3, TRUE, 2);
        MateriaPrima mp4 = new MateriaPrima("Tomate", 4, TRUE, 6);
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

    public void trabajar(Terreno terreno, Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué tipo de terreno quieres trabajar?");
        String a = sc.nextLine();
        if (a.equalsIgnoreCase("huerta")) {
            if (!terreno.isTrabajado()) {
                System.out.println("¿Quieres labrar la tierra? Si/No");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("si")) {
                    usuario.setResistencia(usuario.getResistencia() - 20);
                    usuario.setExperiencia(usuario.getExperiencia() + 20);
                    System.out.println("Tu resistencia después de labrar todo es de:" + usuario.getResistencia());
                    System.out.println("Tu experiencia actual es de:" + usuario.getExperiencia());
                }
            }
        }
        if (a.equalsIgnoreCase("granja")) {
            if (!terreno.isTrabajado()) {
                System.out.println("¿Quieres limpiar la granja?");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("si")) {
                    usuario.setResistencia(usuario.getResistencia() - 20);
                    usuario.setExperiencia(usuario.getExperiencia() + 20);
                    System.out.println("Tu resistencia después de limpiar todo es de:" + usuario.getResistencia());
                    System.out.println("Tu experiencia actual es de:" + usuario.getExperiencia());
                }
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

    public void vender(Usuario usuario, ArrayList<MateriaPrima> p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quieres vender?");
        String a = sc.nextLine();
        if (a.equalsIgnoreCase("si")) {
            System.out.println("¿Que quieres vender ");
            String b = sc.nextLine();
            for (MateriaPrima pe : p) {
                if (pe.getTipo().equalsIgnoreCase(b)) {
                    int precioVenta = (int) (pe.getRecurso() * (Math.random() * 4 + 2) * pe.getPrecio());
                    usuario.setMonedero((int) (precioVenta + usuario.getMonedero()));
                    System.out.println("Has vendido " + pe.getRecurso() + " de " + b + " por " + precioVenta + " monedas.");

                }
            }
        }
    }

    public void comprarVehiculo(Usuario usuario, ArrayList<Vehiculo> ve) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quieres comprar un vehiculo?");
        String a = sc.nextLine();
        if (a.equalsIgnoreCase("si")) {
            System.out.println("¿Qué función quieres que tenga, limpiar o labrar?");
            String b = sc.nextLine();
            for (Vehiculo v : ve) {
                if ((b.equalsIgnoreCase("limpiar"))) {
                    System.out.println("Elige nivel de categoria que quieras comprar entre estas opciones: (1,2,3)");
                    int c = Integer.parseInt(sc.nextLine());
                    if (v.getPrecio() <= usuario.getMonedero()) {
                        if (c == 1) {
                            usuario.setVehiculo(v);
                            usuario.setMonedero(usuario.getMonedero() - v.getPrecio());
                            System.out.println("¡Has comprado un vehículo de categoría " + c + " para " + b + "!");
                            System.out.println("Te queda " + usuario.getMonedero() + " monedas.");
                        }
                        if (c == 2) {
                            usuario.setVehiculo(v);
                            usuario.setMonedero(usuario.getMonedero() - v.getPrecio());
                            System.out.println("¡Has comprado un vehículo de categoría " + c + " para " + b + "!");
                            System.out.println("Te queda " + usuario.getMonedero() + " monedas.");

                        }
                        if (c == 3) {
                            usuario.setVehiculo(v);
                            usuario.setMonedero(usuario.getMonedero() - v.getPrecio());
                            System.out.println("¡Has comprado un vehículo de categoría " + c + " para " + b + "!");
                            System.out.println("Te queda " + usuario.getMonedero() + " monedas.");
                        }

                    }else{
                        System.out.println("No tienes suficiente dinero tu dinero actual es: " + usuario.getMonedero());
                    }
                }
                if (b.equalsIgnoreCase("labrar")) {
                    System.out.println("Elige nivel de categoria que quieras comprar entre estas opciones: (1,2,3)");
                    int c = Integer.parseInt(sc.nextLine());
                    if (v.getPrecio() <= usuario.getMonedero()) {
                        if (c == 1) {
                            usuario.setVehiculo(v);
                            usuario.setMonedero(usuario.getMonedero() - v.getPrecio());
                            System.out.println("¡Has comprado un vehículo de categoría " + c + " para " + b + "!");
                            System.out.println("Te queda " + usuario.getMonedero() + " monedas.");
                        }
                        if (c == 2) {
                            usuario.setVehiculo(v);
                            usuario.setMonedero(usuario.getMonedero() - v.getPrecio());
                            System.out.println("¡Has comprado un vehículo de categoría " + c + " para " + b + "!");
                            System.out.println("Te queda " + usuario.getMonedero() + " monedas.");

                        }
                        if (c == 3) {
                            usuario.setVehiculo(v);
                            usuario.setMonedero(usuario.getMonedero() - v.getPrecio());
                            System.out.println("¡Has comprado un vehículo de categoría " + c + " para " + b + "!");
                            System.out.println("Te queda " + usuario.getMonedero() + " monedas.");
                        }

                    }else{
                        System.out.println("No tienes suficiente dinero tu dinero actual es: " + usuario.getMonedero());
                    }
                }
            }
        }else{
            System.out.println("Saliendo de la tienda ...");
        }

    }
}


