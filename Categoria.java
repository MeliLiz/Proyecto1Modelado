import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase para simular las categorias de un catalogo
 * @see Categoria
 */
public class Categoria extends ComponenteCatalogo implements Serializable{

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
        System.out.println("\n**"+nombreCategoria+"**");
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

    /**
     * Metodo para obtener el nombre de la categoria
     * @return String El nombre de la categoría
     */
    @Override
    public String getNombre() {
        return nombreCategoria;
    }


    /**
     * Metodo para obtener el iterador de una subcategoria
     */
    @Override
    public Iterator getIteradorSubcategoria(String nombreSubcategoria) {
        for (ComponenteCatalogo subcategoria : subcategorias) {
            if(subcategoria.getNombre().equals(nombreSubcategoria)){
                return subcategoria.crearIterador();
            }
        }
        return null;
    }

    /**
     * Metodo para saber si la categoria tiene una determinada subcategoria
     * @param nombreSubcategoria El nombre de la subcategoria buscada
     * @return int El indice de la subcategoria en la lista de subcategorias de la categoria, -1 si no existe la categoria buscada
     */
    public int haySubcategoria(String nombreSubcategoria){
        int indice=0;
        for (ComponenteCatalogo subcategoria : subcategorias) {
            if(subcategoria.getNombre().equals(nombreSubcategoria)){
                return indice;
            }
            indice++;
        }
        return -1;
    }

    /**
     * Metodo para eliminar las subcategorias o productos de la categoria
     */
    public void eliminarSubcategorias(){
        subcategorias.clear();
    }
}
