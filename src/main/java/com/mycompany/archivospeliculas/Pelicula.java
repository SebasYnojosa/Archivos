/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.archivospeliculas;

import java.io.Serializable;

/**
 *
 * @author emili
 */
public class Pelicula implements Comparable<Pelicula>, Serializable {

    private final int identificador;
    private final String nombre;
    private final String actorPrincipal;
    private final String genero;
    private final int duracion;

    public Pelicula(int identificador, String nombre, String actorPrincipal, String genero, int duracion) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.actorPrincipal = actorPrincipal;
        this.genero = genero;
        this.duracion = duracion;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString(){
        return String.format("Pelicula{identificador=%d, nombre=%s, actorPrincipal=%s, genero=%s, duracion=%d}", identificador, nombre, actorPrincipal, genero, duracion);
    }

    @Override
    public int compareTo(Pelicula o) {
        return this.getNombre().compareTo(o.getNombre());
    }
}
