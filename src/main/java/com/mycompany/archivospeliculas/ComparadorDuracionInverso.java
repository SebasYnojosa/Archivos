/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.archivospeliculas;

import java.util.Comparator;

/**
 *
 * @author emili
 */
public class ComparadorDuracionInverso implements Comparator<Pelicula> {

    @Override
    public int compare(Pelicula o1, Pelicula o2) {
        return o2.getDuracion() - o1.getDuracion();
    }
}