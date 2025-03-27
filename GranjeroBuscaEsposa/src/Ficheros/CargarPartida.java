package Ficheros;
import java.io.File;
import java.util.Scanner;

import java.io.FileNotFoundException;

public class CargarPartida {
    public static void cargarPartida() {
        Scanner scFile = null;

        // Supongamos que nuevaPartida devuelve el archivo correctamente
        File f = NuevaPartida.crearPartida();

        try {
            if (f != null && f.exists()) {  // Verificar que el archivo existe
                scFile = new Scanner(f);
                int nLinea = 0;

                System.out.println("=== Cargando partida... ===");
                while (scFile.hasNextLine()) {
                    nLinea++;
                    String linea = scFile.nextLine();
                    System.out.println("Línea " + nLinea + ": " + linea);
                }

                if (nLinea == 0) {
                    System.out.println("El archivo está vacío.");
                }
            } else {
                System.out.println("El archivo no existe o es inválido.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado.");
        } catch (Exception e) {
            System.out.println("Error al cargar la partida: " + e.getMessage());
        } finally {
            if (scFile != null) {
                scFile.close();
            }
        }
    }
}
