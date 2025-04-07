package Ficheros;

import Usuario_Vehiculo.Usuario;
import Usuario_Vehiculo.Vehiculo;

import java.io.File;
import java.util.Scanner;

import java.io.FileNotFoundException;

public class CargarPartida {
    public static void cargarPartida(Usuario usuario, Scanner sc) {
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
                if (partes.length == 10) {
                    try {
                        usuario.setNombre(partes[0].trim());
                        usuario.setMonedero(Integer.parseInt(partes[1].trim()));
                        boolean tieneVehiculo = Boolean.parseBoolean(partes[2].trim().toLowerCase());
                        int experiencia = Integer.parseInt(partes[7].trim());
                        int nivel = Integer.parseInt(partes[8].trim());
                        int resistencia = Integer.parseInt(partes[9].trim());

                        usuario.setExperiencia(experiencia);
                        usuario.setNivel(nivel);
                        usuario.setResistencia(resistencia);

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

                        System.out.println("Datos de usuario cargados para " + usuario.getNombre() + ": Monedero=" + usuario.getMonedero() + ", Experiencia=" + usuario.getExperiencia() + ", Nivel=" + usuario.getNivel() + ", Resistencia=" + usuario.getResistencia());
                        datosCargados = true;

                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir valores numéricos en la línea " + nLinea + ": " + linea);
                    } catch (Exception e) {
                        System.out.println("Error inesperado al procesar la línea " + nLinea + ": " + linea + " - " + e.getMessage());
                    }
                } else {
                    System.out.println("Formato incorrecto en la línea " + nLinea + ": " + linea + ". Se esperaban 10 columnas.");
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