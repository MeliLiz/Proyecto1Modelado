import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase para simular la subcategoria Hornos de un catalogo
 * @see ComponenteCatalogo
 */
public class Hornos extends ComponenteCatalogo{

    private ArrayList<ComponenteCatalogo> productos;//los productos de la categoria

    /**
     * Constructor
     */
    public Hornos(){
        productos=new ArrayList<ComponenteCatalogo>();
        add(new MicroondasSmsungA100());
        add(new HornoOstormini());
    }

    /**
     * Metodo para agregar un producto a la categoria
     * @param producto El producto a agregar
     */
    @Override
    public void add(ComponenteCatalogo componente) {
        productos.add(componente);
    }

    /**
     * Metodo para eliminar un producto de la categoria
     * @param producto El producto a eliminar de la categoria
     */
    @Override
    public void eliminar(ComponenteCatalogo componente) {
        productos.remove(componente);
    }

    /**
     * Metodo para obtener un nodo hijo 
     * @return Componente catalogo El componente hijo 
     */
    @Override
    public ComponenteCatalogo getHijo(int i) {
        return productos.get(i);
    }

    /**
     * Metodo para imprimir las categorias y productos del catalogo
     */
    @Override
    public void imprimir() {
        System.out.println("\nHornos**\n");
        Iterator<ComponenteCatalogo> iterador=productos.iterator();
        while(iterador.hasNext()){
            ComponenteCatalogo componente=iterador.next();
            componente.imprimir();
        }
    }

}
