import java.io.Serializable;
import java.util.Iterator;
/**
 * Clase abstracta que simula el componente de un catalogo
 * @see Serializable
 */
public abstract class ComponenteCatalogo implements Serializable{

    /**
     * Metodo para agregar un componente
     * @param componente El componente a agregar
     */
    public void add(ComponenteCatalogo componente){
        throw new UnsupportedOperationException();
    }

    /**
     * Metodo para eliminar un componente
     * @param componente El componente a eliminar
     */
    public void eliminar(ComponenteCatalogo componente){
        throw new UnsupportedOperationException();
    }

    /**
     * Metodo para obtener un nodo del arbol de componentes
     * @param i El indice del hijo a obtener
     * @return ComponenteCatalogo El componente a obtener
     */
    public ComponenteCatalogo getHijo(int i){
        throw new UnsupportedOperationException();
    }

    /**
     * Metodo para imprimir el componente
     */
    public void imprimir(){
        throw new UnsupportedOperationException();
    }

    /**
     * Metodo para obtener el codigo de barras de un producto
     * @return String el codigo de barras del producto
     */
    public String getCodigoDeBarras(){
        throw new UnsupportedOperationException();
    }

    /**
     * Metodo para obtener el nombre del componente
     * @return
     */
    public String getNombre(){
        throw new UnsupportedOperationException();
    }

    /**
     * Metodo para obtener el departamento al que pertenece un producto
     * @return String El departamento al que pertenece el producto
     */
    public String getDepartamento(){
        throw new UnsupportedOperationException();
    }

    /**
     * Metodo para obtener el precio del producto
     * @return double El precio del producto
     */
    public double getPrecio(){
        throw new UnsupportedOperationException();
    }

    /**
     * Metodo para crear un iterador del componente
     * @return Iterator El iterador del componente
     */
    public Iterator crearIterador(){
        throw new UnsupportedOperationException();
    }

    /**
     * Metodo para obtener un iterador de una subcategoria del catalogo
     * @param nombreSubcategoria El nombre de la subcategoria
     * @return Iterator El iterador de la subcategoria
     */
    public Iterator getIteradorSubcategoria(String nombreSubcategoria){
        throw new UnsupportedOperationException();
    }
}
