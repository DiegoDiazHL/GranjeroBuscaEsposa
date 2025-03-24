package Ficheros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class nuevaPartida {
    public static File crearPartida(){ //Uso static File para poder usar el fichero en otra clase
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre de tu partida");
        String a = sc.nextLine(); // Añadimos el nombre en una variable para poder usarlo como ruta
        File f = new File("./"+a+".csv"); // Crea el archivo con el nombre que se quiera

        try {
            if (f.createNewFile()) {
                System.out.println("Archivo creado exitosamente.");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Hubo un error al crear el archivo.");
        }
        sc.close();
        return f;
    }
}


