import java.util.Stack;
import java.util.Iterator;

public class CompositeIterator {
    Stack pila=new Stack<>();

    public CompositeIterator(Iterator iterador){
        pila.push(iterador);
    }

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

    public void remove(){
        throw new UnsupportedOperationException();
    }
}
