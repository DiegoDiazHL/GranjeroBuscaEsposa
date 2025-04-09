package Ficheros;

import Terrenos.Terreno;
import Usuario_Vehiculo.Usuario;
import Usuario_Vehiculo.Vehiculo;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class CargarPartida {
    public static void cargarPartida(Usuario usuario, Scanner sc, ArrayList<Terreno> ter) {
        System.out.println("Introduce el nombre de la partida a cargar:");
        String nombreArchivo = sc.nextLine().trim();
        nombreArchivo = nombreArchivo.replaceAll("[\\\\/:*?\"<>|]", "_");

        File f = new File("./" + nombreArchivo + ".csv");

        Scanner scFile = null;
        boolean datosCargados = false;

        try {
            if (!f.exists()) {
                System.out.println("El archivo no existe. Asegúrate de ingresar el nombre correcto.");
                return;
            }

            scFile = new Scanner(f);
            int nLinea = 0;

            System.out.println("=== Cargando partida... ===");
            if (scFile.hasNextLine()) {
                nLinea++;
                String linea = scFile.nextLine();
                String[] partes = linea.split(",");
                if (partes.length == 22) {
                    try {
                        // Cargar datos del usuario
                        usuario.setNombre(partes[0].trim());
                        usuario.setMonedero(Integer.parseInt(partes[1].trim()));
                        boolean tieneVehiculo = Boolean.parseBoolean(partes[2].trim().toLowerCase());
                        int experiencia = Integer.parseInt(partes[7].trim());
                        int nivel = Integer.parseInt(partes[8].trim());
                        int resistencia = Integer.parseInt(partes[9].trim());

                        usuario.setExperiencia(experiencia);
                        usuario.setNivel(nivel);
                        usuario.setResistencia(resistencia);

                        // Cargar vehículo si lo tiene
                        if (tieneVehiculo) {
                            String nombreVehiculo = partes[3].trim();
                            String funcionVehiculo = partes[4].trim();
                            int categoriaVehiculo = Integer.parseInt(partes[5].trim());
                            int precioVehiculo = Integer.parseInt(partes[6].trim());

                            Vehiculo vehiculoCargado = new Vehiculo(nombreVehiculo, funcionVehiculo, precioVehiculo, categoriaVehiculo);
                            usuario.setVehiculo(vehiculoCargado);
                            System.out.println("Vehículo cargado: " + vehiculoCargado);
                        } else {
                            usuario.setVehiculo(null);
                            System.out.println("No se cargó ningún vehículo.");
                        }

                        // Cargar los terrenos
                        String tipoTerreno1 = partes[10].trim();
                        int tamanoTerreno1 = Integer.parseInt(partes[11].trim());
                        int capacidadTerreno1 = Integer.parseInt(partes[12].trim());
                        int precioTerreno1 = Integer.parseInt(partes[13].trim());
                        boolean trabajadoTerreno1 = Boolean.parseBoolean(partes[14].trim().toLowerCase());
                        int nivelTerreno1 = Integer.parseInt(partes[15].trim());

                        Terreno t2 = new Terreno(tipoTerreno1, tamanoTerreno1, capacidadTerreno1, precioTerreno1, trabajadoTerreno1, nivelTerreno1);
                        ter.add(t2);

                        String tipoTerreno2 = partes[16].trim();
                        int tamanoTerreno2 = Integer.parseInt(partes[17].trim());
                        int capacidadTerreno2 = Integer.parseInt(partes[18].trim());
                        int precioTerreno2 = Integer.parseInt(partes[19].trim());
                        boolean trabajadoTerreno2 = Boolean.parseBoolean(partes[20].trim().toLowerCase());
                        int nivelTerreno2 = Integer.parseInt(partes[21].trim());

                        Terreno t1 = new Terreno(tipoTerreno2, tamanoTerreno2, capacidadTerreno2, precioTerreno2, trabajadoTerreno2, nivelTerreno2);
                        ter.add(t1);

                        System.out.println("Terrenos cargados:");
                        System.out.println("- " + t1);
                        System.out.println("- " + t2);

                        System.out.println("Datos de usuario cargados para " + usuario.getNombre() + ": Monedero=" + usuario.getMonedero() + ", Experiencia=" + usuario.getExperiencia() + ", Nivel=" + usuario.getNivel() + ", Resistencia=" + usuario.getResistencia());
                        datosCargados = true;

                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir valores numéricos en la línea " + nLinea + ": " + linea);
                    } catch (Exception e) {
                        System.out.println("Error inesperado al procesar la línea " + nLinea + ": " + linea + " - " + e.getMessage());
                    }
                } else {
                    System.out.println("Formato incorrecto en la línea " + nLinea + ": " + linea + ". Se esperaban 22 columnas.");
                }
            }

            if (nLinea == 0) {
                System.out.println("El archivo está vacío.");
            } else if (!datosCargados) {
                System.out.println("No se encontraron datos de partida válidos en el archivo.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se pudo abrir el archivo.");
        } finally {
            if (scFile != null) {
                scFile.close();
            }
        }
    }
}
