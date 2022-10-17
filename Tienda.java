import java.util.Hashtable;
import java.util.Set;

/**
 * Clase para la tienda virtual
 */
public class Tienda implements SujetoObservable {

    private Catalogo catalogo;
    private Idioma idioma;
    private Hashtable<Integer, Cliente> clientes;
    private int numvisitantes;

    /**
     * Constructor con un parametro
     * 
     * @param idioma El idioma de la tienda
     */
    public Tienda(Idioma idioma) {
        this.catalogo = new Catalogo();
        this.idioma = idioma;
        this.clientes = new Hashtable<Integer, Cliente>();
        this.numvisitantes = 0;
    }

    @Override
    public void registrar(Cliente observador) {
        if (observador == null) {
            System.out.println("No se pueden tener clientes null. Favor de registrar un cliente valido");
        } else {
            clientes.put(observador.getIdCliente(), observador);
        }

    }

    @Override
    public void remover(Cliente observador) {
        if (observador == null) {
            System.out.println("No se puede remover un cliente null");
        } else {
            clientes.remove(observador.getIdCliente());
        }

    }

    @Override
    public void notificar() {
        Set<Integer> llaves = clientes.keySet();

        for (Integer llave : llaves) {
            clientes.get(llave).actualizar();
        }

    }

    /**
     * Método para obtener el catálogo de la tienda
     * 
     * @return El catálogo de la tienda
     */
    public Catalogo getCatalogo() {
        return this.catalogo;
    }

    /**
     * Método para cambiar el catálogo de la tienda
     * 
     * @param catalogo El nuevo catálogo de la tienda
     */
    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    /**
     * Método para obtener el idioma de la tienda
     * 
     * @return El idioma de la tienda
     */
    public Idioma getIdioma() {
        return this.idioma;
    }

    /**
     * Método para cambiar el idioma de la tienda
     * 
     * @param idioma El nuevo idioma de la tienda
     */
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    /**
     * Método para obtener los clientes de la tienda
     * 
     * @return Los clientes de la tienda
     */
    public Hashtable<Integer, Cliente> getClientes() {
        return this.clientes;
    }

    /**
     * Método para cambiar los clientes de la tienda
     * 
     * @param clientes Los nuevos clientes de la tienda
     */
    public void setCatalogo(Hashtable<Integer, Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Método para obtener el número de visitantes de la tienda
     * 
     * @return El número de visitantes de la tienda
     */
    public int getNumVisitantes() {
        return this.numvisitantes;
    }

    /**
     * Método para cambiar el número de visitantes de la tienda
     * 
     * @param numVisitantes El nuevo número de visitantes de la tienda
     */
    public void setNumVisitantes(int numVisitantes) {
        this.numvisitantes = numVisitantes;
    }

}
