/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.archivospeliculas.formularios;

import javax.swing.JOptionPane;

/**
 *
 * @author emili
 */
public class Ayuda {
    public static void mensajeError(String msg) {
        JOptionPane.showMessageDialog(null, msg,"Error",JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mensajeExito(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static String construirContraseña(char[] secuencia) {
        StringBuilder conBuilder = new StringBuilder();
        for (char c : secuencia) 
            conBuilder.append(c);
        return conBuilder.toString();
    }
}
