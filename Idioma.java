/**
 * Interfaz para los diferentes idiomas del sistema
 */
public interface Idioma {
    /**
     * Método para saludar
     */
    public void saludar();

    /**
     * Método para despedirse
     */
    public void despedirse();

    /**
     * Método para completar Compra
     */
    public void completarCompra();

    /**
     * Método para dar fecha de entrega
     */
    public void darFechaDeEntrega();

    /**
     * Método para mostrar menu de opciones
     */
    public void mostrarMenuOpciones();

    /**
     * Método para enviar ofertas
     */
    public void anunciarOferta();

    /**
     * Metodo para pedir la cuenta bancaria al usuario
     */
    public void pedirCuentaBancaria();

    /**
     * Metodo para anunciar la pantalla de compra segura
     */
    public void compraSegura();

    /**
     * Metodo para indicar el total a pagar
     */
    public void porPagar(double porPagar);

    /**
     * Metodo para indicar un error de codigo de barras de un producto
     */
    public void errorCodigoProducto();

    /**
     * Metodo para indicar un error en input
     */
    public void errorInput();

    /**
     * Método para indicar una oferta que se aplicó
     * @param deptoOferta
     */
    public void ofertaAplicada(String deptoOferta);

    /**
     * Metodo para indicar el subtotal de compra
     */
    public void subtotal(double subtotal);

    /**
     * Metodo para indicar el total de compra
     * @param total
     */
    public void total(double total);
}
