import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.NotSerializableException;
import java.io.IOException;
import java.io.FileOutputStream;

/**
 * Clase principal
 */
public class Main {

    private static Tienda tienda = new Tienda();
    private static TiendaProxy tiendaProxy = null;
    private static Scanner scanner = new Scanner(System.in);// scanner para números
    private static Scanner scanner2 = new Scanner(System.in);// scanner para líneas

    /**
     * Metodo para iniciar la ejecucion del menu para registrarse, iniciar sesión o
     * salir
     */
    public static void inicio() {
        tienda.notificar();
        System.out.println(tienda.getPaisOfertaTienda());
        principal: do {
            tiendaProxy = new TiendaProxy(tienda);// creamos una nueva tienda proxy
            int opcion = 0;
            while (true) {
                System.out.println("Ingresa una opcion");
                System.out.println("1) Registrarse");
                System.out.println("2) Iniciar sesión");
                System.out.println("3) Salir del sistema");
                try {
                    System.out.print("Ingrese una opcion: ");
                    opcion = scanner.nextInt();
                    if (opcion < 4 && opcion > 0) {
                        break;
                    } else {
                        System.out.println("Opcion no valida");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("No ingresaste un número");
                    scanner.next();
                }
            }
            switch (opcion) {
                case 1:// registrarse
                    String nombreUsuario = null;
                    while (true) {
                        System.out.print("Ingrese su nombre de usuario: ");
                        nombreUsuario = scanner2.nextLine();

                        if (tienda.verificarNombreUsuario(nombreUsuario)) {
                            System.out.println("El nombre de usuario ya existe, ingrese otro.");
                        } else {
                            break;
                        }

                    }
                    System.out.print("\nIngrese su nombre completo: ");
                    String nombreCliente = scanner2.nextLine();
                    System.out.print("\nIngrese su contraseña: ");
                    String contrasena = scanner2.nextLine();
                    int telefono = 0;
                    while (true) {
                        try {
                            System.out.print("\nIngrese su número telefónico (solo 8 numeros): ");
                            telefono = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Al parecer no ingreso un numero");
                            scanner.next();
                        }
                    }

                    System.out.print("\nIngrese su dirección: ");
                    String direccion = scanner2.nextLine();
                    int numCuenta = 0;
                    while (true) {
                        try {
                            System.out.print("\nIngrese su número de cuenta bancaria: ");
                            numCuenta = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Al parecer no ingreso un numero");
                            scanner.next();
                        }
                    }

                    System.out.print("\nIngrese el país de residencia: ");
                    String pais = scanner2.nextLine();
                    Cliente cliente = new Cliente(nombreUsuario, contrasena, nombreCliente, telefono, direccion,
                            numCuenta, pais, tienda.getUltimoIDRegistrado() + 1, tienda);
                    // System.out.println(tienda.getClientes().size());
                    System.out.println("\nInicie sesión por favor");
                    break;
                case 2:// iniciar sesión
                    System.out.print("Ingrese su nombre de usuario: ");
                    String usuario = scanner2.nextLine();

                    System.out.print("Ingrese su contraseña: ");
                    String key = scanner2.nextLine();

                    Cliente client = new Cliente(usuario, key);
                    tiendaProxy.iniciarSesion(client);
                    break;
                case 3:// Salir
                       // Guardamos el objeto de la tienda en el archivo obj
                    ObjectOutputStream escritor = null;
                    try {
                        escritor = new ObjectOutputStream(new FileOutputStream("archivo.obj"));
                        escritor.writeObject(tienda);
                    } catch (NotSerializableException e) {
                        System.out.println("Error en la grabación: " + e + ". Objeto no serializable");
                    } catch (IOException e) {
                        System.out.println("Error en la grabación: " + e);
                    } finally {
                        if (escritor != null) {
                            System.out.println("Cerrando el programa");
                            try {
                                escritor.close();
                            } catch (IOException e) {
                            }
                        } else {
                            System.out.println("No se abrió ningún archivo");
                        }
                    }
                    break principal;

                default:
                    break;
            }
        } while (true);

    }

    /**
     * Método principal
     * 
     * @param args Los argumentos
     */
    public static void main(String[] args) {
        // Leemos el archivo obj (si existe)
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("archivo.obj"));
            tienda = (Tienda) entrada.readObject();
            entrada.close();
        } catch (Exception e) {// Si el archivo no se pudo leer
            System.out.println("No se pudo deserializar");
            // Si el objeto no existe, creamos un cliente de la tienda
            Cliente cliente1 = new Cliente("Elec", "elec17", "Elec Kincaid", 96378415, "Rosewood street, Boston",
                    123456789, "Estados Unidos", 1, tienda);

        }
        // System.out.println(tienda.getClientes().size());

        inicio();
    }
}
