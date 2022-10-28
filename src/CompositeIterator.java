import java.util.Stack;
import java.util.Iterator;

/**
 * Clase de un iterador composite
 * @see Iterator
 */
public class CompositeIterator implements Iterator{

    Stack pila=new Stack<>();

    /**
     * Constructor
     * @param iterador El iterador que usaremos
     */
    public CompositeIterator(Iterator iterador){
        pila.push(iterador);
    }

    /**
     * Metodo para obtener el siguiente componente del iterador
     * @return Object El siguiente componente del iterador
     */
    public Object next(){
        if(hasNext()){
            Iterator iterador = (Iterator) pila.peek();
            ComponenteCatalogo componente = (ComponenteCatalogo) iterador.next();
            if(componente instanceof Categoria){
                Categoria componenteCategoria=(Categoria)componente;
                pila.push(componenteCategoria.crearIterador());
            }
            return componente;
        }else{
            return null;
        }
    }

    /**
     * Metodo para saber si el iterador tiene siguiente
     * @return boolean true si hay siguiente, false en otro caso
     */
    public boolean hasNext(){
        if(pila.empty()){
            return false;
        }else{
            Iterator iterador=(Iterator) pila.peek();
            if(!iterador.hasNext()){
                pila.pop();
                return hasNext();
            }else{
                return true;
            }
        }
    }

    /**
     * Metodo no soportado
     */
    public void remove(){
        throw new UnsupportedOperationException();
    }
}
