/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.archivospeliculas;

import com.mycompany.archivospeliculas.formularios.Ayuda;
import java.util.ArrayList;

/**
 *
 * @author emili
 */
public class ListaUsuarios {
    private ArrayList<Usuario> listaUsuarios;
    private ArchivoSerializable<Usuario> archivoSerializable;

    public ListaUsuarios() {
        archivoSerializable = new ArchivoSerializable("archivos/usuarios.txt");
        if (archivoSerializable.archivoExiste())
            listaUsuarios = new ArrayList<>(archivoSerializable.leerArchivo());
        else
            listaUsuarios = new ArrayList<>();
    }

    public void registrar(Usuario usuario) {
        for (int i = 0; i < listaUsuarios.size(); ++i) {
            if (listaUsuarios.get(i).getNombre().equals(usuario.getNombre())) {
                Ayuda.mensajeError("Ya existe un usuario con este nombre");
                return;
            }
        }
        listaUsuarios.add(usuario);
        archivoSerializable.escribirArchivo(listaUsuarios);
        Ayuda.mensajeExito("Usuario registrado exitosamente");
    }
    
    public int tam() {
        return listaUsuarios.size();
    }

    public Usuario obtener(int indice) {
        return listaUsuarios.get(indice);
    }
    
    public Usuario iniciarSesion(String nombre, String contraseña) {
        if (listaUsuarios.isEmpty() || !archivoSerializable.archivoExiste()) {
            return null;
        }
        for (Usuario u : listaUsuarios) {
            if (u.getNombre().equals(nombre) && u.getContraseña().equals(contraseña))
                return u;
        }
        return null;
    }
}
