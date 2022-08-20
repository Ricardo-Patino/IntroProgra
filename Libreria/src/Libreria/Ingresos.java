/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

/**
 *
 * @author Racha
 */
import javax.swing.JOptionPane; 
public class Ingresos {
    Facturas clsFac=new Facturas();
    clsFunciones clsF = new clsFunciones();
    
    
    
    public void mostrarIngresosDiarios(){
        
       float montoD=clsFac.getsumaMontosDiarios();
       clsF.imprimeMensaje("Los ingresos DIARIOS actuales son de: "+montoD);
        
    }
    
    
    public void mostrarIngresosTotales(){
        
        float montoT=clsFac.getsumaMontosTotales();
       clsF.imprimeMensaje("Los ingresos TOTALES actuales son de: "+montoT);
        
        
    }
    
    public void mostrarCantClientes(){
        
        int clientes=clsFac.getregistroCliTotal();
       clsF.imprimeMensaje("La cantidad de clientes totales que compraron son de: "+clientes);
        
    }
       
  
    
}


