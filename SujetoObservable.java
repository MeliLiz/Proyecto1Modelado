/**
 * Interfaz de una clase observable
 */
public interface SujetoObservable {

    /**
     * Registrar a los objetos observadores
     * 
     * @param observador El observador a registrar
     */
    public void registrar(Cliente observador);

    /**
     * Quitar un objeto observador
     * 
     * @param observador El observador a remover
     */
    public void remover(Cliente observador);

    /**
     * Notificar a los objetos observadores
     */
    public void notificar();
}
