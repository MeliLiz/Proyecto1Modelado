/*
 * Interfaz para un tipo de Servicio
 */
public interface Servicio {


    /**
     * Método para iniciar sesión
     * @param cliente El cliente que quiere iniciar sesion
     * @return Idioma el idioma del cliente
     */
    public Idioma iniciarSesion(Cliente cliente);

    /**
     * Metodo para ostrar el catalogo
     */
    public void mostrarCatalogo();


    /**
     * Método para realizar una compra
     */
    public void realizarCompra();

    /**
     * Metodo para salir del sistema
     */
    public void salir();
}
