/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

import javax.swing.JOptionPane;

/**
 *
 * @autores Gregory - Laicy - Ricardo / Grupo 2
 */
public class main {
    public static void main(String[] args) {
     
        
        JOptionPane.showMessageDialog(null,"Bienvenidos a la librería Star");
      JOptionPane.showMessageDialog(null,"Este programa cuenta con la dispobibilidad de afiliar:\n"
              + "-25 usuarios clientes y 24 usuarios Empleados"
              + "\n-Crear 9 Categorías de productos"
              + "\n-Crear 99 Productos con cantidad existente ilimitada");
        
        menu u1=new menu();
        
        u1.menuPrincipal();
      

}
              
              
}
