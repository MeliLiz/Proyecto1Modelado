import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class Main {

    private static Tienda tienda=new Tienda();
    private static TiendaProxy tiendaProxy=null;;
    private static Scanner scanner=new Scanner(System.in);
    private static Scanner scanner2=new Scanner(System.in);

    public static void inicio(){
        principal:
        do{
            int opcion=0;
            while(true){
                System.out.println("Ingresa una opcion");
                System.out.println("1) Registrarse");
                System.out.println("2) Iniciar sesión");
                System.out.println("3) Salir del sistema");
                try {
                    opcion=scanner.nextInt();
                    if(opcion<4&&opcion>0){
                        break;
                    }else{
                        System.out.println("Opcion no valida");
                    }
                } catch (InputMismatchException e) {
                    e.printStackTrace();
                }  
            }
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese su nombre de usuario");
                    String nombreUsuario=scanner.nextLine();
                    System.out.println("Ingrese su nombre completo");
                    String nombreCliente=scanner.nextLine();
                    System.out.println("Ingrese su contraseña");
                    String contrasena=scanner.nextLine();
                    int telefono=0;
                    while(true){
                        try {
                            System.out.println("Ingrese su número telefónico");
                            telefono=scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Al parecer no ingreso un numero");
                        }
                    }
                    
                    System.out.println("Ingrese su dirección");
                    String direccion=scanner.nextLine();
                    int numCuenta=0;
                    while(true){
                        try {
                            System.out.println("Ingrese su número de cuenta bancaria");
                            numCuenta=scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Al parecer no ingreso un numero");
                        }
                    }
                    
                    System.out.println("Ingrese el país de residencia");
                    String pais=scanner.nextLine();
                    Cliente cliente=new Cliente(nombreUsuario, contrasena, nombreCliente, telefono, direccion, numCuenta, pais, tienda.getUltimoIDRegistrado()+1, tienda);
                    System.out.println("Inicie sesión por favor");
                    break;
                case 2:
                    System.out.println("Ingrese su nombre de usuario");
                    String usuario=scanner2.nextLine();
                    System.out.println("Ingrese su contraseña");
                    String key=scanner2.nextLine();
                    Cliente client =new Cliente(usuario, key);
                    tiendaProxy.iniciarSesion(client);
                    break;
                case 3:
                    break principal;
            
                default:
                    break;
            }
        }while(true);
        
        
    }
    public static void main(String[] args) {
        try{
            ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("archivo.obj"));
            tienda=(Tienda)entrada.readObject();
            entrada.close();
        }catch(Exception e){//Si el archivo no se pudo leer
            System.out.println("No se pudo deserializar");
            Cliente cliente1=new Cliente("Elec", "elec17", "Elec Kincaid", 96378415, "Rosewood street, Boston", 123456789, "Estados Unidos", 1, tienda);
        }finally{
            tiendaProxy=new TiendaProxy(tienda);
            System.out.println(tienda.getClientes().size());
        }

        inicio();
    }
}
