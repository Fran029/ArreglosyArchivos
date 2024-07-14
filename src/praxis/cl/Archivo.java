package praxis.cl;

import java.io.*;
import java.util.ArrayList;


public class Archivo {
    ArrayList<String> lista;


    public Archivo() {

        lista = new ArrayList<>();
        lista.add("Perro");
        lista.add("Gato");
        lista.add("Juan");
        lista.add("Daniel");
        lista.add("Juan");
        lista.add("Gato");
        lista.add("Perro");
        lista.add("Camila");
        lista.add("Daniel");
        lista.add("Camila");
    }

    public ArrayList<String> getLista() {
        return lista;

    }

    public void crearArchivo(String directorio, String fichero) {
        // se crea  la carpeta datos y el fichero texto.txt
        File carpeta = new File("src", directorio);
        File archivo = new File(carpeta, fichero);

        // En caso que la carpeta no exista se crea , en caso de error al crear aparece el mensaje de error al crear, sino indica que existe
        if (!carpeta.exists()) {
            if (!carpeta.mkdir()) {
                System.out.println("Error al crear el directorio");
            }
        } else {
            System.out.println("El directorio existe");
        }
        // se crea el fichero texto.txt  en caso que no exista , el try catch en caso de error captura el error y lo ejecuta como exepcion
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            System.out.println("El fichero ingresado  existe");
        }

        try {
            FileWriter fr = new FileWriter(archivo);// escribe el archivo
            BufferedWriter bw = new BufferedWriter(fr);

            for (String nombres : lista) {
                bw.write(nombres);
                bw.newLine();
            }

            bw.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void buscarTexto(String fichero, String texto) {
        File archivo = new File(fichero);
        ArrayList<String> encontrado = new ArrayList<>();
        int count = 0;

        if (archivo.exists()) {
            try {
                FileReader fr = new FileReader(archivo); // lee el archivo
                BufferedReader br = new BufferedReader(fr);
                // itera y cuenta

                br.lines()
                        .filter(s -> s.equals(texto))
                        .forEach(s -> encontrado.add(s));

                count = encontrado.size();

                br.close();
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("El texto '" + texto + "' se encuentra " + count + " veces en el archivo.");
        } else {
            System.out.println("El fichero ingresado no existe");
        }

    }
}













