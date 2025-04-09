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

    public static void trabajar(ArrayList<Terreno> ter, Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué tipo de terreno quieres trabajar, huerta o granja?");
        String a = sc.nextLine();
        for (Terreno t : ter) {
            if (t.getTipo().equalsIgnoreCase(a)) {
                if (!t.isTrabajado()) {
                    System.out.println("¿Quieres trabajar? Si/No");
                    String b = sc.nextLine();
                    if (b.equalsIgnoreCase("si")) {
                        t.setTrabajado(true);
                        usuario.setResistencia(usuario.getResistencia() - 25);
                        usuario.setExperiencia(usuario.getExperiencia() + 10);
                        System.out.println("Tu resistencia después de trabajar:" + usuario.getResistencia());
                        System.out.println("Tu experiencia actual es de:" + usuario.getExperiencia());
                        break;
                    } else {
                        System.out.println("Saliendo . . .");
                        break;
                    }
                } else {
                    System.out.println("El terreno ya está trabajado");
                    break;
                }
            } else if (!t.getTipo().equalsIgnoreCase("granja") && !t.getTipo().equalsIgnoreCase("huerta")) {
                System.out.println("Error al elegir terreno para trabajar, elige entre granja o huerta");
                break;
            }
        }
    }

    public static Usuario crearUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre de usuario");
        String a = sc.nextLine();
        return new Usuario(a, null);
    }

    public static void vender(Usuario usuario, ArrayList<MateriaPrima> p, ArrayList<Terreno> ter) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("¿Quieres vender? Si/No");
        String a = sc.nextLine();
        if (a.equalsIgnoreCase("si")) {
            System.out.println("¿De que tipo de terreno quieres vender? Granja o huerta.");
            String b = sc.nextLine();
            if (b.equalsIgnoreCase("granja")) {
                for (Terreno t : ter) {
                    if (t.getTipo().equalsIgnoreCase(b)) {
                        System.out.println("¿Qué quieres vender?Elige entre Gallinas o Vacas ");
                        String c = sc.nextLine();
                        for (MateriaPrima pe : p) {
                            if (pe.getTipo().equalsIgnoreCase(c)) {
                                if (pe.isAlimentado()) {
                                    int ganancia = (pe.getRecurso() * pe.getPrecio()) * (generateRandomNumber(2, 5, random)) * usuario.getNivel();
                                    usuario.setMonedero(usuario.getMonedero() + ganancia);
                                    System.out.println("Has vendido " + c + " por un total de " + ganancia);
                                    pe.setAlimentado(false);
                                    break;
                                } else if (!pe.isAlimentado()) {
                                    System.out.println("Debes alimentar los animales para poder vender.");
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Error al elegir entre gallinas o vacas.");
                    }

                }
            } else if (b.equalsIgnoreCase("huerta")) {
                for (Terreno t : ter) {
                    if (t.getTipo().equalsIgnoreCase(b)) {
                        System.out.println("¿Qué quieres vender?Elige entre Tomates o Patatas ");
                        String c = sc.nextLine();
                        for (MateriaPrima pe : p) {
                            if (pe.getTipo().equalsIgnoreCase(c)) {
                                if (pe.isAlimentado()) {
                                    int ganancia = (pe.getRecurso() * pe.getPrecio()) * (generateRandomNumber(2, 5, random)) * usuario.getNivel();
                                    usuario.setMonedero(usuario.getMonedero() + ganancia);
                                    System.out.println("Has vendido " + c + " por un total de " + ganancia);
                                    pe.setAlimentado(false);
                                    break;
                                } else if (!pe.isAlimentado()) {
                                    System.out.println("Debes regar los cultivos para poder vender");
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Error al elegir entre patatas o tomates.");
                    }

                }
            } else if (!b.equalsIgnoreCase("granja") && !b.equalsIgnoreCase("huerta")) {
                System.out.println("Error al elegir entre granja o huerta");
            }
        } else {
            System.out.println("Saliendo de la tienda...");
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
                                System.out.println("El precio del vehiculo es: " + v.getPrecio());
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
                            break;
                        } else {
                            System.out.println("No tienes suficiente dinero tu dinero actual es: " + usuario.getMonedero());
                            System.out.println("El precio del vehiculo es: " + v.getPrecio());
                            break;
                        }
                    }
                }
            }
        } else {
            System.out.println("Saliendo de la tienda ...");
        }
    }

    public static void usarVehiculo(Usuario usuario, ArrayList<Terreno> ter) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quieres usar tu vehiculo?Si/No");
        String a = sc.nextLine();
        if (a.equalsIgnoreCase("si")) {
            if (usuario.getVehiculo() != null) {
                for (Terreno t : ter) {
                    if (!t.isTrabajado()) {
                        if (usuario.getVehiculo().getCategoria() == 1) {
                            if (t.getTipo().equals(usuario.getVehiculo().getFuncion())) {
                                if (usuario.getResistencia() <= 30) {
                                    t.setTrabajado(true);
                                    usuario.setResistencia(usuario.getResistencia() - 30);
                                    usuario.setExperiencia(usuario.getExperiencia() + 20);
                                    System.out.println("Tu resistencia después de trabajar:" + usuario.getResistencia());
                                    System.out.println("Tu experiencia actual es de:" + usuario.getExperiencia());
                                    break;
                                } else {
                                    System.out.println("No tienes la resistencia necesaria, tu resistencia actual es " + usuario.getResistencia());
                                    break;
                                }
                            }
                        } else if (usuario.getVehiculo().getCategoria() == 2) {
                            if (t.getTipo().equals(usuario.getVehiculo().getFuncion())) {
                                if (usuario.getResistencia() <= 15) {
                                    t.setTrabajado(true);
                                    usuario.setResistencia(usuario.getResistencia() - 15);
                                    usuario.setExperiencia(usuario.getExperiencia() + 20);
                                    System.out.println("Tu resistencia después de trabajar:" + usuario.getResistencia());
                                    System.out.println("Tu experiencia actual es de:" + usuario.getExperiencia());
                                    break;
                                } else {
                                    System.out.println("No tienes la resistencia necesaria, tu resistencia actual es " + usuario.getResistencia());
                                    break;
                                }
                            }
                        } else if (usuario.getVehiculo().getCategoria() == 3) {
                            if (t.getTipo().equals(usuario.getVehiculo().getFuncion())) {
                                if (usuario.getResistencia() < 15) {
                                    t.setTrabajado(true);
                                    usuario.setExperiencia(usuario.getExperiencia() + 20);
                                    System.out.println("Tu resistencia después de trabajar:" + usuario.getResistencia());
                                    System.out.println("Tu experiencia actual es de:" + usuario.getExperiencia());
                                    break;
                                } else {
                                    System.out.println("No tienes la resistencia necesaria, tu resistencia actual es " + usuario.getResistencia());
                                    break;
                                }
                            }
                        } else {
                            System.out.println("No cuentas con ningún vehiculo en propiedad " + usuario.getVehiculo());
                            break;
                        }
                    } else {
                        System.out.println("El terreno ya está trabajado");
                        break;
                    }
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

    public static void dormir(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int contador = 0;
        System.out.println("¿Quieres dormir? Si/No: ");
        String a = sc.nextLine();
        if (a.equalsIgnoreCase("Si")) {
            contador++;
            usuario.setResistencia(usuario.getResistenciaMaxima());
            System.out.println("Has descansado con exito tu resistencia se ha reestablecido a " + usuario.getResistencia() + " llevas un total de " + contador + " días.");

            int cobro = 10 * usuario.getNivel();
            usuario.setMonedero(usuario.getMonedero() - cobro);
            System.out.println("Se ha cobrado el alquiler del terreno te han cobrado " + cobro + " ahora tienes " + usuario.getMonedero());

            int resultado = generateRandomNumber(0, 40, random);
            if (resultado == 9) {
                int perdida = 200 * usuario.getNivel();
                usuario.setMonedero(usuario.getMonedero() - perdida);
                System.out.println("Un tornado ha destrozado tu granja, has tenido que pagar " + perdida + " tu dinero actual es de " + usuario.getMonedero());
            }


        }

    }

    public static void mejorarTerreno(ArrayList<Terreno> ter, Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué quieres mejorar? Granja o Huerta");
        String a = sc.nextLine();
        if (usuario.getNivel() == 5 || usuario.getNivel() == 10) {
            for (Terreno t : ter) {
                int coste = (t.getPrecio() * 2);
                if (usuario.getMonedero() >= coste) {
                    if (t.getTipo().equalsIgnoreCase(a)) {
                        System.out.println("Selecciona a que nivel lo quieres mejorar, 1 o superior.");
                        int b = Integer.parseInt(sc.nextLine());
                        if (t.getNivel() < b) {
                            t.setNivel(b);
                            t.setPrecio(t.getPrecio() + 1000);
                            usuario.setMonedero(usuario.getMonedero() - coste);
                            System.out.println("Enhorabuena tu terreno ha subido a nivel " + t.getNivel() + " con un coste de " + coste + " , actualmente tienes " + usuario.getMonedero());
                            break;
                        } else if (t.getNivel() >= b) {
                            System.out.println("Error, tu nivel actual es igual o mayor al que quieres mejorar, tu nivel actual es " + usuario.getNivel() + " selecciona un nivel superior a " + b);
                            break;
                        }
                    } else if (!t.getTipo().equalsIgnoreCase(a) || !t.getTipo().equalsIgnoreCase(a)) {
                        System.out.println("Introduce un tipo válido de terreno, huerta o granja.");
                        break;
                    }
                } else if (usuario.getMonedero() < coste) {
                    System.out.println("No tienes dinero suficiente para mejorar el terreno, el precio de la mejora es de " + coste + " y tienes un tal de " + usuario.getMonedero());
                    break;
                }
            }
        } else {
            System.out.println("No tienes nivel suficiente para poder mejorar, tu nivel actual es " + usuario.getNivel());
        }
    }
}