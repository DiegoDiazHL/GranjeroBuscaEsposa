package Ficheros;
import java.io.File;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cargarPartida {
    public static void main(String[] args) {
        Scanner scFile = null;
        File f = nuevaPartida.crearPartida(); // Usamos el archivo creado en nuevaPartida
        String linea;
        int nLinea = 0;

        try {
            if (f.exists()) {  // Verificar que el archivo existe
                scFile = new Scanner(f);
                while (scFile.hasNextLine()) {
                    nLinea++;
                    linea = scFile.nextLine();
                }
            } else {
                System.out.println("El archivo no existe.");
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

