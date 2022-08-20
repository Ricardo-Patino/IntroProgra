/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

/**
 *
 * @autor Grupo 2
 */
import javax.swing.JOptionPane;
public class Facturas {



 

//--------------------------------------------------------------------------------------------------
clsFunciones clsF = new clsFunciones();

    


    private int IDFactu;
    private String nombreClient;
    private String fechaFactura;
    private int cantidad;
    private float precio;
    private String produVendido;
    private float preciototal;
    private float impuesto=0.13f;
    private boolean registrado;
    private int registroCliDiario=0;
    private int registroCliTotal=0;
    private float sumaMontosDiarios=0;
    private float sumaMontosTotales=0;
    
    public Facturas(int IDFactu,String nombreClient,String fechaFactura,int cantidad,float precio
            ,float preciototal,String produVendido,boolean registrado,int registroCliDiario, int registroCliTotal
      ,float sumaMontosDiarios, float sumaMontosTotales){
    this.fechaFactura=fechaFactura;
   
    this.IDFactu=IDFactu;
    this.nombreClient=nombreClient;
    this.precio=precio;
    this.produVendido=produVendido;
    this.registrado=registrado;
    this.preciototal=preciototal;
    this.cantidad=cantidad;
  
    this.registroCliDiario=registroCliDiario;
    this.registroCliTotal=registroCliTotal;
    this.sumaMontosDiarios=sumaMontosDiarios;
    
    }
    
    
    public Facturas(){
        
    }

    public String getNombreClient() {
        return nombreClient;
    }

    public void setNombreClient(String nombreClient) {
        this.nombreClient = nombreClient;
    }
    
    public String getproduVendido() {
        return produVendido;
    }

    public void setproduVendido(String produVendido) {
        this.produVendido = produVendido;
    }

    public int getIDFactu() {
        return IDFactu;
    }

    public void setIDFactu(int IDFactu) {
        this.IDFactu = IDFactu;
    }

    public int getregistroCliDiario() {
        return registroCliDiario;
    }

    public void setregistroCliDiario(int registroCliDiario) {
        this.registroCliDiario = registroCliDiario;
    }
    
    public int getregistroCliTotal() {
        return registroCliTotal;
    }

    public void setregistroCliTotal(int registroCliTotal) {
        this.registroCliTotal = registroCliTotal;
    }
    
    public float getsumaMontosDiarios() {
        return sumaMontosDiarios;
    }

    public void setsumaMontosDiarios(float sumaMontosDiarios) {
        this.sumaMontosDiarios = sumaMontosDiarios;
    }
    
    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(float preciototal) {
        this.preciototal = preciototal;
    }
    
    public float getsumaMontosTotales() {
        return sumaMontosTotales;
    }

    public void setsumaMontosTotales(float sumaMontosTotales) {
        this.sumaMontosTotales = sumaMontosTotales;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    public boolean getRegistrado() {
        return registrado;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }   
    
    
    
    
    
    
    public boolean crearFactura(Facturas facturas[],int cantF, Usuario usuarios[], int cantU, Catálogo_de_Productos productos[], int cantP){
        
        
        IDFactu=cantF+1; 
        
        fechaFactura = clsF.recibeString("Digite la fecha de la venta");
        
        //Validar el producto a vender
        
        int buscar = clsF.recibeInt("Digite el ID del producto");
        
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantU; i++) {
            if (productos[i].getIdLibro()== buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("Producto no existente");
            return false;
        }else if (productos[posBuscar].getEstado().equalsIgnoreCase("Inactivo")){
            clsF.imprimeMensaje("Producto no disponible, está inactivo");
            return false;
        }else if (productos[posBuscar].getCantiExis()==0){
            clsF.imprimeMensaje("Producto no disponible, está agotado");
            return false;
        }
        else {        
        
            
            produVendido= productos[posBuscar].getTitulo();
        }
        
         
        while (true){ //Ciclo que resta la cantidad de productos que se vayan a comprar
        cantidad = clsF.recibeInt("Digite la cantidad de productos a comprar");
            if (cantidad>productos[posBuscar].getCantiExis()){
               clsF.imprimeMensaje("Cantidad de productos no disponible, quedan solo: "+productos[posBuscar].getCantiExis()); 
               
            }else{
               productos[posBuscar].setCantiExis(productos[posBuscar].getCantiExis()-cantidad); 
               break;
            }
            
        }
    
        precio=productos[posBuscar].getPrecioUni()*cantidad;        
        preciototal =precio+(precio*impuesto);
        
        
        /////////////Validacion de si el usuario está registrado o no
        int buscar2 = clsF.recibeInt("Digite el número de cédula del cliente");
        
        int posBuscar2 = -1;
        
        
        for (int i = 0; i < cantU; i++) {
            if (usuarios[i].getID() == buscar2 ) {
                posBuscar2 = i;
                break;
            }
        }
            
            
        if (posBuscar2 == -1) {
            registrado = false;
            nombreClient = clsF.recibeString("Cliente no registrado, por favor digite el nombre del cliente");
        } else {        
        
            registrado = true;
            nombreClient= usuarios[posBuscar2].getNombre();
        }
        
        registroCliDiario++;
        registroCliTotal++;
        sumaMontosDiarios+=preciototal;
        sumaMontosTotales+=preciototal; 
        
        
        
        
        Facturas nuevaFact = new Facturas(IDFactu,nombreClient,fechaFactura,cantidad,precio,
            preciototal,produVendido,registrado,registroCliDiario,registroCliTotal,sumaMontosDiarios,sumaMontosTotales);
        facturas[cantF] = nuevaFact;

      
        
        clsF.imprimeMensaje("Los datos de la factura son los siguientes"

                                + "\nID de la factura: "+facturas[posBuscar].getIDFactu()
                                + "\nNombre de cliente: "+facturas[posBuscar].getNombreClient()
                                + "\nFecha de venta: "+facturas[posBuscar].getFechaFactura()
                                + "\nProducto comprado de título: "+facturas[posBuscar].getproduVendido()
                                + "\nCantidad comprada: "+facturas[posBuscar].getCantidad()
                                + "\nPrecio sin impuesto: "+facturas[posBuscar].getPrecio()
                                + "\nPrecio total pagado: "+facturas[posBuscar].getPreciototal()                               
                                );
        
        
        
        return true;
   
        
    }
    
    
    
     
    
    public  int anularFactura(Facturas facturas[], int cantF){
        int buscar = clsF.recibeInt("Digite el ID de la factura que desea anular");
        
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantF; i++) {
            if (facturas[i].getIDFactu()== buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias entre las facturas existentes");
            return cantF;
        } else {
            for (int i = posBuscar; i < cantF-1; i++) {
                facturas[i] = facturas[i+1];
            }
            facturas[cantF-1] = null;
            
            clsF.imprimeMensaje("Factura anulada correctamente");
            return cantF-1;
    }
        
        
    }   
    
    public void mostrarFactura(Facturas facturas[], int cantF){
        int buscar = clsF.recibeInt("Digite el ID de la factura que desea buscar");
        
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantF; i++) {
            if (facturas[i].getIDFactu()== buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias, puede que el usuario a buscar no exista");
        } else {
            clsF.imprimeMensaje("Los datos de la factura son los siguientes"

                                + "\nID de la factura: "+facturas[posBuscar].getIDFactu()
                                + "\nNombre de cliente: "+facturas[posBuscar].getNombreClient()
                                + "\nFecha de venta: "+facturas[posBuscar].getFechaFactura()
                                + "\nProducto comprado de título: "+facturas[posBuscar].getproduVendido()
                                + "\nCantidad comprada: "+facturas[posBuscar].getCantidad()
                                + "\nPrecio sin impuesto: "+facturas[posBuscar].getPrecio()
                                + "\nPrecio total pagado: "+facturas[posBuscar].getPreciototal()                               
                                );
        }
    }
    
    public void finalizardía(){
        registroCliDiario=0;
        sumaMontosDiarios=0;
    }
}