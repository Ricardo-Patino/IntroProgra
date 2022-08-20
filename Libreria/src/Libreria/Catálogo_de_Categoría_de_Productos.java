
package Libreria;

import java.awt.TextArea;
import javax.swing.JOptionPane;
public class Catálogo_de_Categoría_de_Productos {
    clsFunciones clsF = new clsFunciones();
    
    
    
    
    private int IDCat;
    private String nombreCategoria;
    private String caracteristicas;
    private char estado=' ';  
    
    
    
    public Catálogo_de_Categoría_de_Productos(int IDCat,String nombreCategoria, String caracteristicas, char estado) {
    this.IDCat = IDCat;
    this.nombreCategoria = nombreCategoria;
    this.caracteristicas = caracteristicas;
    this.estado = estado;
    }

    public Catálogo_de_Categoría_de_Productos() {
    }

    public int getIDCat() {
        return IDCat;
    }
    
    public void setIDCat(int IDCat) {
        this.IDCat = IDCat;
    }
    
    public String getNombreCategoria() {
        return nombreCategoria;
    }
    
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getEstado() {
        switch (estado) {
            case 'A':
                return "Activa";
            case 'I':
                return "Inactiva";
            
            default:
                return "En proceso de asignación";
    }
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    public void agregarCatAdmin(Catálogo_de_Categoría_de_Productos categorias[]) {
        int IDCat=0;
        String nombreCategoria = "General";
        String caracteristicas = "Categoría por defecto para guardar productos iniciales";

       
        estado = 'A';
        Catálogo_de_Categoría_de_Productos nuevaCat = new Catálogo_de_Categoría_de_Productos(IDCat,nombreCategoria,caracteristicas,estado);
        categorias[0] = nuevaCat;

    
        }

    public void agregarCat(Catálogo_de_Categoría_de_Productos categorias[], int cantC){
        int IDCat= clsF.recibeInt("Digite el ID de la categoría");
        String nombreCategoria = clsF.recibeString("Digite el nombre de la categoría");
        String caracteristicas = clsF.recibeString("Digite una descripción o características");

        do {
            estado = clsF.recibeChar("Digite el estado que tendrá la categoría"
                    + "\n-Activa\n-Inactiva");
         } while (estado != 'A' && estado != 'I');
        
      
        Catálogo_de_Categoría_de_Productos nuevaCat = new Catálogo_de_Categoría_de_Productos(IDCat,nombreCategoria,caracteristicas,estado);
        categorias[cantC] = nuevaCat;
    }
    
    public void consultarCat(Catálogo_de_Categoría_de_Productos categorias[], int cantC){
        
        int buscar = clsF.recibeInt("Digite el ID de la categoría a consultar");
        
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantC; i++) {
            if (categorias[i].getIDCat() == buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias, puede que la categoría a buscar no exista");
        } else {
            clsF.imprimeMensaje("\nID de la categoría: "+categorias[posBuscar].getIDCat()
                                + "\nNombre de la categoría: "+categorias[posBuscar].getNombreCategoria()
                                + "\nCaracterísticas: "+categorias[posBuscar].getCaracteristicas()
                                + "\nEstado "+categorias[posBuscar].getEstado()
                                );
        }
    }
    
    public int editarCat(Catálogo_de_Categoría_de_Productos categorias[], int cantC){
        int buscar = clsF.recibeInt("Digite el ID de la categoría");
        
        if (buscar == 0){
            clsF.imprimeMensaje("No se puede editar la categoría 'General'");
            return 0;
        }
        
        
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantC; i++) {
            if (categorias[i].getIDCat() == buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        } else {
            int opcion;
        
            do {
                opcion = clsF.recibeInt("Digite el número correspondiente al valor a editar en el usuario seleccionado: "
                        + "\n1- ID de la categoría"
                        + "\n2- Nombre de categoría"
                        + "\n3- Características"
                        + "\n4- Estado"
 
                        + "\n5- Salir");
                switch (opcion) {
                    case 1:
                        categorias[posBuscar].setIDCat(clsF.recibeInt("Digite el nuevo ID de categoría"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;
                    case 2:
                        
                        categorias[posBuscar].setNombreCategoria(clsF.recibeString("Digite el nuevo nombre"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        
                        break;
                    case 3:
                        categorias[posBuscar].setCaracteristicas(clsF.recibeString("Digite las nuevas características"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;
                   
                    case 4:
                        do {
                            estado = clsF.recibeChar("Digite el estado que tendrá la categoría"
                                    + "\n-Activa\n-Inactiva");
                         } while (estado != 'A' && estado != 'I');
                        categorias[posBuscar].setEstado(estado);
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;
                  
                    case 5:
                        
                        break;    
                        
                        
                    default:
                        clsF.imprimeMensaje("Opción no válida");
                        break;
                }

            } while (opcion != 5);
    }
        return 0;
    }    
    
    public int eliminarCat(Catálogo_de_Categoría_de_Productos categorias[], int cantC){
        
        int buscar = clsF.recibeInt("Digite el ID de la categoría que desea eliminar");
        if (buscar == 0){
            clsF.imprimeMensaje("No se puede eliminar la categoría 'General'");
            return cantC;
        }
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantC; i++) {
            if (categorias[i].getIDCat()== buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        } else {
            for (int i = posBuscar; i < cantC-1; i++) {
                categorias[i] = categorias[i+1];
            }
            categorias[cantC-1] = null;
            
            clsF.imprimeMensaje("Categoría eliminada correctamente");
            return cantC-1;
    }
        return cantC;
        
    }
    
    public int activarCat(Catálogo_de_Categoría_de_Productos categorias[], int cantC){
       int buscar = clsF.recibeInt("Digite el ID de la categoría que desea activar");
        
       if (buscar == 0){
            clsF.imprimeMensaje("No se puede editar la categoría 'General'");
            return 0;
        }
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantC; i++) {
            if (categorias[i].getIDCat()== buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        } else {
            categorias[posBuscar].setEstado('A');
            clsF.imprimeMensaje("Categoría activada correctamente");
    } 
        return 0;
    }
    
    public int inactivarCat(Catálogo_de_Categoría_de_Productos categorias[], int cantC){
       int buscar = clsF.recibeInt("Digite el ID de la categoría que desea desactivar");
        
       if (buscar == 0){
            clsF.imprimeMensaje("No se puede editar la categoría 'General'");
            return 0;
        }
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantC; i++) {
            if (categorias[i].getIDCat()== buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        } else {
            categorias[posBuscar].setEstado('I');
            clsF.imprimeMensaje("Categoría desactivada correctamente");
    } 
        return 0;
    }

}