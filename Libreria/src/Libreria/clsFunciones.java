package Libreria;
import java.awt.TextArea;
import javax.swing.JOptionPane;
public class clsFunciones {
    public int recibeInt(String mensaje){
        return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
    }
    public String recibeString(String mensaje){
        return JOptionPane.showInputDialog(mensaje);
    }
    public char recibeChar(String mensaje){
        return JOptionPane.showInputDialog(mensaje).toUpperCase().charAt(0);
    }
    public void imprimeMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public void imprimeMensaje(TextArea mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public float recibeFloat(String mensaje){
        return Float.parseFloat(JOptionPane.showInputDialog(mensaje));
    }
    //public void recibeboolean(String mensaje){
    //   JOptionPane.showInputDialog(mensaje);
       
    //}

}
