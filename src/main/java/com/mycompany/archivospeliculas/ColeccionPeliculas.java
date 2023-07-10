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
                Pelicula p = obtener(i);
                Ayuda.mensajeExito(String.format("Se encontro la pelicula con ID %d\n"
                        + "Nombre: %s \n"
                        + "Actor principal: %s \n"
                        + "Género: %s \n"
                        + "Duración en minutos: %d", p.getIdentificador(),p.getNombre(), p.getActorPrincipal(), p.getGenero(), p.getDuracion()));
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
        for (int i = 0; i < tamanio(); ++i) {
            if (obtener(i).getIdentificador() == id) {
                Ayuda.mensajeExito("Se elimino la pelicula: " + coleccion.remove(i).getNombre());
                archivoSerializable.escribirArchivo(coleccion);
                return;
            }
        }
        Ayuda.mensajeError("No se encontró una pelicula con este ID");
    }

    // Ordenar por nombre
    public ArrayList<Pelicula> ordenarPorNombre() {
        coleccion = archivoSerializable.leerArchivo();
        Collections.sort(coleccion);
        return coleccion;
    }

    // Ordenar por duracion al reves
    public ArrayList<Pelicula> ordenarPorDuracionInverso() {
        coleccion = archivoSerializable.leerArchivo();
        coleccion.sort(new ComparadorDuracionInverso());
        return coleccion; 
    }
}
