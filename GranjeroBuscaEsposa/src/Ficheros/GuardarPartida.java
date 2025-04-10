package Ficheros;

import Ficheros.NuevaPartida;
import Terrenos.MateriaPrima;
import Terrenos.Terreno;
import Usuario_Vehiculo.Usuario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GuardarPartida {
    public static void guardarPartida(Usuario usuario,ArrayList<Terreno> ter) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre de tu partida:");
        String nombreArchivo = sc.nextLine().trim();
        nombreArchivo = nombreArchivo.replaceAll("[\\\\/:*?\"<>|]", "_");

        File f = new File("./" + nombreArchivo + ".csv");
        FileWriter fw = null;

        try {

            fw = new FileWriter(f,false);


            String linea = usuario.toCSV();
            fw.write(linea+ "," );
            for (Terreno t : ter){
                String linea1 = t.toCSV()+ ",";
                fw.write(linea1);
            }

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

