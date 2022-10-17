/*
 * Interfaz para un tipo de Servicio
 */
public interface Servicio {

    /**
     * Método para registrar a un nuevo usuario
     */
    public void registrarse();

    /**
     * Método para iniciar sesión
     */
    public void iniciarSesion();

    /**
     * Método para mostrar el catálogo
     */
    public void agregarProducto();

    /**
     * Método para realizar una compra
     */
    public void realizarCompra();

    /**
     * Método para cancelar una compra
     */
    public void cancelarCompra();

    /**
     * Método para mostrar ticket
     */
    public void mostrarTicket();

    /**
     * Método para cerrar sesion
     */
    public void cerrarSesion();

    /**
     * Método para canjear oferta
     */
    public void CanjearOferta();
}
