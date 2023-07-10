/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.archivospeliculas;

import com.mycompany.archivospeliculas.formularios.Ayuda;
import com.mycompany.archivospeliculas.formularios.Frm_AgregarPelicula;
import com.mycompany.archivospeliculas.formularios.Frm_IniciarSesion;
import com.mycompany.archivospeliculas.formularios.Frm_MostrarPeliculas;
import com.mycompany.archivospeliculas.formularios.Frm_RegistrarUsuario;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author emili
 */
public class ArchivosPeliculas {
    
    private static Usuario usuarioActual = null;

    public static void menuPeliculas(Scanner myScanner) throws InterruptedException {
        ColeccionPeliculas coleccionActual = new ColeccionPeliculas(usuarioActual.getArchivoURL());
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("1. Agregar pelicula");
            System.out.println("2. Mostrar peliculas");
            System.out.println("3. Eliminar pelicula");
            System.out.println("4. Buscar pelicula por ID");
            System.out.println("5. Vaciar coleccion");
            System.out.println("0. Cerrar sesion");
            opcion = myScanner.nextInt();
            myScanner.nextLine();

            switch (opcion) {
                case 1: {
                    Frm_AgregarPelicula form = new Frm_AgregarPelicula(coleccionActual);
                    Thread.sleep(1000);
                    while (form.isActive()) 
                        Thread.sleep(1000);
                    break;
                }
                case 2: {
                    if (coleccionActual.coleccionVacia())
                        Ayuda.mensajeError("La colección del usuario actual esta vacía");
                    else {
                        Frm_MostrarPeliculas form = new Frm_MostrarPeliculas(coleccionActual);
                        Thread.sleep(1000);
                        while (form.isActive())
                            Thread.sleep(1000);
                    }
                    break;
                }
                case 3: {
                    if (coleccionActual.coleccionVacia())
                        Ayuda.mensajeError("La colección del usuario actual esta vacía");
                    else {
                        int identificador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador de la pelicula a eliminar"));
                        coleccionActual.eliminar(identificador);
                    }
                    break;
                }
                case 4: {
                    if (coleccionActual.coleccionVacia())
                        Ayuda.mensajeError("La colección del usuario actual esta vacía");
                    else {
                        int identificador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador de la pelicula a buscar"));
                        coleccionActual.buscarPorID(identificador);
                    }
                    break;
                }
                case 5: {
                    coleccionActual.vaciarColeccion();
                    break;
                }
                case 0: {
                    System.out.println("Volviendo al menu de inicio de sesion");
                    break;
                }
                default: {
                    System.out.println("Opcion invalida");
                    break;
                }
            }
        }
    }
    
    public static void setUsuario(Usuario usuario) {
        usuarioActual = usuario;
    }
    
    public static String getUsuarioNombre() {
        return usuarioActual.getNombre();
    }

    public static void main(String[] args) throws InterruptedException {
        ListaUsuarios listaUsuarios = new ListaUsuarios();
        Scanner myScanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("1. Iniciar sesion");
            System.out.println("2. Registrarse");
            System.out.println("0. Salir");
            opcion = myScanner.nextInt();
            myScanner.nextLine();

            switch (opcion) {
                case 1: {
                    Frm_IniciarSesion formIni = new Frm_IniciarSesion(listaUsuarios);
                    Thread.sleep(1000);
                    while (formIni.isActive()) 
                        Thread.sleep(1000);
                    if (usuarioActual != null)
                        menuPeliculas(myScanner);
                    break;
                }
                case 2: {
                    Frm_RegistrarUsuario formReg = new Frm_RegistrarUsuario(listaUsuarios);
                    Thread.sleep(1000);
                    while (formReg.isActive()) 
                        Thread.sleep(1000);
                    break;
                }
                case 0: {
                    System.out.println("Adios");
                    break;
                }
                default: {
                    System.out.println("Opcion invalida");
                    break;
                }
            }
        }
    }
}
 