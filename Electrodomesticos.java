import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase para simular la categoria Electrodomesticos de un catalogo
 * @see Categoria
 */
public class Electrodomesticos extends ComponenteCatalogo{

    private ArrayList<ComponenteCatalogo> subcategorias;//los subcategorias de la categoria

    /**
     * Constructor
     */
    public Electrodomesticos(){
        subcategorias=new ArrayList<ComponenteCatalogo>();
        add(new Hornos());
        add(new Licuadoras());
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
     * Metodo para eliminar una subcategoria de la categoria
     * @param componente La subcategoria a eliminar de la categoria
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
        System.out.println("\nElectrodomesticos**\n");
        Iterator<ComponenteCatalogo> iterador=subcategorias.iterator();
        while(iterador.hasNext()){
            ComponenteCatalogo componente=iterador.next();
            componente.imprimir();
        }
    }

}
