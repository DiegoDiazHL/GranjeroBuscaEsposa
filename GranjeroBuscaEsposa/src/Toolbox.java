import Terrenos.MateriaPrima;
import Terrenos.Terreno;
import Usuario_Vehiculo.Usuario;
import Usuario_Vehiculo.Vehiculo;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Toolbox {

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