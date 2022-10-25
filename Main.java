import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.NotSerializableException;
import java.io.IOException;
import java.io.FileOutputStream;

public class Main {

    private static Tienda tienda = new Tienda();
    private static TiendaProxy tiendaProxy = null;
    private static Scanner scanner = new Scanner(System.in);
    private static Scanner scanner2 = new Scanner(System.in);

    public static void inicio() {
        principal: do {
            int opcion = 0;
            while (true) {
                System.out.println("Ingresa una opcion");
                System.out.println("1) Registrarse");
                System.out.println("2) Iniciar sesión");
                System.out.println("3) Salir del sistema");
                try {
                    System.out.print("Ingrese una opcion: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    if (opcion < 4 && opcion > 0) {
                        break;
                    } else {
                        System.out.println("Opcion no valida");
                    }
                } catch (InputMismatchException e) {
                    e.printStackTrace();
                }
            }
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese su nombre de usuario: ");
                    // scanner.nextLine();
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("\nIngrese su nombre completo: ");
                    // scanner.nextLine();
                    String nombreCliente = scanner.nextLine();
                    System.out.print("\nIngrese su contraseña: ");
                    // scanner.nextLine();
                    String contrasena = scanner.nextLine();
                    int telefono = 0;
                    while (true) {
                        try {
                            System.out.print("\nIngrese su número telefónico (solo 8 numeros): ");
                            telefono = scanner2.nextInt();

                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Al parecer no ingreso un numero");
                        }
                    }

                    System.out.print("\nIngrese su dirección: ");
                    // scanner.nextLine();
                    String direccion = scanner.nextLine();
                    int numCuenta = 0;
                    while (true) {
                        try {
                            System.out.print("\nIngrese su número de cuenta bancaria: ");

                            numCuenta = scanner2.nextInt();
                            // scanner.nextLine();

                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Al parecer no ingreso un numero");
                        }
                    }

                    System.out.print("\nIngrese el país de residencia: ");
                    String pais = scanner.nextLine();
                    Cliente cliente = new Cliente(nombreUsuario, contrasena, nombreCliente, telefono, direccion,
                            numCuenta, pais, tienda.getUltimoIDRegistrado() + 1, tienda);
                    System.out.println(tienda.getClientes().size());
                    System.out.println("\nInicie sesión por favor");
                    break;
                case 2:
                    scanner2.nextLine();
                    System.out.print("Ingrese su nombre de usuario: ");
                    String usuario = scanner2.nextLine();

                    System.out.print("Ingrese su contraseña: ");
                    String key = scanner2.nextLine();

                    Cliente client = new Cliente(usuario, key);
                    tiendaProxy.iniciarSesion(client);
                    break;
                case 3:
                    ObjectOutputStream escritor=null;
                    try{
                        escritor=new ObjectOutputStream(new FileOutputStream("archivo.obj"));
                        escritor.writeObject(tienda);
                    }catch(NotSerializableException e){
                        System.out.println("Error en la grabación: "+e+". Objeto no serializable");
                    }catch(IOException e){
                        System.out.println("Error en la grabación: "+e);
                    }finally{
                        if(escritor!=null){
                            System.out.println("Cerrando el archivo");
                            try{
                                escritor.close();
                            }catch(IOException e){}
                        }else{
                            System.out.println("No se abrió ningún archivo");
                        }
                    }
                    break principal;

                default:
                    break;
            }
        } while (true);

    }

    public static void main(String[] args) {
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("archivo.obj"));
            tienda = (Tienda) entrada.readObject();
            entrada.close();
        } catch (Exception e) {// Si el archivo no se pudo leer
            System.out.println("No se pudo deserializar");
            Cliente cliente1 = new Cliente("Elec", "elec17", "Elec Kincaid", 96378415, "Rosewood street, Boston",
                    123456789, "Estados Unidos", 1, tienda);

        } finally {
            tiendaProxy = new TiendaProxy(tienda);
            System.out.println(tienda.getClientes().size());
        }

        inicio();
    }
}
