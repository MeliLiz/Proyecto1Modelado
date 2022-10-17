import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Set;

/**
 * Clase para el registro de clientes en la tienda virtual
 */
public class RegistroTienda {
    private String nombreArchivo; // sera el nombre del archivo que se escribira
    private ObjectOutputStream escritor; // el que escribira el archivo
    private ObjectInputStream lector; // para leer el registro de los clientes
    private Tienda tienda;

    /**
     * Constructor
     * 
     * @param tienda La tienda a registrar
     */
    public RegistroTienda(Tienda tienda) {
        this.tienda = tienda;
        this.nombreArchivo = "clientes.txt";
        try {
            this.escritor = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            this.lector = new ObjectInputStream(new FileInputStream(nombreArchivo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que agrega los clientes de la tienda a un archivo .txt
     * Basicamente toma la tienda que tiene como atributo, obtiene sus clientes, que
     * es una Hastable y lo escribe en un archivo llamdo clientes.txt
     * 
     */
    public void agregarClientesAlRegistro() {

        try {
            this.escritor.writeObject(tienda.getClientes());
            this.escritor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para leer un cliente en específico del registro.
     * Lo hace con ObjectInputStream, obtiene la hastable de la tienda en el archivo
     * .txt
     * y se itera con las llaves en la hastable obtenida, si la llave en el objeto
     * en el que
     * estamos iterando es el mismo que el ID del cliente que buscamos, lo regresa
     * 
     * @param cliente
     * @return
     */
    public Cliente leerCLienteDelRegistro(Cliente cliente) {
        Cliente clienteBuscado = null;
        Hashtable<Integer, Cliente> clientesEnRegistro = null;
        boolean repetidor = true;

        try {

            clientesEnRegistro = (Hashtable<Integer, Cliente>) lector.readObject();
            Set<Integer> llaves = clientesEnRegistro.keySet();

            for (Integer llave : llaves) {
                if (llave == cliente.getIdCliente()) {
                    clienteBuscado = cliente;
                }
            }

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return clienteBuscado;
    }

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("eyeRaven", null, null, 0, null, 0, null, 12323);
        Cliente cliente2 = new Cliente("Clara", null, null, 0, null, 0, null, 22424);
        Cliente cliente3 = new Cliente("Damian", null, null, 0, null, 0, null, 1234344);

        Tienda tienda = new Tienda(new EspanolLatino());
        tienda.registrar(cliente1);
        tienda.registrar(cliente2);
        tienda.registrar(cliente3);

        RegistroTienda registro = new RegistroTienda(tienda);

        registro.agregarClientesAlRegistro();

        Cliente encontrado = registro.leerCLienteDelRegistro(cliente3);

        System.out.println(encontrado.getNombreUsuario());

    }
}
