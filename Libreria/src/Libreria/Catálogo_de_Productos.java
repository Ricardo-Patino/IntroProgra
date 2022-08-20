
package Libreria;
import javax.swing.JOptionPane;
public class Catálogo_de_Productos {
      clsFunciones clsF = new clsFunciones();
    
    private int idLibro;
    private String titulo;
    private String autor;
    private String categoria;
    private String descrip;
    private int cantiExis;
    private float precioUni;
    private char estado=' ';
    
    public Catálogo_de_Productos(int idLibro,String titulo,String autor,String categoria
            ,String descrip,int cantiExis,float precioUni,char estado) {
    this.idLibro = idLibro;
    this.titulo = titulo;
    this.autor= autor;
    this.categoria = categoria;
    this.descrip = descrip;
    this.cantiExis= cantiExis;
    this.precioUni = precioUni;
    this.estado=estado;
    }
    public Catálogo_de_Productos() {
    }
    public int getIdLibro() {
        return idLibro;
    }
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getDescrip() {
        return descrip;
    }
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    public int getCantiExis() {
        return cantiExis;
    }
    public void setCantiExis(int cantiExis) {
        this.cantiExis = cantiExis;
    }
    public float getPrecioUni() {
        return precioUni;
    }
    public void setPrecioUni(float precioUni) {
        this.precioUni = precioUni;
    }
    public String getEstado() {
        
        switch (estado) {
            case 'A':
                return "Activo";
            case 'I':
                return "Inactivo";
            
            default:
                return "En proceso de asignación";
        }

    
    } 
    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    
    public void agregarProduAdmin(Catálogo_de_Productos productos[],Catálogo_de_Categoría_de_Productos categorias[]) {
        
        
        idLibro=0;
        titulo="Introducción a la librería 'El Tesoro del Saber'";
        autor="Librería 'El Tesoro del Saber'";

        categoria= categorias[0].getNombreCategoria();
        descrip="Producto inicial de la librería";
        cantiExis= 1000;
        precioUni=(float)1500;
        estado = 'A';
        
        
        Catálogo_de_Productos nuevoPro = new Catálogo_de_Productos(idLibro,titulo,autor,
                categoria, descrip, cantiExis, precioUni, estado);
        productos[0] = nuevoPro;

    
        }
  
    public void agregarProdu(Catálogo_de_Productos productos[],Catálogo_de_Categoría_de_Productos categorias[],int cantP, int cantC) {
        
        
        idLibro=clsF.recibeInt("Digite el ID del libro");
        titulo=clsF.recibeString("Digite el título del libro");
        autor=clsF.recibeString("Digite el nombre del autor");
        
        while(true){
        int buscar = clsF.recibeInt("Digite el ID de la categoría a la que pertenecerá el libro");
        
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
              categoria= categorias[posBuscar].getNombreCategoria();
              break;
            }
        }

        descrip=clsF.recibeString("Digite la descripción del producto");;
        cantiExis=clsF.recibeInt("Digite la cantidad que ingresarán de ese producto");
        precioUni=clsF.recibeFloat("Digite el precio del producto");

        do {
            estado = clsF.recibeChar("Digite el estado que tendrá el producto"
                    + "\n-Activo\n-Inactivo");
         } while (estado != 'A' && estado != 'I');
        
        
        Catálogo_de_Productos nuevoPro = new Catálogo_de_Productos(idLibro,titulo,autor,
                categoria, descrip, cantiExis, precioUni, estado);
        productos[cantP] = nuevoPro;

    
        }   

    public void consultarProducto(Catálogo_de_Productos productos[], int cantP){
        
        int buscar = clsF.recibeInt("Digite el ID del libro que desea buscar");
        
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantP; i++) {
            if (productos[i].getIdLibro()== buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        } else {
            clsF.imprimeMensaje("ID del libro: "+productos[posBuscar].getIdLibro()
                                + "\nTítulo: "+productos[posBuscar].getTitulo()
                                + "\nAutor: "+productos[posBuscar].getAutor()
                                + "\nCategoría: "+productos[posBuscar].getCategoria()
                                + "\nDescripcion: "+productos[posBuscar].getDescrip()
                                + "\nCantidad existente: "+productos[posBuscar].getCantiExis()+" unidades"
                                + "\nPrecio Unitario: "+productos[posBuscar].getPrecioUni()+" colones"
                                + "\nEstado: "+productos[posBuscar].getEstado()
                                + "");
        }
    }
   
    public void editarProdu(Catálogo_de_Productos productos[],Catálogo_de_Categoría_de_Productos categorias[],int cantP, int cantC){
        int buscar = clsF.recibeInt("Digite el ID del producto a editar");
        
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantP; i++) {
            if (productos[i].getIdLibro()== buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        } else {
            int opcion;
        
            do {
                opcion = clsF.recibeInt("Digite el número correspondiente al valor a editar en el libro seleccionado: "
                        + "\n1- ID del libro"
                        + "\n2- Título del libro"
                        + "\n3- Autor"
                        + "\n4- Categoria"
                        + "\n5- Descripción"
                        + "\n6- Cantidad existente"
                        + "\n7- Precio unitario"
                        + "\n8- Estado"
 
                        + "\n9- Para salir de 'editar producto'");

    
                switch (opcion) {
                    case 1:
                        productos[posBuscar].setIdLibro(clsF.recibeInt("Digite el nuevo ID del libro"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;
                    case 2:
                        
                        productos[posBuscar].setTitulo(clsF.recibeString("Digite el nuevo Título"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        
                        break;
                    case 3:
                        productos[posBuscar].setAutor(clsF.recibeString("Digite el autor"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;
                   
                    case 4:
                        while(true){
                            int buscarCat = clsF.recibeInt("Digite el ID de la categoría a la que pertenecerá el libro");

                                int posBuscarCat = -1;


                                for (int i = 0; i < cantC; i++) {
                                    if (categorias[i].getIDCat() == buscarCat ) {
                                        posBuscarCat = i;
                                        break;
                                    }
                                }


                                if (posBuscarCat == -1) {
                                    clsF.imprimeMensaje("No se encontraron coincidencias, puede que la categoría a buscar no exista");
                                } else {
                                  categoria= categorias[posBuscarCat].getNombreCategoria();
                                  break;
                                }
                            }
                        break;
                  
                    case 5:
                        productos[posBuscar].setDescrip(clsF.recibeString("Digite la nueva descripción"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;    
                    case 6:
                        productos[posBuscar].setCantiExis(clsF.recibeInt("Digite la nueva cantidad existente"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break; 
                    case 7:
                        productos[posBuscar].setPrecioUni(clsF.recibeFloat("Digite el nuevo precio unitario"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;
                    case 8:
                        
                        if (productos[posBuscar].getIdLibro()==0){
                            clsF.imprimeMensaje("No puede cambiar el estado del producto inicial");
                        }else{
                            do {
                            estado = clsF.recibeChar("Digite el estado que tendrá el producto"
                                    + "\n-Activo\n-Inactivo");
                         } while (estado != 'A' && estado != 'I');
                        productos[posBuscar].setEstado(estado);
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        }
                        break; 
                    case 9:
                        
                        break; 
                        
                    default:
                        clsF.imprimeMensaje("Opción no válida");
                        break;
                }

            } while (opcion != 9);
    }
        
    }    
    
    public int eliminarProdu(Catálogo_de_Productos productos[], int cantP){
        
        int buscar = clsF.recibeInt("Digite el ID del libro que desea eliminar");
        if (buscar == 0){
            clsF.imprimeMensaje("No se puede eliminar el producto 'Inicial'");
            return cantP;
        }
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantP; i++) {
            if (productos[i].getIdLibro()== buscar ) {
                posBuscar = i;
                break;
            }
        }
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        } else {
            for (int i = posBuscar; i < cantP-1; i++) {
                productos[i] = productos[i+1];
            }
            productos[cantP-1] = null;
            
            clsF.imprimeMensaje("Producto eliminado correctamente");
            return cantP-1;
    }
        return cantP;
    }  
    
    public void activarProdu(Catálogo_de_Productos productos[], int cantP){
       int buscar = clsF.recibeInt("Digite el ID del producto que desea activar");
       
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantP; i++) {
            if (productos[i].getIdLibro()== buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        } else {
            productos[posBuscar].setEstado('A');
            clsF.imprimeMensaje("Producto activado correctamente");
    } 
      
    }   
    
    public void inactivarProdu(Catálogo_de_Productos productos[], int cantP){
       int buscar = clsF.recibeInt("Digite el ID del producto que desea desactivar");
       
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantP; i++) {
            if (productos[i].getIdLibro()== buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        } else {
            productos[posBuscar].setEstado('I');
            clsF.imprimeMensaje("Producto desactivado correctamente");
    } 
      
    }
}