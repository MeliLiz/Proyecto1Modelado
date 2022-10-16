import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase para simular la categoria Alimenticios de un catalogo
 * @see Categoria
 */
public class Alimenticios implements Categoria{

    private ArrayList<Producto> productos;//los productos de la categoria

    /**
     * Constructor
     */
    public Alimenticios(){
        productos=new ArrayList<Producto>();
        addProducto(new QuesoPanelaPaquete());
        addProducto(new JamonPaquete());
        addProducto(new YogurtNatural());
    }

    /**
     * Metodo para obtener la lista de los productos de la categoria
     * @return La lista donde estan los productos de la categoria
     */
    public ArrayList<Producto> getProductos(){
        return productos;
    }

    /**
     * Metodo para asignar una nueva lista se productos de la categoria
     * @param productos La nueva lista de productos a asignar
     */
    public void setProductos(ArrayList<Producto> productos){
        this.productos=productos;
    }

    /**
     * Metodo para agregar un producto a la categoria
     * @param producto El producto a agregar
     */
    public void addProducto(Producto producto){
        productos.add(producto);
    }

    /**
     * Metodo para eliminar un producto de la categoria
     * @param producto El producto a eliminar de la categoria
     */
    public void eliminarProducto(Producto producto){
        productos.remove(producto);
    }

    /**
     * Metodo para obtener un iterador de los productos de la categoria
     * @return Iterator El iterador de la categoria
     */
    @Override
    public Iterator crearIterador() {
        return productos.iterator();
    }

    /**
     * Metodo para obtener el nombre de la categoria
     * @return String El nombre de la categoria
     */
    @Override
    public String getNombre() {
        return "**Alimenticios**";
    }
}

