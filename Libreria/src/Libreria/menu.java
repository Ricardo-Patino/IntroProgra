
package Libreria;

import javax.swing.JOptionPane;
public class menu {
    clsFunciones clsF = new clsFunciones();
    public void menuPrincipal(){
        char roles=' '; //Esta variable sirve para guardar el rol del usuario al ingresarlo, en la clase menú

        int cantU = 1; //Cantidad de usuarios
        int cantC = 1; //Cantidad de categorias
        int cantP = 1; //Cantidad de productos
        int cantF =0; //Cantidad de facturas
        int cantClientes=0;
        int cantEmpleados=1;
        boolean agregar=false; //controlador de que se agregue un usuario
        boolean agregarFact=false; //controlador de que se agregue una factura minimo 
        
        //Objetos de cada clase
        Usuario clsU=new Usuario();
        Facturas clsFac=new Facturas();
        Usuario usuarios[] = new Usuario[50];
        Ingresos clsIngre=new Ingresos();
        Catálogo_de_Productos clsP = new Catálogo_de_Productos();
        Catálogo_de_Categoría_de_Productos clsC= new Catálogo_de_Categoría_de_Productos();
        
        //Crear cadenas para las categorias existentes, los productos a ingresar y las facturas a crear
        Catálogo_de_Productos productos[] = new Catálogo_de_Productos[100];
        Catálogo_de_Categoría_de_Productos categorias[] = new Catálogo_de_Categoría_de_Productos[10];
        Facturas facturas[]=new Facturas[20000];
        
       
        
        
        //Creacion de usuario 1 ADMIN
        
        clsU.agregarAdmin(usuarios);
        
        
        //Creacion de categoria 1 ADMIN
        
        clsC.agregarCatAdmin(categorias);
        
        //Creacion de producto 1 ADMIN
        
        clsP.agregarProduAdmin(productos, categorias);
        
        byte opc;
        byte cont=1;
        
        char opcion = ' ';

        while (cont==1){
            //menú principal
        opc=Byte.parseByte(JOptionPane.showInputDialog(null, "Digite el número correspondiente a la opción del menú a consultar:"
                        + "\n1-Usuarios"
                        + "\n2-Menú productos "
                        + "\n3-Menú categorías"
                        + "\n4-Menú facturas"
                        + "\n5-Ver ingresos diarios y totales"
                        + "\n6-Ver cantidad total de clientes"
                        + "\n7-Salir del menú y programa"));
            switch (opc){
                case 1://pertenece al menú principal
                    //menú de usuarios
                    byte contMenuUsuarios=0;
                    while (contMenuUsuarios==0){
                    opcion=JOptionPane.showInputDialog(null,
                            "Digite la letra correspondiente a la opción del menú a realizar:"
                            + "\nA-Agregar usuarios (Empleados o Clientes)"
                            + "\nB-Consultar un usuario"
                            + "\nC-Editar un usuario"
                            + "\nD-Eliminar un usuario"
                            + "\nE-Activar un usuario"
                            + "\nF-Inactivar un usuario"
                            + "\nG-Salir del menú 'Usuarios'").toUpperCase().charAt(0);
                        switch (opcion){
                            case 'A':
                                Usuario oj1 = new Usuario();

                                roles=oj1.getrol();
                               if (roles=='E'){
                                   if (cantEmpleados < (usuarios.length/2)) {
                                       agregar = clsU.agregarUsuario(usuarios, cantU, roles);

                                       if (agregar) {
                                      

                                       clsF.imprimeMensaje("El usuario se registró correctamente");
                                       cantEmpleados++;
                                       cantU++;
                                       }

                                   }
                               }
                               else if (roles=='C'){
                                           if (cantClientes < (usuarios.length/2)) {
                                               agregar = clsU.agregarUsuario(usuarios, cantU, roles);
                                               if (agregar) {
                                               

                                           clsF.imprimeMensaje("El usuario se registró correctamente");
                                           cantClientes++;
                                           cantU++;
                                           }

                                           }
                                       }
                               else{
                                   clsF.imprimeMensaje("Ha llegado al límite de personas que ingresar");
                                   }        

                               break; 




                            case 'B':

                               
                                 clsU.consultarUsuario(usuarios, cantU);
                                

                                break;
                            case 'C':
                               
                                 clsU.editarUsuario(usuarios, cantU);
                                
                                break;
                            case 'D':
                                
                                 cantU=clsU.eliminarUsuario(usuarios, cantU);
                                
                                break;
                                
                            case 'E':
                              
                                clsU.activarUsuario(usuarios, cantU);
                               
                                break;
                            case 'F':
                               
                                clsU.inactivarUsuario(usuarios, cantU);
                                
                                break;
                            case 'G':
                                contMenuUsuarios=1;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null,"Opción incorecta, debe digitar una letra según el menú");
                            break;   
                        } 
                    }
                    break;    
                case 2://pertenece al menú principal
                    //menu de productos
                    byte contMenuProductos=0;
                    while (contMenuProductos==0){
                    opc=Byte.parseByte(JOptionPane.showInputDialog(null, "Digite el número correspondiente a la opción del menú a realizar:"
                        + "\n1-Agregar un producto"
                        + "\n2-Consultar producto"
                        + "\n3-Editar producto"
                        + "\n4-Eliminar producto"
                        + "\n5-Activar producto"
                        + "\n6-Inactivar producto"
                        + "\n7-Salir del menú 'Menú productos'"));
                            
                    switch (opc){
                     case 1:
                         
                        if (cantP<productos.length){
                            clsP.agregarProdu(productos,categorias, cantP,cantC);
                            cantP++; 
                            clsF.imprimeMensaje("Producto añadido con éxito");
                        }  
                        else{
                        clsF.imprimeMensaje("Ha llegado al limite de productos para ingresar de 99");
                                   } 
                        break;
                     case 2:
                        clsP.consultarProducto(productos, cantP);
                        break;
                     case 3:
                        clsP.editarProdu(productos, categorias, cantP, cantC);
                        break;
                     case 4:
                         cantP=clsP.eliminarProdu(productos, cantP);
                        
                     case 5:
                         clsP.activarProdu(productos, cantP);
                        break;
                     case 6:
                        clsP.inactivarProdu(productos, cantP);
                        break;   
                        
                     case 7:
                        contMenuProductos=1;
                        break;    
                        
                     default :
                    JOptionPane.showMessageDialog(null, "La opción digitada es incorrecta");
                    break;
                    }
                    }
                    break;
                case 3://pertenece al menú principal
                    //Menu Categorias
                    
                    byte contMenuCategorias=0;
                    while (contMenuCategorias==0){
                    opc=Byte.parseByte(JOptionPane.showInputDialog(null, "Digite el número correspondiente a la opción del menú a realizar:"
                        + "\n1-Agregar una categoría"
                        + "\n2-Consultar categoría"
                        + "\n3-Editar categoría"
                        + "\n4-Eliminar categoría"
                        + "\n5-Activar categoría"
                        + "\n6-Inactivar categoría"
                        + "\n7-Salir del menú 'Menú categoría'"
                            + ""));
                    switch (opc){
                     case 1:
                         
                        if (cantC<categorias.length){
                            clsC.agregarCat(categorias, cantC);
                            cantC++; 
                            clsF.imprimeMensaje("Categoría añadida con éxito");
                        }  
                        else{
                        clsF.imprimeMensaje("Ha llegado al limite de categorías para ingresar de 9");
                                   } 
                        break;
                     case 2:
                        clsC.consultarCat(categorias, cantC);
                        break;
                     case 3:
                        clsC.editarCat(categorias, cantC);
                        break;
                     case 4:
       
                        cantC= clsC.eliminarCat(categorias, cantC);
                     case 5:
                        clsC.activarCat(categorias, cantC);
                        break;
                     case 6:
                        clsC.inactivarCat(categorias, cantC);
                        break;   
                        
                     case 7:
                        contMenuCategorias=1;
                        break;    
                        
                     default :
                    JOptionPane.showMessageDialog(null, "La opción digitada es incorrecta");
                    break;
                    }
                    }
                    
                    
                    
                    break;
                case 4://pertenece al menú principal
                    //Facturas
                    
                    byte contMenuFacturas=0;
                    while (contMenuFacturas==0){
                    opc=Byte.parseByte(JOptionPane.showInputDialog(null, "Digite el número correspondiente a la opción del menú a realizar:"
                        + "\n1-Crear factura/venta"
                        + "\n2-Anular factura"
                        + "\n3-Consultar factura"
                        + "\n4-Finalizar día (Reinicia los variables de ingresos y clientes diarios)"
                        + "\n5-Salir del menú 'Menú facturas'"
                            + ""));
                    switch (opc){
                     case 1:
                         
                        
                        if (cantF < facturas.length) {
                            agregarFact = clsFac.crearFactura(facturas, cantF, usuarios, cantU, productos, cantP);
                            
                            if (agregarFact) {


                            clsF.imprimeMensaje("La factura se agregó correctamente");
                            cantF++;
                            }

                               }
                        
                        else{
                        clsF.imprimeMensaje("Ha llegado al límite de facturas de 20000");
                                   } 
                        break;
                     case 2:
                        if (agregarFact) {
                            cantF=clsFac.anularFactura(facturas, cantF);
                             }else{
                            clsF.imprimeMensaje("Debe ingresar al menos una factura para poder hacer consultas");
                        }
 
                        
                        break;
                     case 3:
                        if (agregarFact) {
                             clsFac.mostrarFactura(facturas, cantF);
                             }else{
                            clsF.imprimeMensaje("Debe ingresar al menos una factura para poder hacer consultas");
                        }
                        break;
                     case 4:
       
                        if (agregarFact) {
                                clsFac.finalizardía();
                             }else{
                            clsF.imprimeMensaje("Debe ingresar al menos una factura para poder hacer consultas");
                        }
                     
                     case 5:
                        contMenuFacturas=1;
                        break;    
                        
                     default :
                    JOptionPane.showMessageDialog(null, "La opción digitada es incorrecta");
                    break;
                    }
                    }
                    
                    
                    
                    break;
                case 5://pertenece al menú principal
                //5-Ver ingresos diarios y totales
                    clsIngre.mostrarIngresosDiarios();
                    clsIngre.mostrarIngresosTotales();
                    break;
                case 6://pertenece al menú principal
                //6-Ver cant de clientes
                    clsIngre.mostrarCantClientes();
                    break;
                case 7://pertenece al menú principal
                    
                    cont=0;
                    JOptionPane.showMessageDialog(null, "Gracias por usar nuestro programa");
                    break;
                default :
                    JOptionPane.showMessageDialog(null, "La opción digitada es incorrecta");
                    break;
               

            }


}
}
    }



            
        
    

