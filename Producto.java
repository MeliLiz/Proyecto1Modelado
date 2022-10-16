import java.util.Iterator;

/**
 * Clase que simula un producto del catalogo
 */
public class Producto extends ComponenteCatalogo implements Componentes{

    private String codigoDeBarras;
    private String nombre;
    private String departamento;
    public double precio;

    /**
     * Constructor
     * @param codigoDeBarras El codigo de barras del producto
     * @param nombre El nombre del producto
     * @param departamento El departamento al que pertenece el producto
     * @param precio El precio del producto
     */
    public Producto(String codigoDeBarras, String nombre, String departamento, double precio){
        this.codigoDeBarras=codigoDeBarras;
        this.nombre=nombre;
        this.departamento=departamento;
        this.precio=precio;
    }

    /**
     * Metodo para obtener el codigo de barras
     * @return String El codigo de barras del producto
     */
    public String getCodigoDeBarras(){
        return codigoDeBarras;
    }

    /**
     * Metodo para obtener el nombre del producto
     * @return String El nombre del producto
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo para obtener el departamento al que pertenece el producto
     * @return String El departamento del producto
     */
    public String getDepartamento(){
        return departamento;
    }

    /**
     * Metodo para obtener el precio del producto
     * @return double El precio del producto
     */
    public double getPrecio(){
        return precio;
    }

    /**
     * Metodo para imprimir el producto
     */
    @Override
    public void imprimir() {
        System.out.println("\n"+nombre+"\n$"+precio+"\nCodigo de barras: "+codigoDeBarras);
    }

    /**
     * Metodo para crear un iterador de productos
     * @return Iterator El iterador de los productos, un iterador nulo
     */
    @Override
    public Iterator crearIterador() {
        return new IteradorNulo();
    }
}
