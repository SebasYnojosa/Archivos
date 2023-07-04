/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.archivospeliculas;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author emili
 */
public class Usuario implements Serializable {
    private String nombre;
    private String contraseña;
    private final int id;
    private final String archivoURL;

    private static final int MAX_ID = 999_999_999;

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.id = generarID();
        this.archivoURL = String.format("archivos/coleccion_%09d.txt", id);
    }

    private int generarID() {
        Random random = new Random();
        return random.nextInt(MAX_ID);
    }

    public boolean contraseñaCorrecta(String contraseña) {
        return this.contraseña.equals(contraseña);
    }

    @Override
    public String toString() {
        return String.format("Usuario{nombre=%s, contraseña=%s, id=%d}", nombre, contraseña, id);
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getArchivoURL() {
        return archivoURL;
    }
}
