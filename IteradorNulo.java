import java.util.Iterator;

/**
 * Clase de un iterador nulo
 */
public class IteradorNulo implements Iterator{

    /**
     * Metodo para obtener el siguiente elemento
     * @return Object null
     */
    @Override
    public Object next() {
        return null;
    }

    /**
     * Metodo para saber si hay elemento siguiente en el iterador
     * @return boolean false
     */
    @Override
    public boolean hasNext() {
        return false;
    }

    /**
     * Operacion no soportada
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
