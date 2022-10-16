import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase para simular las categorias de un catalogo
 * @see Categoria
 */
public class Categoria extends ComponenteCatalogo implements Componentes{

    private ArrayList<ComponenteCatalogo> subcategorias;//los subcategorias de la categoria
    private String nombreCategoria;

    /**
     * Constructor
     * @param nombreCategoria El nombre de la categoria
     */
    public Categoria(String nombreCategoria){
        subcategorias=new ArrayList<ComponenteCatalogo>();
        this.nombreCategoria=nombreCategoria;
    }

    /**
     * Metodo para agregar una subcategoria a la categoria
     * @param componente La subcategoria a agregar
     */
    @Override
    public void add(ComponenteCatalogo componente) {
        subcategorias.add(componente);
    }

    /**
     * Metodo para eliminar una sucategoria
     * @param componente La subcategoria a eliminar de la categoria
     */
    @Override
    public void eliminar(ComponenteCatalogo componente) {
        subcategorias.remove(componente);
    }

    /**
     * Metodo para obtener un nodo hijo 
     * @return ComponenteCatalogo El componente hijo 
     */
    @Override
    public ComponenteCatalogo getHijo(int i) {
        return subcategorias.get(i);
    }

    /**
     * Metodo para imprimir las categorias y subcategorias del catalogo
     */
    @Override
    public void imprimir() {
        System.out.println("\n**"+nombreCategoria+"**\n");
        Iterator<ComponenteCatalogo> iterador=subcategorias.iterator();
        while(iterador.hasNext()){
            ComponenteCatalogo componente=iterador.next();
            componente.imprimir();
        }
    }

    /**
     * Metodo para crear un iterador de la categoria
     * @return Iterator El iterador de la categoria
     */
    @Override
    public Iterator crearIterador() {
        return new CompositeIterator(subcategorias.iterator());
    }

}
