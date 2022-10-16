import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase para simular la categoria Electronica de un catalogo
 * @see Categoria
 */
public class Electronica extends ComponenteCatalogo{

    private ArrayList<ComponenteCatalogo> subcategorias;//los subcategorias de la categoria

    /**
     * Constructor
     */
    public Electronica(){
        subcategorias=new ArrayList<ComponenteCatalogo>();
        add(new Celulares());
        add(new Computadoras());
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
     * Metodo para eliminar una categoria de la categoria
     * @param Componente La subcategoria a eliminar de la categoria
     */
    @Override
    public void eliminar(ComponenteCatalogo componente) {
        subcategorias.remove(componente);
    }

    /**
     * Metodo para obtener un nodo hijo 
     * @return Componente catalogo El componente hijo 
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
        System.out.println("\nElectronica**\n");
        Iterator<ComponenteCatalogo> iterador=subcategorias.iterator();
        while(iterador.hasNext()){
            ComponenteCatalogo componente=iterador.next();
            componente.imprimir();
        }
    }

}
