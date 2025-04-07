package Ficheros;

import Ficheros.NuevaPartida;
import Usuario_Vehiculo.Usuario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GuardarPartida {
    public static void guardarPartida(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre de tu partida:");
        String nombreArchivo = sc.nextLine().trim();
        nombreArchivo = nombreArchivo.replaceAll("[\\\\/:*?\"<>|]", "_");

        File f = new File("./" + nombreArchivo + ".csv");
        FileWriter fw = null;

        try {

            fw = new FileWriter(f);


            String linea = usuario.toCSV();
            fw.write(linea + "\n");

            System.out.println("Partida guardada exitosamente en " + f.getName());

        } catch (IOException e) {
            System.out.println("Fallo al guardar partida: " + e.getMessage());
        } finally {

            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }
}

