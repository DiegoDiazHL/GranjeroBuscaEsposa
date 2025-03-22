package Ficheros;

import java.io.File;
import java.io.IOException;

public class nuevaPartida {
    public static void main(String[] args) {
        File f = new File("partida1.csv"); // Crea el archivo en la raíz del proyecto

        try {
            if (f.createNewFile()) {
                System.out.println("Archivo creado exitosamente.");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Hubo un error al crear el archivo.");
        }
    }
}


