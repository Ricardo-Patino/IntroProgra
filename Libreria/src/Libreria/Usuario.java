
package Libreria;
import javax.swing.JOptionPane;

public class Usuario {
    
    clsFunciones clsF = new clsFunciones();

    private int ID;
    private String nombre;
    private String apellidos;
    private int edad;
    private String ciudad;
    private int telefono;
    private String direccion;
    private String correoE; 
    private char estado=' ';
    private char rol=' ';
    private String nickname;
    private String password;
    
    
    
   

public Usuario(int ID,String nombre, String apellidos, int edad, String ciudad, int telefono,
        String direccion, String correoE, char estado, char rol, String nickname, String password) {
    this.ID= ID;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.edad = edad;
    
    this.ciudad = ciudad;
    this.telefono = telefono;
    this.direccion = direccion;
    this.correoE = correoE;
    
    
    this.estado = estado;
    this.rol = rol;
    
    this.nickname = nickname;
    this.password = password;
    
    }

    public Usuario() {
    }

    public clsFunciones getClsF() {
        return clsF;
    }

    public void setClsF(clsFunciones clsF) {
        this.clsF = clsF;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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
    
    public char getRol() {
        return rol;
    }

    public void setRol(char rol) {
        this.rol = rol;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getCiudad() {
        return ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getnickname() {
        return nickname;
    }

    public void setnickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
     
    public char getrol(){
          do {
            rol = clsF.recibeChar("Digite el tipo del usuario"
                    + "\n-Empleado\n-Cliente");
         } while (rol != 'E' && rol != 'C');
          return rol;
     }
             
    
    
    public void agregarAdmin(Usuario usuarios[]) {
       
        int ID = 12345;
        String nombre = "No definido";
        String apellidos = "No definido";
        int edad = 0;
        String ciudad = "No definido";       
        int telefono = 00000000;
        String direccion = "No definido";
        String correoE = "No definido";
        
        rol='E';
        estado='A';
        
        
        String nickname = "admin";
        String password = "admin";
        
        Usuario nuevoUsuario = new Usuario(ID, nombre, apellidos, edad, ciudad, telefono,
                 direccion, correoE, estado, rol, nickname, password);
        usuarios[0] = nuevoUsuario;

    
        }
    
    public boolean agregarUsuario(Usuario usuarios[], int cantU, char roles) {

        int ID = clsF.recibeInt("Digite el número de cédula");
        String nombre = clsF.recibeString("Digite el nombre");
        String apellidos = clsF.recibeString("Digite los apellidos");
        int edad = clsF.recibeInt("Digite la edad");
        String ciudad = clsF.recibeString("Digite la ciudad de residencia");        
        int telefono = clsF.recibeInt("Digite el número telefónico");
        String direccion = clsF.recibeString("Digite la dirección");
        String correoE = clsF.recibeString("Digite el correo electrónico");
        
        
        rol=roles;
        
        
        
        do {
            estado = clsF.recibeChar("Digite el estado que tendrá el usuario"
                    + "\n-Activo\n-Inactivo");
         } while (estado != 'A' && estado != 'I');
        
        
        String nickname = clsF.recibeString("Digite el nombre de usuario a crear");
        String password = clsF.recibeString("Digite la contraseña para ese usuario");
        
        Usuario nuevoUsuario = new Usuario(ID, nombre, apellidos, edad, ciudad, telefono,
                 direccion, correoE, estado, rol, nickname, password);
        usuarios[cantU] = nuevoUsuario;

        return true;
    
        
        }
 
    public void consultarUsuario(Usuario usuarios[], int cantU){
        
        int buscar = clsF.recibeInt("Digite el número de cédula del usuario que desea buscar");
        
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantU; i++) {
            if (usuarios[i].getID() == buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias, puede que el usuario a buscar no exista");
        } else {
            clsF.imprimeMensaje("\nCédula: "+usuarios[posBuscar].getID()
                                + "\nNombre: "+usuarios[posBuscar].getNombre()
                                + "\nApellidos: "+usuarios[posBuscar].getApellidos()
                                + "\nEdad: "+usuarios[posBuscar].getEdad()
                                + "\nCiudad: "+usuarios[posBuscar].getCiudad()
                                + "\nTeléfono: "+usuarios[posBuscar].getTelefono()
                                + "\nDirección: "+usuarios[posBuscar].getDireccion()
                                + "\nCorreo Electrónico: "+usuarios[posBuscar].getCorreoE()
                                + "\nEstado del usuario: "+usuarios[posBuscar].getEstado()
                                + "\nTipo de usuario: "+usuarios[posBuscar].getRol()
                                + "\nNombre de usuario: "+usuarios[posBuscar].getnickname()
                                + "\nContraseña: "+usuarios[posBuscar].getpassword()
                                );
        }
    }
    
    public int editarUsuario(Usuario usuarios[], int cantU){
        int buscar = clsF.recibeInt("Digite el número de cédula del usuario que desea editar");
        
        if (buscar == 12345){
            clsF.imprimeMensaje("No se puede editar el usuario ADMIN");
            return 0;
        }
        
        
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantU; i++) {
            if (usuarios[i].getID() == buscar ) {
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
                        + "\n1- Cédula"
                        + "\n2- Nombre"
                        + "\n3- Apellidos"
                        + "\n4- Edad"
                        + "\n5- Ciudad"
                        + "\n6- Dirección"
                        + "\n7- Correo electrónico"
                        + "\n8- Teléfono"
                        + "\n9- Estado"
                        + "\n10- Tipo (Empleado / Cliente)"
                        + "\n11- Nombre de usuario"
                        + "\n12- Contraseña"
                       
                        + "\n13- Salir");
                switch (opcion) {
                    case 1:
                        usuarios[posBuscar].setID(clsF.recibeInt("Digite el nuevo número de cédula"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;
                    case 2:
                        
                        usuarios[posBuscar].setNombre(clsF.recibeString("Digite el nuevo nombre"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        
                        break;
                    case 3:
                        usuarios[posBuscar].setApellidos(clsF.recibeString("Digite los nuevos apellidos"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;
                    case 4:
                        usuarios[posBuscar].setEdad(clsF.recibeInt("Digite la nueva edad"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        
                        break;
                    case 5:
                        usuarios[posBuscar].setCiudad(clsF.recibeString("Digite la nueva ciudad"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;
                    case 6:
                        usuarios[posBuscar].setDireccion(clsF.recibeString("Digite la nueva dirección"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;
                    case 7:
                        usuarios[posBuscar].setCorreoE(clsF.recibeString("Digite el nuevo correo electrónico"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;    
                    case 8:
                        usuarios[posBuscar].setTelefono(clsF.recibeInt("Digite el nuevo número telefónico"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;
                    case 9:
                        do {
                            estado = clsF.recibeChar("Digite el estado que tendrá el usuario"
                                    + "\n-Activo\n-Inactivo");
                         } while (estado != 'A' && estado != 'I');
                        usuarios[posBuscar].setEstado(estado);
                        break;
                    case 10:
                            do {
                            rol = clsF.recibeChar("Digite el tipo del usuario"
                                    + "\n-Empleado\n-Cliente");
                         } while (rol != 'E' && rol != 'C');
                         usuarios[posBuscar].setRol(rol);
                         clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;
                    case 11:
                        usuarios[posBuscar].setnickname(clsF.recibeString("Digite el nuevo nombre de usuario"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;
                    case 12:
                        usuarios[posBuscar].setpassword(clsF.recibeString("Digite la nueva contraseña"));
                        clsF.imprimeMensaje("Cambio realizado correctamente");
                        break;
                    case 13:
                        
                        break;    
                        
                        
                    default:
                        clsF.imprimeMensaje("Opción no válida");
                        break;
                }

            } while (opcion != 13);
    }
        return 0;
    }
        
    public int eliminarUsuario(Usuario usuarios[], int cantU){
        
        int buscar = clsF.recibeInt("Digite el número de cédula del usuario que desea eliminar");
        if (buscar == 12345){
            clsF.imprimeMensaje("No se puede eliminar el usuario ADMIN");
            return cantU;
        }
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantU; i++) {
            if (usuarios[i].getID() == buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        } else {
            for (int i = posBuscar; i < cantU-1; i++) {
                usuarios[i] = usuarios[i+1];
            }
            usuarios[cantU-1] = null;
            
            clsF.imprimeMensaje("Usuario eliminado correctamente");
            return cantU-1;
    }
        return cantU;
        
    }
      
    public int activarUsuario(Usuario usuarios[], int cantU){
       int buscar = clsF.recibeInt("Digite el número de cédula del usuario que desea activar");
        
       if (buscar == 12345){
            clsF.imprimeMensaje("No se puede editar el usuario ADMIN");
            return 0;
        }
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantU; i++) {
            if (usuarios[i].getID() == buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        } else {
            usuarios[posBuscar].setEstado('A');
            clsF.imprimeMensaje("Usuario activado correctamente");
    } 
        return 0;
    }
    
    
    public int inactivarUsuario(Usuario usuarios[], int cantU){
        int buscar = clsF.recibeInt("Digite el número de cédula del usuario que desea inactivar");
        if (buscar == 12345){
            clsF.imprimeMensaje("No se puede editar el usuario ADMIN");
            return 0;
        }
        int posBuscar = -1;
        
        
        for (int i = 0; i < cantU; i++) {
            if (usuarios[i].getID() == buscar ) {
                posBuscar = i;
                break;
            }
        }
            
            
        if (posBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        } else {
            usuarios[posBuscar].setEstado('I');
            clsF.imprimeMensaje("Usuario inactvado correctamente");
    }
        return 0;
    }
    
    
    
    
}
