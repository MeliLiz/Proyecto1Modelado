import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase para simular un catalogo
 * @see Categoria
 */
public class Catalogo extends ComponenteCatalogo implements Componentes{

    private ArrayList<ComponenteCatalogo> categorias;//los categorias del catalogo

    /**
     * Constructor
     */
    public Catalogo(){
        categorias=new ArrayList<ComponenteCatalogo>();
        add(new Electrodomesticos());
        add(new Electronica());
        add(new Alimenticios());
    }

    /**
     * Metodo para agregar una categoria al catalogo
     * @param componente La categoría a agregar
     */
    @Override
    public void add(ComponenteCatalogo componente) {
        categorias.add(componente);
    }

    /**
     * Metodo para eliminar una categoria del catalogo
     * @param Componente La categoría a eliminar del catalogo
     */
    @Override
    public void eliminar(ComponenteCatalogo componente) {
        categorias.remove(componente);
    }

    /**
     * Metodo para obtener un nodo hijo
     * @param i El indice del hijo a obtener 
     * @return Componente catalogo El componente hijo 
     */
    @Override
    public ComponenteCatalogo getHijo(int i) {
        return categorias.get(i);
    }

    /**
     * Metodo para imprimir las categorias del catalogo
     */
    @Override
    public void imprimir() {
        System.out.println("\nCatalogo**\n");
        Iterator<ComponenteCatalogo> iterador=categorias.iterator();
        while(iterador.hasNext()){
            ComponenteCatalogo componente=iterador.next();
            componente.imprimir();
        }
    }

    @Override
    public Iterator crearIterador() {
        return CompositeIterator(categorias.iterator());
    }

}