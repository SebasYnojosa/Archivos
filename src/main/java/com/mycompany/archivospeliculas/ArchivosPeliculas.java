/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.archivospeliculas;

import com.mycompany.archivospeliculas.formularios.Frm_AgregarPelicula;
import com.mycompany.archivospeliculas.formularios.Frm_RegistrarUsuario;
import java.util.Scanner;

/**
 *
 * @author emili
 */
public class ArchivosPeliculas {

    public static void menuPeliculas(Usuario usuario, Scanner myScanner) {
        ColeccionPeliculas coleccionActual = new ColeccionPeliculas(usuario.getArchivoURL());
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("1. Agregar pelicula");
            System.out.println("2. Mostrar peliculas");
            System.out.println("3. Eliminar pelicula");
            System.out.println("4. Ordenar peliculas por nombre");
            System.out.println("5. Ordenar peliculas por duracion");
            System.out.println("6. Buscar pelicula por ID");
            System.out.println("7. Vaciar coleccion");
            System.out.println("0. Cerrar sesion");
            opcion = myScanner.nextInt();
            myScanner.nextLine();

            switch (opcion) {
                case 1: {
//                    System.out.print("Ingrese el identificador de la pelicula: ");
//                    int identificador = myScanner.nextInt();
//                    myScanner.nextLine();
//                    System.out.print("Ingrese el nombre de la pelicula: ");
//                    String nombre = myScanner.nextLine();
//                    System.out.print("Ingrese el nombre del actor principal: ");
//                    String actorPrincipal = myScanner.nextLine();
//                    System.out.print("Ingrese el genero de la pelicula: ");
//                    String genero = myScanner.nextLine();
//                    System.out.print("Ingrese la duracion de la pelicula: ");
//                    int duracion = myScanner.nextInt();
//                    coleccionActual.agregar(new Pelicula(identificador, nombre, actorPrincipal, genero, duracion));
                    Frm_AgregarPelicula form = new Frm_AgregarPelicula(coleccionActual);
                    break;
                }
                case 2: {
                    coleccionActual.mostrarFor();
                    break;
                }
                case 3: {
                    System.out.print("Ingrese el identificador de la pelicula a eliminar: ");
                    int identificador = myScanner.nextInt();
                    coleccionActual.eliminar(identificador);
                    break;
                }
                case 4: {
                    coleccionActual.mostrarOrdenadoPorNombre();
                    break;
                }
                case 5: {
                    coleccionActual.mostrarOrdenadoPorDuracionInverso();
                    break;
                }
                case 6: {
                    System.out.print("Ingrese el identificador de la pelicula a buscar: ");
                    int id = myScanner.nextInt();
                    coleccionActual.buscarPorID(id);
                    break;
                }
                case 7: {
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

    public static void main(String[] args) {
        ListaUsuarios listaUsuarios = new ListaUsuarios();
        Usuario usuarioActual = null;
        Scanner myScanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            usuarioActual = null;
            System.out.println("1. Iniciar sesion");
            System.out.println("2. Registrarse");
            System.out.println("0. Salir");
            opcion = myScanner.nextInt();
            myScanner.nextLine();

            switch (opcion) {
                case 1: {
                    System.out.print("Nombre de usuario: ");
                    String nombre = myScanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contraseña = myScanner.nextLine();
                    usuarioActual = listaUsuarios.iniciarSesion(nombre, contraseña);
                    if (usuarioActual != null) {
                        System.out.println("Se inicio sesion como " + usuarioActual.getNombre());
                        menuPeliculas(usuarioActual, myScanner);
                    }
                    else 
                        System.out.println("Nombre o contraseña incorrectos");
                    break;
                }
                case 2: {
                    Frm_RegistrarUsuario formReg = new Frm_RegistrarUsuario(listaUsuarios);
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
