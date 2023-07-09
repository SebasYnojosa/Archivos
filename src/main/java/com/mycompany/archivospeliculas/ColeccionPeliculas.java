/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.archivospeliculas;

import com.mycompany.archivospeliculas.formularios.Ayuda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author emili
 */
public class ColeccionPeliculas {
    private ArrayList<Pelicula> coleccion;

    private final ArchivoSerializable<Pelicula> archivoSerializable;

    public ColeccionPeliculas(String archivoURL) {
        archivoSerializable = new ArchivoSerializable(archivoURL);
        if (archivoSerializable.archivoExiste())
            coleccion = new ArrayList<>(archivoSerializable.leerArchivo());
        else
            coleccion = new ArrayList<>();
    }

    public void agregar(Pelicula pelicula){
        for (int i = 0; i < tamanio(); ++i) {
            if (obtener(i).getIdentificador() == pelicula.getIdentificador()) {
                Ayuda.mensajeError("Ya existe una pelicula con este identificador");
                return;
            }
        }
        coleccion.add(pelicula);
        archivoSerializable.escribirArchivo(coleccion);
    }

    public int tamanio() {
        return coleccion.size();
    }
    
    public boolean coleccionVacia() {
        return tamanio() == 0 || !archivoSerializable.archivoExiste();
    }

    public void buscarPorID(int id) {
        if (coleccionVacia()) {
            Ayuda.mensajeError("No hay peliculas en la coleccion");
            return;
        }
        for (int i = 0; i < tamanio(); ++i) {
            if (obtener(i).getIdentificador() == id) {
                System.out.println(obtener(i));
                return;
            }
        }
        Ayuda.mensajeError("No se encontro la pelicula con este ID");
    }

    public void vaciarColeccion(){
        coleccion.clear();
        archivoSerializable.escribirArchivo(coleccion);
        Ayuda.mensajeExito("Se vació esta colección");
    }

    public Pelicula obtener(int indice) {
        return coleccion.get(indice);
    }

    public void eliminar(int id){
        if (coleccionVacia()) {
            Ayuda.mensajeError("No hay peliculas en la coleccion");
            return;
        }
        for (int i = 0; i < tamanio(); ++i) {
            if (obtener(i).getIdentificador() == id) {
                Ayuda.mensajeExito("Se elimino la pelicula: " + coleccion.remove(i).getNombre());
                archivoSerializable.escribirArchivo(coleccion);
                return;
            }
        }
        Ayuda.mensajeError("No se encontró una pelicula con este ID");
    }

    // forNormal
    public void mostrarFor() {
        if (coleccionVacia())
            Ayuda.mensajeError("No hay peliculas en la coleccion");
        else {
            coleccion = archivoSerializable.leerArchivo();
            for (int i = 0; i < tamanio(); ++i) {
                System.out.println(obtener(i));
            }
        }
    }

    // forEach
    public void mostrarForEach() {
        if (coleccionVacia())
            Ayuda.mensajeError("No hay peliculas en la coleccion");
        else {
            coleccion = archivoSerializable.leerArchivo();
            for (Pelicula p : coleccion) {
                System.out.println(p);
            }
        }
    }

    // iterator
    public void mostrarIterator() {
        if (coleccionVacia())
            Ayuda.mensajeError("No hay peliculas en la coleccion");
        else {
            coleccion = archivoSerializable.leerArchivo();
            Iterator<Pelicula> it = coleccion.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }

    // Ordenar por nombre
    public void mostrarOrdenadoPorNombre() {
        if (coleccionVacia()) {
            Ayuda.mensajeError("No hay peliculas en la coleccion");
        }
        else {
            coleccion = archivoSerializable.leerArchivo();
            Collections.sort(coleccion);
            for (Pelicula p : coleccion) {
                System.out.println(p);
            }
        }
    }

    // Ordenar por duracion al reves
    public void mostrarOrdenadoPorDuracionInverso() {
        if (coleccionVacia())
            Ayuda.mensajeError("No hay peliculas en la coleccion");
        else {
            coleccion = archivoSerializable.leerArchivo();
            coleccion.sort(new ComparadorDuracionInverso());
            for (Pelicula p : coleccion) {
                System.out.println(p);
            }
        }
    }
}
