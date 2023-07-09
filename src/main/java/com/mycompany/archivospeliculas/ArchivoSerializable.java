/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.archivospeliculas;

import com.mycompany.archivospeliculas.formularios.Ayuda;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author emili
 */
public class ArchivoSerializable<T> {
    private final File f;

    public ArchivoSerializable(String archivoURL){
        f = new File(archivoURL);
    }

    public boolean archivoExiste() {
        return f.exists();
    }

    public void escribirArchivo(ArrayList<T> c) {
        try (OutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (int i = 0; i < c.size(); ++i) {
                oos.writeObject(c.get(i));
            }
        } catch (IOException e) {
            Ayuda.mensajeError("Error al escribir en el archivo");
            System.exit(1);
        }
    }

    public ArrayList<T> leerArchivo() {
        ArrayList<T> c = new ArrayList<>();
        try (InputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                c.add((T) ois.readObject());
            }
        } catch (EOFException endOfFile) {
            return c;
        } catch (IOException | ClassNotFoundException e) {
            Ayuda.mensajeError("Error al leer del archivo");
            System.exit(1);
        }
        return c;
    }
}
